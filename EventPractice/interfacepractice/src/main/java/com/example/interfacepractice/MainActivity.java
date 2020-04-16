package com.example.interfacepractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Calculator calc = new Calculator();

        Log.d("MainActivity","덧셈 결과 : "+calc.add(10,20));
        Log.d("MainActivity","뺄셈 결과 : "+calc.subtract(10,20));
        Log.d("MainActivity","곱셈 결과 : "+calc.multiply(10,20));
    }
}



interface Calc{
    int add(int num1,int num2);
    int subtract(int num1, int num2);

}

   abstract class AbstractCalc implements Calc{
    @Override
    public int add(int num1, int num2) {
        return num1+num2;
    }

    public abstract int multiply(int num1, int num2);
}

class Calculator extends AbstractCalc{
    public int subtract(int num1, int num2){
        return num1-num2;
    }

    public int multiply(int num1, int num2){
        return num1 * num2;
    }
}
package com.example.eventpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;

import android.os.Bundle;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    Button btn1,btn2,btn3,btn4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);
        btn4 = findViewById(R.id.button4);

        new View.OnClickListener Listner2 = new View.OnC


    }

    public void onButtonClicked(View view){
        Toast.makeText(this,"버튼1 클릭됨", Toast.LENGTH_SHORT).show();
    }
}

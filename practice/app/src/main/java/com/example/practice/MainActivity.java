package com.example.practice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MainActivity extends AppCompatActivity {
    RadioGroup radioGroup;
    RadioButton rb1,rb2;
    Button newbutton,secondback,thirdback;

    class game{
        int one = 1;
        int two = 2;

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup=findViewById(R.id.radiogroup);
        rb1=findViewById(R.id.secondradio);
        rb2=findViewById(R.id.thirdradio);
        newbutton=findViewById(R.id.newbutton);
        secondback=findViewById(R.id.secondbutton);
        thirdback=findViewById(R.id.thirdbutton);

        game d = new game();

        try {
            //  "dg.ser"로 저장합니다.
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("dg.ser"));
            oos.writeObject(d);
            oos.close();

            //  파일이름이 "dg.ser"인 파일을 가져옵니다.
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("dg.ser"));
            d = (game)ois.readObject();
            ois.close();

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

//        thirdback.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                setContentView(R.layout.activity_main);
//            }
//        });
//
        newbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(radioGroup.getCheckedRadioButtonId()){
                    case R.id.secondradio :

                        break;
                    case R.id.thirdradio :

                        break;
                    default :
                        Toast.makeText(getApplicationContext(), "액티비티를 선택하세요.",Toast.LENGTH_SHORT).show();

                }
            }
        });





    }
}

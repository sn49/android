package com.example.chapter5practice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;



public class MainActivity extends AppCompatActivity {


    Button btn_visible,btn_hide;
    ImageView imagery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        btn_visible = findViewById(R.id.btn_visible);
        btn_hide = findViewById(R.id.btn_hide);
        imagery = findViewById(R.id.imageView);

        btn_visible.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                imagery.setVisibility(View.VISIBLE);
            }
        });

        btn_hide.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                imagery.setVisibility(View.INVISIBLE);
            }
        });

//        View.OnClickListener lister = new View.OnClickListener(){
//            @Override
//            public void onClick(View v){
//                switch(v.getId()){
//                    case R.id.btn_hide:
//                        imageview.setVisibility(View.INVISIBLE);
//                        break;
//                    case R.id.btn_visible:
//                        imageview.setVisibility(View.VISIBLE);
//                }
//            }
//        };
//
//        btn_visible.setOnClickListener(lister);
//        btn_hide.setOnClickListener(lister);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}

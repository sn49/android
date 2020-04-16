package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

public class MainActivity extends AppCompatActivity {

    Chronometer chronometer;
    Button start,stop,reset;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start=findViewById(R.id.start);
        stop=findViewById(R.id.stop);
        reset=findViewById(R.id.reset);

        start.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v){
                chronometer.start();
            }
        });

        stop.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v){
                chronometer.stop();
            }
        });

        reset.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v){
                chronometer.setBase(SystemClock.elapsedRealtime());
            }
        });




    }
}

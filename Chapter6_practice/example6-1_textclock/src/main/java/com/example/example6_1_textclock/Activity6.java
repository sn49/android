package com.example.example6_1_textclock;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextClock;
import android.widget.TextView;

public class Activity6 extends AppCompatActivity {

    TextClock textclock;
    Button btngettime;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_6);

        textclock = findViewById(R.id.textclock);
        btngettime = findViewById(R.id.btngettime);
        textView = findViewById(R.id.textView);

        btngettime.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                textView.setText("Time : "+textclock.getText());
            }
        });
    }
}

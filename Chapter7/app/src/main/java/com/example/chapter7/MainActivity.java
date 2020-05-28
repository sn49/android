package com.example.chapter7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    Button btnLayoutinflatorButton;
    LinearLayout linearLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayout=findViewById(R.id.linearlayout);
        btnLayoutinflatorButton = findViewById(R.id.inflator);

        btnLayoutinflatorButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                LayoutInflater layoutInflater = getLayoutInflater();
                View sampleLayoutView = layoutInflater.inflate(R.layout.samplelayout,null);
                linearLayout.addView(sampleLayoutView);
            }
        });

    }
}

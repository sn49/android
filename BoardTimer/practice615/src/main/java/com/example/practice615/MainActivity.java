package com.example.practice615;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {

    Button btnpre,btnnext;
    ViewFlipper viewFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnpre=findViewById(R.id.btnpre);
        btnnext=findViewById(R.id.btnnext);
        viewFlipper=findViewById(R.id.viewfliper);


        btnpre.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                viewFlipper.showPrevious();
            }
        });

        btnnext.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                viewFlipper.showNext();
            }
        });
    }
}

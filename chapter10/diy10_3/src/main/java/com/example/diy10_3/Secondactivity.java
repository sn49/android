package com.example.diy10_3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.exercise10_16.R;

public class Secondactivity extends AppCompatActivity {

    Button btnreturn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondactivity);

        Intent in_intent= getIntent();
        final int hap= in_intent.getIntExtra("num1",0)+in_intent.getIntExtra("num2",0);


        findViewById(R.id.btn_return).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent out_intent=new Intent(getApplicationContext(),MainActivity.class);
                out_intent.putExtra("hap",hap);
                setResult(RESULT_OK,out_intent);
                finish();
            }
        });


    }
}

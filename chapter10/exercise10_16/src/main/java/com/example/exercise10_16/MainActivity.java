package com.example.exercise10_16;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==0 && resultCode==RESULT_OK){
            int hap = data.getIntExtra("Hap",0);
            Toast.makeText(this,"합계 : "+hap,Toast.LENGTH_SHORT);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnNewActivity = (Button) findViewById(R.id.btn_calcutrate);

        btnNewActivity.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                EditText edtNum1 = (EditText) findViewById(R.id.editText1);
                EditText edtNum2 = (EditText) findViewById(R.id.editText2);
                Intent intent = new Intent(getApplicationContext(),Secondactivity.class);
                intent.putExtra("Num1",Integer.parseInt(edtNum1.getText().toString()));
                intent.putExtra("Num2",Integer.parseInt(edtNum2.getText().toString()));
                startActivityForResult(intent,0);
            }
        });



    }
}

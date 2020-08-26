package com.example.diy10_3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.exercise10_16.R;

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
        final RadioGroup radioGroup = findViewById(R.id.radioGroup);
        final RadioButton radioadd = findViewById(R.id.radio_add);
        final RadioButton radiominus = findViewById(R.id.radio_minus);
        final RadioButton radiomulti = findViewById(R.id.radiomulti);
        final RadioButton radiodiv = findViewById(R.id.radiodiv);
        Button btnNewActivity = (Button) findViewById(R.id.btn_calcurate);

        int id1,id2,id3,id4;

        for(RadioButton id : RadioGroup){
            id1=id.getId();
        }

        btnNewActivity.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                EditText edtNum1 = (EditText) findViewById(R.id.editText1);
                EditText edtNum2 = (EditText) findViewById(R.id.editText2);
                Intent intent = new Intent(getApplicationContext(),Secondactivity.class);
                switch (radioGroup.getCheckedRadioButtonId()){
                    case radioadd.getId() :
                        break;
                    case radiominus.getId():
                        break;
                    case radiomulti.getId():
                        break;
                    case radiodiv.getId() :
                        break;
                }



                intent.putExtra("Num1",Integer.parseInt(edtNum1.getText().toString()));
                intent.putExtra("Num2",Integer.parseInt(edtNum2.getText().toString()));
                startActivityForResult(intent,0);
            }
        });



    }
}

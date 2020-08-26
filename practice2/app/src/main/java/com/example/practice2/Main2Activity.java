package com.example.practice2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class Main2Activity extends AppCompatActivity {

    Button button2;
    RadioGroup radioGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        radioGroup=findViewById(R.id.radiogr);
        button2=findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(radioGroup.getCheckedRadioButtonId()){
                    case R.id.radioButton :
                        Uri uri= Uri.parse("tel:0629496800");
                        Intent intent = new Intent(Intent.ACTION_DIAL,uri);
                        startActivity(intent);
                        setResult(RESULT_OK,intent);
                        break;
                    case R.id.radioButton2 :
                        Intent intent1=new Intent(MediaStore.ACTION_IMAGE_CAPTURE_SECURE);
                        startActivity(intent1);
                        setResult(RESULT_OK,intent1);
                        break;
                }

            }
        });
    }
}

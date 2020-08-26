package com.example.diy10_2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ex02_practice10_2.R;

public class ResultActivity extends AppCompatActivity {

    Button btnReturn;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        imageView=findViewById(R.id.imageView);
        btnReturn = findViewById(R.id.btnReturn);
        Integer imageFileid[] = {R.drawable.kakao01,R.drawable.kakao02,R.drawable.kakao03,R.drawable.kakao04,R.drawable.kakao05,R.drawable.kakao06,R.drawable.kakao07,R.drawable.kakao08,R.drawable.kakao09};

        // MainActivity에서 보낸 인텐트 객체 받기
        Intent intent = getIntent();
        String[] imageNames = intent.getStringArrayExtra("nameData");
        int[] voteResult = intent.getIntArrayExtra("voteData");

        math.max()


    }
}

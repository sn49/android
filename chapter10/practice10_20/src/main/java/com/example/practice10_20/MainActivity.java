package com.example.practice10_20;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    Button btnDial,btnWeb,btnGoogle,btnSearch,btnSms,btnPhoto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDial=findViewById(R.id.btnDial);
        btnGoogle=findViewById(R.id.btnGoogle);
        btnWeb=findViewById(R.id.btnWeb);
        btnSearch=findViewById(R.id.btnSearch);
        btnSms=findViewById(R.id.btnSms);
        btnPhoto=findViewById(R.id.btnPhoto);



        final View.OnClickListener listner = new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Uri uri;
                Intent intent;
                switch (v.getId()){
                    case R.id.btnDial :
                        uri = Uri.parse("tel:01012345678");
                        intent = new Intent(Intent.ACTION_DIAL,uri);
                        startActivity(intent);
                        break;
                    case R.id.btnGoogle :
                        uri =Uri.parse("https://map.naver.com/v5/search/%EA%B4%91%EC%A3%BC%EC%86%8C%ED%94%84%ED%8A%B8%EC%9B%A8%EC%96%B4%EB%A7%88%EC%9D%B4%EC%8A%A4%ED%84%B0%EA%B3%A0%EB%93%B1%ED%95%99%EA%B5%90?c=14115251.5914177,4183279.1251910,17,0,0,0,dh");
                        intent = new Intent(Intent.ACTION_VIEW,uri);
                        startActivity(intent);
                        break;
                    case R.id.btnPhoto :
                        intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        startActivity(intent);
                        break;
                    case R.id.btnSearch :
                        intent = new Intent(Intent.ACTION_WEB_SEARCH);
                        intent.putExtra(SearchManager.QUERY,"광주소프트웨어마이스터고");
                        startActivity(intent);
                        break;
                    case R.id.btnSms :
                        intent = new Intent(Intent.ACTION_SENDTO);
                        intent.putExtra("sms_body","광주소프트웨어마이스터고");
                        intent.setData(Uri.parse("smsto:"+Uri.encode("010-9549-7174")));
                        startActivity(intent);
                        break;
                    case R.id.btnWeb :
                        uri =Uri.parse("http://avoidgames.com");
                        intent = new Intent(Intent.ACTION_VIEW,uri);
                        startActivity(intent);
                        break;
                }
            }
        };

        btnDial.setOnClickListener(listner);
        btnSms.setOnClickListener(listner);
        btnPhoto.setOnClickListener(listner);
        btnWeb.setOnClickListener(listner);
        btnGoogle.setOnClickListener(listner);
        btnSearch.setOnClickListener(listner);
    }
}

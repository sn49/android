package com.example.kartrider_information_java;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.telecom.Call;
import android.util.JsonReader;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.example.kartrider_information_java.Fragment1;
import com.example.kartrider_information_java.Fragment2;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import com.example.kartrider_information_java.MainActivity.*;

import javax.net.ssl.HttpsURLConnection;

public class Test extends AppCompatActivity {

    Button button1, button2, button3;
    Fragment1 fragment1;
    Fragment2 fragment2;
    Fragment3 fragment3;
    FragmentTransaction transaction;
    FrameLayout frameLayout;
    MainActivity mainActivity;

    String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);
        setTitle("OP.GG");

        frameLayout = findViewById(R.id.fragment_a);

        button1 = findViewById(R.id.button1);
//        button2 = findViewById(R.id.button2);
//        button3 = findViewById(R.id.button3);

        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        fragment3 = new Fragment3();
        mainActivity = new MainActivity();

        transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_a, fragment1).commit();

        /*final Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);*/

        //region
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button1.setBackgroundResource(R.drawable.line);
//                button2.setBackgroundResource(R.drawable.haejae);
//                button3.setBackgroundResource(R.drawable.haejae);
                transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_a, fragment1).commit();

                //startActivity(intent);
            }
        });

//        button2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                button2.setBackgroundResource(R.drawable.line);
//                button1.setBackgroundResource(R.drawable.haejae);
//                button3.setBackgroundResource(R.drawable.haejae);
//                transaction = getSupportFragmentManager().beginTransaction();
//                transaction.replace(R.id.fragment_a, fragment2).commit();
//
//
//            }
//        });
//
//        button3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                button3.setBackgroundResource(R.drawable.line);
//                button2.setBackgroundResource(R.drawable.haejae);
//                button1.setBackgroundResource(R.drawable.haejae);
//                transaction = getSupportFragmentManager().beginTransaction();
//                transaction.replace(R.id.fragment_a, fragment3).commit();
//            }
//        });
        //endregion
    }
}
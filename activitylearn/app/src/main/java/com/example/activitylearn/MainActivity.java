package com.example.activitylearn;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_activy);
        Log.d("MainActivty","Oncreate");
        Toast.makeText(this, "OnCreate", Toast.LENGTH_SHORT).show();



    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("MainActivty","OnStart");
        Toast.makeText(this, "onStart", Toast.LENGTH_SHORT).show();
    }

    public void onPostResume(){
        super.onPostResume();
        Log.d("MainActivty","OnPostResume");
        Toast.makeText(this, "onPostResume", Toast.LENGTH_SHORT).show();
    }

    public void onPause(){
        super.onPause();
        Log.d("MainActivty","OnPause");
        Toast.makeText(this, "onPause", Toast.LENGTH_SHORT).show();
    }

    public void onStop(){
        super.onStop();
        Log.d("MainActivty","OnStop");
        Toast.makeText(this, "onStop", Toast.LENGTH_SHORT).show();
    }
}

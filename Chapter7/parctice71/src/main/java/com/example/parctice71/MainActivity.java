package com.example.parctice71;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {


    LinearLayout linearLayout;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("배경색 바꾸기");
        linearLayout = findViewById(R.id.linearLayout);
        button = findViewById(R.id.button);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu1,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.itemRed:
                linearLayout.setBackgroundColor(Color.RED);
                break;
            case R.id.itemGreen:
                linearLayout.setBackgroundColor(Color.GREEN);
                break;
            case R.id.itemBlue:
                linearLayout.setBackgroundColor(Color.BLUE);
                break;
            case R.id.subRotate:
                button.setRotation(button.getRotationX()+45);
                break;
            case R.id.subSizeUp:
                button.setScaleX(button.getScaleX()*2);
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}

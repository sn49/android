package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Spinner spinner;


    ArrayList<String> datalist = getStringList(20);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=findViewById(R.id.textView);
        spinner=findViewById(R.id.spinner);

        //Adapter생성
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,datalist);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);



        //spinner 어댑터
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               textView.setText(datalist.get(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

    private ArrayList<String> getStringList(int count) {
        ArrayList<String> arrayList = new ArrayList<String>();
        for (int i=1; i<=count; i++){
            arrayList.add("리스트 아이템 "+i);
        }
        return arrayList;
    }
}

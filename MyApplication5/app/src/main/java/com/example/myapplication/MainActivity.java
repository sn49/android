package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;
import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    Button btnadd,btnmodify,btndelete;
    ListView listView;
    TextView textView;
    ArrayAdapter arrayAdapter;
    List<String> context2;
    Context context;
    Inflater inflater;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnadd=findViewById(R.id.btnadd);
        btnmodify=findViewById(R.id.btnmodify);
        btndelete=findViewById(R.id.btndelete);

        listView=findViewById(R.id.listview);
        textView=findViewById(R.id.textview);
        context2=getContext2(5);
        arrayAdapter = new ArrayAdapter(context,android.R.layout.simple_list_item_single_choice ,context2);
        listView.setAdapter(arrayAdapter);
        listView.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);
        listView.setOnItemClickListener(new ListView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }

    List<String> getContext2(int amount){
        List<String> list = null;
        for(int i=0; i<amount; i++){
            list.add("리스트 데이터 "+(i+1));
        }

        return list;
    }
}

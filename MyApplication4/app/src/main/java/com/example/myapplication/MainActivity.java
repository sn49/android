package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.AndroidException;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    ListView listView;
    Button btnadd;

    ArrayList<itemvo> datalist= new ArrayList<itemvo>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=findViewById(R.id.listView);
        textView=findViewById(R.id.selectedListItem);
        btnadd=findViewById(R.id.addBtn);

        datalist.add(new itemvo("doc","document1","simple data"));
        datalist.add(new itemvo("img","image1","simple data"));
        datalist.add(new itemvo("file","file1","simple data"));

        CustomAdapter adapter=new CustomAdapter(this,R.layout.row,datalist);














        listView.setOnItemClickListener();
    }
}

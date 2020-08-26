package com.example.a2x02_listview;

import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    ListView listView;

    String[] dataArr = getStringArray();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        listView = findViewById(R.id.listview);

        ArrayAdapter<String> adapter = new ArrayAdapter(this,R.layout.row,dataArr);
        listView.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                textView.setText(dataArr[position]);
            }
        });

    }


    private String[] getStringArray() {
        String[] strArr = new String[100];
        for (int i=0; i<strArr.length; i++){
            strArr[i] = "아이템"+(i+1);
        }

        return strArr;
    }

    private ArrayList<String> getStringList(){
        ArrayList<String> arrayList = new ArrayList<String>();
        for(int i=1; i<=100; i++){
            arrayList.add("리스트 아이템"+i);
        }

        return arrayList;
    }

}

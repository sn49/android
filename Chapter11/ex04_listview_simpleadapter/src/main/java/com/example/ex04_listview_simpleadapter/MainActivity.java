package com.example.ex04_listview_simpleadapter;

import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    ListView listView;

     ArrayList titledata<String> = getStringList("Title",50);
     ArrayList contentsdata<String> = getStringList("Contents",50);







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        listView = findViewById(R.id.listview);


           ArrayList<HashMap<String,String>> listviewdata = new ArrayList<HashMap<String, String>>();

           for (int i=0; i<titledata.size(); i++){
               HashMap<String,String> hashmap = new HashMap<String, String>();
               hashmap.put("title",titledata.get(i));
               hashmap.put("context",contentsdata.get(i));

               listviewdata.add(hashmap);
           }

           String[] keys={"title","contents"};

           int[] id={android.R.id.text1,android.R.id.text2};

        SimpleAdapter adapter = new SimpleAdapter(this,listviewdata,android.R.layout.simple_list_item_2,keys,id);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                textView.setText(titledata.get(position)+":"+contentsdata.get(position));

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

    private ArrayList<String> getStringList(String data,int count){
        ArrayList<String> arrayList = new ArrayList<String>();
        for(int i=1; i<=count; i++){
            arrayList.add(data+i);
        }

        return arrayList;
    }

}

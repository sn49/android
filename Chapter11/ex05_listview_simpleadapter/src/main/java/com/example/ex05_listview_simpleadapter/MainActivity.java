package com.example.ex05_listview_simpleadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {


    TextView textView;
    ListView listView;

    int[] imgresids={R.drawable.kakao01,R.drawable.kakao02,R.drawable.kakao03,R.drawable.kakao04,R.drawable.kakao05,R.drawable.kakao06,R.drawable.kakao07,R.drawable.kakao08,R.drawable.kakao09};

    ArrayList<String> titledata = getArrayListdata("title",imgresids.length);
    ArrayList<String> contentsdata = getArrayListdata("Contents",imgresids.length);

    private ArrayList<String> getArrayListdata(String str,int count) {
        ArrayList<String> list = new ArrayList<String>();
        for (int i=0; i<count; i++){
            list.add(str+(i+1));
        }
        return list;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        listView = findViewById(R.id.listView);

        ArrayList<HashMap<String,Object>> listviewdata = new ArrayList<>();
        for(int i=0; i<imgresids.length;i++){
            HashMap<String,Object> heshMap = new HashMap<String,Object>();
            heshMap.put("img",imgresids[i]);
            heshMap.put("title",titledata.get(i));
            heshMap.put("contents",contentsdata.get(i));

            listviewdata.add(heshMap);
        }


        SimpleAdapter adapter = new SimpleAdapter(this,listviewdata,R.layout.row,new String[]{"img","title","contents"},new int[]{R.id.rowimageView,R.id.textviewrowtitle,R.id.textviewrowcontents});

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                textView.setText(titledata.get(position)+" : "+contentsdata.get(position));
            }
        });
    }
}

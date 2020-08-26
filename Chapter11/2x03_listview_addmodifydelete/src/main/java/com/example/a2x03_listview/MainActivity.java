package com.example.a2x03_listview;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView textView;
    ListView listView;
    Button btnadd, btnmodify, btndelete;
    ArrayList<String> arrayList = getArrayListData();
    ArrayAdapter<String> adapter;

    @Override
    public void onClick(View v) {
        final int checkedItemPosition = listView.getCheckedItemPosition();
        switch(v.getId()){
            case R.id.btnadd :
                int count = adapter.getCount();
                arrayList.add("리스트 아이템"+(count+1));
                break;
            case R.id.btndelete :
                arrayList.remove(checkedItemPosition);
                break;
            case R.id.btnmodify :
                final EditText editText = new EditText(getApplicationContext());
                new AlertDialog.Builder(getApplicationContext())
                        .setTitle("리스트뷰의 아이템 수정")
                        .setMessage("선택된 데이터 : "+arrayList.get(checkedItemPosition))
                        .setIcon(R.mipmap.ic_launcher)
                        .setCancelable(false)
                        .setView(editText)
                        .setPositiveButton("수정", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                arrayList.set(checkedItemPosition,editText.getText().toString());
                            }
                        })
                        .setNegativeButton("취소",null)
                        .show();
                break;
        }
        adapter.notifyDataSetChanged();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        listView = findViewById(R.id.listview);
        btnadd = findViewById(R.id.btnadd);
        btndelete = findViewById(R.id.btndelete);
        btnmodify = findViewById(R.id.btnmodify);

        adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice,arrayList);
        listView.setChoiceMode(listView.CHOICE_MODE_SINGLE);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                textView.setText(arrayList.get(position));
            }
        });

        btnadd.setOnClickListener(this);
        btndelete.setOnClickListener(this);
        btnmodify.setOnClickListener(this);
    }

    private ArrayList<String> getArrayListData() {
        ArrayList<String > arrayList = new ArrayList<String>();
        for(int i=0; i<5; i++){
            arrayList.add("리스트 아이템"+(i+1));
        }
        return arrayList;
    }
}
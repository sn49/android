package com.example.kartrider_information_java;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment2 extends Fragment {

    ListView lv;
    MyAdapter myAdapter = new MyAdapter();
    int count = 0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_fragment2, container, false);

        lv = v.findViewById(R.id.listView);

        if (count == 0) {
            myAdapter.addItem("1위 : 솔라", null);
            myAdapter.addItem("2위 : 핑크 코튼", null);
            myAdapter.addItem("3위 : 골드 로디 카프카", null);
            myAdapter.addItem("4위 : 퍼플 미티어", null);
            myAdapter.addItem("5위 : 스파이더", null);
            count++;
        }

        lv.setAdapter(myAdapter);


        return v;
    }
}
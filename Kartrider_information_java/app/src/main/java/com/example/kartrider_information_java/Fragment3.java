package com.example.kartrider_information_java;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment3 extends Fragment {

    ListView lv;
    MyAdapter myAdapter = new MyAdapter();
    int count=0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_fragment3, container, false);

        lv = v.findViewById(R.id.listView);

        if (count == 0) {
            myAdapter.addItem("1위 : 빌리지 고가의 질주", null);
            myAdapter.addItem("2위 : 비치 해변 드라이브", null);
            myAdapter.addItem("3위 : 차이나 서안 병마용", null);
            myAdapter.addItem("4위 : 월드 두바이 다운타운", null);
            myAdapter.addItem("5위 : 아이스 갈라진 빙산산", null);
            count++;
        }
       lv.setAdapter(myAdapter);

        return v;
    }
}
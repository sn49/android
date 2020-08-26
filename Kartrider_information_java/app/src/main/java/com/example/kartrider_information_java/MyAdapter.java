package com.example.kartrider_information_java;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {

    private ArrayList<User> users = new ArrayList<>();

    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public User getItem(int position) {
        return users.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Context context = parent.getContext();

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.row, parent, false);


        TextView textViewTitle = convertView.findViewById(R.id.textViewTitle);
        //TextView textViewContent = convertView.findViewById(R.id.textViewContent);

        User user = getItem(position);

        textViewTitle.setText(user.getMap());
        //textViewContent.setText(user.getTime());

        return convertView;
    }

    public void addItem(String map, String contents) {

        User user = new User();

        user.setMap(map);
        user.setTime(contents);

        /* mItems에 MyItem을 추가한다. */
        users.add(user);
    }
}
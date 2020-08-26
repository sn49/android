package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

class CustomAdapter extends BaseAdapter {
    Context context;
    int resource;
    ArrayList<itemvo> dataList;

    public CustomAdapter(Context context, int resource, ArrayList<itemvo> dataList) {
        this.context = context;
        this.resource = resource;
        this.dataList = dataList;
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Object getItem(int position) {
        return dataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(context);
            inflater.inflate(resource,null);
        }

        ImageView imageView = convertView.findViewById(R.id.imageView);
        TextView textView = convertView.findViewById(R.id.textView);
        TextView textView1 = convertView.findViewById(R.id.textView2);

        switch (dataList.get(position).getTypestr()){
            case "doc":
                imageView.setImageResource(R.drawable.ic_launcher_background);
                break;
            case "img":
                imageView.setImageResource(R.drawable.ic_launcher_foreground);
                break;
            case "file":
                imageView.setImageResource(R.mipmap.ic_launcher);
                break;
        }
        textView.setText(dataList.get(position).getTitlestr());
        textView1.setText(dataList.get(position).getTypestr());


        return convertView;
    }
}

package com.example.ex01_thread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;



public class MainActivity extends AppCompatActivity {

    ProgressBar pb1,pb2;
    Button btn_thread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pb1=findViewById(R.id.progressBar3);
        pb2=findViewById(R.id.progressBar4);
        btn_thread=findViewById(R.id.btn_thread);

//        btn_thread.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
//
//        btn_thread.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ProgressThread pt1 = new ProgressThread(pb1,2);
//                pt1.start();
//
//                ProgressThread pt2=new ProgressThread(pb2,1);
//                pt2.start();
//            }
//        });

        btn_thread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(){
                    @Override
                    public void run() {
                        for(int i=0; i<100; i++){
                            pb1.setProgress(pb1.getProgress()+2);
                            pb2.setProgress(pb2.getProgress()+1);
                            SystemClock.sleep(100);
                        super.run();
                    }
                    }
                }.start();
            }
        });



    }
}

class ProgressThread extends Thread{
    ProgressBar pb;
    int increaseValue;

    public ProgressThread(ProgressBar pb,int increaseValue){
        this.pb=pb;
        this.increaseValue = increaseValue;
    }


    public void run(){
        for(int i=0; pb.getProgress()<=100; i+=increaseValue){
            pb.setProgress(i);
            SystemClock.sleep(100);
        }
    }
}
package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class dialog extends AppCompatActivity {

    Button btnDialog1, btnDialog2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        btnDialog1 = findViewById(R.id.btndialog1);
        btnDialog2 = findViewById(R.id.btndialog2);

        btnDialog1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                AlertDialog.Builder builder = new AlertDialog.Builder(dialog.this);
                builder.setTitle("제목");
                builder.setMessage("내용");
                builder.setIcon(R.mipmap.ic_launcher);
                builder.show();
            }
        });

        final DialogInterface.OnClickListener dialogListner = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                    switch(i){
                        case DialogInterface.BUTTON_NEUTRAL:
                            Toast.makeText(dialog.this,"BUTTON_NEUTRAL",Toast.LENGTH_SHORT).show();
                            break;
                        case DialogInterface.BUTTON_NEGATIVE:
                            Toast.makeText(dialog.this,"BUTTON_NEGATIVE",Toast.LENGTH_SHORT).show();
                            break;
                        case DialogInterface.BUTTON_POSITIVE:
                            Toast.makeText(dialog.this,"BUTTON_POSITIVE",Toast.LENGTH_SHORT).show();
                            break;
                }
            }
        };

        btnDialog2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                new AlertDialog.Builder(dialog.this)
                        .setTitle("제목")
                        .setMessage("내용")
                        .setIcon(R.mipmap.ic_launcher)
                        .setNegativeButton("Negative",null)
                        .setPositiveButton("Positive",null)
                        .setNeutralButton("Neutral",null)
                        .show();
            }
        });
    }
}

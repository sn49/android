package com.example.boardtimer;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    TextToSpeech textToSpeech;
    EditText editTextEnteredSecond;
    Button btnTimerSwitch,btnReset,btnPauseRestart;
    TextView textViewCopyright;
    CountDownTimer countDownTimer;

    long fulltime, halfTime;
    boolean ispause=false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //region
        editTextEnteredSecond = findViewById(R.id.editTextEnteredSeconds);
        btnTimerSwitch = findViewById(R.id.btnTimerSwitch);
        btnPauseRestart = findViewById(R.id.btnPauseRestart);
        btnReset = findViewById(R.id.btnReset);
        textViewCopyright = findViewById(R.id.textViewCopyright);
        //endregion



        btnTimerSwitch.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                MediaPlayer.create(getApplicationContext(),R.raw.bell_sound2);
                canceltimer();
                resetTimer();
                countDownTimer = countDownTimer(fulltime);
                countDownTimer.start();
            }
        });

        btnPauseRestart.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(ispause){
                    btnPauseRestart.setText(R.string.pause);
                    countDownTimer = countDownTimer(Long.parseLong(btnTimerSwitch.getText().toString()));
                    countDownTimer.start();
                    ispause=false;
                }else{
                    countDownTimer.cancel();
                    btnPauseRestart.setText(R.string.restart);
                    ispause=true;
                }
            }
        });


        btnReset.setOnLongClickListener(new View.OnLongClickListener(){

            public boolean onLongClick(View v) {


                resetTimer();
                canceltimer();
            }
        });
    }

    private void resetTimer(){
            if (editTextEnteredSecond.getText().toString().equals("")) {
                Toast.makeText(MainActivity.this, "입력값이 없습니다.", Toast.LENGTH_SHORT).show();
                return;
            }
            fulltime = Long.parseLong(editTextEnteredSecond.getText().toString());
            halfTime = Math.round(fulltime / 2);


            btnTimerSwitch.setBackgroundColor(Color.YELLOW);
            btnTimerSwitch.setTextColor(Color.BLACK);
            btnTimerSwitch.setEnabled(true);
    }

    private void canceltimer(){
    if(countDownTimer!=null)
        countDownTimer.cancel();
    }


    private CountDownTimer countDownTimer(long t){
        return new CountDownTimer(t*1000,1000) {
            @Override
            public void onTick(long l) {
                long currenttime = l/1000;
                changeTextSize(currenttime);

                if(currenttime<=halfTime){
                    MediaPlayer.create(getApplicationContext(),R.raw.warning_sound);
                }

                if(currenttime<=10){
                    btnTimerSwitch.setTextColor(Color.RED);

                btnTimerSwitch.setText(String.valueOf(currenttime));
            }

            @Override
            public void onFinish() {
                btnTimerSwitch.setBackgroundColor(Color.DKGRAY);
                btnTimerSwitch.setTextColor(Color.GRAY);
                btnTimerSwitch.setEnabled(false);
            }
        }

    }

    private void changeTextSize(long seconds){
        if(seconds>=100){
            btnTimerSwitch.setTextSize(200);
        }else if(seconds>=10){
            btnTimerSwitch.setTextSize(300);
        }else{
            btnTimerSwitch.setTextSize(400);
        }
    }
}

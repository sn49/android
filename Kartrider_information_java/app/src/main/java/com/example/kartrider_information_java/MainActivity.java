package com.example.kartrider_information_java;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.JsonReader;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {
    TextView userview;
    TextView resultview;
    Button button_search;
    EditText editText;
    ImageView trackView,characterview,kartView;

    String text;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);



        kartView=findViewById(R.id.kart_view);
        characterview=findViewById(R.id.character_view);
        trackView =findViewById(R.id.track_view);
        userview= findViewById(R.id.userview);
        button_search=findViewById(R.id.button_search);
        editText=findViewById(R.id.editText);
        resultview=findViewById(R.id.resultview);

        button_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultview.setText("");
                Connecting connect = new Connecting();
                if (connect.isAlive()) {
                    connect.interrupt();
                }
                else
                    connect.start();
            }
        });


    }

    public class Connecting extends Thread
    {
        URL kartrequesturl = null;
        JsonReader jsonReader;
        HttpsURLConnection myConnection;
        String key="Authorization";
        String value="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhY2NvdW50X2lkIjoiMTY0NDQyMzc3NiIsImF1dGhfaWQiOiIyIiwidG9rZW5fdHlwZSI6IkFjY2Vzc1Rva2VuIiwic2VydmljZV9pZCI6IjQzMDAxMTM5MyIsIlgtQXBwLVJhdGUtTGltaXQiOiIyMDAwMDoxMCIsIm5iZiI6MTU3NDY3MTM3NSwiZXhwIjoxNjM3NzQzMzc1LCJpYXQiOjE1NzQ2NzEzNzV9.MrI87qOGv3ejTAKrPC5yZxZi6VO3zYnZvaUAdDKchIE";
        InputStreamReader responsebodyreader=null;
        InputStream responsebody= null;
        String name;
        String username;
        String accessid;
        String Urlstring;
        String showvalue;
        int number;
        void getusernumber() throws Exception {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    userview.setText("");
                }
            });
            String nickname=editText.getText().toString();
            Urlstring="https://api.nexon.co.kr/kart/v1.0/users/nickname/"+nickname;
            connect();
        }

        void getuserresult() throws Exception{
            Urlstring="https://api.nexon.co.kr/kart/v1.0/users/"+accessid+"/matches?start_date=&end_date= &offset=0&limit=1&match_types=";
            connect();
        }

        <T> void runuiname(final T value){
            runOnUiThread(new Runnable() {

                @Override
                public void run() {
                    resultview.setText(resultview.getText()+"\n"+value+"\n");
                }
            });
        }


        void connect() throws Exception {
            kartrequesturl = new URL(Urlstring);
            myConnection = (HttpsURLConnection) kartrequesturl.openConnection();
            myConnection.setRequestProperty(key, value);
        }

        void startjsonread() throws Exception {
            responsebody = myConnection.getInputStream();
            responsebodyreader = new InputStreamReader(responsebody);
            jsonReader = new JsonReader(responsebodyreader);
        }




        @Override
        public void run()
        {
            try {
                getusernumber();
            } catch (Exception e) {
                e.printStackTrace();
            }


            try
            {

                if (myConnection.getResponseCode() == 200)
                {
                    startjsonread();

                    jsonReader.beginObject();
                    while(jsonReader.hasNext()) {
                        name= jsonReader.nextName();
                        if (name.equals("name")){
                            username=jsonReader.nextString();
                        }
                        else if(name.equals("accessId")){
                            accessid=jsonReader.nextString();
                        }
                        final String Username = username;
                        final String finalAccesssid = accessid;
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                //userview.setText(Username+"\n"+ finalAccesssid);
                            }
                        });
                    }

                    jsonReader.endObject();
                }

                //region 유저의 정보를 불러오는 곳
                getuserresult();
                if (myConnection.getResponseCode()==200){
                    startjsonread();
                    String license;
                    while(jsonReader.hasNext()){
                        if(jsonReader.peek().toString().equals("BEGIN_ARRAY")){
                            jsonReader.beginArray();
                        }
                        else if(jsonReader.peek().toString().equals("BEGIN_OBJECT")){
                            jsonReader.beginObject();
                        }
                        else if(jsonReader.peek().toString().equals("STRING")){
                            jsonReader.nextString();
                        }
                        else if(jsonReader.peek().toString().equals("END_ARRAY")){
                            jsonReader.endArray();
                        }
                        else if(jsonReader.peek().toString().equals("END_OBJECT")){
                            jsonReader.endObject();
                        }
                        else if(jsonReader.peek().toString().equals("NAME")){
                            name=jsonReader.nextName();
                            final String trackId;

                            Resources resources=getResources();
                            int resourceid;


                            if(name.equals("matchRank")) {

                                name = "순위";
                                String rank=jsonReader.nextString();
                                if(rank.equals("99")){
                                    rank="리타이어";
                                }

                                runuiname("순위 : "+rank);

                            }
                            else if (name.equals("rankinggrade2")){
                                name="라이센스";

                                switch(jsonReader.nextString()) {
                                    case "1":
                                        license = "초보";
                                        break;
                                    case "2":
                                        license = "루키";
                                        break;
                                    case "3":
                                        license = "L3";
                                        break;
                                    case "4":
                                        license = "L2";
                                        break;
                                    case "5":
                                        license = "L1";
                                        break;
                                    case "6":
                                        license = "프로";
                                        break;
                                    default :
                                        license="알 수 없음";


                                }
                                runuiname(name+" : "+license);


                            }
                            else if (name.equals("channelName")){
                                runuiname("채널 이름 : "+jsonReader.nextString());
                            }
                            else if(name.equals("playerCount")) {
                                runuiname("플레이어 수 : "+jsonReader.nextString());
                            }
                            else if(name.equals("nickName")) {
                                runuiname("닉네임 : "+jsonReader.nextString());
                            }
                            else if(name.equals("trackId")){
                                trackId=jsonReader.nextString();
                                resourceid = resources.getIdentifier("_"+trackId,"drawable",getPackageName());
                                trackView.setImageResource(resourceid);

                            }
                            else if(name.equals("character")){
                                trackId=jsonReader.nextString();
                                resourceid = resources.getIdentifier("_"+trackId,"drawable",getPackageName());
                                characterview.setImageResource(resourceid);

                            }
                            else if(name.equals("matchWin")){
                                String result;
                                if(jsonReader.nextString().equals("0"))
                                    result="패배";
                                else
                                    result="승리";

                                runuiname("결과 : "+result);
                            }
                            else if(name.equals("kart")){


                                trackId=jsonReader.nextString();
                                if(trackId.equals("")){
                                    runuiname("연습카트 X를 탔을 확률이 높음...");
                                    kartView.setImageResource(R.drawable.ic_launcher_background);
                                }
                                else {
                                    resourceid = resources.getIdentifier("_" + trackId, "drawable", getPackageName());
                                    kartView.setImageResource(resourceid);
                                }


                            }


                        }
                        else if(jsonReader.peek().toString().equals("NUMBER")){
                            number=jsonReader.nextInt();
                            runuiname(number);
                        }
                    }
                }
                else{

                }
                //endregion

                Thread.sleep(1000);
            }
            catch (final Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}

/*class item_info{
    Bitmap map_image;
    String map_name;
    String date;
    int person;
    int rank;
    String mode;
}*/

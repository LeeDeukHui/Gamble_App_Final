package com.example.orangefit.test;

import android.graphics.Typeface;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.*;
import android.view.animation.*;
import android.widget.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;


public class MainActivity extends AppCompatActivity {
    ViewFlipper flipper;

    public static int tmp;
    public static int score = 0;
    public static ArrayList<Question> Q_data_adult = new ArrayList<Question>();
    public static ArrayList<Question> Q_data_teen = new ArrayList<Question>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);
        setting();
        Typeface face = Typeface.createFromAsset(getAssets(), "훈솜사탕R.ttf");
        flipper = (ViewFlipper)findViewById(R.id.flipper);
        Button start_button = (Button) findViewById(R.id.start_button);
        start_button.setTypeface(face);
        Button teen_button = (Button) findViewById(R.id.teen_button);
        teen_button.setTypeface(face);
        teen_button.setVisibility(View.GONE);
        Button adult_button = (Button) findViewById(R.id.adult_button);
        adult_button.setVisibility(View.GONE);
        adult_button.setTypeface(face);

        Animation showIn= AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
        flipper.setInAnimation(showIn);
        flipper.setOutAnimation(this, android.R.anim.slide_out_right);
        flipper.setFlipInterval(5000);
        flipper.startFlipping();

    }
    public void cu_Click(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.cu.ac.kr"));
        startActivity(myIntent);
    }//학교 배너 클릭

    public void gamble_Click(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.kcgp.or.kr"));
        startActivity(myIntent);
    }//도박관리센터 배너 클릭


    public void cu2_Click(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.cu.ac.kr"));
        startActivity(myIntent);
    }//학교 배너 클릭(사업단배너)

    public void start_Click(View v){
        Button start_button = (Button) findViewById(R.id.start_button);
        start_button.setVisibility(View.GONE);

        Button teen_button = (Button) findViewById(R.id.teen_button);
        teen_button.setVisibility(View.VISIBLE);
        Button adult_button = (Button) findViewById(R.id.adult_button);
        adult_button.setVisibility(View.VISIBLE);
    }//시작 버튼 클릭

    public void childBTN_Click(View v){

        Intent intent = new Intent(getApplicationContext(), GambleActivity.class);
        startActivity(intent);
        tmp = 1;
        Button start_button = (Button) findViewById(R.id.start_button);
        start_button.setVisibility(View.VISIBLE);
        Button teen_button = (Button) findViewById(R.id.teen_button);
        teen_button.setVisibility(View.GONE);
        Button adult_button = (Button) findViewById(R.id.adult_button);
        adult_button.setVisibility(View.GONE);

    }//청소년 버튼 클릭

    public void adultBTN_Click(View v){
        Intent intent = new Intent(getApplicationContext(), GambleActivity.class);
        startActivity(intent);
        tmp = 0;
        Button start_button = (Button) findViewById(R.id.start_button);
        start_button.setVisibility(View.VISIBLE);
        Button teen_button = (Button) findViewById(R.id.teen_button);
        teen_button.setVisibility(View.GONE);
        Button adult_button = (Button) findViewById(R.id.adult_button);
        adult_button.setVisibility(View.GONE);

    }//성인 버튼 클릭

    public void setting(){

        try{
            InputStream Data_adult = getResources().openRawResource(R.raw.gamble_adult);
            BufferedReader Ques = new BufferedReader(new InputStreamReader(Data_adult, "UTF-8"));
            while(true){
                String data = Ques.readLine();
                if(data == null || data.charAt(0) == '\n'){
                    break;
                }
                Question tmp = new Question(1, data);
                Q_data_adult.add(tmp);
            }
            InputStream Data_teen = getResources().openRawResource(R.raw.gamble_teen);
            Ques = new BufferedReader(new InputStreamReader(Data_teen, "UTF-8"));
            while(true){
                String data = Ques.readLine();
                if(data == null || data.charAt(0) == '\n'){
                    break;
                }
                Question tmp = new Question(1, data);
                Q_data_teen.add(tmp);
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
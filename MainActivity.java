package com.example.orangefit.test;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);

        Button teen_button = (Button) findViewById(R.id.teen_button);
        teen_button.setVisibility(View.GONE);
        Button adult_button = (Button) findViewById(R.id.adult_button);
        adult_button.setVisibility(View.GONE);

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
    }//시작 버튼 클릭 -> 도박 설명으로 이동

    public void childBTN_Click(View v){

        Intent intent = new Intent(getApplicationContext(), GambleActivity.class);
        intent.putExtra("Type", "child");
        startActivity(intent);

        Button start_button = (Button) findViewById(R.id.start_button);
        start_button.setVisibility(View.VISIBLE);
        Button teen_button = (Button) findViewById(R.id.teen_button);
        teen_button.setVisibility(View.GONE);
        Button adult_button = (Button) findViewById(R.id.adult_button);
        adult_button.setVisibility(View.GONE);
    }//청소년 버튼 클릭 -> 도박 설명으로 이동
    public void adultBTN_Click(View v){
        Intent intent = new Intent(getApplicationContext(), GambleActivity.class);
        intent.putExtra("Type", "adult");
        startActivity(intent);

        Button start_button = (Button) findViewById(R.id.start_button);
        start_button.setVisibility(View.VISIBLE);
        Button teen_button = (Button) findViewById(R.id.teen_button);
        teen_button.setVisibility(View.GONE);
        Button adult_button = (Button) findViewById(R.id.adult_button);
        adult_button.setVisibility(View.GONE);
    }//성인 버튼 클릭 -> 도박 설명으로 이동
}

package com.example.orangefit.test;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.*;
import android.widget.*;

import java.util.ArrayList;

import static com.example.orangefit.test.GambleActivity.complete_Num;
import static com.example.orangefit.test.MainActivity.*;
import static com.example.orangefit.test.menu_4_operation.*;

/**
 * Created by ORANGEFIT on 2017-01-25.
 */

public class sub_menu_4_operation extends AppCompatActivity {
    int Q_data;
    int OK = 0;
    public ArrayList<Button> select_button = new ArrayList<Button>();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sub_menu_4);
        score = 0;
        Intent intent = getIntent();
        int Question_Num = intent.getIntExtra("Question_Num",0);

        Q_data = Question_Num;
        TextView score_board = (TextView)findViewById(R.id.scoreboard);
        if(tmp == 0) {
            score_board.setText(Q_data_adult.get(Question_Num).data + "");
        }
        else{
            score_board.setText(Q_data_teen.get(Question_Num).data + "");
        }


        Button b_1 = (Button)findViewById(R.id._1);
        Button b_2 = (Button)findViewById(R.id._2);
        Button b_3 = (Button)findViewById(R.id._3);
        Button b_4 = (Button)findViewById(R.id._4);
        select_button.add(b_1);
        select_button.add(b_2);
        select_button.add(b_3);
        select_button.add(b_4);
        for(int i=0; i<select_button.size(); i++){
            select_button.get(i).setBackgroundResource(R.color.PaleTurquoise);
        }

    }
    public void select(int N){
        for(int i=0; i<select_button.size(); i++){
            if(i == N-1){
                select_button.get(i).setCompoundDrawablesWithIntrinsicBounds(R.drawable.select,0,0,0);
                select_button.get(i).setBackgroundResource(R.color.PowderBlue);
            }
            else{
                select_button.get(i).setCompoundDrawablesWithIntrinsicBounds(0,0,0,0);
                select_button.get(i).setBackgroundResource(R.color.PaleTurquoise);
            }
        }

    }


    public void N_1(View v){
        if(tmp == 0) {
            Q_data_adult.get(Q_data).Score = 1;
        }
        else{
            Q_data_teen.get(Q_data).Score = 1;
        }
        select(1);
        TextView select_board = (TextView)findViewById(R.id.select);
        select_board.setText("매우 그렇지 않다.");
        select_board.setTextColor(Color.parseColor("#1E90FF"));
        OK = 1;
    }

    public void N_2(View v){
        if(tmp == 0) {
            Q_data_adult.get(Q_data).Score = 2;
        }
        else{
            Q_data_teen.get(Q_data).Score = 2;
        }
        select(2);
        TextView select_board = (TextView)findViewById(R.id.select);
        select_board.setText("그렇지 않다.");
        select_board.setTextColor(Color.parseColor("#1E90FF"));
        OK = 1;
    }

    public void N_3(View v){
        if(tmp == 0) {
            Q_data_adult.get(Q_data).Score = 3;
        }
        else{
            Q_data_teen.get(Q_data).Score = 3;
        }
        select(3);
        TextView select_board = (TextView)findViewById(R.id.select);
        select_board.setText("그렇다.");
        select_board.setTextColor(Color.parseColor("#1E90FF"));
        OK = 1;
    }

    public void N_4(View v){
        if(tmp == 0) {
            Q_data_adult.get(Q_data).Score = 4;
        }
        else{
            Q_data_teen.get(Q_data).Score = 4;
        }
        select(4);
        TextView select_board = (TextView)findViewById(R.id.select);
        select_board.setText("매우 그렇다.");
        select_board.setTextColor(Color.parseColor("#1E90FF"));
        OK = 1;
    }

    public void finish(View v){
        if(OK == 1) {
            complete_Num++;
            if(tmp == 0) {
                button_adult.get(Q_data).setText("완료");
                button_adult.get(Q_data).setCompoundDrawablesWithIntrinsicBounds(0,0,0,R.drawable.check);
                button_adult.get(Q_data).setBackgroundResource(R.color.Goldenrod);
                button_adult.get(Q_data).setEnabled(false);
            }
            else{
                button_teen.get(Q_data).setText("완료");
                button_teen.get(Q_data).setCompoundDrawablesWithIntrinsicBounds(0,0,0,R.drawable.check);
                button_teen.get(Q_data).setBackgroundResource(R.color.Goldenrod);
                button_teen.get(Q_data).setEnabled(false);
            }
        }
        finish();
    }
}

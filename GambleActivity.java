package com.example.orangefit.test;

/**
 * Created by ORANGEFIT on 2017-01-21.
 */
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.*;

import static com.example.orangefit.test.MainActivity.tmp;



public class GambleActivity extends AppCompatActivity{
    public static int complete_Num = 0;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_gamble);
        Typeface face = Typeface.createFromAsset(getAssets(), "HUSimple_0.ttf");
        Typeface face2 = Typeface.createFromAsset(getAssets(), "훈생활의발견R.ttf");

        Button sub_menu_1 = (Button) findViewById(R.id.sub_menu_1);
        sub_menu_1.setTypeface(face);
        Button sub_menu_2 = (Button) findViewById(R.id.sub_menu_2);
        sub_menu_2.setTypeface(face);
        Button sub_menu_3 = (Button) findViewById(R.id.sub_menu_3);
        sub_menu_3.setTypeface(face);
        Button sub_menu_4 = (Button) findViewById(R.id.sub_menu_4);
        sub_menu_4.setTypeface(face);
        Button sub_menu_5 = (Button) findViewById(R.id.sub_menu_5);
        sub_menu_5.setTypeface(face);
        Button sub_menu_6 = (Button) findViewById(R.id.sub_menu_6);
        sub_menu_6.setTypeface(face2);



        if(tmp== 0){
            setTitle("청소년");
        }
        else{
            setTitle("성인");
        }


    }

    public void sub_menu_1(View v){
        Intent intent = new Intent(this, sub_menu_1_operation.class);
        startActivity(intent);
    }
    public void sub_menu_4(View v){
        Intent intent = new Intent(GambleActivity.this, menu_4_operation.class);
        startActivity(intent);
        complete_Num = 0;
    }

    public void Home(View v){
        finish();
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

}
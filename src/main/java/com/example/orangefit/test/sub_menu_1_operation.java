package com.example.orangefit.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.*;

/**
 * Created by ORANGEFIT on 2017-01-22.
 */

public class sub_menu_1_operation extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sub_menu_1);

        TextView info_Text = (TextView)findViewById(R.id.sub_menu_1_textview);
        info_Text.setText("도박중독이란?");


    }
}

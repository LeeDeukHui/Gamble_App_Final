package com.example.orangefit.test;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.*;

import static com.example.orangefit.test.GambleActivity.complete_Num;
import static com.example.orangefit.test.MainActivity.*;
import static com.example.orangefit.test.menu_4_operation.*;

/**
 * Created by ORANGEFIT on 2017-01-27.
 */

public class menu_4_result extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_4_result);
        TextView result = (TextView)findViewById(R.id.menu_4_result);
        Typeface face = Typeface.createFromAsset(getAssets(), "훈솜사탕R.ttf");
        result.setTextSize(100);
        if(tmp == 0) {
            for (int i = 0; i < Q_data_adult.size(); i++) {
                score+=Q_data_adult.get(i).Score;
                Q_data_adult.get(i).Score = 0;
            }
        }
        else{
            for (int i = 0; i < Q_data_teen.size(); i++) {
                score+=Q_data_teen.get(i).Score;
                Q_data_teen.get(i).Score = 0;
            }
        }

        result.setText("총점 : "+score+"");

        Button ok_button = (Button)findViewById(R.id.complete_button);
        ok_button.setTypeface(face);
        ok_button.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                complete_Num = 0;
                score = 0;
                layout_adult.clear();
                button_adult.clear();
                layout_teen.clear();
                button_teen.clear();
               finish();
            }
        });
    }
}

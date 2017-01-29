package com.example.orangefit.test;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.BaseTransientBottomBar;
import android.support.v7.app.*;
import android.support.v7.widget.RecyclerView;
import android.view.*;
import android.widget.*;

import java.util.ArrayList;

import static com.example.orangefit.test.GambleActivity.complete_Num;
import static com.example.orangefit.test.MainActivity.*;

/**
 * Created by ORANGEFIT on 2017-01-26.
 */

public class menu_4_operation extends AppCompatActivity {

    public static ArrayList<LinearLayout> layout_adult = new ArrayList<LinearLayout>();
    public static ArrayList<LinearLayout> layout_teen = new ArrayList<LinearLayout>();
    public static ArrayList<Button> button_adult = new ArrayList<Button>();
    public static ArrayList<Button> button_teen = new ArrayList<Button>();
    public static int tmp_data = tmp;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        tmp_data = tmp;
        complete_Num = 0;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_4);
        Typeface face = Typeface.createFromAsset(getAssets(), "HUSimple_0.ttf");
        Typeface face2 = Typeface.createFromAsset(getAssets(), "훈솜사탕R.ttf");
        int i;
        int j = -1;

        final ScrollView parent_scroll = new ScrollView(this);
        final LinearLayout parent_layout = new LinearLayout(this);
        parent_scroll.addView(parent_layout);
        parent_scroll.setBackground(getResources().getDrawable(R.drawable.background));
        parent_layout.setOrientation(LinearLayout.VERTICAL);

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.weight = 1;
        layoutParams.setMargins(10,10,10,10);
        layoutParams2.setMargins(10,10,10,10);
        layoutParams3.weight = 1;
        layoutParams3.setMargins(10,10,10,10);

        if (tmp == 0) {
            for (i = 0; i < Q_data_adult.size() / 5 + 1; i++) {
                LinearLayout tmp = new LinearLayout(this);
                tmp.setOrientation(LinearLayout.HORIZONTAL);
                layout_adult.add(tmp);
                tmp.setLayoutParams(layoutParams2);
                parent_layout.addView(tmp);
            }

            for (i = 0; i < Q_data_adult.size(); i++) {
                if (i % 5 == 0) {
                    j++;
                }
                final int data = i;
                Button tmp = new Button(this);
                tmp.setLayoutParams(layoutParams3);
                tmp.setText(i + 1 + "");
                tmp.setId(i);
                tmp.setBackgroundResource(R.color.BurlyWood);
                tmp.setCompoundDrawablesWithIntrinsicBounds(0,0,0,R.drawable.uncheck);
                tmp.setTextSize(30);
                tmp.setTypeface(face);
                tmp.setOnClickListener(new Button.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(menu_4_operation.this, sub_menu_4_operation.class);
                        intent.putExtra("Question_Num", data);
                        startActivity(intent);
                    }
                });
                button_adult.add(tmp);
                layout_adult.get(j).addView(tmp);
            }
        } else {
            for (i = 0; i < Q_data_teen.size() / 5 + 1; i++) {
                LinearLayout tmp = new LinearLayout(this);
                tmp.setOrientation(LinearLayout.HORIZONTAL);
                layout_teen.add(tmp);
                tmp.setLayoutParams(layoutParams2);
                parent_layout.addView(tmp);
            }

            for (i = 0; i < Q_data_teen.size(); i++) {
                if (i % 5 == 0) {
                    j++;
                }
                final int data2 = i;
                Button tmp = new Button(this);
                tmp.setLayoutParams(layoutParams3);
                tmp.setText(i + 1 + "");
                tmp.setId(i);
                tmp.setBackgroundResource(R.color.BurlyWood);
                tmp.setCompoundDrawablesWithIntrinsicBounds(0,0,0,R.drawable.uncheck);
                tmp.setTypeface(face);
                tmp.setTextSize(30);
                tmp.setOnClickListener(new Button.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(menu_4_operation.this, sub_menu_4_operation.class);
                        intent.putExtra("Question_Num", data2);
                        startActivity(intent);
                    }
                });
                button_teen.add(tmp);
                layout_teen.get(j).addView(tmp);
            }

        }
//뒤로가는 버튼 만들기~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        LinearLayout tmp = new LinearLayout(this);
        tmp.setOrientation(LinearLayout.HORIZONTAL);
        tmp.setLayoutParams(layoutParams3);
        parent_layout.addView(tmp);

        Button b_tmp = new Button(this);
        b_tmp.setLayoutParams(layoutParams3);

        Button b_tmp2 = new Button(this);
        b_tmp2.setLayoutParams(layoutParams3);

        b_tmp.setText("그만할래요");
        b_tmp.setTypeface(face);
        b_tmp.setTextSize(27);
        b_tmp.setBackgroundResource(R.color.DarkGoldenrod);
        b_tmp.setCompoundDrawablesWithIntrinsicBounds(R.drawable.stop,0,0,0);
        b_tmp.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view){
                complete_Num = 0;
                layout_adult.clear();
                button_adult.clear();
                layout_teen.clear();
                button_teen.clear();

                finish();
            }
        });
        b_tmp2.setText("결과 확인");
        b_tmp2.setTypeface(face2);
        b_tmp2.setTextSize(27);
        b_tmp2.setBackgroundResource(R.color.DarkGoldenrod);
        b_tmp2.setCompoundDrawablesWithIntrinsicBounds(R.drawable.result,0,0,0);
        b_tmp2.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view){
                if(tmp_data == 0){
                    if(complete_Num == Q_data_adult.size()){
                        Intent intent = new Intent(menu_4_operation.this, menu_4_result.class);
                        startActivity(intent);
                        finish();
                    }
                    else{
                        new AlertDialog.Builder(menu_4_operation.this)
                                .setTitle("결과 확인을 할 수 없습니다.")
                                .setMessage("모든 문항에 답하세요.\n")
                                .setNeutralButton("닫기", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dlg, int sumthin) {

                                    }
                                })
                                .show(); // 팝업창 보여줌

                    }
                }
                else{
                    if(complete_Num == Q_data_teen.size()){
                        Intent intent = new Intent(menu_4_operation.this, menu_4_result.class);
                        startActivity(intent);
                        finish();
                    }
                    else{
                        new AlertDialog.Builder(menu_4_operation.this)
                                .setTitle("결과 확인을 할 수 없습니다.")
                                .setMessage("모든 문항에 답하세요.")
                                .setNeutralButton("닫기", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dlg, int sumthin) {

                                    }
                                })
                                .show(); // 팝업창 보여줌
                    }
                }

            }
        });
        tmp.addView(b_tmp);
        tmp.addView(b_tmp2);
        setContentView(parent_scroll);
    }
    @Override
    public void onBackPressed() {
        Toast.makeText(this, "자가진단이 초기화 되었습니다.", Toast.LENGTH_SHORT).show();
        super.onBackPressed();
        complete_Num = 0;
        layout_adult.clear();
        button_adult.clear();
        layout_teen.clear();
        button_teen.clear();
        finish();
    }
}

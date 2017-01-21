package spokenlanguagelab.gamble_app_finalgit;

import android.app.Activity;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by Lee Je-ho on 2017-01-19.
 */

public class MainActivity extends AppCompatActivity {
    public static ArrayList<Activity> activityStackList = new ArrayList<Activity>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        activityStackList.add(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);
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
    public void childBTN_Click(View v){
        Intent intent = new Intent(getApplicationContext(), GambleActivity.class);
        intent.putExtra("Type", "child");
        startActivity(intent);
    }//청소년 버튼 클릭 -> 도박 설명으로 이동
    public void adultBTN_Click(View v){
        Intent intent = new Intent(getApplicationContext(), GambleActivity.class);
        intent.putExtra("Type", "adult");
        startActivity(intent);
    }//성인 버튼 클릭 -> 도박 설명으로 이동
}

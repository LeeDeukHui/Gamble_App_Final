package spokenlanguagelab.gamble_app_finalgit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import static spokenlanguagelab.gamble_app_finalgit.MainActivity.activityStackList;

/**
 * Created by big94 on 2017-01-21.
 */

public class CenterGuideActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        activityStackList.add(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_centerguide);


    }
    public void prevBTN_Click(View v){
        finish();
    }
    public void nextBTN_Click(View v){
        for(int i=0; i<activityStackList.size();i++)  //actList, 즉 액티비티들을 배열로 저장.
        {
            activityStackList.get(i).finish(); // actList.add(this) 를 이용하여 쌓인 액티비티들을 종료 시킴.
        }
        Intent intent=new Intent(getApplicationContext(), MainActivity.class); // 메인으로 돌아가는 인텐트!
        startActivity(intent);
    }

}

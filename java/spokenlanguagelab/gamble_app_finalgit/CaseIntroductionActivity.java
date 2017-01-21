package spokenlanguagelab.gamble_app_finalgit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by big94 on 2017-01-21.
 */

public class CaseIntroductionActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_caseintroduction);
    }
    public void prevBTN_Click(View v){
        finish();
    }
    public void nextBTN_Click(View v){
        Intent intent = new Intent(getApplicationContext(), CenterGuideActivity.class);
        startActivity(intent);
    }
}

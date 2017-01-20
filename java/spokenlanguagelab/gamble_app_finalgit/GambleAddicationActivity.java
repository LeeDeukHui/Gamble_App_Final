package spokenlanguagelab.gamble_app_finalgit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Lee Je-ho on 2017-01-20.
 */

public class GambleAddicationActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_gamble_addication);
    }
    public void prevBTN_Click(View v){
        finish();
    }
    public void nextBTN_Click(View v){

    }
}

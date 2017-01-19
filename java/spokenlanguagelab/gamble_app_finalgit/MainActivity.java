package spokenlanguagelab.gamble_app_finalgit;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;

/**
 * Created by Lee Je-ho on 2017-01-19.
 */

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
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
    }

    public void cu2_Click(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.cu.ac.kr"));
        startActivity(myIntent);
    }//학교 배너 클릭(사업단배너)
}

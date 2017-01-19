package spokenlanguagelab.gamble_app_finalgit;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.os.Handler;


public class LoadingActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
                setContentView(R.layout.layout_loading);
                startLoading();
            }
            private void startLoading(){
                Handler handler = new Handler();
                handler.postDelayed(new Runnable(){
                    public void run(){
                        Intent intent = new Intent(getBaseContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 1000);
    }
}

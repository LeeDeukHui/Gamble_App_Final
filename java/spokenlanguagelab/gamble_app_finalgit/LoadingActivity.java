package spokenlanguagelab.gamble_app_finalgit;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.os.Handler;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;


public class LoadingActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_loading);

        ImageView loading = (ImageView)findViewById(R.id.loading);
        GlideDrawableImageViewTarget imageViewTarget = new GlideDrawableImageViewTarget(loading);       //레이아웃의 이미지뷰를 Glide 타겟에 추가
        Glide.with(this).load(R.drawable.loading_img).into(imageViewTarget);        //추가한 Glide 타겟에 Gif 이미지를 추가함.

        startLoading();     //2초 대기
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

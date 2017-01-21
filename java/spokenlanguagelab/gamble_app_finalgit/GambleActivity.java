package spokenlanguagelab.gamble_app_finalgit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Lee Je-ho on 2017-01-20.
 */

public class GambleActivity extends AppCompatActivity{
    private Intent prevIntent;
    private String type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_gamble);
        TextView gambleText = (TextView)findViewById(R.id.gambleText);

        getIntentData();

        if(type.equals("adult")){
            gambleText.setText(readText(1));
        }
        else if(type.equals("child")){
            gambleText.setText(readText(2));
        }
    }

    public void getIntentData(){        //이전 인텐트에 저장된 값 읽어오기
        prevIntent = getIntent();
        type = prevIntent.getStringExtra("Type");
    }

    private String readText(int type){      //텍스트파일 읽어오는 함수
        String data = null;
        InputStream inputStream = null;
        if(type == 1) {
            inputStream = getResources().openRawResource(R.raw.gamble_adult);
        }
        else if(type == 2){
            inputStream = getResources().openRawResource(R.raw.gamble_child);
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i;
        try{
            i = inputStream.read();
            while(i != -1){
                byteArrayOutputStream.write(i);
                i = inputStream.read();
            }
            data = new String(byteArrayOutputStream.toByteArray(),"UTF-8");
            inputStream.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return data;
    }
    public void prevBTN_Click(View v){
        finish();
    }
    public void nextBTN_Click(View v){
        Intent intent = new Intent(getApplicationContext(), GambleAddicationActivity.class);
        intent.putExtra("Type", type);                          //버튼 값을 인텐트에 저장
        startActivity(intent);                                  //인텐트 수행
    }
}

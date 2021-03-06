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

public class GambleAddicationActivity extends AppCompatActivity{
    private Intent prevIntent;
    private String type;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_gamble_addication);

        TextView gambleText = (TextView)findViewById(R.id.gambleAddicationText);
        getIntentData();            //인텐트 데이터 불러오는 함수
        if(type.equals("adult")){
            gambleText.setText(readText(1));
        }
        else if(type.equals("child")){
            gambleText.setText(readText(2));
        }
    }
    public void getIntentData(){        //이전 인텐트로부터 값 입력받아오기.
        prevIntent = getIntent();
        type = prevIntent.getStringExtra("Type");
    }

    private String readText(int type){      //텍스트 파일 읽어오는 함수. type은 onCreate에서 readText를 호출할때 사용한 매개변수
        String data = null;
        InputStream inputStream = null;
        if(type == 1) {         //성인의 경우에 텍스트파일 읽기
            inputStream = getResources().openRawResource(R.raw.gamble_addication_adult);
        }
        else if(type == 2){     //청소년의 경우에 텍스트파일 읽기
            inputStream = getResources().openRawResource(R.raw.gamble_addication_child);
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
        if(type.equals("adult")) {      //성인이면 성인 자가진단화면
            Intent intent = new Intent(getApplicationContext(), SelfTestActivityAdult.class);
            startActivity(intent);
        }
        else if(type.equals("child")){  //청소년이면 청소년 자가진단화면
            Intent intent = new Intent(getApplicationContext(), SelfTestActivityChild.class);
            startActivity(intent);
        }
    }
}

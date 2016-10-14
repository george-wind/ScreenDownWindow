package ni.george.screendownwindow.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import ni.george.screendownwindow.R;

public class MainActivity extends Activity {
    private Context mContext;
    private Handler handler=new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext=this;
        //发一条广播（延时5秒为了锁屏）
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent();
                intent.setAction("testScreenDown");
                sendBroadcast(intent);
            }
        },5*1000);



    }


}

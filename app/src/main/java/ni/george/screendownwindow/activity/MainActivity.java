package ni.george.screendownwindow.activity;

import android.app.Activity;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

import ni.george.screendownwindow.R;

public class MainActivity extends Activity {
    private Context mContext;
    private Handler handler=new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext=this;

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(mContext,ScreenDownActivity.class);
                startActivity(intent);
            }
        },10*1000);


    }


}

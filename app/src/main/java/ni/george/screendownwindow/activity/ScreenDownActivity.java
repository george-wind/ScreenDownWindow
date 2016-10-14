package ni.george.screendownwindow.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PowerManager;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;

import ni.george.screendownwindow.R;

/**
 * Created by quan on 2016/10/12.
 * 锁屏弹窗界面
 */
public class ScreenDownActivity extends Activity implements View.OnClickListener {
    private LinearLayout ll_msg;
    private Button btCancel;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_down);
        final Window win = getWindow();
        win.addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED
                | WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD
//                | WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON
                | WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON);

        initViews();

    }

    @Override
    protected void onNewIntent(Intent intent) {
        PowerManager pm = (PowerManager) this.getSystemService(Context.POWER_SERVICE);
        if (!pm.isScreenOn()) {
            PowerManager.WakeLock wl = pm.newWakeLock(PowerManager.ACQUIRE_CAUSES_WAKEUP |
                    PowerManager.SCREEN_BRIGHT_WAKE_LOCK, "bright");
            wl.acquire();
            wl.release();
        }
    }

    private void initViews() {
        mContext = this;
        ll_msg = (LinearLayout) findViewById(R.id.ll_msg);
        ll_msg.setOnClickListener(this);
        btCancel = (Button) findViewById(R.id.cancel);
        btCancel.setOnClickListener(this);
    }

    private long oldClickTime = 0;

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.ll_msg:
                long newClickTime = System.currentTimeMillis();
                if (newClickTime - oldClickTime < 2 * 1000) {
                    intent.setClass(mContext, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    oldClickTime = newClickTime;
                }
                break;
            case R.id.cancel:
                finish();
                break;
        }
    }
}

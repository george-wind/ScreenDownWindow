package ni.george.screendownwindow.receiver;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import ni.george.screendownwindow.activity.ScreenDownActivity;

/**
 * Created by ASUS on 10/12/2016.
 */
public class MyReceiver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {

        //锁屏弹窗
        KeyguardManager km
                = (KeyguardManager) context.getSystemService(Context.KEYGUARD_SERVICE);
        //判断是否在锁屏状态
        if (km.inKeyguardRestrictedInputMode()) {
            Intent alarmIntent = new Intent(context, ScreenDownActivity.class);
            //从广播里跳转至activity，需要添加以下标志，不然会报错！
            alarmIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(alarmIntent);
        }


    }
}

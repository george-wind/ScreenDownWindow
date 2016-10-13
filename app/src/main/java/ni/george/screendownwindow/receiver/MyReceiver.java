package ni.george.screendownwindow.receiver;

import android.app.KeyguardManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;

import ni.george.screendownwindow.R;
import ni.george.screendownwindow.activity.MainActivity;
import ni.george.screendownwindow.activity.ScreenDownActivity;

/**
 * Created by ASUS on 10/12/2016.
 */
public class MyReceiver extends BroadcastReceiver {
    private NotificationManager mNotificationManager;

    @Override
    public void onReceive(Context context, Intent intent) {

        //锁屏弹窗
        KeyguardManager km = (KeyguardManager) context.getSystemService(Context.KEYGUARD_SERVICE);
        if (km.inKeyguardRestrictedInputMode()) {
            Intent alarmIntent = new Intent(context, ScreenDownActivity.class);
            alarmIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(alarmIntent);
        }
//        锁屏通知
        mNotificationManager = (NotificationManager) context.
                getSystemService(Context.NOTIFICATION_SERVICE);
        Intent noticeIntent = new Intent(context, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        PendingIntent contentIntent = PendingIntent.getActivity(context, 0, noticeIntent,
                PendingIntent.FLAG_ONE_SHOT);

        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(context)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_launcher))
                        .setContentTitle("锁屏通知")
                        .setDefaults(Notification.DEFAULT_SOUND)
                        .setStyle(new NotificationCompat.BigTextStyle()
                                .bigText("锁屏通知"))
                        .setContentText("锁屏通知")
                        .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
                        .setPriority(Notification.PRIORITY_MAX);

        mBuilder.setContentIntent(contentIntent);
        mNotificationManager.notify(0, mBuilder.build());
    }
}

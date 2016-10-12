package ni.george.screendownwindow.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by ASUS on 10/13/2016.
 */
public class MyService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Intent intent1 = new Intent();
        intent1.setAction("testScreenDown");
        sendBroadcast(intent1);
        return super.onStartCommand(intent, flags, startId);
    }
}

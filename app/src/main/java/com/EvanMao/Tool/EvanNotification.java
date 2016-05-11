package com.EvanMao.Tool;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.support.v7.app.NotificationCompat;


import com.EvanMao.LiveList.MainActivity.MainActivity;

import java.util.HashMap;

/**
 * Created by Administrator on 2015/9/11.
 */
public class EvanNotification extends ContextWrapper {
    static EvanNotification instance = null;
    HashMap<Integer, Notification> notifications = null;
    NotificationManager mNM;

    public static EvanNotification getInstance(Context base) {
        if (instance == null)
            instance = new EvanNotification(base);
        return instance;
    }

    public EvanNotification(Context base) {
        super(base);
        notifications = new HashMap<>();
        mNM = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    }

    NotificationCompat.Builder ncb;

    public void notifyDownLoadRunning(boolean isRunning, long lenght, long cur) {
        if (isRunning) {
            //通知之后点击跳转用到的Intent

            PendingIntent contentIntent;
            if (ncb == null) {
                Intent i = new Intent();
                i.setClass(instance, MainActivity.class);
                //一定要Intent.FLAG_ACTIVITY_NEW_TASK
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                //PendingIntent 是Intent的包装类
                contentIntent = PendingIntent.getActivity(instance, 1, i, PendingIntent
                        .FLAG_UPDATE_CURRENT);
                ncb = new NotificationCompat.Builder(instance);
//                ncb.setTicker(getString(R.string.downloading));
                ncb.setAutoCancel(true);
                ncb.setContentIntent(contentIntent);
//                ncb.setDefaults(Notification.DEFAULT_ALL);
//                ncb.setContentTitle(getString(R.string.downloading));
                ncb.setSound(null);
                ncb.setVibrate(null);
//                ncb.setSmallIcon(R.drawable.app_icon);
            }
//            RemoteViews remoteView = new RemoteViews(this.getPackageName(), R.layout.notify_download);
//            remoteView.setProgressBar(R.id.progressBar, (int) lenght, (int) cur, false);
//            remoteView.setTextViewText(R.id.textView134, getString(R.string.downloading));
//            remoteView.setTextViewText(R.id.textView135, 100 * cur / lenght + "%");
//            ncb.setContent(remoteView);
            ncb.setProgress((int) lenght, (int) cur, false);
            ncb.setContentText(100 * cur / lenght + "%");
//        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            mNM.notify(1, ncb.build());
        } else {
            mNM.cancel(1);
        }
    }
}

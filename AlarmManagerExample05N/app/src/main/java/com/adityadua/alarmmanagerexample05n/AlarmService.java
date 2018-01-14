package com.adityadua.alarmmanagerexample05n;

import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

/**
 * Created by AdityaDua on 14/01/18.
 */

public class AlarmService
        extends IntentService {

    private NotificationManager alarmNotificationManager;



    public AlarmService() {
        super("Alarm Service");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        sendNotification("Wake Up !! Its to go to WORK!!!");
    }

    private void sendNotification(String name){
        Log.d("Alarm Service:","Preparing to send the Notification");
        alarmNotificationManager = (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);

        PendingIntent contentIntent = PendingIntent.getActivity(this,0,new Intent(this,MainActivity.class),0);

        NotificationCompat.Builder alarmNB = new NotificationCompat.Builder(this)
                .setContentTitle("ALARMM")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentText(name)
                .setStyle(new NotificationCompat.BigTextStyle().bigText(name));

        alarmNB.setContentIntent(contentIntent);
        alarmNotificationManager.notify(1,alarmNB.build());


    }
}

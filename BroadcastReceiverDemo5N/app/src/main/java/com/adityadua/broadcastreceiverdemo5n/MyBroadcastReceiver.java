package com.adityadua.broadcastreceiverdemo5n;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.widget.Toast;

/**
 * Created by AdityaDua on 20/01/18.
 */

public class MyBroadcastReceiver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {

        String action = intent.getAction();
        Toast.makeText(context, "Broadcast Received :"+action, Toast.LENGTH_SHORT).show();

        if(action.contains("DATE_SET")){

        }else if(action.contains("SOME_OTHER_ACTION")){

        }else if(action.contains("TIME_SET")){

        }
        // Notifications are :: Simple events whihc lie down on the suer notification and wait till the action is being processed.

        NotificationCompat.Builder mBuilder = (NotificationCompat.Builder) new NotificationCompat.Builder(context.getApplicationContext())
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Welcome to New TimeZone")
                .setContentText("Action :"+action+" Welcome to a new Zone")
                .setAutoCancel(true);

        Intent resultIntent = new Intent(context,MainActivity.class);

        TaskStackBuilder stackBuilder = TaskStackBuilder.create(context.getApplicationContext());

        stackBuilder.addParentStack(MainActivity.class);

        stackBuilder.addNextIntent(resultIntent);

        PendingIntent PI = PendingIntent.getActivity(context,0,resultIntent,0);

        mBuilder.setContentIntent(PI);

        NotificationManager nm = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        nm.notify(100,mBuilder.build());









    }
}

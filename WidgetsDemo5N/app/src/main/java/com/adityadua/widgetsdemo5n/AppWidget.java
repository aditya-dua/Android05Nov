package com.adityadua.widgetsdemo5n;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.RemoteViews;
import android.widget.Toast;

/**
 * Created by AdityaDua on 30/12/17.
 */

public class AppWidget extends AppWidgetProvider {


    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        super.onUpdate(context, appWidgetManager, appWidgetIds);

        Toast.makeText(context, "Widget Added or Updated", Toast.LENGTH_SHORT).show();

        for(int i=0;i<appWidgetIds.length;i++){

            int currentId = appWidgetIds[i];

            String url = "http://www.acadgild.com";

            // TAsk Stack Builder
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setData(Uri.parse(url));

            PendingIntent pi = PendingIntent.getActivity(context,0,intent,0);

            RemoteViews views = new RemoteViews(context.getPackageName(),R.layout.activity_main);

            views.setOnClickPendingIntent(R.id.button,pi);
            appWidgetManager.updateAppWidget(currentId,views);

            Toast.makeText(context, "Widget has beem added successfully.", Toast.LENGTH_SHORT).show();
            

            



        }


    }
}

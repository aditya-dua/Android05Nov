package com.adityadua.contentprovider5ndemo;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.widget.Toast;

/**
 * Created by AdityaDua on 28/01/18.
 */

public class SMSContentObserver extends ContentObserver {

    Context context;
    Handler handler;


    /**
     * Creates a content observer.
     *
     * @param handler The handler to run {@link #onChange} on, or null if none.
     */
    public SMSContentObserver(Context context,Handler handler) {
        super(handler);

        this.context = context;
        this.handler = handler;
        
        
    }

    @Override
    public void onChange(boolean selfChange) {
        super.onChange(selfChange);

        Toast.makeText(context, "In OnChange", Toast.LENGTH_SHORT).show();
        // every content object is associated a URL
        //content://sms/inbox => Uri For SMS
        //content://contacts => Uri For Contacts

        Uri uri = Uri.parse("content://sms/inbox");

        Cursor cursor = context.getContentResolver().query(uri,null,null,null,"date ASC");
        //12/10/1980 10AM
        //12/10/1981
        //1/1/2006

        // sorting was done as per ascending order : So thats why
        cursor.moveToLast();

        StringBuilder builder = new StringBuilder();
        builder.append("From : "+cursor.getString(cursor.getColumnIndex("address")));
        builder.append("Message : "+cursor.getString(cursor.getColumnIndex("body")));

        cursor.close();
        String str = builder.toString();
        handler.obtainMessage(1,str).sendToTarget();




    }
}

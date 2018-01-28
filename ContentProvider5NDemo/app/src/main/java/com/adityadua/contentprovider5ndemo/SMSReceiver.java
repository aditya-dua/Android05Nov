package com.adityadua.contentprovider5ndemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by AdityaDua on 28/01/18.
 */

public class SMSReceiver extends BroadcastReceiver {


    SMSContentObserver contentObserver;
    @Override
    public void onReceive(Context context, Intent intent) {
        Uri uri = Uri.parse("content://sms/inbox");
        Cursor cursor = context.getContentResolver().query(uri,null,null,null,"date ASC");

        cursor.moveToLast();
        StringBuilder builder = new StringBuilder();
        builder.append("From : "+cursor.getColumnIndex("address"));
        builder.append("Message : "+cursor.getColumnIndex("body"));

        cursor.close();
        String str = builder.toString();

        String msgStr = str.substring(str.indexOf("Message"),str.length());

        String otp = fetchOTP(msgStr);

        Toast.makeText(context, "OTP is ::"+otp, Toast.LENGTH_SHORT).show();


    }
    // to fetch the OTP :
    // and from the msg for all 6 continous digits :::
    // Your OTP fro transaction amount of Rs 1234567 is 123456
    // 123456,234567
    public static  String fetchOTP (String in){

        Pattern p = Pattern.compile("(\\d){6}");
        Matcher m = p.matcher(in);

        if(m.find()){
            return m.group(0);
        }
        return  "";
    }
}

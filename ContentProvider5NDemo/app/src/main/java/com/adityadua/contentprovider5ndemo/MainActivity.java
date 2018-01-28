package com.adityadua.contentprovider5ndemo;

import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    SMSContentObserver contentObserver;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textview);

        contentObserver = new SMSContentObserver(this,handler);

        Uri uri = Uri.parse("content://sms/inbox");
        getContentResolver().registerContentObserver(uri,true,contentObserver);

    }
    Handler handler = new Handler(){

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            String str = (String) msg.obj;

            String otpStr= str.substring(str.indexOf("Message:"),str.length());
            String otp = SMSReceiver.fetchOTP(otpStr);

            textView.setText(otp);
        }

    };


}

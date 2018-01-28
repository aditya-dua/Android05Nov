package com.adityadua.broadcastreceiverdemo5n;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private BroadcastReceiver receiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IntentFilter If  = new IntentFilter();
        If.addAction("SOME_OTHER_ACTION");

        // creating the receiver using Anonmyus inner class

        /*receiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Toast.makeText(context, "onReceive is called", Toast.LENGTH_SHORT).show();
            }
        };*/

        // 2 points ::
        // 1 create a broadcast => in main Atcivity : dynamic way
        // 2 you trigger the broadcast => OS
        // 3

        // creating the object of the class
        MyBroadcastReceiver myBR = new MyBroadcastReceiver();

        //registerReceiver(receiver,If);
        registerReceiver(myBR,If);

    }

    @Override
    protected void onDestroy() {

        if(receiver !=null){
            unregisterReceiver(receiver);
            receiver = null;
        }
        super.onDestroy();
    }
}

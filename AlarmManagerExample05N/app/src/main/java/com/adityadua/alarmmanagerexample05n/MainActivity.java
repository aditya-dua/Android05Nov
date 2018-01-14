package com.adityadua.alarmmanagerexample05n;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.ToggleButton;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    AlarmManager alarmManager;
    private PendingIntent pendingIntent;
    private TimePicker alarmTimePicker;
    private static  MainActivity inst;
    private TextView alarmTextView;
    private Button stopBtn;


    public  static MainActivity instance(){
        return inst;
    }

    @Override
    public void onStart() {
        super.onStart();
        inst = this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alarmTimePicker = (TimePicker) findViewById(R.id.timePicker);
        alarmTextView = (TextView)findViewById(R.id.alarmText);
        ToggleButton alarmToggle = (ToggleButton) findViewById(R.id.alarmToggle);
        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        stopBtn = (Button)findViewById(R.id.stop_btn);


    }

    public void onToggleClicked(View v){

        if(((ToggleButton)v).isChecked()){
            Log.d("Alarm ON","ON");

            Calendar calendar = Calendar.getInstance();
            calendar.set(calendar.HOUR_OF_DAY,alarmTimePicker.getHour());
            calendar.set(calendar.MINUTE,alarmTimePicker.getMinute());

            Intent myIntent = new Intent(MainActivity.this,AlarmReceiver.class);
            pendingIntent = PendingIntent.getBroadcast(MainActivity.this,0,myIntent,0);

            alarmManager.set(AlarmManager.RTC,calendar.getTimeInMillis(),pendingIntent);

        }
        else{
            alarmManager.cancel(pendingIntent);

        }
    }
}

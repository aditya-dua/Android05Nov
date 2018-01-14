package com.adityadua.service05ndemo;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by AdityaDua on 14/01/18.
 */

public class MyService extends Service {

    MediaPlayer mp;
    static int currentPos=0;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }



    @Override
    public void onCreate() {
        Log.i("Song status:","Object Created");

        mp = MediaPlayer.create(getApplicationContext(),R.raw.song);
        Log.i("Song status:","Song Linked");


    }



    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        Log.i("Song status:","Started");
        mp.start();
        mp.setLooping(true);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.i("Song status:","Started");
        if(currentPos!=0){
            Log.i("Current Pos ::",Integer.toString(currentPos));
            mp.start();
            mp.seekTo(currentPos);
            currentPos =0;
        }else {
            Log.i("Current Pos ::",Integer.toString(currentPos));
            mp.start();

        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {

        if(mp.isPlaying()){
            currentPos =mp.getCurrentPosition();
            Log.i("Current Pos ::",Integer.toString(currentPos));
        }
        mp.stop();

        super.onDestroy();

    }
}

package com.adityadua.webservicesdemo5n.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

/**
 * Created by AdityaDua on 21/01/18.
 */

public class NetworkStatus {

    private  static  NetworkStatus instance = new NetworkStatus();

    static Context context;
    ConnectivityManager connectivityManager;
    boolean connected = false;


    public static NetworkStatus getInstance(Context con){
        context = con;
        return  instance;

    }

    public boolean isOnline(Context con){
        try{
            connectivityManager =  (ConnectivityManager) con.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            connected = networkInfo != null && networkInfo.isAvailable() && networkInfo.isConnected();


        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(con, "Check Network Connection", Toast.LENGTH_SHORT).show();
        }


        return  connected;

    }

}

package com.adityadua.dailogdemo5n;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn = (Button)findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openExitDailog();
            }
        });

    }

    @Override
    public void onBackPressed() {

        openExitDailog();
    }

    private void openExitDailog(){
        AlertDialog.Builder alertDailogBuilder = new AlertDialog.Builder(MainActivity.this);

        alertDailogBuilder.setTitle("Exit App");
        alertDailogBuilder.setMessage("Are you sure you want to exit ?");
        alertDailogBuilder.setIcon(R.mipmap.ic_launcher);


        alertDailogBuilder.setPositiveButton("Yes ! Exit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Toast.makeText(MainActivity.this, "App Exit", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        alertDailogBuilder.setNeutralButton("No ! Close Dailog", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Not Exiting the App", Toast.LENGTH_SHORT).show();
                dialog.cancel();
            }
        });

        alertDailogBuilder.setNegativeButton("No !", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "No is clicked and you can stay here", Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog alertDialog = alertDailogBuilder.create();
        alertDialog.show();

    }
}

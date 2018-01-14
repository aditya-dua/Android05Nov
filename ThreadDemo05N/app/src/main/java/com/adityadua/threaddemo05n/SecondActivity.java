package com.adityadua.threaddemo05n;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by AdityaDua on 07/01/18.
 */

public class SecondActivity extends AppCompatActivity {

    Button loadIconBtn,checkThread;
    private Bitmap mBitmap;
    private ImageView imageView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_screen);


        imageView = (ImageView)findViewById(R.id.imageView2);
        loadIconBtn = (Button)findViewById(R.id.loadIconBtn);
        checkThread = (Button)findViewById(R.id.button4);


        loadIconBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadIcon();
            }
        });

        checkThread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SecondActivity.this, "The button is working", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void loadIcon(){

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                mBitmap = BitmapFactory.decodeResource(getResources(),R.drawable.acadgild_logo);
                SecondActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        imageView.setImageBitmap(mBitmap);
                    }
                });
            }
        }).start();

    }
}

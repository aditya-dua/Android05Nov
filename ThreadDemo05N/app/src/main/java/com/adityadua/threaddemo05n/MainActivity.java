package com.adityadua.threaddemo05n;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v4.app.LoaderManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button loadIcon,checkThread;
    ImageView image;
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadIcon = (Button)findViewById(R.id.loadimgBtn);
        checkThread = (Button)findViewById(R.id.button2);

        image = (ImageView) findViewById(R.id.imageView);

        progressBar = (ProgressBar)findViewById(R.id.progressBar);


        loadIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new LoadIconTask().execute(R.drawable.acadgild_logo);
            }
        });
        
        checkThread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "I'm working", Toast.LENGTH_SHORT).show();
            }
        });

        Button jThread = (Button)findViewById(R.id.button3);
        jThread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,SecondActivity.class);
                startActivity(i);
            }
        });

    }




    class LoadIconTask extends AsyncTask<Integer,Integer,Bitmap>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setVisibility(ProgressBar.VISIBLE);
        }

        @Override
        protected Bitmap doInBackground(Integer... params) {

            Bitmap tmpBmp = BitmapFactory.decodeResource(getResources(),params[0]);

            for (int i=0;i<10;i++){
                try {
                    Thread.sleep(2000);
                    publishProgress(i*10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            return tmpBmp;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            progressBar.setProgress(values[0]);
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            progressBar.setVisibility(ProgressBar.INVISIBLE);
            image.setImageBitmap(bitmap);
        }
    }
}

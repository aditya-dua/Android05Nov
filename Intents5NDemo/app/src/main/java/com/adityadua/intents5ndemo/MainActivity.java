package com.adityadua.intents5ndemo;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button lgnBtn,googleBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lgnBtn = (Button)findViewById(R.id.button);

        lgnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // This code accepts the target and the current activity as param
                // and creates a new object of the Intent.
                Intent i = new Intent(MainActivity.this,SecondActivity.class);

                // Since the target is Activity , I will start the Activity
                startActivity(i);
            }
        });

        googleBtn = (Button)findViewById(R.id.button2);
        googleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));

                startActivity(i);
            }
        });
    }
}

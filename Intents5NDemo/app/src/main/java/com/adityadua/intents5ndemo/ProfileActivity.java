package com.adityadua.intents5ndemo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by AdityaDua on 02/12/17.
 */

public class ProfileActivity extends AppCompatActivity {

    TextView profileText;
    String test="";
    ImageView profileIV;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_layout);

        profileText = (TextView)findViewById(R.id.textView4);
        Intent comIntent = getIntent();

        String userName = comIntent.getStringExtra(SecondActivity.USER_KEY);


        Bundle b = comIntent.getExtras();
        String sessionId=b.getString("sessionId");
        boolean loginStatus=b.getBoolean("login");
        if(loginStatus){
            Toast.makeText(this, "Welcome "+userName+" ,your session id is::"+sessionId, Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Session could not be created as login failed", Toast.LENGTH_SHORT).show();
        }

        if(!userName.equals("") && userName !=null){
            profileText.setText("Hi "+userName+",");
        }

        profileIV = (ImageView)findViewById(R.id.imageView);
        profileIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(i,100);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 100){
            if(resultCode == RESULT_OK){
                Bundle extra = data.getExtras();
                Bitmap imgBMP = (Bitmap)extra.get("data");
                profileIV.setImageBitmap(imgBMP);

            }else if(resultCode == RESULT_CANCELED){
                Toast.makeText(this, "User Cancelled the operation", Toast.LENGTH_SHORT).show();
            }
        }
    }
}

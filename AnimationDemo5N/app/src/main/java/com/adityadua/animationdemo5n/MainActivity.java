package com.adityadua.animationdemo5n;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button startBtn;
    Animation fadeInAnimation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // i => Infomartion
        Log.i("starting Oncreate","Execution of onCreate has started successfully :: MainActivity : onCreate()");

        textView = (TextView)findViewById(R.id.textview);
        startBtn = (Button)findViewById(R.id.button);

        Log.v("TAG of Verbose","Message");

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    Log.d("textview is::", textView.toString());
                    textView.setVisibility(TextView.VISIBLE);

                    fadeInAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fadein);

                    fadeInAnimation.setRepeatMode(Animation.RESTART);
                    //fadeInAnimation.setRepeatCount(10);
                    fadeInAnimation.setRepeatCount(Animation.INFINITE);
                    textView.startAnimation(fadeInAnimation);
                }catch (Exception e){
                    Log.e("Exp onclick",e.toString());
                    //Log.wtf()
                }

                fadeInAnimation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        Toast.makeText(MainActivity.this, "Animation Started", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        Toast.makeText(MainActivity.this, "Animation Eneded", Toast.LENGTH_SHORT).show();
                        //textView.startAnimation(fadeInAnimation);

                        // start a new animation
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                        Toast.makeText(MainActivity.this, "Repeater Called", Toast.LENGTH_SHORT).show();
                       /* textView.setText(textView.getText().toString()+" "+animation.getRepeatCount());


                        for(int i =0;i<10;i++){
                            textView.startAnimation(fadeInAnimation);

                            textView.setText(textView.getText().toString()+" "+i);
                        }*/
                    }
                });
            }
        });

    }
}

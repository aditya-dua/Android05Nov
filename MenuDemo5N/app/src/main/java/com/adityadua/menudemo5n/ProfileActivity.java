package com.adityadua.menudemo5n;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

/**
 * Created by AdityaDua on 09/12/17.
 */

public class ProfileActivity extends AppCompatActivity {

    private Toolbar mTopToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_layout);

        mTopToolbar = (Toolbar) findViewById(R.id.toolbar);
       // mTopToolbar.setTitle("My App");
      //  mTopToolbar.setSubtitle("Profile Page");


        setSupportActionBar(mTopToolbar);
    }
}

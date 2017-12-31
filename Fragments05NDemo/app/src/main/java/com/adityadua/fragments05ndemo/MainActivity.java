package com.adityadua.fragments05ndemo;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements HeadlineFragment.OnHeadlineSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(findViewById(R.id.activity_main)!=null){
            if(savedInstanceState !=null){
                return;
            }

            HeadlineFragment firstFragment = new HeadlineFragment();
            firstFragment.setArguments(getIntent().getExtras());

            getSupportFragmentManager().beginTransaction().add(R.id.activity_main,firstFragment).commit();
        }
        // make the object of fragment :: onAttach:::


    }

    @Override
    public void onArticleSelected(int position) {
       // ????

        NewFragment newFragment = (NewFragment)getSupportFragmentManager().findFragmentById(R.id.fragment2);

        if(newFragment !=null){
            newFragment.updateArticleView(position);
        }else{
            NewFragment newFragment1 = new NewFragment();
            Bundle args = new Bundle();

            args.putInt(NewFragment.ARG_POSITION,position);
            newFragment1.setArguments(args);

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.activity_main,newFragment1);
            transaction.addToBackStack(null);
            transaction.commit();

        }

    }
}

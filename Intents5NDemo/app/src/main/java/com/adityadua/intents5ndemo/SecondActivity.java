package com.adityadua.intents5ndemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by AdityaDua on 02/12/17.
 */

public class SecondActivity extends AppCompatActivity {

    EditText userET,pwdET;
    Button loginBtn;

    static final String USER_KEY="UserName";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);

        userET = (EditText) findViewById(R.id.editText);
        pwdET = (EditText)findViewById(R.id.editText2);
        loginBtn = (Button)findViewById(R.id.button3);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName= userET.getText().toString();
                String pwd = pwdET.getText().toString();

                if(userName.equalsIgnoreCase("aditya.dua")){
                    if(pwd.equals("Aditya")){
                        // Create a new Intent for the profile page::

                        Intent i = new Intent(SecondActivity.this,ProfileActivity.class);
                        // pass the user

                        Bundle b = new Bundle();
                        b.putString("sessionId","12345");
                        b.putBoolean("login",true);
                        i.putExtras(b);

                        i.putExtra(USER_KEY,userName);

                        startActivity(i);
                    }else{
                        Toast.makeText(SecondActivity.this, "Incorrect UserName/Password", Toast.LENGTH_SHORT).show();
                        userET.setText("");
                        pwdET.setText("");
                    }
                }else{
                    Toast.makeText(SecondActivity.this, "Incorrect UserName/Password", Toast.LENGTH_SHORT).show();
                    userET.setText("");
                    pwdET.setText("");
                }
            }
        });


    }
}

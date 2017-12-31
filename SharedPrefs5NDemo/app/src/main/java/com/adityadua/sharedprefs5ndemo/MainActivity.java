package com.adityadua.sharedprefs5ndemo;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    Button saveBtn , fetchBtn;
    EditText userName,password;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        saveBtn = (Button)findViewById(R.id.button);
        fetchBtn = (Button)findViewById(R.id.button2);

        userName = (EditText)findViewById(R.id.editText);
        password = (EditText)findViewById(R.id.editText2);

        tv = (TextView)findViewById(R.id.textView);

        sharedPreferences = getSharedPreferences("myprefs", Context.MODE_APPEND);

        if(sharedPreferences.contains("username")){
            String str = sharedPreferences.getString("username","No text");
            tv.setText(str);
        }


        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = userName.getText().toString();
                String pass = password.getText().toString();

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("username",name);
                editor.putString("password",pass);

                editor.commit();

                userName.setText("");
                password.setText("");
                Toast.makeText(MainActivity.this, "Values Saved Successfully", Toast.LENGTH_SHORT).show();

            }
        });

        fetchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText(sharedPreferences.getString("username",""));
                Toast.makeText(MainActivity.this, "Values fetched"+sharedPreferences.getString("username","No Text"), Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(sharedPreferences.contains("username")){
            String str = sharedPreferences.getString("username","");
            tv.setText(str);
        }
    }
}

package com.adityadua.eventhandlingsession45n;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView testTV;
    EditText userNameEdt,passwordEdt;
    Button checkUserBtn,loginBtn;
    String user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Toast.makeText(this,"This is a Test message",Toast.LENGTH_SHORT).show();
        testTV = (TextView)findViewById(R.id.textView2);
        String text = testTV.getText().toString();

        Toast t = Toast.makeText(this,text,Toast.LENGTH_SHORT);

        t.setGravity(Gravity.CENTER,100,100);
        t.show();

        userNameEdt = (EditText)findViewById(R.id.editText2);
        passwordEdt = (EditText)findViewById(R.id.editText3);

        checkUserBtn = (Button)findViewById(R.id.button2);
        loginBtn = (Button)findViewById(R.id.button3);

        passwordEdt.setVisibility(TextView.INVISIBLE);
        loginBtn.setVisibility(Button.INVISIBLE);

        Button testBtn = (Button)findViewById(R.id.button4);
        testBtn.setOnClickListener(this);

        Button test2btn = (Button)findViewById(R.id.button5);
        test2btn.setOnClickListener(this);

        checkUserBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user = userNameEdt.getText().toString();

                if(user.equalsIgnoreCase("aditya.dua")){
                    passwordEdt.setVisibility(TextView.VISIBLE);
                    loginBtn.setVisibility(Button.VISIBLE);

                    userNameEdt.setEnabled(false);
                    checkUserBtn.setEnabled(false);
                }
            }
        });


        testTV.setText("Aditya Dua");
    }

    public void loginAction(View v){

        String pwd = passwordEdt.getText().toString();
        if(pwd.equals("aditya")){
            passwordEdt.setEnabled(false);
            loginBtn.setEnabled(false);


            Toast.makeText(this,"Hi "+user+",", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View v) {


        if (v.getId() == R.id.button4) {

            Toast.makeText(this, "Test Button clciked", Toast.LENGTH_SHORT).show();
        }else if(v.getId() == R.id.button5){
            Toast.makeText(this, "Test  2 Button clciked", Toast.LENGTH_SHORT).show();

        }

    }
}

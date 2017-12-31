package com.adityadua.storage05ndemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import static java.lang.String.valueOf;

public class MainActivity extends AppCompatActivity {

    Button save,read;
    File tempFile;
    TextView showTV;
    EditText textET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        save = (Button) findViewById(R.id.button);
        read = (Button) findViewById(R.id.button2);

        showTV = (TextView) findViewById(R.id.textView2);

        textET = (EditText) findViewById(R.id.editText);

        tempFile = new File(this.getFilesDir(),"testfile");

        try {
           // "file.txt
            File file = File.createTempFile("aditya","txt",this.getCacheDir());
        } catch (IOException e) {
            e.printStackTrace();
        }

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fileName ="testfile";
                try {
                    FileOutputStream fileOutputStream = openFileOutput(fileName,MODE_PRIVATE);
                    
                    String text = textET.getText().toString();
                    fileOutputStream.write(text.getBytes());
                
                    fileOutputStream.close();
                    Toast.makeText(MainActivity.this, "Text written successfully", Toast.LENGTH_SHORT).show();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        });

        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    FileInputStream fin = openFileInput("testfile");
                    String test = String.valueOf(fin.read());
                    fin.close();

                    showTV.setText(test);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}

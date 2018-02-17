package com.adityadua.googlecloudvisisonapi5demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.vision.barcode.Barcode;

public class MainActivity extends AppCompatActivity {

    TextView barcodeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        barcodeTextView = (TextView) findViewById(R.id.textView2);

    }

    public void scanBarcode(View v){
        Intent i = new Intent(this,ScanBarCodeActivity.class);
        startActivityForResult(i,0);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(requestCode ==0){
            if(resultCode == RESULT_OK){

                if(data !=null){
                    Barcode barcode = data.getParcelableExtra("barcode");
                }
            }

        }

        super.onActivityResult(requestCode, resultCode, data);
    }
}

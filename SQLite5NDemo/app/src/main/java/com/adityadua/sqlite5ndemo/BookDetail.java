package com.adityadua.sqlite5ndemo;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.adityadua.sqlite5ndemo.R;
import com.adityadua.sqlite5ndemo.database.DBHelper;
import com.adityadua.sqlite5ndemo.utils.Constants;

/**
 * Created by AdityaDua on 17/12/17.
 */

public class BookDetail extends Activity {

    TextView authorNameTV,bookNameTV;
    EditText authorNameET,bookNameET;
    Button deleteBtn,updateBtn;

    DBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_detail);

        db = DBHelper.getInstance(this);
        authorNameTV = (TextView)findViewById(R.id.nameTV);
        bookNameTV = (TextView)findViewById(R.id.titleTV);

        authorNameET = (EditText) findViewById(R.id.authorNameET);
        bookNameET = (EditText)findViewById(R.id.bookNameET);

        Intent i = getIntent();

        final String name,title;
        name = i.getStringExtra(Constants.BOOK_NAME);
        title = i.getStringExtra(Constants.BOOK_AUTHOR);

        authorNameTV.setText(name);
        bookNameTV.setText(title);

        deleteBtn = (Button)findViewById(R.id.button);
        updateBtn = (Button)findViewById(R.id.updateBn);

        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.deleteRecord(Constants.BOOK_RECORD,Constants.BOOK_NAME+" ='"+name+"'",null);
                Toast.makeText(BookDetail.this, "Data Deleted", Toast.LENGTH_SHORT).show();
            }
        });


        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues cv = new ContentValues();
                cv.put(Constants.BOOK_AUTHOR,authorNameET.getText().toString());
                cv.put(Constants.BOOK_NAME,bookNameET.getText().toString());
                db.updateRecord(Constants.BOOK_RECORD,cv,Constants.BOOK_NAME+" ='"+name+"'",null);
                Toast.makeText(BookDetail.this, "Book Data Updated Deleted", Toast.LENGTH_SHORT).show();
            }
        });

    }
}

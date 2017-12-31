package com.adityadua.sqlite5ndemo;

import android.content.ContentValues;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.adityadua.sqlite5ndemo.database.DBHelper;
import com.adityadua.sqlite5ndemo.model.BookData;
import com.adityadua.sqlite5ndemo.utils.Constants;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    String [] book_name=new String[]{
            "My Experiments with truth",
            "My Pursuit Of Happyness",
            "The Wings Of Fire",
            "The monk who sold his Ferrari"
    };


    String [] author_name=new String[]{
            "M. K. Gandhi",
            "Chris Gardner",
            "Dr A P J Abdul Kalam",
            "Robin Sharma"
    };

    String [] book_id=new String[]{
            "12345",
            "12346",
            "12348",
            "34988"
    };

    ListView list;
    ArrayAdapter<String> myAdapter;
    DBHelper dbHelper;
    List<BookData> dataList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // the use of getInstance
        dbHelper = DBHelper.getInstance(this);

        list = (ListView)findViewById(R.id.list);

        int count = dbHelper.getFullCount(Constants.BOOK_RECORD,null);

        if(count == 0){
            insertBookData();
        }


        dataList = dbHelper.getAllBooks();

        List<String> listTitle = new ArrayList<>();
        for(int i =0;i<dataList.size();i++){
            listTitle.add(dataList.get(i).getBookName());
        }

        myAdapter = new ArrayAdapter<String>(this,R.layout.row_layout,R.id.listText,listTitle);

        myAdapter.notifyDataSetChanged();
        list.setAdapter(myAdapter);

        list.setOnItemClickListener(this);

    }

    private void insertBookData(){

        for(int i=0;i<book_name.length;i++){
            ContentValues cv = new ContentValues();
            cv.put(Constants.BOOK_ID,book_id[i]);
            cv.put(Constants.BOOK_NAME,book_name[i]);
            cv.put(Constants.BOOK_AUTHOR,author_name[i]);

            dbHelper.insertContentValues(Constants.BOOK_RECORD,cv);

        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Intent i = new Intent(MainActivity.this,BookDetail.class);

        i.putExtra(Constants.BOOK_NAME,dataList.get(position).getBookName());
        i.putExtra(Constants.BOOK_AUTHOR,dataList.get(position).getBookAuthor());

        startActivityForResult(i,1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        dataList = dbHelper.getAllBooks();

        List<String> listTitle = new ArrayList<>();
        for(int i =0;i<dataList.size();i++){
            listTitle.add(dataList.get(i).getBookName());
        }

        myAdapter = new ArrayAdapter<String>(this,R.layout.row_layout,R.id.listText,listTitle);
        list.setAdapter(myAdapter);

        list.setOnItemClickListener(this);
    }
}

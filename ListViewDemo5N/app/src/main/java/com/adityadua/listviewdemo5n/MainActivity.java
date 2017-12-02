package com.adityadua.listviewdemo5n;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    String [] technology = {"Android","Java","C++",".Net","Big Data","Selenium"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1 : Create the object Of ListView
        // 2 : Create the object Of Adapter
        // 3 : Call the constructor of ArrayAdapter to link the link the adapter tp the
        //         Data source
        // 4 : Set the adapter on to the ListView.


        ListView lv = (ListView) findViewById(R.id.listview);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_list_item_1,technology);

        lv.setAdapter(adapter);
        lv.setOnItemClickListener(this);
        // 2 ways : anonymus Inner class dec::
        /*lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Item Clicked Is::"+technology[position], Toast.LENGTH_SHORT).show();
            }
        });*/
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "Item POsition clicked is:"+position, Toast.LENGTH_SHORT).show();
    }
}

package com.adityadua.menudemo5n;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    static int countExit=0;

    ListView lv;
    ArrayList<String> contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView)findViewById(R.id.listView);

        contact = new ArrayList<>();

        for(int i=0;i<10;i++){
            contact.add("Contact ::"+i);
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,contact);
        lv.setAdapter(adapter);

        registerForContextMenu(lv);

        TextView tv = (TextView) findViewById(R.id.textview);
        registerForContextMenu(tv);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.setHeaderIcon(R.mipmap.ic_launcher);
        menu.setHeaderTitle("Context Menu Example");

        menu.add(0,100,1,"Copy");
        menu.add(0,101,2,"Cut");
        menu.add(0,102,4,"Paste");

        if(v.getId() == R.id.listView){
            menu.add(1,103,3,"Add an item to the list");
        }else if(v.getId()==R.id.textview){
            menu.add(2,103,3,"Select All");

        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuI = getMenuInflater();
        menuI.inflate(R.menu.main,menu);
        return  true;

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        if(item.getItemId() == 100){
            Toast.makeText(this, "Data on Clipboard , select paste to paste", Toast.LENGTH_SHORT).show();
        }else if(item.getItemId() == 101){
            Toast.makeText(this, "Data on Clipboard,please paste", Toast.LENGTH_SHORT).show();
        }else if(item.getItemId() == 102){
            Toast.makeText(this, "Data Pasted", Toast.LENGTH_SHORT).show();
        }else if(item.getItemId() == 103 && item.getGroupId()==2){
            Toast.makeText(this, "Select All", Toast.LENGTH_SHORT).show();
        }else if(item.getItemId() == 103 && item.getGroupId()==1){
            Toast.makeText(this, "Item added to the list", Toast.LENGTH_SHORT).show();
        }
        

        return super.onContextItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        countExit++;
        Toast.makeText(this, "Press again to exit", Toast.LENGTH_SHORT).show();

        if(countExit==2){
            countExit=0;
            super.onBackPressed();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int selectedItemId = item.getItemId();
        
        if(selectedItemId == R.id.save){
            // write the code to save the data 
            Toast.makeText(this, "Data Saved Successfully !", Toast.LENGTH_SHORT).show();
        }else if(selectedItemId == R.id.profile){
            Intent i = new Intent(MainActivity.this,ProfileActivity.class);
            startActivity(i);
        }else if(selectedItemId == R.id.setting){
            Toast.makeText(this, "Please edit the setiing", Toast.LENGTH_SHORT).show();
        }else if(selectedItemId == R.id.exit){
            this.finish();

            //Toast.makeText(this, "Please edit the setiing", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}

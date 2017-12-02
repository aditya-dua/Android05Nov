package com.adityadua.listviewdemo5n;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by AdityaDua on 26/11/17.
 */

public class ActivitySpinner extends Activity implements AdapterView.OnItemSelectedListener {

    String age_group[]={"10-15","16-18","19-22","23-30","31-40","41 & above"};
    TextView ageTV;
    Spinner age_spinner;
    AutoCompleteTextView autoCompleteTextView;
    String city[]={"Delhi","Mumbai","Gurgoan","Chennai","Chandigarh","Dehradun"};

    RadioGroup rg;
    CheckBox moviesChbk,novelsChbk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spinner_example);


        age_spinner = (Spinner)findViewById(R.id.spinner);

        ageTV = (TextView)findViewById(R.id.textView);
        ArrayAdapter<String> ageAdapter = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_spinner_dropdown_item,age_group);


        age_spinner.setAdapter(ageAdapter);
        age_spinner.setOnItemSelectedListener(this);

        rg = (RadioGroup)findViewById(R.id.radiogroup);

        autoCompleteTextView = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView);

        ArrayAdapter<String> actvAdap=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,city);
        autoCompleteTextView.setAdapter(actvAdap);
        autoCompleteTextView.setThreshold(1);
        moviesChbk = (CheckBox)findViewById(R.id.checkBox);
        novelsChbk = (CheckBox)findViewById(R.id.checkBox2);

        Button clickBtn = (Button)findViewById(R.id.button);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.male){
                    Toast.makeText(ActivitySpinner.this, "Gender Is Male", Toast.LENGTH_SHORT).show();
                }else if(checkedId == R.id.female){
                    Toast.makeText(ActivitySpinner.this, "Gender Is Female", Toast.LENGTH_SHORT).show();
                }
            }
        });
        clickBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(moviesChbk.isChecked() && novelsChbk.isChecked()){
                    Toast.makeText(ActivitySpinner.this, "Hobbies are :Watching Movies & Reading Novels", Toast.LENGTH_SHORT).show();
                }else if(moviesChbk.isChecked()){
                    Toast.makeText(ActivitySpinner.this, "Hobby is :Watching Movies.", Toast.LENGTH_SHORT).show();
                }else if(novelsChbk.isChecked()){
                    Toast.makeText(ActivitySpinner.this, "Hobby is :Reading Novels.", Toast.LENGTH_SHORT).show();
                }


                
            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "Selected Age is::"+age_group[position], Toast.LENGTH_SHORT).show();
        ageTV.setText(age_group[position]);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Toast.makeText(this, "Nothing Selected", Toast.LENGTH_SHORT).show();
    }
}

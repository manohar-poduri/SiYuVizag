/*
Updated by Sirisha Balireddy from 25-04-2019 - SiYuVizag 1.1*/
/*
This module displays the list of hospitals present in vizag. On clicking the desired hospital this is redirected to info.xml page
 */
package com.alcove.partners.siyu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class HospitalActivity extends second implements AdapterView.OnItemClickListener{
    //takes the values in string
    ListView lv;
    String hospitals[] = {"KGH Hospital", "R.K.Hospital", "Simhadri Hospital", "SevenHills Hospital", "Care Hospital", "A.N.Beach Hospital"};
    ArrayList<String> listItem =new ArrayList<String>();

    ImageView home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadLocale();
        setContentView(R.layout.activity_hospital);

        home = findViewById(R.id.home);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), second.class));
            }
        });

        //Adding elements to the listview
        listItem = new ArrayList<>();
        for(int i=0;i<hospitals.length;i++)
        {
            listItem.add(hospitals[i]);
        }
        //Sorting the arraylist and the array
      Collections.sort(listItem);
        Arrays.sort(hospitals);
        lv = (ListView) findViewById(R.id.lv1);
        lv.setOnItemClickListener(this);
        //setting the arraylist to listview
        ArrayAdapter<String> ad = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listItem);
        lv.setAdapter(ad);

    }
/*
On click of any of the hospitals from the list of hospitals, it is redirected to info.xml page.
 */
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        Intent i1 = new Intent(HospitalActivity.this, InfoHospital.class);
        i1.putExtra("info", hospitals[i]);
        startActivity(i1);

    }
    //It deals with the function to move to previous activity
    public void gotoPrevious(View view){
        finish();

    }

}
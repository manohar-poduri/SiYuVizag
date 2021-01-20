/*
Updated by Sirisha Balireddy on 20-05-2019 - SiYuVizag 1.1
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

public class busFare extends second implements AdapterView.OnItemClickListener {


//Take in the values in form of strings
        private String[] from = {"Jagadamba to R.K.Beach ", "Jagadamba to Madhurawada", "Jagadamba to Maddilapalem", "Jagadamba to MVP", "Jagadamba to Complex", "Jagadamba to Seethammadara",
            "Jagadamba to Kailasagiri", "Jagadamba to Submarine", "Jagadamba to ChinnaWaltair", "Jagadamba to PeddaWaltair",
            "Jagadamba to Rushikonda", "Jagadamba to Vuda Park", "Jagadamba to Zoo", "Jagadamba to Simhachalam", "Jagadamba to Gajuwaka",
            "Jagadamba to Akkayapalem", "Jagadamba to Kancharapalem", "R.K.Beach to Madhurawada", "R.K.Beach  to Maddilapalem", "R.K.Beach  to MVP", "R.K.Beach  to Complex", "R.K.Beach  to Seethammadara",
            "R.K.Beach  to Kailasagiri", "R.K.Beach  to Submarine", "R.K.Beach  to ChinnaWaltair", "R.K.Beach  to PeddaWaltair",
            "R.K.Beach  to Rushikonda", "R.K.Beach  to Vuda Park", "R.K.Beach  to Zoo", "R.K.Beach  to Simhachalam", "R.K.Beach  to Gajuwaka",
            "R.K.Beach  to Akkayapalem", "R.K.Beach  to Kancharapalem", "Madhurawada to Maddilapalem", "Madhurawada to MVP", "Madhurawada  to Complex", "Madhurawada to Seethammadara",
            "Madhurawada  to Kailasagiri", "Madhurawada  to Submarine", "Madhurawada to ChinnaWaltair", "Madhurawada to PeddaWaltair",
            "Madhurawada  to Rushikonda", "Madhurawada  to Vuda Park", "Madhurawada  to Zoo", "Madhurawada  to Simhachalam", "Madhurawada  to Gajuwaka",
            "Madhurawada  to Akkayapalem", "Madhurawada  to Kancharapalem", "Maddilapalem to MVP", "Maddilapalem   to Complex", "Maddilapalem to Seethammadara",
            "Maddilapalem  to Kailasagiri", "Maddilapalem  to Submarine", "Maddilapalem to ChinnaWaltair", "Maddilapalem to PeddaWaltair",
            "Maddilapalem  to Rushikonda", "Maddilapalem  to Vuda Park", "Maddilapalem  to Zoo", "Maddilapalem  to Simhachalam", "Maddilapalem  to Gajuwaka",
            "Maddilapalem  to Akkayapalem", "Maddilapalem  to Kancharapalem", "MVP  to Complex", "MVP to Seethammadara", "MVP  to Kailasagiri", "MVP  to Submarine", "MVP to ChinnaWaltair", "MVP to PeddaWaltair", "MVP  to Rushikonda", "MVP  to Vuda Park", "MVP  to Zoo", "MVP  to Simhachalam", "MVP  to Gajuwaka", "MVP  to Akkayapalem", "MVP  to Kancharapalem", "Complex to Seethammadara", "Complex  to Kailasagiri", "Complex  to Submarine", "Complex to ChinnaWaltair", "Complex to PeddaWaltair",
            "Complex  to Rushikonda", "Complex  to Vuda Park", "Complex  to Zoo", "Complex  to Simhachalam", "Complex  to Gajuwaka", "Complex  to Akkayapalem", "Complex  to Kancharapalem", "Seethammadara  to Kailasagiri", "Seethammadara  to Submarine", "Seethammadara to ChinnaWaltair", "Seethammadara to PeddaWaltair",
            "Seethammadara  to Rushikonda", "Seethammadara  to Vuda Park", "Seethammadara  to Zoo", "Seethammadara  to Simhachalam", "Seethammadara  to Gajuwaka",
            "Seethammadara  to Akkayapalem", "Seethammadara  to Kancharapalem", "Kailasagiri  to Submarine", "Kailasagiri to ChinnaWaltair", "Kailasagiri to PeddaWaltair",
            "Kailasagiri  to Rushikonda", "Kailasagiri  to Vuda Park", "Kailasagiri  to Zoo", "Kailasagiri  to Simhachalam", "Kailasagiri  to Gajuwaka",
            "Kailasagiri  to Akkayapalem", "Kailasagiri  to Kancharapalem", "Submarine to ChinnaWaltair", "Submarine to PeddaWaltair",
            "Submarine  to Rushikonda", "Submarine  to Vuda Park", "Submarine  to Zoo", "Submarine  to Simhachalam", "Submarine  to Gajuwaka",
            "Submarine  to Akkayapalem", "Submarine  to Kancharapalem", "ChinnaWaltair to PeddaWaltair",
            "ChinnaWaltair  to Rushikonda", "ChinnaWaltair  to Vuda Park", "ChinnaWaltair  to Zoo", "ChinnaWaltair  to Simhachalam", "ChinnaWaltair  to Gajuwaka",
            "ChinnaWaltair  to Akkayapalem", "ChinnaWaltair  to Kancharapalem", "PeddaWaltair  to Rushikonda", "PeddaWaltair  to Vuda Park", "PeddaWaltair  to Zoo", "PeddaWaltair  to Simhachalam", "PeddaWaltair  to Gajuwaka",
            "PeddaWaltair  to Akkayapalem", "PeddaWaltair  to Kancharapalem", "Rushikonda  to Vuda Park", "Rushikonda  to Zoo", "Rushikonda  to Simhachalam", "Rushikonda  to Gajuwaka",
            "Rushikonda  to Akkayapalem", "Rushikonda  to Kancharapalem", "Vuda Park  to Zoo", "Vuda Park   to Simhachalam", "Vuda Park   to Gajuwaka",
            "Vuda Park   to Akkayapalem", "Vuda Park   to Kancharapalem", "ZOO  to Simhachalam", "ZOO  to Gajuwaka",
            "ZOO   to Akkayapalem", "ZOO  to Kancharapalem", "Simhachalam  to Gajuwaka", "Simhachalam   to Akkayapalem", "Simhachalam  to Kancharapalem", "Gajuwaka   to Akkayapalem", "Gajuwaka  to Kancharapalem", "Akkayapalem  to Kancharapalem",
            "ZillaParishad to R.K.Beach ", "ZillaParishad to Madhurawada", "ZillaParishad to Maddilapalem", "ZillaParishad to MVP", "ZillaParishad to Complex", "ZillaParishad to Seethammadara",
            "ZillaParishad to Kailasagiri", "ZillaParishad to Submarine", "ZillaParishad to ChinnaWaltair", "ZillaParishad to PeddaWaltair",
            "ZillaParishad to Rushikonda", "ZillaParishad to Vuda Park", "ZillaParishad to Zoo", "ZillaParishad to Simhachalam", "ZillaParishad to Gajuwaka",
            "ZillaParishad to Akkayapalem", "ZillaParishad to Kancharapalem",

    };
        private ArrayList<String> listItem =new ArrayList<String>();
        private ListView list;

        private ImageView home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadLocale();
        setContentView(R.layout.activity_bus_fare);

        home = findViewById(R.id.home);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), second.class));
            }
        });

      //Adding elements to the arraylist
        listItem = new ArrayList<>();
        for(int i=0;i<from.length;i++)
        {
            listItem.add(from[i]);
        }
        //sorting the arraylist and the array
      Collections.sort(listItem);
        Arrays.sort(from);
        list = (ListView) findViewById(R.id.lv5);
        list.setOnItemClickListener(this);

//Setting the arraylist to listview
        ArrayAdapter<String> ad = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listItem);
        list.setAdapter(ad);


    }
//function to goback to previous page or activity

        public void gotoPrevious(View view){

            finish();
        }
        /*
        deals with action to be done after clicking an item in listview
         */
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent i1=new Intent(busFare.this,fares.class);
        i1.putExtra("address",from[i].toString());
        startActivity(i1);



    }

}
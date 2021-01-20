/*
Updated and Modified by Sirisha Balireddy -14-05-2019 -SiYuVizag 1.1
 */
package com.alcove.partners.siyu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class FoodActivity extends second  implements  AdapterView.OnItemClickListener {
   //Takes the values in form of strings
    /*String[] hnames = {"Flying Spaghetti Monster","Mint Garden","Kamat Restaurant","Barbeque Nation","SriSaiRam Parlour", "Dharani Restaurant","Tycoon MultiCuisine Restaurant", "Green Park","Shack","Venkatadri Vantillu",
            "The Eatery","FoodEx","Welcom Cafe Oceanic Restaurant"};*/

    private ListView listView;
    private ArrayList<String> arrayList = new ArrayList<>();
    private DatabaseReference databaseReference;
    ImageView home;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadLocale();
        setContentView(R.layout.activity_food);

        home = findViewById(R.id.home);
        listView = findViewById(R.id.listView);

        final ArrayAdapter<String> arrayAdapter =new ArrayAdapter<String>(FoodActivity.this,
                android.R.layout.simple_list_item_1,arrayList);

        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(this);


        databaseReference = FirebaseDatabase.getInstance().getReference("Restaurants");

        databaseReference.keepSynced(true);

        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                String value =snapshot.getKey();

                arrayList.add(value);
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), second.class));
            }
        });

        /*//Adding elements to the arraylist
        listItem = new ArrayList<>();
        for (int i = 0; i < hnames.length; i++) {
            listItem.add(hnames[i]);
        }
        //Sorts the arraylist and array
        Collections.sort(listItem);
        Arrays.sort(hnames);
        lv = (ListView) findViewById(R.id.lv4);
        lv.setOnItemClickListener(this);
        //setting the arraylist to listview
        ArrayAdapter<String> ad = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listItem);
        lv.setAdapter(ad);
*/

    }
//Deals with function to be performed when a particular item is clicked
   /* public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent i1=new Intent(FoodActivity.this,food.class);
        i1.putExtra("restaurantnames", hnames[i]);
        startActivity(i1);

    }*/
   /*
   This section inserts the data into the SqLite Database
    */

    public void gotoPrevious(View view){

        Intent i = new Intent(this,second.class);
        startActivity(i);
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

        String currentHotelName = adapterView.getItemAtPosition(position).toString();

        Intent intent = new Intent(FoodActivity.this,food.class);
        intent.putExtra("hotelName",currentHotelName);
        startActivity(intent);
    }
}

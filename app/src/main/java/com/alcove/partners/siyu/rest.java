/*
Updated and modified by Sirisha Balireddy -20-05-2019 YOURLOCALGUIDE 1.1
 */
package com.alcove.partners.siyu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
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

public class rest extends second implements  AdapterView.OnItemClickListener {
    //takes the values into an array of strings
//    String[] address = {"SuryabaghRoad-Jagadamba", "SuryabaghRoad-Jagadamba", "DabaGardens-JagadambaJunction", "DabaGardens-JagadambaJunction", "DabaGardens-JagadambaJunction",
//            "NowrojiRoad-MaharaniPeta", "Pandurangapuram-BeachRoad", "KrishnaNagar-MaharaniPeta", "R.K.BeachMainRoad-MaharaniPeta", "KirlumpudiLayout-BeachRoad",
//            "MVPSector2-APGColony", "Venkojipalem-MVPSector1", "ShivajiPalem-MVPColony", "PeddaWaltair-NearMVPColony", "MVPColonySecotr1",
//            "SagarNagar-DwarakaNagar", "AslimettaJunction-RamNagar", "Dondaparthy-DwarakaNagar1stLine", "Dondaparthy-Dwarakanagar", "Dondaparthy-DwarakaNagar"};
    /*String[] names = {"Daspalla Hotel", "The Port Hotel", "Dolphin Hotel", "Hotel Tanvi Grand", "Hotel Spar Grand",
            "Novotel Varun Beach", "The Gateway Hotel", "Hotel Supreme", "Beach View Guest House", "Ambica Sea Green Hotel",
            "OYO Rooms 073", "Seacity Guest House", "Hotel Mvv Bhavan", "Hotel New Blue Homes", "Black and White Hotel",
            "Ginger Hotel", "Royal Fort Hotel", "Hotel Budhil Park", "V Hotel", "Fortune Inn Sree Kanya"};
*/

    private ArrayList<String> arrayList = new ArrayList<>();
    private ListView listView;
    private DatabaseReference databaseReference;

    ImageView home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadLocale();
        setContentView(R.layout.activity_rest);

        home = findViewById(R.id.home);
        listView = findViewById(R.id.lv1);

        final ArrayAdapter<String> arrayAdapter =new ArrayAdapter<String>(rest.this,
                android.R.layout.simple_list_item_1,arrayList);

        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(this);


        databaseReference = FirebaseDatabase.getInstance().getReference("Accommodation");

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

/*
        This is to sort the array
        for (int i = 0; i < names.length; i++) {
            listItem.add(names[i]);

        }  listItem = new ArrayList<>();
        for(int i=0;i<names.length;i++)
        {
            listItem.add(names[i]);
        }
        Collections.sort(listItem);
        Arrays.sort(names);
        lv = (ListView) findViewById(R.id.lv1);
        lv.setOnItemClickListener(this);
This is to append the array to the listview
        ArrayAdapter<String> ad = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listItem);
        lv.setAdapter(ad);
*/

    }
    public void gotoPrevious(View view){

        finish();
    }



    //deals with function that should trigger when a element is clicked
   public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        /*Intent i1=new Intent(rest.this,HotelsActivity.class);
       i1.putExtra("hotelname",names[i]);
        startActivity(i1);*/

       String currentHotelName = adapterView.getItemAtPosition(position).toString();

       Intent intent = new Intent(rest.this,HotelsActivity.class);
       intent.putExtra("AccName",currentHotelName);
       startActivity(intent);

    }

}

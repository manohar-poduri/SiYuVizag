/*
Updated by Sirisha Balireddy on 30-05-2019- YOURLOCALGUIDE 1.1
 */
package com.alcove.partners.siyu;

import android.os.Bundle;
import android.content.Intent;
import android.text.TextWatcher;
import android.view.View;
import android.text.Editable;
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
import java.util.HashMap;


public class PlacesActivity extends second  implements  AdapterView.OnItemClickListener {

    /*String[] names={"VMRDA Park (VUDA Park)","Tenneti Park","Shivaji Park","Lumbini Park","Kailasagiri",
            "ZOO (Indira Gandhi Zoological Park)","R.K. Beach","Rushikonda Beach","Yarada Beach",
            "Bheemili Beach","Light House","Lakshmi Narasimha Temple(Simhachalam)","Kanaka Mahalakshmi Temple",
            "Sri Sampath Vinayagar Temple","ISKCON Temple","Rope Way","Submarine Museum (INS Kursura)",
            "Victory At Sea Memorial","TU 142 Aircraft Museum"};
    int[] pics={R.drawable.vuda,R.drawable.tenneti,R.drawable.shivaji,R.drawable.lum,R.drawable.siva,R.drawable.zoo,R.drawable.rk,
            R.drawable.rushi,R.drawable.yarada,R.drawable.bheemili,R.drawable.light,R.drawable.simhachalam,R.drawable.kanaka,R.drawable.sampath,R.drawable.iscon,
            R.drawable.roap,R.drawable.sub,R.drawable.victory,R.drawable.tu};
    String[] address={"Beach Rd Kailasagiri Arch, Chinna Waltair, Jalari Peta, Visakhapatnam, Andhra Pradesh 530017",
            "Opp. Kailashagiri Hills, Jadugupalem, Visakhapatnam, Andhra Pradesh 530001",
            "MVP Double Rd, Sector 5, MVP Colony, Visakhapatnam, Andhra Pradesh 530017",
            "Beach Rd, Opposite To Appughar Bus Stop, Appughar, Sector 9, Jalari Peta, Visakhapatnam, Andhra Pradesh 530001",
            "Hill Top Rd, Kailasagiri, Visakhapatnam, Andhra Pradesh 530043",
            "Near Dairy Farm, Yendada Nursery, Visakhapatnam, Andhra Pradesh 530040",
            " R.K. Beach,Visakhapatnam, Andhra Pradesh, India", "Rushikonda Beach,Visakhapatnam, Andhra Pradesh, India",
            " Yarada, Visakhapatnam district, Andhra Pradesh, India", "Bheemili Beach",
            "Jalari Peta, Visakhapatnam, Andhra Pradesh 530017", "Simhachalam Rd, Simhachalam, Visakhapatnam, Andhra Pradesh 530028",
            "Town Kotha Rd, Burujupeta, Chengal Rao Peta, Jagadamba Junction, Visakhapatnam, Andhra Pradesh 530001",
            "10-1-33 Waltair Appliance, road, Visakhapatnam, Andhra Pradesh 530003",
            "Beach Road, Hare Krishna Land, Sagar Nagar, Rushikonda, Visakhapatnam, Andhra Pradesh 530045",
             "Hill Top Rd, Kailasagiri, Visakhapatnam, Andhra Pradesh 530043",
            "R. K. Beach Road, Kirlampudi Layout, Chinna Waltair, Paanduranga Puram, Visakhapatnam, Andhra Pradesh 530017",
            "31, Beach Rd, Kirlampudi Layout, Chinna Waltair, Pedda Waltair, Visakhapatnam, Andhra Pradesh 530003",
            "Beach Rd, Opp Kursura Submarine museum, AU North Campus, HPCL Colony, Paanduranga Puram, Visakhapatnam, Andhra Pradesh 530003"};
 String[] description={"VUDA Park now VMRDA Park is an urban park located near RK Beach in Visakhapatnam, Andhra Pradesh, India. The park is named after the Chief Minister of Andhra Pradesh at the time of its establishment, N T Rama Rao. It is operated by the Visakhapatnam Metropolitan Region Development Authority.",
                   "Tenneti Park also known as is an Urban park in the city of Visakhapatnam, India. Situated on the Beach Road in Jodugullapalem, it the first children’s park, and one of the oldest parks in the city. It is located beside Sea Shore of Bay of Bengal. GVMC installed LED screens in the park to boost Tourism in the city",
           "Sivaji Park is an urban park in the Indian city of Visakhapatnam. It is spread over 16 acres of land and is surrounded by MVP Colony and Sivajipalem. Originally a dumping yard, it was created in 1999 with an initial investment of ₹ 8 lakh. It is one of the most famous attractions of Visakhapatnam.",
                  "Lumbini Park is located on the beautiful beach road with the Buddha Statue in the middle of the park and is gifted with idyllic syivan hills on one side and the blue sea on the other is a great attraction to the tourist public.",
           "Kailasagiri is a hilltop park in the city of Visakhapatnam in the Indian state of Andhra Pradesh. The park was developed by the Visakhapatnam Metropolitan Region Development Authority and comprises 380 acres of land covered with flora and tropical trees. The hill, at 173 metres, overlooks the city of Visakhapatnam",
           "Indira Gandhi Zoological Park is located amidst Kambalakonda Reserve Forest in Visakhapatnam, Andhra Pradesh, India. It is the third largest zoo in the country. The zoological park is named after the former Prime Minister of India, Indira Gandhi. It was declared open to the public on 19 May 1977.",
           "RK Beach also known as Ramakrishna Beach is situated on the East coast of Bay of Bengal in Visakhapatnam. It is located near Dolphin's Nose.",
           "Rushikonda Beach is located in Visakhapatnam on the coast of Bay of Bengal in the Indian state of Andhra Pradesh. The beach is maintained by the state tourism board, APTDC.",
           "Yarada Beach is situated on the west coast of Bay of Bengal in Yarada, a village at a distance of 15 kilometres from Visakhapatnam. It is located near Gangavaram beach, Dolphin's Nose, and Gangavaram Port.",
           "Bheemili Beach is located at the origin of the Gosthani River, at a distance of 24 km from Visakhapatnam in Visakhapatnam district of the Indian state of Andhra Pradesh.[1] The beach reflects the British and Dutch settlements of the 17th century",
 "This light house , that has a beautiful view of Bay of Bengal and Vizag port. The entry has information about other light houses in the area.",
           "The Shri Varaha Lakshmi Narasimha temple, Simhachalam is a Hindu temple situated on the Simhachalam hill, which is 500 metres above the sea level in Visakhapatnam, Andhra Pradesh. It is dedicated to one of the Hindu trinity deities Vishnu, who is worshipped there as Varaha Narasimha.",
           "Sri Kanaka Maha Lakshmi is the presiding deity of Visakhapatnam locals. The temple is located in Burujupeta of Visakhapatnam city.",
           "Sri Sampath Vinayagar is the prominent deity of Visakhapatnam locals. The temple is located in Asilmetta of Visakhapatnam city.",
         "ISKCON Visakhapatnam Temple is the upcoming temple on Sagar Nagar in visakhapatnam, India. this temple construction started in 2005 the day of Akshaya Tritiya facing the calm waters of the Bay of Bengal At sagar Nagar ",
           "An attraction to the tourist in kailasagiri.",

"NS Kursura (S20) was a Kalvari-class diesel-electric submarine of the Indian Navy. She was India's fifth submarine. Kursura was commissioned on 18 December 1969 and was decommissioned on 27 February 2001 after 31 years of service.",
 "The Victory at Sea Memorial is an Indian memorial constructed after the Indo-Pakistani War of 1971 which is dedicated to the Indian Navy and the Eastern Naval Command sailors. It was constructed in 1996. It is located on Beach Road, Visakhapatnam.",
 "TU 142 Aircraft Museum is also called as TU-142 Aircraft Museum or Aircraft Museum is a preserved Tupolev Tu-142 located in Visakhapatnam, in the Indian state of Andhra Pradesh. it was established in 2017 by President of India Ram Nath Kovind."};*/


    /*ListView lv;
    ArrayList<String> listItem;
    EditText inputsearch;
    ArrayList<HashMap<String,String>> productlist;
    ArrayAdapter<String> ad;*/

    private ArrayList<String> arrayList = new ArrayList<>();
    private ListView listView;
    private DatabaseReference databaseReference;

    ImageView home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadLocale();
        setContentView(R.layout.activity_places);
        listView = findViewById(R.id.lvP);

        home = findViewById(R.id.home);

        final ArrayAdapter<String> arrayAdapter =new ArrayAdapter<String>(PlacesActivity.this,
                android.R.layout.simple_list_item_1,arrayList);

        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(this);


        databaseReference = FirebaseDatabase.getInstance().getReference("Tourism");

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

       /*inputsearch =(EditText)findViewById(R.id.inputSearch);
        lv = (ListView) findViewById(R.id.lv1);
// Adding the elements to the arraylist
        listItem = new ArrayList<>();
        for(int i=0;i<names.length;i++)
        {
            listItem.add(names[i]);
        }
        //Sorting the arraylist and array
        Collections.sort(listItem);
        Arrays.sort(names);
 ad = new ArrayAdapter<String>(this,R.layout.list_view,R.id.tv3,names);
 lv.setAdapter(ad);
 //Filtering//
        inputsearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence cs, int start, int before, int count) {
           PlacesActivity.this.ad.getFilter().filter(cs);


            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

       lv.setOnItemClickListener(this);*/


    }

    /*public void gotoPrevious(View view){

       finish();
    }*/

//deals with function that should trigger when a element is clicked
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

        String currentHotelName = adapterView.getItemAtPosition(position).toString();

        Intent intent = new Intent(PlacesActivity.this,ImagesActivity.class);
        intent.putExtra("TourName",currentHotelName);
        startActivity(intent);

        /*Intent i1=new Intent(PlacesActivity.this,ImagesActivity.class);

        i1.putExtra("typename",names[i]);
        startActivity(i1);*/

    }

    public void gotoPrevious(View view) {
        finish();
    }
}





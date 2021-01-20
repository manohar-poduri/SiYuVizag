/*
Updated by Sirisha Balireddy on 25-05-2019 -YOURLOCALGUIDE 1.1
 */
package com.alcove.partners.siyu;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Callback;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

/**
 * Created by jyothi on 7/18/2017.
 * Updated by Sirisha Balireddy on 10-05-2019 - SiYuVizag 1.1
 */
public class ImagesActivity extends second {
    //taking values into an array of strings
    /*ImageView img;
    String [] id={"https://www.youtube.com/watch?v=E3xwJpn3eyo","https://www.youtube.com/watch?v=YUQnD-nKw3k&t=32s","https://www.youtube.com/watch?v=CU-OzMS39Dc&t=20s",
            "https://www.youtube.com/watch?v=cwkajOUEu8g&t=23s","https://www.youtube.com/watch?v=9Rb95j2LlYc&t=15s","https://www.youtube.com/watch?v=lcE-o9L8HEQ&t=27s", "https://www.youtube.com/watch?v=ocpiUQopsMo","https://www.youtube.com/watch?v=FvEmXvKqHrs","https://www.youtube.com/watch?v=7EIMc87yyjw&t=21s","https://www.youtube.com/watch?v=qVICGZpsi1A",
            "https://www.youtube.com/watch?v=tyf0H7J3D_M","https://www.youtube.com/watch?v=Sbkw-Wuq6GA","https://www.youtube.com/watch?v=XvwbEKuqcSw&t=43s","https://www.youtube.com/watch?v=5P5hkdy8Hes"
, "https://www.youtube.com/watch?v=LGynO2xvCxg&t=26s","https://www.youtube.com/watch?v=gkXF50skmyI&t=8s","https://www.youtube.com/watch?v=NgP7jS-nrSI&t=26s",
    "https://www.youtube.com/watch?v=VpjR5YhOz6E","https://www.youtube.com/watch?v=4vvlBCm5_ds","https://www.youtube.com/watch?v=m5DjMsvKv20"};
    String[] names={"VMRDA Park (VUDA Park)","Tenneti Park","Shivaji Park","Lumbini Park","Kailasagiri","ZOO (Indira Gandhi Zoological Park)","R.K. Beach","Rushikonda Beach","Yarada Beach",
            "Bheemili Beach","Light House","Lakshmi Narasimha Temple(Simhachalam)","Kanaka Mahalakshmi Temple","Sri Sampath Vinayagar Temple","ISKCON Temple"," Aqua Sports Complex(Swimming Pool)","Rope Way","INS Kurusura(S20 Submarine)",
            "Victory At Sea Memorial","TU 142 aircraft Museum"};
    int[] pics={R.drawable.vuda,R.drawable.tenneti,R.drawable.shivaji,R.drawable.lum,R.drawable.siva,R.drawable.zoo,R.drawable.rk,
            R.drawable.rushi,R.drawable.yarada,R.drawable.bheemili,R.drawable.light,R.drawable.simhachalam,R.drawable.kanaka,R.drawable.sampath,R.drawable.iscon,
            R.drawable.swimming,R.drawable.roap,R.drawable.sub,R.drawable.victory,R.drawable.tu};
    String[] address={"Beach Rd Kailasagiri Arch, Chinna Waltair, Jalari Peta, Visakhapatnam, Andhra Pradesh 530017", "Opp. Kailashagiri Hills, Jadugupalem, Visakhapatnam, Andhra Pradesh 530001", "MVP Double Rd, Sector 5, MVP Colony, Visakhapatnam, Andhra Pradesh 530017",
            "Beach Rd, Opposite To Appughar Bus Stop, Appughar, Sector 9, Jalari Peta, Visakhapatnam, Andhra Pradesh 530001", "Hill Top Rd, Kailasagiri, Visakhapatnam, Andhra Pradesh 530043", "Near Dairy Farm, Yendada Nursery, Visakhapatnam, Andhra Pradesh 530040",
            " R.K. Beach,Visakhapatnam, Andhra Pradesh, India", "Rushikonda Beach,Visakhapatnam, Andhra Pradesh, India", " Yarada, Visakhapatnam district, Andhra Pradesh, India", "Bheemili Beach",
            "Jalari Peta, Visakhapatnam, Andhra Pradesh 530017", "Simhachalam Rd, Simhachalam, Visakhapatnam, Andhra Pradesh 530028", "Town Kotha Rd, Burujupeta, Chengal Rao Peta, Jagadamba Junction, Visakhapatnam, Andhra Pradesh 530001",
            "10-1-33 Waltair Appliance, road, Visakhapatnam, Andhra Pradesh 530003", "Beach Road, Hare Krishna Land, Sagar Nagar, Rushikonda, Visakhapatnam, Andhra Pradesh 530045",
            "Paanduranga Puram, Visakhapatnam, Andhra Pradesh 530003", "Hill Top Rd, Kailasagiri, Visakhapatnam, Andhra Pradesh 530043",
            "R. K. Beach Road, Kirlampudi Layout, Chinna Waltair, Paanduranga Puram, Visakhapatnam, Andhra Pradesh 530017",
            "31, Beach Rd, Kirlampudi Layout, Chinna Waltair, Pedda Waltair, Visakhapatnam, Andhra Pradesh 530003","Beach Rd, Opp Kursura Submarine museum, AU North Campus, HPCL Colony, Paanduranga Puram, Visakhapatnam, Andhra Pradesh 530003"};
    String[] description={"VUDA Park now VMRDA Park is an urban park located near RK Beach in Visakhapatnam, Andhra Pradesh, India. The park is named after the Chief Minister of Andhra Pradesh at the time of its establishment, N T Rama Rao. It is operated by the Visakhapatnam Metropolitan Region Development Authority.",
            "Tenneti Park also known as is an Urban park in the city of Visakhapatnam, India. Situated on the Beach Road in Jodugullapalem, it the first children’s park, and one of the oldest parks in the city. It is located beside Sea Shore of Bay of Bengal. GVMC installed LED screens in the park to boost Tourism in the city", "Sivaji Park is an urban park in the Indian city of Visakhapatnam. It is spread over 16 acres of land and is surrounded by MVP Colony and Sivajipalem. Originally a dumping yard, it was created in 1999 with an initial investment of ₹ 8 lakh. It is one of the most famous attractions of Visakhapatnam.",
            "Lumbini Park is located on the beautiful beach road with the Buddha Statue in the middle of the park and is gifted with idyllic syivan hills on one side and the blue sea on the other is a great attraction to the tourist public.", "Kailasagiri is a hilltop park in the city of Visakhapatnam in the Indian state of Andhra Pradesh. The park was developed by the Visakhapatnam Metropolitan Region Development Authority and comprises 380 acres of land covered with flora and tropical trees. The hill, at 173 metres, overlooks the city of Visakhapatnam", "Indira Gandhi Zoological Park is located amidst Kambalakonda Reserve Forest in Visakhapatnam, Andhra Pradesh, India. It is the third largest zoo in the country. The zoological park is named after the former Prime Minister of India, Indira Gandhi. It was declared open to the public on 19 May 1977.", "RK Beach also known as Ramakrishna Beach is situated on the East coast of Bay of Bengal in Visakhapatnam. It is located near Dolphin's Nose.", "Rushikonda Beach is located in Visakhapatnam on the coast of Bay of Bengal in the Indian state of Andhra Pradesh. The beach is maintained by the state tourism board, APTDC.", "Yarada Beach is situated on the west coast of Bay of Bengal in Yarada, a village at a distance of 15 kilometres from Visakhapatnam. It is located near Gangavaram beach, Dolphin's Nose, and Gangavaram Port.", "Bheemili Beach is located at the origin of the Gosthani River, at a distance of 24 km from Visakhapatnam in Visakhapatnam district of the Indian state of Andhra Pradesh.[1] The beach reflects the British and Dutch settlements of the 17th century",
            "This light house , that has a beautiful view of Bay of Bengal and Vizag port. The entry has information about other light houses in the area.", "The Shri Varaha Lakshmi Narasimha temple, Simhachalam is a Hindu temple situated on the Simhachalam hill, which is 500 metres above the sea level in Visakhapatnam, Andhra Pradesh. It is dedicated to one of the Hindu trinity deities Vishnu, who is worshipped there as Varaha Narasimha.", "Sri Kanaka Maha Lakshmi is the presiding deity of Visakhapatnam locals. The temple is located in Burujupeta of Visakhapatnam city.", "Sri Sampath Vinayagar is the prominent deity of Visakhapatnam locals. The temple is located in Asilmetta of Visakhapatnam city.",
            "ISKCON Visakhapatnam Temple is the upcoming temple on Sagar Nagar in visakhapatnam, India. this temple construction started in 2005 the day of Akshaya Tritiya facing the calm waters of the Bay of Bengal At sagar Nagar ", "Great place to get trained in swimming. It has a good coaches all around....Excellent place for water sports", "An attraction to the tourist in kailasagiri.",

            "NS Kursura (S20) was a Kalvari-class diesel-electric submarine of the Indian Navy. She was India's fifth submarine. Kursura was commissioned on 18 December 1969 and was decommissioned on 27 February 2001 after 31 years of service.",
            "The Victory at Sea Memorial is an Indian memorial constructed after the Indo-Pakistani War of 1971 which is dedicated to the Indian Navy and the Eastern Naval Command sailors. It was constructed in 1996. It is located on Beach Road, Visakhapatnam.",
            "TU 142 Aircraft Museum is also called as TU-142 Aircraft Museum or Aircraft Museum is a preserved Tupolev Tu-142 located in Visakhapatnam, in the Indian state of Andhra Pradesh. it was established in 2017 by President of India Ram Nath Kovind."};*/

    private TextView tourName,tourAddress,tourDes;
    private ImageView tourImage;
    private ImageView home;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadLocale();
        setContentView(R.layout.image);

        tourName = findViewById(R.id.nameT);
        tourAddress = findViewById(R.id.addressT);
        tourDes = findViewById(R.id.descriptionT);
        tourImage = findViewById(R.id.imageT);

        home = findViewById(R.id.home);


        final String tourName1 = getIntent().getStringExtra("TourName");
        tourName.setText(tourName1);

        DatabaseReference databaseReference =
                FirebaseDatabase.getInstance().getReference("Tourism");

        Query query = databaseReference.orderByChild(tourName1);

        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                String address =
                        snapshot.child(tourName1).child("Address").getValue(String.class);
                tourAddress .setText(address);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String phone =
                        snapshot.child(tourName1).child("Des").getValue(String.class);
                tourDes.setText(phone);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                final String image = snapshot.child(tourName1).child("Image").getValue(String.class);

                Picasso.get().load(image).networkPolicy(NetworkPolicy.OFFLINE).into(tourImage,
                        new Callback() {
                            @Override
                            public void onSuccess() {

                            }

                            @Override
                            public void onError(Exception e) {

                                Picasso.get().load(image).into(tourImage);
                            }
                        });

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

       /* Intent iget = getIntent();
        String c = iget.getExtras().getString("typename");
        int c1 =iget.getExtras().getInt("typename");
        TextView txt=(TextView)findViewById(R.id.address);
        TextView txt1=(TextView)findViewById(R.id.description);
        img=(ImageView)findViewById(R.id.img1);
// Taking inputs from previous activity and compare them and displays the details
        for(int i=0;i<names.length;i++) {
            if (c.equals(names[i])) {
                places_visit.setText(names[i]);
                txt.setText("Address: "+address[i]);
                txt1.setText("About : "+description[i]);
                img.setImageResource(pics[i]);



            }
        }*/
    }
    //On click of the button will take you to youtube
   /* public void getlink(View view)
    {
        Intent iget = getIntent();
        String c = iget.getExtras().getString("typename");
        for(int i=0;i<names.length;i++) {
            if (c.equals(names[i])) { ;
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(id[i]));
                startActivity(intent);
            }

            }
        }*/
//this deals with function that triggers when the backarrow is pressed
   /* public void homeButton(View view){
        *//*Intent gotoScreenVar = new Intent(ImagesActivity.this,PlacesActivity.class);
        gotoScreenVar.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(gotoScreenVar);*//*

        startActivity(new Intent(getApplicationContext(),PlacesActivity.class));
    }*/
}

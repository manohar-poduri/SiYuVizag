package com.alcove.partners.siyu;

/**
 * Created by jyothi on 7/17/2017.
 * Updated and modified by Sirisha Balireddy on 25-04-2019 -SiYuVizag 1.1
 */

/*
This section takes care of the list of hotels along with their addresses and price for two.
 */
import android.content.DialogInterface;

import java.util.ArrayList;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Callback;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

/*
The method takes the names, address and prices in form of strings
 */
public class HotelsActivity extends second {
   //Takes values in String
    private TextView accName,accAddress,accPhone,accPrice;
    private ImageView accImage;
    private ImageView home;


    /*String[] names = {"Daspalla Hotel", "The Port Hotel", "Dolphin Hotel", "Hotel Tanvi Grand", "Hotel Spar Grand",
            "Novotel Varun Beach", "The Gateway Hotel", "Hotel Supreme", "Beach View Guest House", "Ambica Sea Green Hotel",
            "OYO Rooms 7317 Tapasya Convention", "Seacity Guest House", "Hotel Mvv Bhavan", "Hotel New Blue Homes", "Black and White Hotel",
            "Ginger Hotel", "Royal Fort Hotel", "Hotel Budhil Park", "V Hotel", "Fortune Inn Sree Kanya"};
int [] pics ={R.drawable.dasapalla,R.drawable.port,R.drawable.dolphin,R.drawable.tanvi,R.drawable.spar,R.drawable.novotel,R.drawable.gate,
R.drawable.supreme,R.drawable.beachview,R.drawable.ambica,R.drawable.oyo,R.drawable.seacity,R.drawable.mvv,R.drawable.blue,R.drawable.black
,R.drawable.ginger,R.drawable.royalfort,R.drawable.budhili,R.drawable.vhotel,R.drawable.fortune};
    String[] address = {"28-2-48, Suryabagh, Jagadamba Junction, Visakhapatnam, Andhra Pradesh 520020",
            "No. 28, 9-57, Chitralaya Rd, Suryabagh, Near, Jagadamba Junction, Visakhapatnam, Andhra Pradesh 530020",
            "City Center, Daba Garden Rd, Dolphin Area, Daba Gardens, Jagadamba Junction, Visakhapatnam, Andhra Pradesh 530020",
            " 27-32-8, 75 Feet Rd, Suryabagh, Allipuram, Visakhapatnam, Andhra Pradesh 530001",
            "32, 31, 41, Daba Garden Rd, Opp. Jyothi Theatre Ladies Gate, Daba Gardens, Allipuram, Visakhapatnam, Andhra Pradesh 530020",
            "Beach Road, Nowroji Rd, Maharani Peta, Visakhapatnam, Andhra Pradesh 530003",
            "Varun Beach, RK Beach Road Opposite, Visakhapatnam, Andhra Pradesh 530002",
            "Beach Road Near, RK Beach, Visakhapatnam, Andhra Pradesh 530002",
            "RK Beach, Main Rd, Beside Novotel, Krishna Nagar, Maharani Peta, Visakhapatnam, Andhra Pradesh 530002",
            "Door No 7-24, Plot No: 1, Kirlumpudi Layout, 3/2, Beach Rd, Visakhapatnam, Andhra Pradesh 530017",
            "Plot No.1-84-19 MVP Colony Road Near Sathi Creations, MVP Colony, Visakhapatnam, Andhra Pradesh 530017",
            "Sector-1,MVP Colony, 51, MVP Main Rd, MVP Sector 1, Venkojipalem, Visakhapatnam, Andhra Pradesh 530017",
            "6, 9, 1943, Sivajipalem Rd, Shivaji Palem, Pithapuram Colony, Maddilapalem, Visakhapatnam, Andhra Pradesh 530017",
            "Plot No.42, 2nd Back lane of YMCA Kirlampudi Layout, Near Beach Road, Visakhapatnam 530 017",
            "RK BEACH, 1-14-93, Nowroji Rd, OPP. NOVOTEL, Daspalla Hills, Paanduranga Puram, Visakhapatnam, Andhra Pradesh 530002",
            "47-10-19, 2nd Ln, Opp. HDFC Bank, Dwaraka Nagar, Visakhapatnam, Andhra Pradesh 530016",
            "Ram Nagar Rd Opposite Municipal Corporation, Asilmetta Junction, Ram Nagar, Visakhapatnam, Andhra Pradesh 530002",
            "48-8-12, 1st Street, RTC Complex, Near, Dwaraka Nagar, Visakhapatnam, Andhra Pradesh 530016",
            "48/8/17, Srinagar, Dwaraka Nagar, Visakhapatnam, Andhra Pradesh 530016",
            "47-10 34 35 Sree Kanya Road Diamond Park, Dwaraka Nagar, Visakhapatnam, Andhra Pradesh 530016"};
    int[] price = {4116, 2706, 4581, 1408, 2440, 7151, 7535, 3184, 1705, 3282, 1635, 1269, 1813, 900, 1702, 1939, 3430, 2744, 2466, 3585};
    String [] phonenumber={"09866319729","08912555400","08912567000","07210208345","07093497555","08912822222","08916623670",
            "07210208345","083744 63155",
  "08912821818","07210208345","08912761199","072102 08345","92466 49999","072102 08345","08916193333","08916622888"," 07210108345"," 093999 96666", "0891 668 8444"};*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadLocale();
        setContentView(R.layout.hotels);

        accName = findViewById(R.id.accName);
        accAddress = findViewById(R.id.accAddress);
        accPrice = findViewById(R.id.accPrice);
        accPhone = findViewById(R.id.accPhone);
        accImage = findViewById(R.id.accImage);
        home = findViewById(R.id.home);

        final String accName1 = getIntent().getStringExtra("AccName");
        accName.setText(accName1);

        DatabaseReference databaseReference =
                FirebaseDatabase.getInstance().getReference("Accommodation");

        Query query = databaseReference.orderByChild(accName1);

        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                String address =
                        snapshot.child(accName1).child("Address").getValue(String.class);
                accAddress.setText(address);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String phone =
                        snapshot.child(accName1).child("Phone").getValue(String.class);
                accPhone.setText(phone);

                accPhone.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Intent.ACTION_DIAL);
                        intent.setData(Uri.parse("tel:" +accPhone.getText().toString()));
                        startActivity(intent);
                    }
                });

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                String price = snapshot.child(accName1).child("Price").getValue(String.class);
                accPrice.setText(price);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                final String image = snapshot.child(accName1).child("Image").getValue(String.class);

                Picasso.get().load(image).networkPolicy(NetworkPolicy.OFFLINE).into(accImage,
                        new Callback() {
                    @Override
                    public void onSuccess() {

                    }

                    @Override
                    public void onError(Exception e) {

                        Picasso.get().load(image).into(accImage);
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

       /* lv=(ListView)findViewById(R.id.lv1);
        Intent iget = getIntent();
    String c = iget.getExtras().getString("hotelname");
    //finds the fields using the id
       img=(ImageView)findViewById(R.id.img);
       txt=(TextView)findViewById(R.id.address);
         txt2=(TextView)findViewById(R.id.price1);
         txt1=(TextView)findViewById(R.id.number);
         //Takes input from previous activity and compares them and displays the result
        for(int i=0;i<names.length;i++) {
            if (c.equals(names[i])) {
                accommodation_names.setText(names[i]);
                img.setImageResource(pics[i]);
                txt.setText(" Address : "+address[i]);
                txt2.setText(" Price(Approximate)   : Rs "+price[i]);
                txt1.setText(phonenumber[i]);

            }
        }
        //Deals with function that triggers when that field is clciked( mobile number)
        txt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(HotelsActivity.this);
                builder.setMessage("Do you want to make a call?").setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent in = new Intent(Intent.ACTION_DIAL);
                        in.setData(Uri.parse("tel:" +txt1.getText().toString()));
                        startActivity(in);
                    }

                })
                        *//*
                        This section deals when the user clicks cancel option on the popup displayed
                         *//*
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();

            }
        });

*/
    }
// This function triggers when back arrow is clicked
   public void homeButton(View view){
        Intent gotoScreenVar = new Intent(HotelsActivity.this,rest.class);
        gotoScreenVar.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(gotoScreenVar);
    }
}

package com.alcove.partners.siyu;

/**
 * Created by jyothi on 7/17/2017.
 * Updated and modified by Sirisha Balireddy on 25-04-2019 SiYuVizag
 */

/*
This section takes care of the list of hotels along with their addresses and price for two.
 */
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import android.view.View;
import android.widget.ImageView;
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
public class food extends second {

    ImageView restaurantImage;
    TextView restaurantName, restaurantAddress,restaurantPrice,restaurantPhone;
    ImageView home;

    /*String[] hnames = {"Flying Spaghetti Monster","Mint Garden","Kamat Restaurant","Barbeque Nation","SriSaiRam Parlour", "Dharani Restaurant","Tycoon MultiCuisine Restaurant", "Green Park","Shack","Venkatadri Vantillu",
            "The Eatery","FoodEx","Welcom Cafe Oceanic Restaurant"};
    String[] address = {"G2 Sai Dakshita Complex G2 Waltair Main Road, Club main Gate, Waltair Uplands, Opp, Visakhapatnam, Andhra Pradesh 530003",
    "The Gateway Hotel, Beach Road, Visakhapatnam, Andhra Pradesh 520010",
    "Vuda Complex, Waltair Club Rd, Siripuram, Visakhapatnam, Andhra Pradesh 530003",
    " Harbour Park, 1st Floor, ATR Towers, East Wing Near, Harbour Park Rd, Pandurangapuram, Visakhapatnam, Andhra Pradesh 530003",
    "47-11-9, Diamond Park Rd, Near Diamond park, Dondaparthy, Dwaraka Nagar, Visakhapatnam, Andhra Pradesh 530016",
     "Hotel Dasapalla, Town Kotha Rd, Suryabagh, Jagadamba Junction, Visakhapatnam, Andhra Pradesh 530020","" +
     "Balaji Mangalagiri Chambers, Waltair Main Rd, Balaji Nagar, Asilmetta, Visakhapatnam, Andhra Pradesh 530003","" +
     "Waltair Main Rd, Jagadamba Centre, Nehru Nagar, Ram Nagar, Visakhapatnam, Andhra Pradesh 530002",
     "The Park Hotel Beach Road Visakapatnam, Visakhapatnam, Andhra Pradesh 530023",
     " 8-1-6 Waltair Main Road opp. AU Campus, Balaji Nagar, Siripuram, Visakhapatnam, Andhra Pradesh 530003",
     "10-28-3, Waltair Main Rd, Waltair Uplands, Uplands, Visakhapatnam, Andhra Pradesh 530003",
     "Block A, Udhyog Bhawan Complex Chiina, Waltair Main Rd, Behind HSBC, Siripuram, Visakhapatnam, Andhra Pradesh 530003","" +
            " WelcomHotel Grand Bay, Beach Rd, Krishna Nagar, Maharani Peta, Visakhapatnam, Andhra Pradesh 530002"};
    int[] price={1400,2000,800,1600,300,800,1500,1800,1500,200,800,700,1500};
    int[] pics={R.drawable.spaghetti,R.drawable.mint,R.drawable.kamat,R.drawable.barbeque,R.drawable.sairam,R.drawable.dharani,R.drawable.tycoon,R.drawable.green,R.drawable.shack,R.drawable.venkatadri,
                R.drawable.eatery,R.drawable.foodex,R.drawable.welocme};
    String []number={"08912566652","08916623685","08912788984","09711726060","09866076575","08912564825","089125 40202","097010 39314" ,
        "08916615151","08912541377","08913051111","08912702552","08916600101"};*/



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadLocale();
        setContentView(R.layout.food);

        restaurantName = findViewById(R.id.names);

        home = findViewById(R.id.home);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), second.class));
            }
        });

        /*Intent iget = getIntent();
        String c = iget.getExtras().getString("restaurantnames");
*/
        restaurantAddress=(TextView)findViewById(R.id.address1);
        restaurantPrice=(TextView)findViewById(R.id.price2);
        restaurantImage =(ImageView)findViewById(R.id.img2);
        restaurantPhone=(TextView)findViewById(R.id.number1);


        final String currentHotel = getIntent().getStringExtra("hotelName");
        restaurantName.setText(currentHotel);

        DatabaseReference databaseReference =
                FirebaseDatabase.getInstance().getReference("Restaurants");


        Query query = databaseReference.orderByChild(currentHotel);

        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                String address =
                        snapshot.child(currentHotel).child("Address").getValue(String.class);
                restaurantAddress.setText(address);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String phone =
                        snapshot.child(currentHotel).child("Phone").getValue(String.class);
                restaurantPhone.setText(phone);

                restaurantPhone.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Intent.ACTION_DIAL);
                        intent.setData(Uri.parse("tel:" +restaurantPhone.getText().toString()));
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

                String price = snapshot.child(currentHotel).child("Price").getValue(String.class);
                restaurantPrice.setText(price);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                final String image = snapshot.child(currentHotel).child("Image").getValue(String.class);


                Picasso.get().load(image).networkPolicy(NetworkPolicy.OFFLINE).into(restaurantImage, new Callback() {
                    @Override
                    public void onSuccess() {

                    }

                    @Override
                    public void onError(Exception e) {

                        Picasso.get().load(image).into(restaurantImage);
                    }
                });

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
/*

//Taking the inputs from previous activity comparing them and displaying their details
for(int i=0;i<hnames.length;i++) {
            if (c.equals(hnames[i])) {
                names1.setText(hnames[i]);
                txt.setText("Address :"+address[i]);
                img.setImageResource(pics[i]);
                txt2.setText("Price for Two(Approximate) :"+price[i]);
                txt1.setText(number[i]);


            }
        }

        //This defines what should be done when the number is clicked.
txt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(food.this);
                builder.setMessage("Do you want to make a call?").setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent in = new Intent(Intent.ACTION_DIAL);
                        in.setData(Uri.parse("tel:" +txt1.getText().toString()));
                        startActivity(in);
                    }

                })
This section deals when the user clicks cancel option on the popup displayed
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


//this redirects the page
    public void backButton(View view){
        Intent gotoScreenVar = new Intent(food.this,FoodActivity.class);
        gotoScreenVar.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(gotoScreenVar);
    }
}

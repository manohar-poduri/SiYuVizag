package com.alcove.partners.siyu;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by jyothi on 7/18/2017.- SUBHYATRA 1.0
 * Updated by Sirisha Balireddy on 25/04/2019 - SiYuVizag 1.1
 */
/*
This module takes care of the giving the list of hospitals in Vizag along with their address and contact numbers.
The user can select the hospital which he wants to visit from the list of hospitals provided. Then it redirects to the page where
there is address and contact number of the hospitals. On clicking the contact number of the hospital, the user will be able to make a call
 */
public class InfoHospital extends second {

    TextView txt1,txt2;

/* List of hospitals, address, phone numbers are taken in the form of strings*/

    String hospitals[] = {"KGH Hospital", "R.K.Hospital", "Simhadri Hospital", "SevenHills Hospital", "Care Hospital", "A.N.Beach Hospital"};
    String Address[] = {"Opp. District, Collector Office, Maharani Peta, Visakhapatnam, Andhra Pradesh 530002",
            "26-16-7, Chaitanya Nagar, Gajuwaka, Visakhapatnam, Andhra Pradesh 530026",
            "15-12-1 Near Collectorate Junction, Krishna Nagar, Maharani Peta, Visakhapatnam, Andhra Pradesh 530002",
            "11-4-4/A Waltair Main Road Ram Nagar, Rockdale Layout, Visakhapatnam, Andhra Pradesh 530002",
            "10-50-11/5, A S Raja Complex, Waltair Main Rd, Ram Nagar, Visakhapatnam, Andhra Pradesh 530002",
            "Door. No. 15-9, 13/24, Beach Rd, Pandurangapuram, Krishna Nagar, Maharani Peta, Visakhapatnam, Andhra Pradesh 530002"};
    String Number[] = {"08912564893", "08912764411", "08912784545", "08916677777", "08913041444", "089127 37877"};

    /*
    The below function finds the address and contact number when a particular hospital is selected
     */

    ImageView home;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadLocale();
        setContentView(R.layout.info);

        home = findViewById(R.id.home);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), second.class));
            }
        });

        Intent iget = getIntent();
        String c = iget.getExtras().getString("info");

        txt1=(TextView)findViewById(R.id.address);
        txt2=(TextView)findViewById(R.id.number);

        for(int i=0;i<hospitals.length;i++) {
            if (c.equals(hospitals[i])) {
                txt1.setText(Address[i]);
                txt2.setText(Number[i]);


            }
        }
        /*
        This part makes the calls to hospitals when the user clicks on the contact number provided and then clicks okay on the popup
        that is displayed.
         */
        txt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(InfoHospital.this);
                builder.setMessage("Do you want to make a call?").setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent in = new Intent(Intent.ACTION_DIAL);
                        in.setData(Uri.parse("tel:" +txt2.getText().toString()));
                        startActivity(in);
                    }

                })
                        /*
                        This section deals when the user clicks cancel option on the popup displayed
                         */
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
    }
    /*
    This sections takes the user to home page when the home button is clicked.
     */
    public void homeButton(View view){
        Intent gotoScreenVar = new Intent(InfoHospital.this,second.class);
        gotoScreenVar.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(gotoScreenVar);
    }

    }


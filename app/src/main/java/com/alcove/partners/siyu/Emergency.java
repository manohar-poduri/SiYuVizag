/*
Updated by Sirisha Balireddy on 25-04-2019 - SiYuVizag 1.1
 */
/*
This module deals with emergency calls. The user can make calls for ambulance, fireengine, policestation and the hospitals available in vizag.

 */
package com.alcove.partners.siyu;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import androidx.appcompat.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Emergency extends second {

    private Button ambulance, fire, medical, police;

    /*
    This section has the onclick functions for all the emergency cases.
     */

    private ImageView home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadLocale();
        setContentView(R.layout.activity_emergency);

        home = findViewById(R.id.home);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), second.class));
            }
        });

        ambulance = (Button) findViewById(R.id.danger);
        fire = (Button) findViewById(R.id.fire);
        police = (Button) findViewById(R.id.police);

        /*
        When the user needs to call the ambulance ,this section takes care of it. When the user clicks ok then it is redirected to the
        calling page of the mobile along with the number.
         */

        ambulance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(Emergency.this);

                builder.setMessage("Do you want to make a call?").setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent i = new Intent(Intent.ACTION_DIAL);
                        i.setData(Uri.parse("tel:108"));
                        startActivity(i);
                    }

                })
                        /*
                        This section takes care when the user clicks the cancel button
                         */
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();

            }
        });
     /*   When the user needs to call the fireengine ,this section takes care of it. When the user clicks ok then it is redirected to the
        calling page of the mobile along with the number.*/
        fire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(Emergency.this);

                builder.setMessage("Do you want to make a call?").setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent i = new Intent(Intent.ACTION_DIAL);
                        i.setData(Uri.parse("tel:101"));
                        startActivity(i);
                    }

                })
                        /*
                        This section takes care when the user clicks the cancel button
                         */
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();

            }
        });
         /*   When the user needs to call the policestation ,this section takes care of it. When the user clicks ok then it is redirected to the
        calling page of the mobile along with the number.*/
        police.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Emergency.this);

                builder.setMessage("Do you want to make a call?").setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent i = new Intent(Intent.ACTION_DIAL);
                        i.setData(Uri.parse("tel:100"));
                        startActivity(i);
                    }

                })
                        /*
                        This section takes care when the user clicks the cancel button.
                         */
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
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
    This section takes care when the user clicks the hospital button on the screen. It redirects to the activity_hospital.xml  page.
     */
        public void hospital(View view){
        Intent i = new Intent(this,HospitalActivity.class);
        startActivity(i);

    }
    /*
    When the user clicks the back button on the bottom of the page
     */
    public void gotoPrevious(View view){
        finish();

    }
}


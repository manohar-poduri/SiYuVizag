/*
Updated and modified by Sirisha Balireddy -25-04-2019 - SiYuVizag 1.1
 */
/*
This module deals with the second page of application where it provides users with some options like hotels,food or restaurants
busfares,emergency contacts, places to visit and feed back.
 */
package com.alcove.partners.siyu;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import java.util.Locale;

public class second extends AppCompatActivity {

//    Spinner spinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     loadLocale();
       setContentView(R.layout.activity_second);


      /* spinner = findViewById(R.id.spinner);


        List<String> list = new ArrayList<String>();
        list.add("Telugu");
        list.add("Hindi");
        list.add("Bengali");
        list.add("English");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(dataAdapter);

        spinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });*/

        Button b1=(Button)findViewById(R.id.b1);
       b1.setOnClickListener(new View.OnClickListener() {
         @Override
           public void onClick(View v) {
             showChangeLanguageDialog();
           }
       });


    }
    //This creates the spinner where the user will be able to select the language he/she wants to
   public void showChangeLanguageDialog()
    {
        final String[] listItems={"English","हिंदी","తెలుగు","বাঙালি","ନୀୟ"};
        AlertDialog.Builder nBuilder =new AlertDialog.Builder(second.this);
        nBuilder.setTitle("Choose Language");
        nBuilder.setSingleChoiceItems(listItems, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if(i==0)
                {
                    setLocale("en");
                    recreate();
                }
                else if(i==1)
                {
                    setLocale("hi");
                    recreate();
                }
                else if(i==2)
                {
                    setLocale("te");
                    recreate();
                }
               else  if(i==3)
                {
                    setLocale("bn");
                    recreate();
                }
                else if(i==4)
                {
                    setLocale("or");
                    recreate();
                }
                dialogInterface.dismiss();
            }
        });

        AlertDialog mDialog = nBuilder.create();
        mDialog.show();
    }
//this function sets the the lanuage from default language
    public void setLocale(String lang)
    {

        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale=locale;
        getBaseContext().getResources().updateConfiguration(config,getBaseContext().getResources().getDisplayMetrics());
        SharedPreferences.Editor editor =getSharedPreferences("Settings",MODE_PRIVATE).edit();
        editor.putString("MyLanguage",lang);
        editor.apply();

    }
    //This change the language
    public void loadLocale()
    {
        SharedPreferences pref = getSharedPreferences("Settings",MODE_PRIVATE);
        String language =pref.getString("MyLanguage","");
        setLocale(language);
    }

    public void food (View view){
        Intent i = new Intent(this, FoodActivity.class);
        startActivity(i);
    }

    public void restRoom (View view){
        Intent i = new Intent(this, rest.class);
        startActivity(i);
    }

    public void busFare (View view){
        Intent i = new Intent(this, busFare.class);
        startActivity(i);
    }

    public void places (View view){
        Intent i = new Intent(this, PlacesActivity.class);
        startActivity(i);
    }

    public void emergency (View view){
        Intent i = new Intent(this, Emergency.class);
        startActivity(i);
    }


    /*public void feedback (View view){
        Intent i = new Intent(this, Feedback.class);
        startActivity(i);
    }*/
        public void gotoPrevious (View view){

            Intent i = new Intent(this, second.class);
            startActivity(i);
        }

        public void info(View view){
            String[] listItems1 = {"Contact","About"};
            final AlertDialog.Builder builder = new AlertDialog.Builder(second.this);
            builder.setTitle("INFO");
            builder.setSingleChoiceItems(listItems1, -1, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    if (i == 0){
                        startActivity(new Intent(getApplicationContext(),contactUs.class));
                    } else if (i == 1){
                        startActivity(new Intent(getApplicationContext(),about.class));
                    }

                    dialogInterface.dismiss();
                }

            });


            AlertDialog dialog = builder.create();
            dialog.show();
        }

    public void feedback(View view) {

            startActivity(new Intent(second.this,Feedback.class));
            finish();
    }




   /* boolean doubleBackToExitPressedOnce = false;
//This function takes care of when the user presses the back button in his mobile.
    @Override
    public void onBackPressed() {

        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();


        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }*/
}


/*
Updated by Sirisha Balireddy on 25-04-2019 - SiYuVizag 1.1
 */
package com.alcove.partners.siyu;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Feedback extends second {
    EditText  edit1, edit2, edit3;
    // String datas,data;
//    DbHelper dbhelper = new DbHelper(this);

    DatabaseReference databaseReference;
    Database database;
    ImageView home;

    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadLocale();
        setContentView(R.layout.activity_feedback);

        databaseReference = FirebaseDatabase.getInstance().getReference().child("Feedback");

        database = new Database();

        spinner = findViewById(R.id.spinner);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Feedback.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.content));

        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);




        /*feedback = findViewById(R.id.feedback);
        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] listItems = {"Restaurants","Accommodation","Fares","Tourism"};
                final AlertDialog.Builder builder = new AlertDialog.Builder(Feedback.this);
                builder.setTitle("Feedback");
                builder.setSingleChoiceItems(listItems, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        if (i == 0){
                            edit.setText("Restaurants");
                            dialogInterface.dismiss();
                        } else if (i == 1){
                            edit.setText("Accommodation");
                            dialogInterface.dismiss();
                        } else if (i == 2){
                            edit.setText("Travel");
                            dialogInterface.dismiss();
                        } else if (i == 3){
                            edit.setText("Tourism");
                            dialogInterface.dismiss();

                        }
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });*/

        home = findViewById(R.id.home);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), second.class));
            }
        });

        edit1 = (EditText) findViewById(R.id.ed2);
        edit2 = (EditText) findViewById(R.id.ed3);
        edit3 = (EditText) findViewById(R.id.ed4);
        Intent i1 = getIntent();


    }
    //Inserting the data into database taken from the inputs of users

    public void gotoDatabase(View view) {
        String set2 = edit1.getText().toString();
        String set3 = edit2.getText().toString();
        String set4 = edit3.getText().toString();
        String mySpinner = spinner.getSelectedItem().toString();
        if (set2.equals("") || set3.equals("") || set4.equals("")) {
            Toast.makeText(getApplicationContext(), "Please fill in all details", Toast.LENGTH_SHORT).show();
        } else {
           /* SQLiteDatabase sqLiteDatabase = dbhelper.getWritableDatabase();
            ContentValues Names = new ContentValues();
            ContentValues Names1 = new ContentValues();
            ContentValues Names2 = new ContentValues();
            ContentValues Names3 = new ContentValues();
            Names1.put("Name", set1);
            Names.put("Feedback", set2);
            Names2.put("Phone", set3);
            Names3.put("Email", set4);
            sqLiteDatabase.insert("Name", null, Names);
            sqLiteDatabase.insert("Feedback", null, Names1);
            sqLiteDatabase.insert("Phone", null, Names2);
            sqLiteDatabase.insert("Email", null, Names3);
            sqLiteDatabase.close();
            dbhelper.close();*/


           database.setPhone(set2);
           database.setEmail(set3);
           database.setFeedback(set4);
           database.setFeedbackName(mySpinner);

           databaseReference.push().setValue(database);

            Toast.makeText(getApplicationContext(), "Thank you for your feedback.", Toast.LENGTH_SHORT).show();
            gotoHome();
        }

    }

//This function is to go back to the previous activity
    public void gotoHome() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent gotoScreenVar = new Intent(Feedback.this, second.class);
                gotoScreenVar.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(gotoScreenVar);
            }
        }, 1000);


    }
}


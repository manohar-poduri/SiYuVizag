package com.alcove.partners.siyu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class contactUs extends AppCompatActivity {

    private EditText name,phone,email,message;
    private Button database;

//    DbHelper dbhelper = new DbHelper(this);

    private DatabaseReference databaseReference;
    private Database databaseSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        databaseReference = FirebaseDatabase.getInstance().getReference().child("Contact Us");

        databaseSave = new Database();

        name =findViewById(R.id.name);
        phone = findViewById(R.id.phone1);
        email = findViewById(R.id.email1);
        message = findViewById(R.id.message);
        database= findViewById(R.id.but1);

        database.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String set1 = name.getText().toString();
                String set3 = phone.getText().toString();
                String set4 = email.getText().toString();
                String set2 = message.getText().toString();
                if (set1.equals("") || set2.equals("") || set3.equals("") || set4.equals("")) {
                    Toast.makeText(getApplicationContext(), "Please fill in all details", Toast.LENGTH_SHORT).show();
                } else {
                    /*SQLiteDatabase sqLiteDatabase = dbhelper.getWritableDatabase();
                    ContentValues Names = new ContentValues();
                    ContentValues Names1 = new ContentValues();
                    ContentValues Names2 = new ContentValues();
                    ContentValues Names3 = new ContentValues();
                    Names1.put("Name", set1);
                    Names.put("Message", set2);
                    Names2.put("Phone",set3);
                    Names3.put("Email",set4);
                    sqLiteDatabase.insert("Message", null, Names);
                    sqLiteDatabase.insert("Name", null, Names1);
                    sqLiteDatabase.insert("Phone",null,Names2);
                    sqLiteDatabase.insert("Email",null,Names3);
                    sqLiteDatabase.close();
                    dbhelper.close();*/

                    databaseSave.setContactName(set1);
                    databaseSave.setContactPhone(set2);
                    databaseSave.setContactEmail(set3);
                    databaseSave.setContactMessage(set4);

                    databaseReference.push().setValue(databaseSave);

                    Toast.makeText(getApplicationContext(), "Thank you for your Details.", Toast.LENGTH_SHORT).show();
                    gotoHome();
                }
            }
        });
    }


    public void homeButton(View view) {
        startActivity(new Intent(contactUs.this,second.class));
    }
    public void gotoHome() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent gotoScreenVar = new Intent(contactUs.this, second.class);
                gotoScreenVar.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(gotoScreenVar);
            }
        }, 1000);


    }

    /*public void home(View view) {
        startActivity(new Intent(contactUs.this,second.class));
    }*/
}
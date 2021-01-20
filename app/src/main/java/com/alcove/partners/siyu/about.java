package com.alcove.partners.siyu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class about extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
    }

    public void homeButton(View view) {
        startActivity(new Intent(about.this,second.class));
    }

//    public void home(View view) {
//        startActivity(new Intent(about.this,second.class));
//    }
}
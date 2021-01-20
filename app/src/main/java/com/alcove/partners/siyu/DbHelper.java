/*
Created by Sirisha Balireddy on 20-05-2019 -SiYuVizag 1.1
 */
package com.alcove.partners.siyu;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper  extends SQLiteOpenHelper  {
    private static final String DB_Name = "sirisha";
    private static final int DB_Version = 1;
    DbHelper(Context context) {
        super(context, DB_Name, null, DB_Version);
    }
//Creation of databases
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE Feedback (" + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "+"Feedback varchar(255),"+" Names varchar(255));");

    }
//function if table already exists
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
sqLiteDatabase.execSQL("drop table if exists Feedback");

        sqLiteDatabase.execSQL("drop table if exists Rest");
    }
    //function to insert values into database


}

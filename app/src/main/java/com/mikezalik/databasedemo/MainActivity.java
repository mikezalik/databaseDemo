package com.mikezalik.databasedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SQLiteDatabase myDatabase = this.openOrCreateDatabase("Users", MODE_PRIVATE, null);
        myDatabase.execSQL("CREATE TABLE IF NOT EXISTS users (name VARCHAR, age INT(3))");

        myDatabase.execSQL("INSERT INTO users (name, age) VALUES ('Mike', 29)");
        myDatabase.execSQL("INSERT INTO users (name, age) VALUES ('Brianna', 24)");

        Cursor c = myDatabase.rawQuery("SELECT * FROM users", null);

        int nameIndex = c.getColumnIndex("name");
        int ageIndex = c.getColumnIndex("age");

        c.moveToFirst();

        while (!c.isAfterLast()){
            Log.i("name", c.getString(nameIndex));
            Log.i("age", c.getString(ageIndex));

            c.moveToNext();
        }
    }
}

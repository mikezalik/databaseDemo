package com.mikezalik.databasedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SQLiteDatabase myDatabase = this.openOrCreateDatabase("Users", MODE_PRIVATE, null);
        myDatabase.execSQL("CREATE TABLE IF NOT EXIST users (name VARCHAR, age INT(3))");
    }
}

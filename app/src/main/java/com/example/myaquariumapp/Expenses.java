package com.example.myaquariumapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.internal.ForegroundLinearLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;


public class Expenses extends AppCompatActivity {

    FloatingActionButton Del;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expenses);
        setTitle("Expenses");

        BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.execute("get_info");



        //Del = (FloatingActionButton) findViewById(R.id.floatingActionButton2);



    }


    public void OpenAddExpense(View view) {
        Intent intent = new Intent(this, AddExpense.class);
        startActivity(intent);
    }

    public void OpenDeleteExpense(View view) {
        Intent intent = new Intent(this, DeleteExpense.class);
        startActivity(intent);
    }




}

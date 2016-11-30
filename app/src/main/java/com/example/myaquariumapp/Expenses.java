package com.example.myaquariumapp;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


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

    public void OpenEditExpense(View view) {
        Intent intent = new Intent(this, EditExpense.class);
        startActivity(intent);
    }




}

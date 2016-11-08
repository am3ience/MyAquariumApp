package com.example.myaquariumapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Expenses extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expenses);
        setTitle("Expenses");
    }

    public void OpenAddExpense(View view) {
        Intent intent = new Intent(this, AddExpense.class);
        startActivity(intent);
    }


}

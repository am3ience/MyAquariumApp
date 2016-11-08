package com.example.myaquariumapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Expenses extends AppCompatActivity {

    String[] expenseArray = {"Filter $50","Goldfish $10","Tropical Fish Food $5","Fish net $10",
            "10 gallon tank $40"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expenses);
        setTitle("Expenses");

        ArrayAdapter adapter = new ArrayAdapter<>(this,
                R.layout.activity_listview, expenseArray);

        ListView listView = (ListView) findViewById(R.id.expense_list);
        listView.setAdapter(adapter);
    }


    public void OpenAddExpense(View view) {
        Intent intent = new Intent(this, AddExpense.class);
        startActivity(intent);
    }


}

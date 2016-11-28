package com.example.myaquariumapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import static com.example.myaquariumapp.R.id.textView2;

public class AddExpense extends AppCompatActivity {

    EditText NameExpense = (EditText) findViewById(R.id.editText);
    EditText CostExpense = (EditText) findViewById(R.id.editText3);
    String radiobutt = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_expense);
        setTitle("Add Expense");


    }

    public void getText(View view){

        EditText expenseName = (EditText) findViewById(R.id.expenseName);
        String expenseNameString = expenseName.getText().toString();
        EditText expenseCost = (EditText) findViewById(R.id.expenseCost);
        String expenseCostString = expenseCost.getText().toString();

    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radioButton:
                if (checked)
                    radiobutt = "Equipment";
                    break;
            case R.id.radioButton2:
                if (checked)
                    radiobutt = "Livestock";
                    break;
        }
    }

    /** Called when the user clicks the Submit button */
    public void writeExpense(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, Expenses.class);
    }


}

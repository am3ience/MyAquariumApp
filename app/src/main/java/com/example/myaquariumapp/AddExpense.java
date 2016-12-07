package com.example.myaquariumapp;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import static com.example.myaquariumapp.R.id.radioButton;
import static com.example.myaquariumapp.R.id.textView2;

public class AddExpense extends AppCompatActivity {

    //EditText NameExpense = (EditText) findViewById(R.id.editText);
    //EditText CostExpense = (EditText) findViewById(R.id.editText3);
    EditText expenseName, expenseCost;
    RadioGroup expenseCategory;

    RadioButton radioButton;
    String expenseNameString, expenseCostString, radiobutt, expenseCategoryString;
    Button REG;
    Context ctx = this;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_expense);
        setTitle("Add Expense");

        expenseName = (EditText) findViewById(R.id.expenseName);

        expenseCost = (EditText) findViewById(R.id.expenseCost);

        expenseCategory = (RadioGroup) findViewById(R.id.RadioGroup);



        /*REG = (Button) findViewById(R.id.button);
        REG.setOnClickListener(new View.OnClickListener(){*/

            /*@Override
            public void onClick(View v){
                expenseNameString = expenseName.getText().toString();
                expenseCostString = expenseCost.getText().toString();

                // get selected radio button from radioGroup
                int selectedId = expenseCategory.getCheckedRadioButtonId();

                // find the radiobutton by returned id
                radioButton = (RadioButton) findViewById(selectedId);

                expenseCategoryString = radioButton.getText().toString();

                DatabaseOperations DB = new DatabaseOperations(ctx);
                DB.putInformation(DB, expenseNameString, expenseCostString, expenseCategoryString);
                Toast.makeText(getBaseContext(), "Expense Added!", Toast.LENGTH_LONG).show();
            }
        });*/


    }


    public void addExpense(View view) {

        expenseNameString = expenseName.getText().toString();
        expenseCostString = expenseCost.getText().toString();

        // get selected radio button from radioGroup
        int selectedId = expenseCategory.getCheckedRadioButtonId();

        // find the radiobutton by returned id
        radioButton = (RadioButton) findViewById(selectedId);

        expenseCategoryString = radioButton.getText().toString();

        //BackgroundTask backgroundTask = new BackgroundTask(this);
        //backgroundTask.execute("add_info", expenseNameString, expenseCostString, expenseCategoryString);

        if (expenseNameString.matches("")) {
            Toast.makeText(this, "You did not enter a Name", Toast.LENGTH_SHORT).show();
            return;
        } else if (expenseCostString.matches("")) {
            Toast.makeText(this, "You did not enter a Cost", Toast.LENGTH_SHORT).show();
            return;
        } else if (expenseCostString.matches("") && expenseNameString.matches("")) {
            Toast.makeText(this, "You did not enter anything", Toast.LENGTH_SHORT).show();
            return;

        } else {
            BackgroundTask backgroundTask = new BackgroundTask(this);
            backgroundTask.execute("add_info", expenseNameString, expenseCostString, expenseCategoryString);
            Intent intent = new Intent(this, Expenses.class);
            startActivity(intent);
        }

    }




}

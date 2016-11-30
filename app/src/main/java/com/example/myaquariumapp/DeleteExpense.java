package com.example.myaquariumapp;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteExpense extends AppCompatActivity {

    Button del;
    EditText Name;
    String name;
    DatabaseOperations DOP;
    Context CTX = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_expense);

        del = (Button)findViewById(R.id.deleteExpense);
        Name = (EditText)findViewById(R.id.deleteExpenseName);





    }

    public void DeleteExpense(View view) {
        name = Name.getText().toString();
        DOP = new DatabaseOperations(CTX);
        Cursor CR = DOP.getExpenseName(DOP, name);
        CR.moveToFirst();
        boolean correct_name = false;
        do {

            if(name.equals(CR.getString(0))){
                correct_name = true;
            }

        }while(CR.moveToNext());{

        }

        if(correct_name == true){
            DOP.deleteEntry(DOP,name);
            Toast.makeText(getBaseContext(), "Entry Removed Successfully", Toast.LENGTH_LONG).show();
            finish();

        }else{
            Toast.makeText(getBaseContext(), "Invalid Name", Toast.LENGTH_LONG).show();
            finish();
        }

    }


}

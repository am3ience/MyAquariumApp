package com.example.myaquariumapp;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by Paul on 11/29/2016.
 */

public class BackgroundTask extends AsyncTask<String, ExpenseDisplay, String> {
    Context ctx;
    ExpenseAdapter expenseAdapter;
    Activity activity;
    ListView listView;
    BackgroundTask(Context ctx){
        this.ctx = ctx;
        activity = (Activity)ctx;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... params){

        String method = params[0];
        DatabaseOperations dbOperations = new DatabaseOperations(ctx);
        if(method.equals("add_info")){
            String ExpenseName = params[1];
            int ExpenseCost = Integer.parseInt(params[2]);
            String ExpenseCategory = params[3];
            //SQLiteDatabase db = dbOperations.getWritableDatabase();
            dbOperations.putInformation(dbOperations, ExpenseName, ExpenseCost, ExpenseCategory);
            return "One Row Inserted...";

        }else if (method.equals("get_info")){

            listView = (ListView)activity.findViewById(R.id.display_expenses);
            SQLiteDatabase db = dbOperations.getReadableDatabase();

            Cursor cursor = dbOperations.getInformations(db);

            expenseAdapter = new ExpenseAdapter(ctx,R.layout.display_expense_row);

            String expensename, expensecategory;
            int expensecost;

            while (cursor.moveToNext()){
                expensename = cursor.getString(cursor.getColumnIndex(TableData.TableInfo.EXPENSE_NAME));
                expensecost = cursor.getInt(cursor.getColumnIndex(TableData.TableInfo.EXPENSE_COST));
                expensecategory = cursor.getString(cursor.getColumnIndex(TableData.TableInfo.EXPENSE_CATEGORY));
                ExpenseDisplay expense = new ExpenseDisplay(expensename,expensecost,expensecategory);
                publishProgress(expense);
            }
                return "get_info";
        }

        return null;
    }

    @Override
    protected void onProgressUpdate(ExpenseDisplay... values) {
        expenseAdapter.add(values[0]);

    }

    @Override
    protected void onPostExecute(String result) {

        if (result.equals("get_info")) {
            listView.setAdapter(expenseAdapter);
        } else {
            Toast.makeText(ctx, result, Toast.LENGTH_LONG).show();
        }
    }
}

package com.example.myaquariumapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.style.TtsSpan;
import android.util.Log;
import android.view.View;

import com.example.myaquariumapp.TableData.TableInfo;

/**
 * Created by Paul on 11/27/2016.
 */

public class DatabaseOperations extends SQLiteOpenHelper {
    public static final int database_version = 3;
    public String CREATE_QUERY = "CREATE TABLE " + TableInfo.TABLE_NAME + "(" + TableInfo.EXPENSE_NAME + " TEXT," + TableInfo.EXPENSE_COST + " INTEGER," + TableInfo.EXPENSE_CATEGORY + " TEXT );";

    public DatabaseOperations (Context context){
        super(context, TableInfo.DATABASE_NAME, null, database_version);
        Log.d("Database operations", "Database successfully created");
    }

    @Override
    public void onCreate(SQLiteDatabase sdb){
        sdb.execSQL(CREATE_QUERY);
        Log.d("Database operations", "Table created");
    }
    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2){

    }

    public void putInformation(DatabaseOperations db, String name, int cost, String category){
        SQLiteDatabase SQ = db.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(TableInfo.EXPENSE_NAME, name);
        cv.put(TableInfo.EXPENSE_COST, cost);
        cv.put(TableInfo.EXPENSE_CATEGORY, category);
        long k = SQ.insert(TableInfo.TABLE_NAME, null, cv);
        Log.d("Database operations", "One row inserted.");

    }

    public Cursor getInformations(SQLiteDatabase db){

        String[] projections ={TableInfo.EXPENSE_NAME, TableInfo.EXPENSE_COST,  TableInfo.EXPENSE_CATEGORY};

        Cursor cursor = db.query(TableInfo.TABLE_NAME, projections,
                        null, null, null, null, null);

        return cursor;
    }

    public Cursor getExpenseName(DatabaseOperations DOP, String name) {
        SQLiteDatabase SQ = DOP.getReadableDatabase();
        String selection = TableInfo.EXPENSE_NAME + " LIKE ?";
        String columns[] = {TableInfo.EXPENSE_NAME};
        String args[] = {name};
        Cursor CR = SQ.query(TableInfo.TABLE_NAME, columns, selection, args, null, null, null);
        return CR;
    }

    public void deleteEntry(DatabaseOperations DOP, String name){

        String selection = TableInfo.EXPENSE_NAME + " LIKE ?";
        String columns[] = {TableInfo.EXPENSE_NAME, TableInfo.EXPENSE_COST, TableInfo.EXPENSE_CATEGORY};
        String args[] = {name};
        SQLiteDatabase SQ = DOP.getWritableDatabase();
        SQ.delete(TableInfo.TABLE_NAME, selection, args);
    }


}

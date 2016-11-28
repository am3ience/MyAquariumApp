package com.example.myaquariumapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.style.TtsSpan;
import android.util.Log;

import com.example.myaquariumapp.TableData.TableInfo;

/**
 * Created by Paul on 11/27/2016.
 */

public class DatabaseOperations extends SQLiteOpenHelper {
    public static final int database_version = 2;
    public String CREATE_QUERY = "CREATE TABLE " + TableInfo.TABLE_NAME + "(" + TableInfo.EXPENSE_NAME + " TEXT," + TableInfo.EXPENSE_COST + " TEXT," + TableInfo.EXPENSE_CATEGORY + " TEXT );";

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

    public void putInformation(DatabaseOperations dop, String name, String cost, String category){
        SQLiteDatabase SQ = dop.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(TableInfo.EXPENSE_NAME, name);
        cv.put(TableInfo.EXPENSE_COST, cost);
        cv.put(TableInfo.EXPENSE_CATEGORY, category);
        long k = SQ.insert(TableInfo.TABLE_NAME, null, cv);
        Log.d("Database operations", "One row inserted.");

    }
}

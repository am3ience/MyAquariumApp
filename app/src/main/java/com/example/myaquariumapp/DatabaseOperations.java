package com.example.myaquariumapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.myaquariumapp.TableData.TableInfo;

/**
 * Created by Paul on 11/27/2016.
 */

public class DatabaseOperations extends SQLiteOpenHelper {
    public static final int database_version = 1;

    public DatabaseOperations (Context context){
        super(context, TableInfo.DATABASE_NAME, null, database_version);

    }

    @Override
    public void onCreate(SQLiteDatabase arg0){

    }
    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2){

    }
}

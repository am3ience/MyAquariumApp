package com.example.myaquariumapp;

import android.provider.BaseColumns;

/**
 * Created by Paul on 11/27/2016.
 */

public class TableData {

    public TableData(){

    }

    public static abstract class TableInfo implements BaseColumns{

        public static final String EXPENSE_NAME = "name";
        public static final String EXPENSE_COST = "cost";
        public static final String EXPENSE_CATEGORY = "category";
        public static final String DATABASE_NAME = "AquariumApp";
        public static final String TABLE_NAME = "Expenses";

    }
}

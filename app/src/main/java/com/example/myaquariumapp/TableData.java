package com.example.myaquariumapp;

import android.provider.BaseColumns;

/**
 * Created by Paul on 11/27/2016.
 */

public class TableData {

    public TableData(){

    }

    public static abstract class TableInfo implements BaseColumns{

        public static final String EXPENSE_NAME = "Name";
        public static final String EXPENSE_COST = "Cost";
        public static final String EXPENSE_Category = "Category";
        public static final String DATABASE_NAME = "AquariumApp";
        public static final String TABLE_NAME = "Expenses";

    }
}

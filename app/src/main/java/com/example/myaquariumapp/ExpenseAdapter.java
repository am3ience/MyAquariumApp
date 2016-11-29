package com.example.myaquariumapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Paul on 11/29/2016.
 */

public class ExpenseAdapter extends ArrayAdapter{

    List list = new ArrayList();
    public ExpenseAdapter(Context context, int resource) {
        super(context, resource);
    }


    public void add(ExpenseDisplay object) {
        list.add(object);
        super.add(object);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ExpenseHolder expenseHolder;
        if(row == null){
            LayoutInflater layoutInflater = (LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.display_expense_row,parent,false);
            expenseHolder = new ExpenseHolder();
            expenseHolder.expense_name = (TextView)row.findViewById(R.id.expense_name);
            expenseHolder.expense_cost = (TextView)row.findViewById(R.id.expense_cost);
            expenseHolder.expense_category = (TextView)row.findViewById(R.id.expense_category);
            row.setTag(expenseHolder);
        }else{
            expenseHolder = (ExpenseHolder) row.getTag();
        }

        ExpenseDisplay expenseDisplay = (ExpenseDisplay)getItem(position);
        expenseHolder.expense_name.setText(expenseDisplay.getName().toString());
        expenseHolder.expense_cost.setText(Integer.toString(expenseDisplay.getCost()));
        expenseHolder.expense_category.setText(expenseDisplay.getCategory().toString());
        return row;

    }

    static class ExpenseHolder{

        TextView expense_name, expense_cost, expense_category;

    }
}

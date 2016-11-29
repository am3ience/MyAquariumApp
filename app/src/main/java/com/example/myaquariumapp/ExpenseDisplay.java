package com.example.myaquariumapp;

/**
 * Created by Paul on 11/29/2016.
 */

public class ExpenseDisplay {

    private String name,category;
    private int cost;

    public ExpenseDisplay(String name, int cost, String category){
        this.setName(name);
        this.setCost(cost);
        this.setCategory(category);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}

package com.example.myaquariumapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void OpenExpenses(View view) {
        Intent intent = new Intent(this, Expenses.class);
        startActivity(intent);
    }
    public void OpenTimeline(View view) {
        Intent intent = new Intent(this, TankTimeline.class);
        startActivity(intent);
    }

    public void OpenTasks(View view) {
        Intent intent = new Intent(this, Tasks.class);
        startActivity(intent);
    }

    public void OpenParams(View view) {
        Intent intent = new Intent(this, WaterParams.class);
        startActivity(intent);
    }

}

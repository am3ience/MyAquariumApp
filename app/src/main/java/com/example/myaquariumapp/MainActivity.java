package com.example.myaquariumapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    String[] taskArray = {"10/27/2016 Feed fish 7:30pm","10/30/2016 Clean tank 5:30pm","10/31/2016 Change water 7:30pm"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter adapter = new ArrayAdapter<>(this,
                R.layout.activity_listview, taskArray);

        ListView listView = (ListView) findViewById(R.id.task_list);
        listView.setAdapter(adapter);
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

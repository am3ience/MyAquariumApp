package com.example.myaquariumapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class TankTimeline extends AppCompatActivity {

    String[] timelineArray = {"10/27/2016 Tested water in preparation of new fish","10/30/2016 Added new fish to the tank! (Neon Tetras)"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tank_timeline);
        setTitle("Tank Timeline");

        ArrayAdapter adapter = new ArrayAdapter<>(this,
                R.layout.activity_listview, timelineArray);

        ListView listView = (ListView) findViewById(R.id.timeline_list);
        listView.setAdapter(adapter);
    }

    public void OpenAddTimeline(View view) {
        Intent intent = new Intent(this, AddTimeline.class);
        startActivity(intent);
    }
}

package com.example.myaquariumapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class TankTimeline extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tank_timeline);
        setTitle("Tank Timeline");
    }

    public void OpenAddTimeline(View view) {
        Intent intent = new Intent(this, AddTimeline.class);
        startActivity(intent);
    }
}

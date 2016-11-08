package com.example.myaquariumapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class WaterParams extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_params);
        setTitle("Water Parameters");
    }

    public void OpenAddWaterParam(View view) {
        Intent intent = new Intent(this, AddWaterParam.class);
        startActivity(intent);
    }
}

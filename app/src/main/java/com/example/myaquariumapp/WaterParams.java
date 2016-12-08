package com.example.myaquariumapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class WaterParams extends AppCompatActivity {

    String[] paramsArray = {"10/27/2016 Ammonia: 0.1 Nitrite: 0.05 Nitrate: 2","10/31/2016 Ammonia: 0.05 Nitrite: 0.05 Nitrate: 3",
                                "12/05/2016 Ammonia: 0 Nitrite: 0 Nitrate: 2", "12/10/2016 Ammonia: 0 Nitrite: 0.05 Nitrate: 5"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_params);
        setTitle("Water Parameters");

        ArrayAdapter adapter = new ArrayAdapter<>(this,
                R.layout.activity_listview, paramsArray);

        ListView listView = (ListView) findViewById(R.id.params_list);
        listView.setAdapter(adapter);
    }

    public void OpenAddWaterParam(View view) {
        Intent intent = new Intent(this, AddWaterParam.class);
        startActivity(intent);
    }
}

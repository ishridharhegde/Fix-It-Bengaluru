package com.team7.parking.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Main5Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        Intent intent = new Intent(Main5Activity.this, Main4Activity.class);
        startActivity(intent);

        String t = getIntent().getExtras().getString("Point");
        Intent intent1 = new Intent(Main5Activity.this, MapsActivity.class);
        //String t = Double.toString(latitude)+"\n"+Double.toString(longitude);
        intent1.putExtra("Point",t);
        startActivity(intent1);


        finish();
    }
}

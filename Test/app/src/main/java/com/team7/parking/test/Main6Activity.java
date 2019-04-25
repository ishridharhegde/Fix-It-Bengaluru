package com.team7.parking.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Main6Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        final String value = getIntent().getExtras().getString("Money");
        Intent intent11 = new Intent(Main6Activity.this, payment.class);
        intent11.putExtra("Money",value);
        startActivity(intent11);
        finish();
    }
}

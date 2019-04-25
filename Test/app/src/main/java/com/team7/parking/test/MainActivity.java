package com.team7.parking.test;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button raise_money, notify_govt, disp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        User user = new User("SantoshG", "santoshgunashekar@gmail.com", "Hi", "hey","heyeydas");
//        FirebaseDatabase database = FirebaseDatabase.getInstance();
//        DatabaseReference myRef = database.getReference().child("User");
//        myRef.setValue(user);
//
//        User user1 = new User("SantoshG", "santoshgunashekar@gmail.com", "Hi1", "hey", "fsdfsd");
//        FirebaseDatabase database1 = FirebaseDatabase.getInstance();
//        DatabaseReference myRef1 = database1.getReference().child("User1");
//        myRef1.setValue(user);

        //Intent intent = new Intent(this, MainActivity.class);
        //startActivity(intent);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Home");

        raise_money = (Button) findViewById(R.id.justdoit);
        notify_govt = (Button) findViewById(R.id.nofees);
        disp = (Button) findViewById(R.id.list);
        initialize();

        raise_money.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("Money",10);
                startActivity(intent);
            }
        });

        notify_govt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("Money",1);
                startActivity(intent);
            }
        });
        disp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main3Activity.class);
                startActivity(intent);
            }
        });
        }

    public void initialize(){
        DatabaseReference database = FirebaseDatabase.getInstance().getReference("People");
        //Geocoder geocoder = new Geocoder(this, Locale.getDefault());
        //List<Address> addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
        //display_loc.setText(display_loc.getText() + "\n"+addresses.get(0).getAddressLine(0)+", "+
        //addresses.get(0).getAddressLine(1)+", "+addresses.get(0).getAddressLine(2));
        //String temp = display_loc.getText().toString();
        //temp = temp.replaceAll(", null","");
        //display_loc.setText(temp);
        //while(temp!="Before getting location"){
        User user;
        String temp1, temp2, temp3, temp4;
        temp1="Student";
        temp2="saafsadnkj@gmail.com";
        temp3="1616516816";
        temp4="Pothole";

        user = new User(temp1, temp2, temp3, temp4, 74.68, 63.48);
        DatabaseReference myRef;
        myRef = database.child(temp1);
        myRef.setValue(user);
        //2
        temp1="member2";
        temp2="member2@gmail.com";
        temp3="989888787";
        temp4="Footpath";

        user = new User(temp1, temp2, temp3, temp4, 80.33, 73.09);
        myRef = database.child(temp1);
        myRef.setValue(user);
        //3
        temp1="sharma";
        temp2="sharma@gmail.com";
        temp3="07344687";
        temp4="Pothole";

        user = new User(temp1, temp2, temp3, temp4, 54.32, 93.77);
        myRef = database.child(temp1);
        myRef.setValue(user);
        //4
        temp1="sneha";
        temp2="sneha2@gmail.com";
        temp3="678968467";
        temp4="Pothole";

        user = new User(temp1, temp2, temp3, temp4, 44.21, 83.32);
        myRef = database.child(temp1);
        myRef.setValue(user);
        //5
        temp1="gupta";
        temp2="gupta@gmail.com";
        temp3="989888787";
        temp4="Pothole";

        user = new User(temp1, temp2, temp3, temp4, 84.78, 93.09);
        myRef = database.child(temp1);
        myRef.setValue(user);
        //6
        temp1="ssuresh";
        temp2="suresh5@gmail.com";
        temp3="285353927";
        temp4="Footpath";

        user = new User(temp1, temp2, temp3, temp4, 74.55, 63.43);
        myRef = database.child(temp1);
        myRef.setValue(user);
        //7
        temp1="rohit";
        temp2="rohit@gmail.com";
        temp3="9856848787";
        temp4="Footpath";

        user = new User(temp1, temp2, temp3, temp4, 54.60, 83.43);
        myRef = database.child(temp1);
        myRef.setValue(user);
        //8
        temp1="ganavi";
        temp2="ganavi2@gmail.com";
        temp3="954633787";
        temp4="Pothole";

        user = new User(temp1, temp2, temp3, temp4, 74.88, 73.09);
        myRef = database.child(temp1);
        myRef.setValue(user);
        //9
        temp1="rahul";
        temp2="rahul@gmail.com";
        temp3="789778799";
        temp4="Pothole";

        user = new User(temp1, temp2, temp3, temp4, 54.21, 63.32);
        myRef = database.child(temp1);
        myRef.setValue(user);
        //10
        temp1="ajay";
        temp2="ajay@gmail.com";
        temp3="689888787";
        temp4="Footpath";

        user = new User(temp1, temp2, temp3, temp4, 94.78, 53.44);
        myRef = database.child(temp1);
        myRef.setValue(user);



    }



    public void exit(View view)
    {

        new AlertDialog.Builder(this)
                .setMessage("Are you sure you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                    }
                })
                .setNegativeButton("No", null)
                .show();
    }

    @Override
    public void onBackPressed()

    {
        super.onBackPressed();
        new AlertDialog.Builder(this)
                .setMessage("Are you sure you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                    }
                })
                .setNegativeButton("No", null)
                .show();
    }
}

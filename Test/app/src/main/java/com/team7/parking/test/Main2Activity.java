package com.team7.parking.test;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.List;
import java.util.Locale;

public class Main2Activity extends AppCompatActivity implements LocationListener {
    //https://androstock.com/tutorials/getting-current-location-latitude-longitude-country-android-android-studio.html
    EditText name, email_address, phone, description;
    LocationManager locationManager;
    Button submit, get_loc;
    TextView display, display_loc;
    String total="";

    ImageView imageView;
    String temp1, temp2, temp3, temp4;
    double latitude ;
    double longitude;
    String value;
    DatabaseReference database = FirebaseDatabase.getInstance().getReference("People");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Raise Issue");

        name = (EditText) findViewById(R.id.et1);
        email_address = (EditText) findViewById(R.id.et2);
        phone = (EditText) findViewById(R.id.et3);
        description = (EditText) findViewById(R.id.et4);
        imageView= (ImageView) findViewById(R.id.iv1);
        submit = (Button) findViewById(R.id.btn1);


        value = getIntent().getExtras().getString("Money");


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //total = "";
                //total+="Name : "+name.getText().toString()+"\nEmail address : "+email_address.getText().toString();
                //total+="\nPhone Number : "+phone.getText().toString()+"\nDescription : "+description.getText().toString();
                //display.setText(total);
                getLocation();
                /***/


            }
        });

        if (ContextCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION, android.Manifest.permission.ACCESS_COARSE_LOCATION}, 101);

        }
    }
    void getLocation() {
        try {
            locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 5000, 5, this);
        }
        catch(SecurityException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void onLocationChanged(Location location) {
        latitude = location.getLatitude();
        longitude = location.getLongitude();
        //display_loc.setText("Latitude: " + location.getLatitude() + "\n Longitude: " + location.getLongitude());

        try {

            //Geocoder geocoder = new Geocoder(this, Locale.getDefault());
            //List<Address> addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
            //display_loc.setText(display_loc.getText() + "\n"+addresses.get(0).getAddressLine(0)+", "+
                    //addresses.get(0).getAddressLine(1)+", "+addresses.get(0).getAddressLine(2));
            //String temp = display_loc.getText().toString();
            //temp = temp.replaceAll(", null","");
            //display_loc.setText(temp);
            //while(temp!="Before getting location"){
            temp1=name.getText().toString();
            if(temp1.length()==0){
                temp1 = "No name";
            }
            temp2=email_address.getText().toString();
            temp3=phone.getText().toString();
            temp4=description.getText().toString();
            //Toast.makeText(Main2Activity.this,"Here", Toast.LENGTH_SHORT).show();
            User user = new User(temp1, temp2, temp3, temp4, latitude, longitude);
            DatabaseReference myRef = database.child(temp1);
            myRef.setValue(user);
            //Toast.makeText(Main2Activity.this,"there", Toast.LENGTH_SHORT).show();

            //}
        }catch(Exception e)
        {

        }


        //long sec=3000;
        //wait(sec);


        Intent intent1 = new Intent(Main2Activity.this, Main5Activity.class);
        String t = Double.toString(latitude)+"\n"+Double.toString(longitude);
        intent1.putExtra("Point",t);

        startActivity(intent1);

        Intent intent11 = new Intent(Main2Activity.this, Main6Activity.class);
        intent11.putExtra("Money",value);
        startActivity(intent11);


        finish();

    }

    @Override
    public void onProviderDisabled(String provider) {
        Toast.makeText(Main2Activity.this, "Please Enable GPS and Internet", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }




}

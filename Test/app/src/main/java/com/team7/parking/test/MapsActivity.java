package com.team7.parking.test;

import android.content.Intent;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.Scanner;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        final String value = getIntent().getExtras().getString("Point");
        // Add a marker in Sydney and move the camera
        Scanner scanner = new Scanner(value);
        double latitude = scanner.nextDouble();
        double longitude = scanner.nextDouble();
        LatLng India = new LatLng(latitude, longitude);
        Toast.makeText(this,"An issue has been raised at the marked location",Toast.LENGTH_SHORT).show();
        mMap.addMarker(new MarkerOptions().position(India).title("Marker in India"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(India,20.2f));
//        new Handler().postDelayed(new Runnable()
//        {
//            @Override
//            public void run()
//            {
//                Toast.makeText(MapsActivity.this,"An issue has been raised at the above location",Toast.LENGTH_SHORT).show();
//                finish();
//            }
//        }, 10000);
    }
    @Override
    public void onBackPressed(){
        //Intent a = new Intent(Intent.ACTION_MAIN);
        //a.addCategory(Intent.CATEGORY_HOME);
        //a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        startActivity(a);
        finish();
    }
}

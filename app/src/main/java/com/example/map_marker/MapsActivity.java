package com.example.map_marker;

import android.graphics.Color;
import android.os.Bundle;



import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;

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
     *
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        //mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        LatLng sydney1 = new LatLng(-34.01, 151.02);
        LatLng sydney2 = new LatLng(-34.03, 151.05);
        mMap.addMarker(new MarkerOptions()
                .position(sydney)
                .title("Marker in Sydney"));/*.snippet("here where i live").icon(BitmapDescriptorFactory.fromResource(R.drawable.warning)));
         */  mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney,14));
         mMap.addCircle(new CircleOptions().center(sydney)
                 .radius(200)
                 .strokeColor(Color.RED)
                 .fillColor(Color.BLUE));
         mMap.addPolyline(new PolylineOptions()
                 .add(sydney,sydney1)
                 .width(25)
                 .color(Color.BLUE)
                 .geodesic(true));
         mMap.addPolygon(new PolygonOptions()
         .add(sydney,sydney1,sydney2));

         mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
             @Override
             public void onMapClick(LatLng latLng) {
                 mMap.addMarker(new MarkerOptions()
                         .position(latLng)
                         .title("add by click"));
             }
         });
    }
}

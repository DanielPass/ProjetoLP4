package com.steplab.projetolpiv.projetolpiv;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by daniel on 4/12/2017.
 */

public class MapsFragment extends SupportMapFragment implements OnMapReadyCallback {
    private GoogleMap mMap;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        CameraUpdate zoom  = CameraUpdateFactory.zoomTo(12);

        LatLng cardinal = new LatLng(-16.6554902, -49.2385342);

        mMap.addMarker(new MarkerOptions()
                            .position(cardinal)
                            .title("Goiânia"));

        mMap.moveCamera(CameraUpdateFactory.newLatLng(cardinal));
        mMap.animateCamera(zoom);
    }


}

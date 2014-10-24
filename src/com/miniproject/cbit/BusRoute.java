package com.miniproject.cbit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class BusRoute extends FragmentActivity {
  static final LatLng HYDERABAD = new LatLng(17.3660, 78.4760);
  private GoogleMap mMap;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_bus_route);
    
    Intent b = getIntent();
    String route = (b.getStringExtra(MainActivity.ROUTE_NUMBER));
    setUpMapIfNeeded();
    
  }

  private void setUpMapIfNeeded() {
      if (mMap != null) {
          return;
      }
      mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map)).getMap();
      if (mMap == null) {
          return;
      }
      // Initialize map options. For example:
      // mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
      Marker hyderabad = mMap.addMarker(new MarkerOptions().position(HYDERABAD)
    	        .title("Hyderabad"));
   // Move the camera instantly to hyderabad with a zoom of 15.
      mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(HYDERABAD, 15));

      // Zoom in, animating the camera.
      mMap.animateCamera(CameraUpdateFactory.zoomTo(10), 2000, null);
  }

} 
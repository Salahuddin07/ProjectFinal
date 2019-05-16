package com.example.salahuddin.humansafety;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

import static android.Manifest.permission.ACCESS_FINE_LOCATION;

public class Location extends AppCompatActivity {

    private FusedLocationProviderClient client;
    Geocoder geocoder;
    List<Address> addresses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        geocoder = new Geocoder(this, Locale.getDefault());

        requestPermission();
        client = LocationServices.getFusedLocationProviderClient(this);

                if (ActivityCompat.checkSelfPermission(Location.this, ACCESS_FINE_LOCATION)
                        != PackageManager.PERMISSION_GRANTED) {

                    return;
                }
                client.getLastLocation().addOnSuccessListener(new OnSuccessListener<android.location.Location>() {
                    @Override
                    public void onSuccess(android.location.Location location) {

                        if (location != null){

                            double latitude = location.getLatitude();
                            double longitude = location.getLongitude();
                            // Toast.makeText(getApplicationContext(),"Latitude"+latitude+"\n"+"Longitude"+longitude,Toast.LENGTH_LONG).show();

                            try {
                                addresses = geocoder.getFromLocation(latitude,longitude,1);

                                String address = addresses.get(0).getAddressLine(0);
                                // String area = addresses.get(0).getLocality();
                                // String city = addresses.get(0).getSubAdminArea();
                                //String country = addresses.get(0).getCountryName();
                                //String postalCode = addresses.get(0).getPostalCode();

                                String fullAddress = address;

                                Intent intent = new Intent(getApplicationContext(),MyBroadCastReceiver.class);
                                intent.putExtra("location",fullAddress);
                                startActivity(intent);

                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
    }

    private void requestPermission(){
        ActivityCompat.requestPermissions(this,new String[]{ACCESS_FINE_LOCATION},1);
    }
}

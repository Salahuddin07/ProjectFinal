package com.example.salahuddin.humansafety;

import android.Manifest;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.telephony.SmsManager;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import static android.Manifest.permission.ACCESS_FINE_LOCATION;
import static android.content.Context.MODE_PRIVATE;
import static com.example.salahuddin.humansafety.Constant.MY_PREFS_NAME;

public class MyBroadCastReceiver extends BroadcastReceiver {
    private String guardianPhone = "";
    int countOFF = 0;
    int countON = 0;
    private Activity activity = null;
    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS = 1;

    private FusedLocationProviderClient client;
    Geocoder geocoder;
    List<Address> addresses;
    private String fullAddress = "";
    private String TAG = "MyBroadCastReceiver";
    DatabaseHelper databaseHelper;
    private int mpressingcount = 0;
    private static final int TIME_INTERVAL = 1000;

    public MyBroadCastReceiver(MainActivity2 activity) {

        this.activity = activity;
    }

    @Override
    public void onReceive(Context context, Intent intent) {

//        if (intent.getAction().equals(Intent.ACTION_SCREEN_OFF)) {
//
//           // countOFF++;
//            //mpressingcount++;
//           //Log.e(TAG, "press: " + mpressingcount);
//        } else
        if (intent.getAction().equals(Intent.ACTION_SCREEN_ON)) {

            //countON++;
            mpressingcount++;
            Log.e(TAG, "press: " + mpressingcount);

            if (mpressingcount == 2) {
                sendSMSMessage();
                vibrateDevice(context);
            }
        } else if(intent.getAction().equals(Intent.ACTION_USER_PRESENT)){
//            countON = 0;
//            countOFF = 0;
//            Log.e(TAG, "countOff: " + countOFF);
            mpressingcount = 0;
            Log.e(TAG, "presentScreen: " + mpressingcount);
        }
    }

    private void vibrateDevice(Context context) {

        Vibrator v = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
// Vibrate for 500 milliseconds
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            v.vibrate(VibrationEffect.createOneShot(500, VibrationEffect.DEFAULT_AMPLITUDE));
        } else {
            //deprecated in API 26
            v.vibrate(500);
        }
    }

    protected void sendSMSMessage() {
        ///check if the permission is not granted
        if (ContextCompat.checkSelfPermission(activity,
                                              Manifest.permission.SEND_SMS)
                != PackageManager.PERMISSION_GRANTED) {

            ///if permission has not been granted then check if the user denied the permission
            if (ActivityCompat.shouldShowRequestPermissionRationale(activity,
                                                                    Manifest.permission.SEND_SMS)) {
                ///do nothing
            } else {
                //// Asking for requesting permission
                ActivityCompat.requestPermissions(activity,
                                                  new String[]{Manifest.permission.SEND_SMS},
                                                  MY_PERMISSIONS_REQUEST_SEND_SMS);
            }
        } else {

            geocoder = new Geocoder(activity.getApplicationContext(), Locale.getDefault());
            //requestPermission();

            client = LocationServices.getFusedLocationProviderClient(activity.getApplicationContext());
            if (ActivityCompat.checkSelfPermission(activity.getApplicationContext(), ACCESS_FINE_LOCATION)
                    != PackageManager.PERMISSION_GRANTED) {

                return;
            }
            client.getLastLocation().addOnSuccessListener(new OnSuccessListener<Location>() {
                @Override
                public void onSuccess(android.location.Location location) {

                    if (location != null) {

                        double latitude = location.getLatitude();
                        double longitude = location.getLongitude();
                        //Toast.makeText(activity.getApplicationContext(), "Latitude" + latitude + "\n" + "Longitude" + longitude, Toast.LENGTH_LONG).show();

                        try {
                            addresses = geocoder.getFromLocation(latitude, longitude, 1);

                            String address = addresses.get(0).getAddressLine(0);

                            SharedPreferences prefs = activity.getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
                            String userEmail = prefs.getString(Constant.EMAIL, "null");
                            Log.e(TAG, "MyBroadCastReceiver: email " + userEmail);


                            databaseHelper = new DatabaseHelper(activity);
                            SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();
                            String query = "select * from Guardian_info where Email=\"" + userEmail + "\"";
                            Cursor cursor = sqLiteDatabase.rawQuery(query, null);

                            cursor.moveToFirst();
                            guardianPhone = cursor.getString(3);
                            Thread.sleep(1000);

                            Toast.makeText(activity, guardianPhone, Toast.LENGTH_SHORT).show();
                            String message = "i am in danger and my location is: " + address+ " Please help me as soon as possible";
                            SmsManager smsManager = SmsManager.getDefault();
                            smsManager.sendTextMessage(guardianPhone, null, message, null, null);
                            Toast.makeText(activity, "SMS sent.", Toast.LENGTH_LONG).show();
                            fullAddress = address;
                            mpressingcount = 0;

                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        Toast.makeText(activity.getApplicationContext(), "location is not null", Toast.LENGTH_SHORT).show();
                    }
                }
            });

                mpressingcount = 0;
//            countOFF = 0;
//            countON = 0;
        }

    }


    //// after getting the result of permission the result will pass through this method
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {

        /// check the request code
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_SEND_SMS: { ///// if the request code is MY_PERMISSIONS_REQUEST_SEND_SMS
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {


                    String phoneNo = "019999999999";
                    Toast.makeText(activity, phoneNo, Toast.LENGTH_SHORT).show();
                    String message = "i am in danger and my location is: " + fullAddress;
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(phoneNo, null, message, null, null);
                    Toast.makeText(activity, "SMS sent.",
                                   Toast.LENGTH_LONG).show();

//                    countOFF = 0;
//                    countON = 0;

                    mpressingcount = 0;

                } else {
                    Toast.makeText(activity,
                                   "SMS faild, please try again.", Toast.LENGTH_LONG).show();
                }


            }

        }
    }

    public MyBroadCastReceiver() {
    }
}



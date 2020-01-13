package com.techoutsource.mparking.locationclass;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;

import androidx.core.app.ActivityCompat;

import android.widget.Toast;

public class TurnLocationOn {
    //  CHECK FOR LOCATION PERMISSION
    public static boolean checkPermission(Activity activity) {
        int result = ActivityCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_FINE_LOCATION);
        if (result == PackageManager.PERMISSION_GRANTED) {

            return true;

        } else {

            return false;

        }
    }

    //REQUEST FOR PERMISSSION
    public static boolean requestPermission(final Activity activity, final int code) {

        if (ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.ACCESS_FINE_LOCATION)) {
            Toast.makeText(activity, "GPS permission allows us to access location data. so that we can display information close to your current", Toast.LENGTH_LONG).show();
            ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, code);
            return false;
        } else {

            ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, code);
            return true;
        }
    }
}

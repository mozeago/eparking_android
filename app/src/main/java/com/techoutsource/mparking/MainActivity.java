package com.techoutsource.mparking;

import android.content.DialogInterface;
import android.content.Intent;
import android.location.LocationManager;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.techoutsource.mparking.locationclass.TurnLocationOn;

public class MainActivity extends AppCompatActivity {
    Button button_turn_location_on;
    LocationManager locationManager;
    Intent dashboard_intent;
    boolean locationStatus;
    public final static int REQUEST_LOCATION_ACCESS_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_main);
        button_turn_location_on = (Button) findViewById(R.id.button_turn_location_on);
        button_turn_location_on.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TurnLocationOn.checkPermission(MainActivity.this)) {
                    Toast.makeText(MainActivity.this, "Location Not Turned on", Toast.LENGTH_SHORT).show();
                    if (TurnLocationOn.requestPermission(MainActivity.this, REQUEST_LOCATION_ACCESS_CODE)) {
                        dashboard_intent = new Intent(getApplicationContext(), DashboardActivity.class);
                        startActivity(dashboard_intent);
                    }

                } else {
                    Toast.makeText(MainActivity.this, "Location already Turned On", Toast.LENGTH_SHORT).show();
                    dashboard_intent = new Intent(getApplicationContext(), DashboardActivity.class);
                    startActivity(dashboard_intent);
                }
            }
        });
    }
}

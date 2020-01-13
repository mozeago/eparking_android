package com.techoutsource.mparking;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.techoutsource.mparking.model.BreakdownServicesModel;
import com.techoutsource.mparking.model.ParkingFees;

public class BreakdownServicesActivity extends AppCompatActivity {
    Button call_breakdown_services;
    EditText vehicle_numberplate, mobile_number, exact_location_name;
    Spinner location_radius;
    Spinner vehicle_type;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breakdown_services);
        BreakdownServicesActivity.this.setTitle("Call Breakdown Services");
        vehicle_numberplate = (EditText) findViewById(R.id.input_breakdown_vehicle_number_plate);
        mobile_number = (EditText) findViewById(R.id.input_vehicle_breakdown_contact_number);
        location_radius = (Spinner) findViewById(R.id.spinner_breakdown_location_radius);
        exact_location_name = (EditText) findViewById(R.id.input_breakdown_exact_location);
        vehicle_type = (Spinner) findViewById(R.id.spinner_breakdown_vehicle_type);
        call_breakdown_services = (Button) findViewById(R.id.btn_call_breakdown);
        databaseReference = FirebaseDatabase.getInstance().getReference("breakdown_calls");
        call_breakdown_services.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (callBreakdownServices()) {
                    Toast.makeText(BreakdownServicesActivity.this, " Wait service team will call you shortly", Toast.LENGTH_SHORT).show();
                } else {

                }
            }
        });
    }

    private boolean callBreakdownServices() {
        String mobilenumber = mobile_number.getText().toString().trim();
        String vehiclenumberplate = vehicle_numberplate.getText().toString().trim();
        String locationradius = location_radius.getSelectedItem().toString().trim();
        String exactlocationname = exact_location_name.getText().toString().trim();
        String vehicletype = vehicle_type.getSelectedItem().toString().trim();
        String _id = databaseReference.push().getKey();
        BreakdownServicesModel breakdownServicesModel = new BreakdownServicesModel(_id,
                vehiclenumberplate,locationradius,exactlocationname,mobilenumber,vehicletype
                );
        databaseReference.child(_id).setValue(breakdownServicesModel);
        return true;
    }
}

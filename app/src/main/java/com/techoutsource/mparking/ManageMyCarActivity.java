package com.techoutsource.mparking;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.techoutsource.mparking.model.VehicleData;

public class ManageMyCarActivity extends AppCompatActivity implements View.OnClickListener {
    Button save_vehicle_info;
    EditText vehicle_number_plate;
    Spinner vehicle_type;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_my_car);
        ManageMyCarActivity.this.setTitle("Manage My Car");
        save_vehicle_info = (Button) findViewById(R.id.btn_add_vehicle);
        vehicle_number_plate = (EditText) findViewById(R.id.input_vehicle_number_plate);
        vehicle_type = (Spinner) findViewById(R.id.spinner_vehicle_types);
        save_vehicle_info.setOnClickListener(this);
        databaseReference = FirebaseDatabase.getInstance().getReference("eparking_mombasa_vehicles");
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        if (addVehicle()) {
            Toast.makeText(this, "Vehicle Data Saved ! ", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean addVehicle() {
        String number_plate = vehicle_number_plate.getText().toString().trim();
        String vehicletype = vehicle_type.getSelectedItem().toString().trim();
        String _id = databaseReference.push().getKey();
        VehicleData vehicleData = new VehicleData(_id, number_plate, vehicletype);
        databaseReference.child(_id).setValue(vehicleData);
        return true;
    }
}

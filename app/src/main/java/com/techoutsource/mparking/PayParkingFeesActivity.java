package com.techoutsource.mparking;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.techoutsource.mparking.model.ParkingFees;

public class PayParkingFeesActivity extends AppCompatActivity {
    Button payparkingfees;
    EditText vehicle_numberplate, mpesa_number_to_pay_with;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_parking_fees);
        PayParkingFeesActivity.this.setTitle("Pay Parking Fees");
        vehicle_numberplate = (EditText) findViewById(R.id.input_vehicle_number_plate);
        mpesa_number_to_pay_with = (EditText) findViewById(R.id.input_phone_number_for_mpesa);
        payparkingfees = (Button) findViewById(R.id.btn_pay_parkingfees);
        databaseReference = FirebaseDatabase.getInstance().getReference("parkingfees");
        payparkingfees.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (insertToFirebase()) {
                    Toast.makeText(PayParkingFeesActivity.this, " Data Added Successfully", Toast.LENGTH_SHORT).show();
                } else {

                }
            }
        });
    }

    private boolean insertToFirebase() {
        String mpesa_number = mpesa_number_to_pay_with.getText().toString().trim();
        String vehicle_number_plate = vehicle_numberplate.getText().toString().trim();
        String _id = databaseReference.push().getKey();
        ParkingFees parkingFees = new ParkingFees(_id, mpesa_number, vehicle_number_plate);
        databaseReference.child(_id).setValue(parkingFees);
        return true;
    }
}

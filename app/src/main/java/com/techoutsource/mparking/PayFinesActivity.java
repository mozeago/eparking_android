package com.techoutsource.mparking;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.techoutsource.mparking.model.PayCountyFines;

public class PayFinesActivity extends AppCompatActivity {
    Button pay_fines_button;
    EditText offence_number, mpesa_number, vehicle_number_plate;
    DatabaseReference databaseReference;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PayFinesActivity.this.setTitle("Pay County Fines");
        setContentView(R.layout.activity_pay_fines);
        pay_fines_button = (Button) findViewById(R.id.btn_payfine);
        offence_number = (EditText) findViewById(R.id.input_OB_number);
        mpesa_number = (EditText) findViewById(R.id.input_phone_number_for_mpesa);
        vehicle_number_plate = (EditText) findViewById(R.id.input_vehicle_number_plate);
        databaseReference = FirebaseDatabase.getInstance().getReference("county_fines");
        pay_fines_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (payCountyFines()){

                }
            }
        });
    }

    private boolean payCountyFines() {
        String mpesa_number_paying = mpesa_number.getText().toString();
        String vehicle_number = vehicle_number_plate.getText().toString();
        String offencenumber = offence_number.getText().toString();

        String _id = databaseReference.push().getKey();
        PayCountyFines vehicleData = new PayCountyFines(_id, mpesa_number_paying, vehicle_number, offencenumber);
        databaseReference.child(_id).setValue(vehicleData);
        return true;
    }
}

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
import com.techoutsource.mparking.model.ReportAccidentModel;

import org.w3c.dom.Text;

public class ReportAccidentActivity extends AppCompatActivity {
    Button btn_report_accident;
    EditText accident_cause, vehicle_number_plate_1, vehicle_number_plate_2, accident_exact_location_name, accident_reporter;
    Spinner spinner_accident_location_radius;
    DatabaseReference databaseReference;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_accident);
        ReportAccidentActivity.this.setTitle("Report Accident");
        vehicle_number_plate_1 = (EditText) findViewById(R.id.input_vehicle_number_plate_1);
        vehicle_number_plate_2 = (EditText) findViewById(R.id.input_vehicle_number_plate_2);
        accident_exact_location_name = (EditText) findViewById(R.id.input_acccident_exact_location_name);
        spinner_accident_location_radius = (Spinner) findViewById(R.id.spinner_accident_location_radius);
        accident_cause = (EditText) findViewById(R.id.input_acccident_cause);
        accident_reporter = (EditText) findViewById(R.id.input_acccident_reporter_name);
        btn_report_accident = (Button) findViewById(R.id.btn_report_accident);
        databaseReference = FirebaseDatabase.getInstance().getReference("mombasa_reported_accidents");
        btn_report_accident.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (reportAccident()) {
                    Toast.makeText(ReportAccidentActivity.this, "Accident Reported to Traffic Unit", Toast.LENGTH_SHORT).
                            show();
                }
            }
        });
    }

    private boolean reportAccident() {
        String _id = databaseReference.push().getKey();
        String number_plate_1 = vehicle_number_plate_1.getText().toString().trim();
        String number_plate_2 = vehicle_number_plate_2.getText().toString().trim();
        String accident_location_radius_name = spinner_accident_location_radius.getSelectedItem().toString().trim();
        String exact_location_name = accident_exact_location_name.getText().toString().trim();
        String reporter_name = accident_reporter.getText().toString().trim();
        String accident_caused_by = accident_cause.getText().toString().trim();
        ReportAccidentModel reportAccidentModel = new ReportAccidentModel(
                _id, number_plate_1, number_plate_2, accident_location_radius_name,
                exact_location_name, reporter_name, accident_caused_by);
        databaseReference.child(_id).setValue(reportAccidentModel);
        return true;
    }
}

package com.techoutsource.mparking;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.techoutsource.mparking.model.ReportTrafficJam;

public class ReportTrafficJamActivity extends AppCompatActivity {
    Button btn_report_traffic_jam;
    EditText traffic_jam_location_name, traffic_jam_cause;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ReportTrafficJamActivity.this.setTitle("Report Traffic Jam");
        setContentView(R.layout.activity_report_traffic_jam);
        btn_report_traffic_jam = (Button) findViewById(R.id.btn_report_traffic_jam);
        traffic_jam_location_name = (EditText) findViewById(R.id.input_traffic_jam_loction_name);
        traffic_jam_cause = (EditText) findViewById(R.id.input_traffic_jam_cause);
        databaseReference = FirebaseDatabase.getInstance().getReference("reported_traffic_jam");
        btn_report_traffic_jam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (insertToFirebase()) {
                    Toast.makeText(ReportTrafficJamActivity.this, " Jam reported to traffic unit", Toast.LENGTH_SHORT).show();
                } else {

                }
            }
        });
    }

    private boolean insertToFirebase() {
        String jamlocationname = traffic_jam_location_name.getText().toString().trim();
        String jamcause = traffic_jam_cause.getText().toString().trim();
        String _id = databaseReference.push().getKey();
        ReportTrafficJam reported_jam = new ReportTrafficJam(_id, jamlocationname, jamcause);
        databaseReference.child(_id).setValue(reported_jam);
        return true;
    }
}

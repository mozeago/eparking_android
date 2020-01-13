package com.techoutsource.mparking;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ReportTrafficJamActivity extends AppCompatActivity {
    Button btn_report_traffic_jam;
    EditText traffic_jam_location_name, traffic_jam_cause;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ReportTrafficJamActivity.this.setTitle("Report Traffic Jam");
        setContentView(R.layout.activity_report_traffic_jam);
        btn_report_traffic_jam = (Button) findViewById(R.id.btn_report_traffic_jam);
        btn_report_traffic_jam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                traffic_jam_location_name = (EditText) findViewById(R.id.input_traffic_jam_loction_name);
                traffic_jam_cause = (EditText) findViewById(R.id.input_traffic_jam_cause);
                String traffic_jam_location = traffic_jam_location_name.getText().toString();
                String jam_cause = traffic_jam_cause.getText().toString();
                Toast.makeText(ReportTrafficJamActivity.this, traffic_jam_location + " " + jam_cause, Toast.LENGTH_SHORT).show();
            }
        });
    }
}

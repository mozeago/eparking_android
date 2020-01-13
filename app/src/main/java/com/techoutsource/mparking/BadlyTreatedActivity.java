package com.techoutsource.mparking;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BadlyTreatedActivity extends AppCompatActivity {
    EditText mistreated_by, mistreat_desc;
    Button btnbadlytreated;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_badly_treated);
        mistreated_by = (EditText) findViewById(R.id.input_who_mistreated);
        mistreat_desc = (EditText) findViewById(R.id.input_mistreat_description);
        final String who_mistreated = mistreated_by.getText().toString();
        final String mistreat_description = mistreat_desc.getText().toString();
        btnbadlytreated.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(BadlyTreatedActivity.this, who_mistreated + " " + mistreat_description, Toast.LENGTH_SHORT).show();
            }
        });

    }
}

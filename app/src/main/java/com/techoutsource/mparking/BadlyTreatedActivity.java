package com.techoutsource.mparking;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.techoutsource.mparking.model.BadlyTreated;

public class BadlyTreatedActivity extends AppCompatActivity {
    EditText mistreated_by, mistreat_desc;
    Button btnbadlytreated;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_badly_treated);
        databaseReference = FirebaseDatabase.getInstance().getReference("mistreated");
        mistreated_by = (EditText) findViewById(R.id.input_who_mistreated);
        mistreat_desc = (EditText) findViewById(R.id.input_mistreat_description);
        btnbadlytreated = (Button) findViewById(R.id.report_mistreat);
        btnbadlytreated.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (reportMistreat()) {
                    Toast.makeText(BadlyTreatedActivity.this, " Thank you, we have received the complain and we will follow up on it ", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean reportMistreat() {
        String who_mistreated = mistreated_by.getText().toString().trim();
        String mistreat_description = mistreat_desc.getText().toString().trim();
        String _id = databaseReference.push().getKey();
        BadlyTreated badlyTreated = new BadlyTreated(_id,
                who_mistreated, mistreat_description
        );
        databaseReference.child(_id).setValue(badlyTreated);
        return true;
    }
}

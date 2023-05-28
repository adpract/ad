package com.example.stregistration;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RegistrationResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_result);

        TextView resultTextView = findViewById(R.id.resultTextView);

        Intent intent = getIntent();
        if (intent != null) {
            String subject = intent.getStringExtra("subject");
            String gender = intent.getStringExtra("gender");
            boolean hasQualification = intent.getBooleanExtra("hasQualification", false);

            String result = "Subject: " + subject +
                    "\nGender: " + gender +
                    "\nHas Qualification: " + (hasQualification ? "Yes" : "No");

            resultTextView.setText(result);
        }
    }
}

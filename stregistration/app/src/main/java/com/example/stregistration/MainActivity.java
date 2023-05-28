package com.example.stregistration;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Spinner subjectSpinner;
    private RadioGroup genderRadioGroup;
    private CheckBox qualificationCheckBox;
    private Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        subjectSpinner = findViewById(R.id.subjectSpinner);
        genderRadioGroup = findViewById(R.id.genderRadioGroup);
        qualificationCheckBox = findViewById(R.id.qualificationCheckBox);
        registerButton = findViewById(R.id.registerButton);

        // Setup subject spinner
        ArrayAdapter<CharSequence> subjectAdapter = ArrayAdapter.createFromResource(this, R.array.subjects, android.R.layout.simple_spinner_item);
        subjectAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        subjectSpinner.setAdapter(subjectAdapter);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get selected data
                String subject = subjectSpinner.getSelectedItem().toString();
                String gender = getSelectedGender();
                boolean hasQualification = qualificationCheckBox.isChecked();

                // Start RegistrationResultActivity and pass the data
                Intent intent = new Intent(MainActivity.this, RegistrationResultActivity.class);
                intent.putExtra("subject", subject);
                intent.putExtra("gender", gender);
                intent.putExtra("hasQualification", hasQualification);
                startActivity(intent);
            }
        });
    }

    private String getSelectedGender() {
        int selectedId = genderRadioGroup.getCheckedRadioButtonId();
        RadioButton radioButton = findViewById(selectedId);
        if (radioButton != null) {
            return radioButton.getText().toString();
        }
        return "";
    }
}

package com.example.railwayticketregistration;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Spinner spinnerBerthChoice;
    private RadioGroup radioGroupDestination;
    private CheckBox checkboxVeg, checkboxNonVeg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerBerthChoice = findViewById(R.id.spinner_berth_choice);
        radioGroupDestination = findViewById(R.id.radio_group_destination);
        checkboxVeg = findViewById(R.id.checkbox_veg);
        checkboxNonVeg = findViewById(R.id.checkbox_non_veg);

        Button buttonRegister = findViewById(R.id.button_register);
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String berthChoice = spinnerBerthChoice.getSelectedItem().toString();
                int selectedDestinationId = radioGroupDestination.getCheckedRadioButtonId();
                RadioButton selectedDestination = findViewById(selectedDestinationId);
                String destinationCity = selectedDestination.getText().toString();
                boolean isVeg = checkboxVeg.isChecked();
                boolean isNonVeg = checkboxNonVeg.isChecked();

                Intent intent = new Intent(MainActivity.this, DisplayActivity.class);
                intent.putExtra("berth_choice", berthChoice);
                intent.putExtra("destination_city", destinationCity);
                intent.putExtra("is_veg", isVeg);
                intent.putExtra("is_non_veg", isNonVeg);
                startActivity(intent);
            }
        });
    }
}

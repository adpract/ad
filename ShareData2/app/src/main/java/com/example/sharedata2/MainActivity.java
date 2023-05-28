package com.example.sharedata2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private EditText editText;
    private EditText nameEditText;
    private EditText ageEditText;

    private EditText phoneEditText;

    private EditText cityEditText;

    private SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        editText = findViewById(R.id.editText);
        nameEditText = findViewById(R.id.name_edittext);
        ageEditText = findViewById(R.id.age_edittext);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = editText.getText().toString();
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("message", message);
                startActivity(intent);
            }
        });

    }

    public void shareData(View view) {
        // Get the values from the EditText views
        String name = nameEditText.getText().toString();
        int age = Integer.parseInt(ageEditText.getText().toString());

        // Create a new Bundle to hold the data
        Bundle bundle = new Bundle();

        // Put the name and age values into the Bundle
        bundle.putString("name", name);
        bundle.putInt("age", age);

        // Create a new Intent to start the second activity
        Intent intent = new Intent(this, SecondActivity.class);

        // Set the Bundle as the extra data for the Intent
        intent.putExtras(bundle);

        // Start the second activity
        startActivity(intent);
    }
}
package com.example.sharedata2;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    private TextView textView;
    private TextView nameTextView;
    private TextView ageTextView;

    private TextView phoneTextView;
    private TextView cityTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Get references to the TextView views

        textView = findViewById(R.id.textView);
        // Get references to the TextView views
        nameTextView = findViewById(R.id.name_textview);
        ageTextView = findViewById(R.id.age_textview);

        // Get the Bundle from the Intent
        Bundle bundle = getIntent().getExtras();

        String message = getIntent().getStringExtra("message");
        textView.setText(message);
        String name = bundle.getString("name");
        int age = bundle.getInt("age");

        // Display the name and age values in the TextView views
        nameTextView.setText("Name: " + name);
        ageTextView.setText("Age: " + age);
    }
}
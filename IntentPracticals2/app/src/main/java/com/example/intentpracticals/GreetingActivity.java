package com.example.intentpracticals;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class GreetingActivity extends AppCompatActivity {
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greeting);

        // Get the name from the intent
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");

        // Display the greeting message
        TextView textViewGreeting = findViewById(R.id.text_greeting);
        textViewGreeting.setText("Hello, " + name + "!");

        // Create an explicit intent to launch FarewellActivity
        b1 = findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Create an explicit intent to launch farewell activity
                Intent intent = new Intent(GreetingActivity.this, FarewellActivity.class);
                startActivity(intent);

            }
        });
    }
}
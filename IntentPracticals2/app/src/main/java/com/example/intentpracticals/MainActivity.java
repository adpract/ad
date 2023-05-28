package com.example.intentpracticals;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSubmit = findViewById(R.id.btn_submit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the entered name
               EditText editTextName = findViewById(R.id.editTextName);
                String name = editTextName.getText().toString();

                // Create an explicit intent to launch GreetingActivity
                Intent intent = new Intent(MainActivity.this, GreetingActivity.class);
                // Pass the name to GreetingActivity
                intent.putExtra("name", name);
                startActivity(intent);
            }
        });
    }
}
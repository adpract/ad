package com.example.share3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Activity2 extends AppCompatActivity {

    private TextView dataTextView;
    private Button openActivityButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        dataTextView = findViewById(R.id.dataTextView);
        openActivityButton = findViewById(R.id.openActivityButton);

        String data = getIntent().getStringExtra("data");
        dataTextView.setText(data);

        openActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity3(data);
            }
        });
    }

    private void openActivity3(String data) {
        Intent intent = new Intent(this, Activity3.class);
        intent.putExtra("data", data);
        startActivity(intent);
    }
}

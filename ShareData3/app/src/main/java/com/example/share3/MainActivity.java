package com.example.share3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText dataEditText;
    private Button openActivityButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataEditText = findViewById(R.id.dataEditText);
        openActivityButton = findViewById(R.id.openActivityButton);

        openActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = dataEditText.getText().toString();
                openActivity2(data);
            }
        });
    }

    private void openActivity2(String data) {
        Intent intent = new Intent(this, Activity2.class);
        intent.putExtra("data", data);
        startActivity(intent);
    }
}

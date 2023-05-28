package com.example.practical_15_tourregistration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ShowDetails extends AppCompatActivity {
    TextView name,phoneno,tourtype,Package,location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_details);

        init();

        Intent intent=getIntent();
        name.setText(intent.getStringExtra("name"));
        phoneno.setText(intent.getStringExtra("phoneno"));
        tourtype.setText(intent.getStringExtra("tourtype"));
        Package.setText(intent.getStringExtra("package"));
        location.setText(intent.getStringExtra("location"));

    }
    public void init(){
        name=findViewById(R.id.name);
        phoneno=findViewById(R.id.phoneNo);
        tourtype=findViewById(R.id.tourtype);
        Package=findViewById(R.id.Package);
        location=findViewById(R.id.location);
    }
}
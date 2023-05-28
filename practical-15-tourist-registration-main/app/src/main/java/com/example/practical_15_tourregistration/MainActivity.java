package com.example.practical_15_tourregistration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioGroup packages;
    EditText name,phoneNo;
    Spinner tourTypes;
    CheckBox pune,lonavala,kokan;
    Button register;
    String tourType,Package,location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        tourTypes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    Toast.makeText(MainActivity.this, "Select valid option", Toast.LENGTH_SHORT).show();
                }
                else{
                     tourType=parent.getItemAtPosition(position).toString();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        packages.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.basic:
                        Package="Basic";
                        break;
                    case R.id.perks:
                        Package="Basic+perks";
                        break;
                    case R.id.sports:
                        Package="Basic+perks+sports";
                        break;

                }
            }
        });
        pune.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    location="Pune";
                }
            }
        });
        lonavala.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                location=location+","+"Lonavala";
            }
        });
        kokan.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                location=location+","+"kokan";
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,ShowDetails.class);
                intent.putExtra("name",name.getText().toString());
                intent.putExtra("phoneno",phoneNo.getText().toString());
                intent.putExtra("tourtype",tourType);
                intent.putExtra("package",Package);
                intent.putExtra("location",location);
                startActivity(intent);

            }
        });

    }
    public void init(){
        packages=findViewById(R.id.tourtype);
        name=findViewById(R.id.name);
        phoneNo=findViewById(R.id.phoneno);
        tourTypes=findViewById(R.id.tourTypes);
        pune=findViewById(R.id.pune);
        lonavala=findViewById(R.id.lonavala);
        kokan=findViewById(R.id.kokan);
        register=findViewById(R.id.register);
    }
}
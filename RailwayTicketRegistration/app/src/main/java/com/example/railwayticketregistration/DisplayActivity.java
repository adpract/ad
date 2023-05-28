package com.example.railwayticketregistration;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        TextView textViewBerthChoice = findViewById(R.id.text_berth_choice);
        TextView textViewDestinationCity = findViewById(R.id.text_destination_city);
        TextView textViewMealVariety = findViewById(R.id.text_meal_variety);

        Intent intent = getIntent();
        String berthChoice = intent.getStringExtra("berth_choice");
        String destinationCity = intent.getStringExtra("destination_city");
        boolean isVeg = intent.getBooleanExtra("is_veg", false);
        boolean isNonVeg = intent.getBooleanExtra("is_non_veg", false);

        textViewBerthChoice.setText("Berth Choice: " + berthChoice);
        textViewDestinationCity.setText("Destination City: " + destinationCity);

        StringBuilder mealVariety = new StringBuilder("Meal Variety: ");
        if (isVeg) {
            mealVariety.append("Vegetarian ");
        }
        if (isNonVeg) {
            mealVariety.append("Non-Vegetarian");
        }
        textViewMealVariety.setText(mealVariety.toString());
    }
}

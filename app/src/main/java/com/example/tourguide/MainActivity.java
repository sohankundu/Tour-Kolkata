package com.example.tourguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

        // Find the View that shows the heritage category
        TextView heritage = (TextView) findViewById(R.id.heritage);

        // Set a click listener on that View
        heritage.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the heritage category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link HeritageActivity}
                Intent heritageIntent = new Intent(MainActivity.this,
                        HeritageActivity.class);

                // Start the new activity
                startActivity(heritageIntent);
            }
        });

        // Find the View that shows the religious category
        TextView religious = (TextView) findViewById(R.id.religious);

        // Set a click listener on that View
        religious.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the religious category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link ReligiousActivity}
                Intent religiousIntent = new Intent(MainActivity.this,
                        ReligiousActivity.class);

                // Start the new activity
                startActivity(religiousIntent);
            }
        });

        // Find the View that shows the nature category
        TextView nature = (TextView) findViewById(R.id.nature);

        // Set a click listener on that View
        nature.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the nature category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link NatureActivity}
                Intent natureIntent = new Intent(MainActivity.this,
                        NatureActivity.class);

                // Start the new activity
                startActivity(natureIntent);
            }
        });

        // Find the View that shows the sports category
        TextView sports = (TextView) findViewById(R.id.sports);

        // Set a click listener on that View
        sports.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the sports category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link SportsActivity}
                Intent sportsIntent = new Intent(MainActivity.this,
                        SportsActivity.class);

                // Start the new activity
                startActivity(sportsIntent);
            }
        });

        // Find the View that shows the heritage category
        TextView others = (TextView) findViewById(R.id.others);

        // Set a click listener on that View
        others.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the others category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link OthersActivity}
                Intent othersIntent = new Intent(MainActivity.this,
                        OthersActivity.class);

                // Start the new activity
                startActivity(othersIntent);
            }
        });
    }
}
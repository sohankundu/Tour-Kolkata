package com.example.tourguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ReligiousActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spot_list);

        // Create a list of spots
        ArrayList<Spot> spots = new ArrayList<Spot>();

        spots.add(new Spot("Belur Math", getApplicationContext().getString(
                R.string.belur_math), R.drawable.belur_math));
        spots.add(new Spot("Dakshineswar Kali Temple", getApplicationContext().getString(
                R.string.dakshineswar), R.drawable.dakhineswar));
        spots.add(new Spot("St. Paul's Cathedral", getApplicationContext().getString(
                R.string.st_pauls_cathedral), R.drawable.st_pauls_cathedral));
        spots.add(new Spot("Birla Mandir", getApplicationContext().getString(
                R.string.birla_mandir), R.drawable.birla_mandir));
        spots.add(new Spot("Kalighat Temple", getApplicationContext().getString(
                R.string.kalighat_temple), R.drawable.kalighat));
        spots.add(new Spot("Nakhoda Masjid", getApplicationContext().getString(
                R.string.nakhoda_masjid), R.drawable.nakhoda_masjid));
        spots.add(new Spot("Jain Temple", getApplicationContext().getString(
                R.string.jain_temple), R.drawable.jain_temple));
        spots.add(new Spot("South Park Street Cemetery", getApplicationContext().getString(
                R.string.south_park_street_cemetery), R.drawable.south_park_street_cemetery));
        spots.add(new Spot("Buddhist Pagoda", getApplicationContext().getString(
                R.string.buddhist_pagoda), R.drawable.buddhist_pagoda));
        spots.add(new Spot("St. James Church", getApplicationContext().getString(
                R.string.st_james_church), R.drawable.st_james_church));
        spots.add(new Spot("St. John's Church", getApplicationContext().getString(
                R.string.st_johns_church), R.drawable.st_johns_church));

        // Create an {@link SpotAdapter}, whose data source is a list of {@link Spot}s. The
        // adapter knows how to create list items for each item in the list.
        SpotAdapter adapter = new SpotAdapter(this, spots, R.color.religious_color);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // spot_list.xml layout file.
        ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);

        //Set a click listener on each list item
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            // The code in this method will be executed when a list item is clicked on.
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Get the {@link Spot} object at the given position the user clicked on
                Spot spot = spots.get(position);
                // Get the name, description and the image resource ID of the clicked tourist spot
                String name = spot.getName();
                String description = spot.getDescription();
                int imageResourceId = spot.getImageResourceId();

                // Create a new intent to open the {@link SpotDetailActivity}
                Intent spotDetailIntent = new Intent(ReligiousActivity.this,
                        SpotDetailActivity.class);

                // Put the name, description and the image resource ID of the clicked tourist spot to the intent
                spotDetailIntent.putExtra("name", name);
                spotDetailIntent.putExtra("description", description);
                spotDetailIntent.putExtra("imageResourceId", imageResourceId);

                // Start the new activity
                startActivity(spotDetailIntent);
            }
        });
    }
}
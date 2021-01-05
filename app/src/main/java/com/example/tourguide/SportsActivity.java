package com.example.tourguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class SportsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spot_list);

        // Create a list of spots
        ArrayList<Spot> spots = new ArrayList<Spot>();

        spots.add(new Spot("Eden Gardens", getApplicationContext().getString(
                R.string.eden_gardens), R.drawable.eden_garden));
        spots.add(new Spot("Salt Lake Stadium", getApplicationContext().getString(
                R.string.salt_lake_stadium), R.drawable.salt_lake_stadium));
        spots.add(new Spot("Netaji Indoor Stadium", getApplicationContext().getString(
                R.string.netaji_indoor_stadium), R.drawable.netaji_indoor_stadium));
        spots.add(new Spot("Kolkata Race Course", getApplicationContext().getString(
                R.string.kolkata_race_course), R.drawable.kolkata_race_course));
        spots.add(new Spot("Fanattic Sports Museum", getApplicationContext().getString(
                R.string.fanattic_sports_museum), R.drawable.fanattic_sports_museum));

        // Create an {@link SpotAdapter}, whose data source is a list of {@link Spot}s. The
        // adapter knows how to create list items for each item in the list.
        SpotAdapter adapter = new SpotAdapter(this, spots, R.color.sports_color);

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
                Intent spotDetailIntent = new Intent(SportsActivity.this,
                        SpotDetailActivity.class);

                // Put the name, description and the image resource ID of the clicked tourist spot
                // to the intent
                spotDetailIntent.putExtra("name", name);
                spotDetailIntent.putExtra("description", description);
                spotDetailIntent.putExtra("imageResourceId", imageResourceId);

                // Start the new activity
                startActivity(spotDetailIntent);
            }
        });
    }
}
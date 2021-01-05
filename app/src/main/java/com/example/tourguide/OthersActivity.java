package com.example.tourguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class OthersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spot_list);

        // Create a list of spots
        ArrayList<Spot> spots = new ArrayList<Spot>();

        spots.add(new Spot("Birla Planetarium", getApplicationContext().getString(
                R.string.birla_planetarium), R.drawable.birla_planetarium));
        spots.add(new Spot("Science City", getApplicationContext().getString(
                R.string.science_city), R.drawable.science_city));
        spots.add(new Spot("Birla Industrial & Technological Museum", getApplicationContext().
                getString(R.string.birla_industrial), R.drawable.birla_planetarium));
        spots.add(new Spot("Nicco Park", getApplicationContext().getString(
                R.string.nicco_park), R.drawable.nicco_park));
        spots.add(new Spot("Park Street", getApplicationContext().getString(
                R.string.park_street), R.drawable.park_street));
        spots.add(new Spot("Esplanade", getApplicationContext().getString(
                R.string.esplanade), R.drawable.esplanade));
        spots.add(new Spot("Academy of Fine Arts", getApplicationContext().getString(
                R.string.academy_of_fine_arts), R.drawable.academy_of_fine_arts));
        spots.add(new Spot("Mother's Wax Museum", getApplicationContext().getString(
                R.string.mothers_wax_museum), R.drawable.mothers_wax_museum));

        // Create an {@link SpotAdapter}, whose data source is a list of {@link Spot}s. The
        // adapter knows how to create list items for each item in the list.
        SpotAdapter adapter = new SpotAdapter(this, spots, R.color.others_color);

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
                Intent spotDetailIntent = new Intent(OthersActivity.this,
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
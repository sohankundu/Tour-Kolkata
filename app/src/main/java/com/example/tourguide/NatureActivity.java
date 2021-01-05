package com.example.tourguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class NatureActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spot_list);

        // Create a list of spots
        ArrayList<Spot> spots = new ArrayList<Spot>();

        spots.add(new Spot("Rabindra Sarovar", getApplicationContext().getString(
                R.string.rabindra_sarovar), R.drawable.rabindra_sarovar));
        spots.add(new Spot("Botanical Gardens", getApplicationContext().getString(
                R.string.botanical_gardens), R.drawable.botanical_gardens));
        spots.add(new Spot("Alipore Zoo", getApplicationContext().getString(
                R.string.alipore_zoo), R.drawable.alipore_zoo));
        spots.add(new Spot("Eco Tourism Park", getApplicationContext().getString(
                R.string.eco_tourism_park), R.drawable.eco_park));
        spots.add(new Spot("Maidan", getApplicationContext().getString(
                R.string.maidan), R.drawable.maidan));
        spots.add(new Spot("Central Park", getApplicationContext().getString(
                R.string.central_park), R.drawable.central_park));
        spots.add(new Spot("Millenium Park", getApplicationContext().getString(
                R.string.millenium_park), R.drawable.millenium_park));
        spots.add(new Spot("Nalban Boating Park", getApplicationContext().getString(
                R.string.nalban), R.drawable.nalban));
        spots.add(new Spot("Subhash Sarovar", getApplicationContext().getString(
                R.string.subhash_sarovar), R.drawable.subhas_sarovar));
        spots.add(new Spot("Hoogly Riverfront", getApplicationContext().getString(
                R.string.hoogly_riverfront), R.drawable.hoogly_riverfront));

        // Create an {@link SpotAdapter}, whose data source is a list of {@link Spot}s. The
        // adapter knows how to create list items for each item in the list.
        SpotAdapter adapter = new SpotAdapter(this, spots, R.color.nature_color);

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
                Intent spotDetailIntent = new Intent(NatureActivity.this,
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
package com.example.tourguide;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class HeritageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spot_list);

        // Create a list of spots
        ArrayList<Spot> spots = new ArrayList<Spot>();

        spots.add(new Spot("Victoria Memorial", getApplicationContext().getString(
                R.string.victoria_memorial), R.drawable.victoria_memorial));
        spots.add(new Spot("Fort William", getApplicationContext().getString(
                R.string.fort_william), R.drawable.fort_william));
        spots.add(new Spot("Howrah Bridge", getApplicationContext().getString(
                R.string.howrah_bridge), R.drawable.howrah_bridge));
        spots.add(new Spot("Indian Museum", getApplicationContext().getString(
                R.string.indian_museum), R.drawable.indian_museum));
        spots.add(new Spot("Marble Palace Mansion", getApplicationContext().getString(
                R.string.marble_palace), R.drawable.marble_palace));
        spots.add(new Spot("Mother House", getApplicationContext().getString(
                R.string.mother_house), R.drawable.mother_house));
        spots.add(new Spot("Jorasanko Thakurbari", getApplicationContext().getString(
                R.string.jorasanko_thakurbari), R.drawable.jorasanko_thakurbari));
        spots.add(new Spot("Shobhabazar Rajbari", getApplicationContext().getString(
                R.string.shobhabajar_rajbari), R.drawable.shobhabajar_rajbari));
        spots.add(new Spot("Prinsep Ghat", getApplicationContext().getString(
                R.string.prinsep_ghat), R.drawable.prinsep_ghat));
        spots.add(new Spot("National Library", getApplicationContext().getString(
                R.string.national_library), R.drawable.national_library));
        spots.add(new Spot("Shaheed Minar", getApplicationContext().getString(
                R.string.shaheed_minar), R.drawable.shaheed_minar));
        spots.add(new Spot("Raj Bhavan", getApplicationContext().getString(
                R.string.raj_bhavan), R.drawable.raj_bhavan));
        spots.add(new Spot("Netaji Bhavan", getApplicationContext().getString(
                R.string.netaji_bhavan), R.drawable.netaji_bhavan));

        // Create an {@link SpotAdapter}, whose data source is a list of {@link Spot}s. The
        // adapter knows how to create list items for each item in the list.
        SpotAdapter adapter = new SpotAdapter(this, spots, R.color.heritage_color);

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
                Intent spotDetailIntent = new Intent(HeritageActivity.this,
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
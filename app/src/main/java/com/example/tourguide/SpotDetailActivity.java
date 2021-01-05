package com.example.tourguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SpotDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spot_detail);

        //Get the intent for the selected spot
        Intent intent = getIntent();
        //Get the name of the spot from the intent
        String name = intent.getStringExtra("name");
        //Get the description of the spot from the intent
        String description = intent.getStringExtra("description");
        //Get the image resource id of the spot from the intent
        int imageResourceId = intent.getIntExtra("imageResourceId", -1);

        TextView nameTextView = (TextView) findViewById(R.id.name_text_view);
        TextView descriptionTextView = (TextView) findViewById(R.id.description_text_view);
        ImageView image = (ImageView) findViewById(R.id.image);

        //Set the name text view of the spot
        nameTextView.setText(name);
        //Set the description text view for the spot
        descriptionTextView.setText(description);
        //Set the image of the spot if it exists
        if (imageResourceId != -1){
            image.setImageResource(imageResourceId);
        }

    }
}
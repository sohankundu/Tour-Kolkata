package com.example.tourguide;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.core.content.ContextCompat;

/**
 * {@link SpotAdapter} is an {@link ArrayAdapter} that can provide the layout for each list item
 * based on a data source, which is a list of {@link Spot} objects.
 */
public class SpotAdapter extends ArrayAdapter<Spot> {

    /** Resource ID for the background color for this list of spots */
    private int mColorResourceId;

    /**
     * Create a new {@link SpotAdapter} object.
     *
     * @param context is the current context (i.e. Activity) that the adapter is being created in.
     * @param spots is the list of {@link Spot}s to be displayed.
     * @param colorResourceId is the resource ID for the background color for this list of spots
     */
    public SpotAdapter(Context context, ArrayList<Spot> spots, int colorResourceId) {
        super(context, 0, spots);
        mColorResourceId = colorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link com.example.tourguide.Spot} object located at this position in the list
        Spot currentSpot = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID name_text_view.
        TextView nameTextView = (TextView) listItemView.findViewById(R.id.name_text_view);
        // Get the name of the spot from the currentSpot object and set this text on
        // the Name TextView.
        nameTextView.setText(currentSpot.getName());

        // Find the ImageView in the list_item.xml layout with the ID image.
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        // Set the ImageView to the image resource specified in the current Word
        imageView.setImageResource(currentSpot.getImageResourceId());

        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);


        // Return the whole list item layout so that it can be shown in
        // the ListView.
        return listItemView;
    }
}
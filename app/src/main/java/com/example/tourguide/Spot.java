package com.example.tourguide;

/**
 * {@link Spot} represents a tourist spot in the city of Kolkata.
 * It contains the name of the spot and an image for that spot.
 */
public class Spot {

    /** Image resource id for the tourist spot */
    private int mImageResourceId;

    /** Name of the tourist spot */
    private String mName;

    /** Description of the tourist spot */
    private String mDescription;

    /**
     * Create a new com.example.tourguide.Spot object.
     *
     * @param name is the name of the tourist spot
     * @param description is the description of the tourist spot
     * @param imageResourceId is the drawable resource ID for the image associated with the word
     *
     */
    public Spot(String name, String description, int imageResourceId) {

        mName = name;
        mDescription = description;
        mImageResourceId = imageResourceId;
    }

    public Spot(String name, int imageResourceId) {

        mName = name;
        mImageResourceId = imageResourceId;
    }

    /**
     * Get the name of the tourist spot.
     */
    public String getName() {
        return mName;
    }

    /**
     * Get the description of the tourist spot.
     */
    public String getDescription() {
        return mDescription;
    }

    /**
     * Return the image resource ID of the spot.
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }

}
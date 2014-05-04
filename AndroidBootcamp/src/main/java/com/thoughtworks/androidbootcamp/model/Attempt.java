package com.thoughtworks.androidbootcamp.model;

import java.io.Serializable;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static java.lang.String.format;

/**
 * Created by macosgrove on 23/04/2014.
 */
public class Attempt implements Serializable, Locatable {
    //For best performance, implement Parcelable rather than Serializable
    //See http://www.developerphil.com/parcelable-vs-serializable/, for example
    private int distance = Integer.MAX_VALUE;
    private List<Double> coordinates;
    private String photoPath;
    private int count;

    public Attempt(double latitude, double longitude, String photoPath, int count) {
        this.photoPath = photoPath;
        this.count = count;
        //Longitude is stored first for consistency with Treasure
        coordinates = newArrayList(longitude, latitude);
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    @Override
    public double getLatitude() {
        return coordinates.get(1);
    }

    @Override
    public double getLongitude() {
        return coordinates.get(0);
    }

    @Override
    public void setCoordinates(double latitude, double longitude) {
        coordinates.clear();
        coordinates.add(longitude);
        coordinates.add(latitude);
    }

    @Override
    public String getName() {
        return format("Attempt %d: %dm", count, distance);
    }
}

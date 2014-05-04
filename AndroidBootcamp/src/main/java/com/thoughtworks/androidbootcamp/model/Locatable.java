package com.thoughtworks.androidbootcamp.model;

/**
 * Created by macosgrove on 27/04/2014.
 */
public interface Locatable {
    public double getLatitude();
    public double getLongitude();
    public void setCoordinates(double latitude, double longitude);
    public String getName();
}

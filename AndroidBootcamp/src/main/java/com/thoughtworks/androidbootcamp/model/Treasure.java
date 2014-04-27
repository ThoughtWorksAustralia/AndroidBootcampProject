package com.thoughtworks.androidbootcamp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Treasure implements Serializable, Locatable {
    //For best performance, implement Parcelable rather than Serializable
    //See http://www.developerphil.com/parcelable-vs-serializable/, for example
    private String address;
    private List<Double> coordinates = new ArrayList<Double>();
    private String id;
    private String name;
    private String url;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Double> getCoordinates() {
        return coordinates;
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
        //Longitude is stored first because that's how the server sends it through
        coordinates.add(longitude);
        coordinates.add(latitude);
    }

    public void setCoordinates(List<Double> coordinates) {
        this.coordinates = coordinates;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
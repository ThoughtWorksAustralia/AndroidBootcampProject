package com.thoughtworks.androidbootcamp;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;

public class Treasure {
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
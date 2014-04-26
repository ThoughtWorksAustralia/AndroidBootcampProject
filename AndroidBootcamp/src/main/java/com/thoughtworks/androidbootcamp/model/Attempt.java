package com.thoughtworks.androidbootcamp.model;

import com.thoughtworks.androidbootcamp.Treasure;

import java.io.Serializable;

/**
 * Created by macosgrove on 23/04/2014.
 */
public class Attempt implements Serializable {
    //For best performance, implement Parcelable rather than Serializable
    //See http://www.developerphil.com/parcelable-vs-serializable/, for example
    private int distance;

    public int getDistance() {
        return distance;
    }
}

package com.thoughtworks.androidbootcamp.model;

import java.io.Serializable;

public class Game implements Serializable {
    //For best performance, implement Parcelable rather than Serializable
    //See http://www.developerphil.com/parcelable-vs-serializable/, for example
    private String player;

    public Game(String player) {
        this.player = player;
    }

    public String getPlayer() {
        return player;
    }

}

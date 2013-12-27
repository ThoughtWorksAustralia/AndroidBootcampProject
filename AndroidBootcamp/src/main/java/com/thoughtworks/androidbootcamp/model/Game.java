package com.thoughtworks.androidbootcamp.model;

import java.io.Serializable;

public class Game implements Serializable {
    private String player;

    public Game(String player) {
        this.player = player;
    }

    public String getPlayer() {
        return player;
    }

}

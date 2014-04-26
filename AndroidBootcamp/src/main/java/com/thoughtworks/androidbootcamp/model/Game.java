package com.thoughtworks.androidbootcamp.model;

import android.location.Location;

import com.thoughtworks.androidbootcamp.Treasure;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game implements Serializable {
    //For best performance, implement Parcelable rather than Serializable
    //See http://www.developerphil.com/parcelable-vs-serializable/, for example
    private String player;
    private Map<Treasure, Attempt> attempts;

    public Game() {
        attempts = new HashMap<Treasure, Attempt>();
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public String getPlayer() {
        return player;
    }

    public List<Treasure> getTreasures() {
        return new ArrayList<Treasure>(attempts.keySet());
    }

    public void setTreasures(List<Treasure> treasures) {
        attempts.clear();
        for (Treasure treasure : treasures) {
            attempts.put(treasure, null);
        }
    }

    public Attempt getAttemptForTreasure(Treasure treasure) {
        return attempts.get(treasure);
    }

    public void recordAttempt(Treasure treasure, Attempt attempt) {
        attempts.put(treasure, attempt);
    }
}

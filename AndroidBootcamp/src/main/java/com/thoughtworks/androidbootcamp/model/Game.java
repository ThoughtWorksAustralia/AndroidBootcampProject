package com.thoughtworks.androidbootcamp.model;

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
        //I'd prefer to use Google Collection's newArrayList() here, but that causes
        //java.lang.IllegalAccessError: Class ref in pre-verified class resolved to unexpected implementation
        //when running the instrumentation tests
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

    public int recordAttempt(Treasure treasure, Attempt attempt) {
        Attempt currentBestAttempt = getAttemptForTreasure(treasure);
        int difference = Integer.MAX_VALUE;
        if (currentBestAttempt != null) {
            difference = currentBestAttempt.getDistance() - attempt.getDistance();
        }
        if (difference >= 0) {
            attempts.put(treasure, attempt);
        }
        return difference;
    }

    public boolean hasPreviouslyAttemptedTreasure(Treasure treasure) {
        return (getAttemptForTreasure(treasure) != null);
    }

    public List<Attempt> getAttempts() {
        List<Attempt> nonNullAttempts = new ArrayList<Attempt>();
        for (Attempt attempt : attempts.values()) {
            if (attempt != null) {
                nonNullAttempts.add(attempt);
            }
        }
        return nonNullAttempts;
    }

    public boolean hasNoTreasures() {
        return attempts.isEmpty();
    }
}

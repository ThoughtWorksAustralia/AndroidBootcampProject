package com.thoughtworks.androidbootcamp.model;

import java.io.Serializable;

/**
 * Created by macosgrove on 21/04/2014.
 */
public class Score implements Serializable {
    //For best performance, implement Parcelable rather than Serializable
    //See http://www.developerphil.com/parcelable-vs-serializable/, for example
    private int gameVersion;
    private String id;
    private String name;
    private int score;

    public int getGameVersion() {
        return gameVersion;
    }

    public void setGameVersion(int gameVersion) {
        this.gameVersion = gameVersion;
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

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}

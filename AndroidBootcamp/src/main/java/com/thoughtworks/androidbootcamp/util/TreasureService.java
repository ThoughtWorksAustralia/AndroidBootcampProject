package com.thoughtworks.androidbootcamp.util;

import com.thoughtworks.androidbootcamp.model.Score;
import com.thoughtworks.androidbootcamp.model.Treasure;

import java.util.List;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;

/**
 * Created by trogdor on 2/04/14.
 */
public interface TreasureService {
    @GET("/treasures")
    List<Treasure> listTreasures();

    @GET("/players/top/10")
    List<Score> listHighScores();

    @POST("/players")
    void postScore(@Body Score score, Callback<Score> scoreCallback);
}

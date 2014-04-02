package com.thoughtworks.androidbootcamp.util;

import com.thoughtworks.androidbootcamp.Treasure;

import java.util.List;

import retrofit.http.GET;

/**
 * Created by trogdor on 2/04/14.
 */
public interface TreasureService {
    @GET("/treasures")
    List<Treasure> listTreasures();
}

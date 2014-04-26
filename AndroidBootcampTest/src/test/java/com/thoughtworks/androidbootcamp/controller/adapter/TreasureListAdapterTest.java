package com.thoughtworks.androidbootcamp.controller.adapter;

import android.app.Activity;
import android.content.Context;

import com.thoughtworks.androidbootcamp.Treasure;
import com.thoughtworks.androidbootcamp.controller.HelloAndroid;

import org.junit.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(RobolectricTestRunner.class)
@Config(emulateSdk = 18)
public class TreasureListAdapterTest {

    @Test
    public void shouldReturnItemCountAsNumberOfImagesProvided() throws Exception {
        int numTreasures = 10;
        List<Treasure> treasureList = new ArrayList<Treasure>();
        for (int i=0; i< numTreasures; i++) {
            treasureList.add(new Treasure());
        }
        HelloAndroid activity = Mockito.mock(HelloAndroid.class);
        when(activity.getTreasures()).thenReturn(treasureList);
        TreasureListAdapter adapter = new TreasureListAdapter(activity);
        Assert.assertEquals(10, adapter.getCount());
    }

    @Test
    public void shouldReturnAbsoluteURLOfTreasure() throws Exception {
        String expectedUrl = "http://android-bootcamp-rest-server.herokuapp.com/images/treasure.jpg";
        Treasure treasure = new Treasure();
        treasure.setUrl("images/treasure.jpg");
        TreasureListAdapter adapter = new TreasureListAdapter(Mockito.mock(HelloAndroid.class));

        String generatedUrl = adapter.getUrlForTreasure(treasure);

        Assert.assertEquals(expectedUrl, generatedUrl);
    }
}

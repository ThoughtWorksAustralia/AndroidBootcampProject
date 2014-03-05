package com.thoughtworks.androidbootcamp.controller.adapter;

import android.app.Activity;
import android.content.Context;

import com.thoughtworks.androidbootcamp.controller.HelloAndroid;

import org.junit.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

@RunWith(RobolectricTestRunner.class)
public class TreasureListAdapterTest {

    @Config(emulateSdk = 18)
    @Test
    public void shouldReturnItemCountAsNumberOfImagesProvided() throws Exception {
        int numTreasures = 10;
        TreasureListAdapter adapter = new TreasureListAdapter(Mockito.mock(Context.class), new String[numTreasures]);
        Assert.assertEquals(10, adapter.getCount());
    }
}

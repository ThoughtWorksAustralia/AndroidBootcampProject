package com.thoughtworks.androidbootcamp.controller;

import com.thoughtworks.androidbootcamp.Treasure;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

@Config(emulateSdk = 18)
@RunWith(RobolectricTestRunner.class)
public class HelloAndroidUnitTest {

    HelloAndroid activity;

    @Before
    public void setUp() {
        activity = spy(Robolectric.buildActivity(HelloAndroid.class).create().get());
    }

    @Test
    public void shouldShowTreasureListWhenFirstSpinnerItemSelected() throws Exception {
        activity.onNavigationItemSelected(0, 0);
        verify(activity).showTreasureList();
    }

    @Test
    public void shouldShowHighScoresWhenSecondSpinnerItemSelected() throws Exception {
        activity.onNavigationItemSelected(1, 0);
        verify(activity).showHighScores();
    }

    @Test
    public void shouldShowMapWhenThirdSpinnerItemSelected() throws Exception {
        activity.onNavigationItemSelected(2, 0);
        verify(activity).showMap();
    }

    @Test
    public void shouldSetTreasuresOnGame() throws Exception {
        Treasure treasure = mock(Treasure.class);
        List<Treasure> treasures = newArrayList(treasure);
        activity.setTreasures(treasures);
        List<Treasure> actual = activity.getGame().getTreasures();
        assertThat(actual.size(), is(1));
        assertThat(actual.get(0), is(treasure));
    }

    @Test
    public void shouldGetTreasuresFromGame() throws Exception {
        Treasure treasure = mock(Treasure.class);
        List<Treasure> treasures = newArrayList(treasure);
        activity.getGame().setTreasures(treasures);
        List<Treasure> actual = activity.getTreasures();
        assertThat(actual.size(), is(1));
        assertThat(actual.get(0), is(treasure));
    }



}

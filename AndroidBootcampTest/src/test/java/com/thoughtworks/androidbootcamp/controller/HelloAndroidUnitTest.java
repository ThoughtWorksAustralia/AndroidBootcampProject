package com.thoughtworks.androidbootcamp.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

@Config(emulateSdk = 18)
@RunWith(RobolectricTestRunner.class)
public class HelloAndroidUnitTest {

    private HelloAndroid activity;

    @Before
    public void setUp() throws Exception {
        activity = spy(Robolectric.buildActivity(HelloAndroid.class).create().get());
    }

    @Test
    public void shouldShowTreasureListWhenFirstSpinnerItemSelected() throws Exception {
        activity.onNavigationItemSelected(0, 0);
        verify(activity).showTreasureList();
    }

    @Test
    public void shouldShowHighScoresWhenSecondFragmentStarted() throws Exception {
        activity.onNavigationItemSelected(1, 0);
        verify(activity).showHighScores();
    }

    @Test
    public void shouldShowMapWhenThirdFragmentStarted() throws Exception {
        activity.onNavigationItemSelected(2, 0);
        verify(activity).showMap();
    }

}

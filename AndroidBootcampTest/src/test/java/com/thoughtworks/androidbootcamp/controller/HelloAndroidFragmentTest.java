package com.thoughtworks.androidbootcamp.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

@RunWith(RobolectricTestRunner.class)
public class HelloAndroidFragmentTest {

    @Config(emulateSdk = 18)
    @Test
    public void shouldShowTreasureListWhenFirstSpinnerItemSelected() throws Exception {
        HelloAndroid activity = spy(Robolectric.buildActivity(HelloAndroid.class).create().get());
        activity.onNavigationItemSelected(0, 0);
        verify(activity).showTreasureList();
    }

//    @Test
//    public void shouldShowTreasureListWhenFirstFragmentStarted() throws Exception {
//        HelloAndroid.PlaceholderFragment fragment = spy(HelloAndroid.PlaceholderFragment.newInstance(1));
//
//        startFragment(fragment);
//
//        verify(fragment).showTreasureList(any(View.class));
//    }
//
//    @Test
//    public void shouldShowHighScoresWhenSecondFragmentStarted() throws Exception {
//        HelloAndroid.PlaceholderFragment fragment = spy(HelloAndroid.PlaceholderFragment.newInstance(2));
//
//        startFragment(fragment);
//
//        verify(fragment).showHighScores(any(View.class));
//    }
//
//    @Test
//    public void shouldShowMapWhenThirdFragmentStarted() throws Exception {
//        HelloAndroid.PlaceholderFragment fragment = spy(HelloAndroid.PlaceholderFragment.newInstance(3));
//
//        startFragment(fragment);
//
//        verify(fragment).showMap(any(View.class));
//    }

}

package com.thoughtworks.androidbootcamp.controller;

import android.view.View;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.robolectric.util.FragmentTestUtil.startFragment;

@RunWith(RobolectricTestRunner.class)
public class HelloAndroidFragmentTest {

    @Test
    public void shouldShowTreasureListWhenFirstFragmentStarted() throws Exception {
        HelloAndroid.PlaceholderFragment fragment = spy(HelloAndroid.PlaceholderFragment.newInstance(1));

        startFragment(fragment);

        verify(fragment).showTreasureList(any(View.class));
    }

    @Test
    public void shouldShowHighScoresWhenSecondFragmentStarted() throws Exception {
        HelloAndroid.PlaceholderFragment fragment = spy(HelloAndroid.PlaceholderFragment.newInstance(2));

        startFragment(fragment);

        verify(fragment).showHighScores(any(View.class));
    }

    @Test
    public void shouldShowMapWhenThirdFragmentStarted() throws Exception {
        HelloAndroid.PlaceholderFragment fragment = spy(HelloAndroid.PlaceholderFragment.newInstance(3));

        startFragment(fragment);

        verify(fragment).showMap(any(View.class));
    }

}

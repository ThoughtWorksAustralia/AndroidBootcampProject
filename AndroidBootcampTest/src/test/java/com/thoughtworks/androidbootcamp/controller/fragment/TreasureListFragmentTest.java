package com.thoughtworks.androidbootcamp.controller.fragment;

import com.thoughtworks.androidbootcamp.model.Attempt;
import com.thoughtworks.androidbootcamp.model.Game;
import com.thoughtworks.androidbootcamp.model.Treasure;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


/**
 * Created by macosgrove on 25/04/2014.
 */
@RunWith(RobolectricTestRunner.class)
@Config(emulateSdk = 18)

public class TreasureListFragmentTest {

    private TreasureListFragment fragment;

    @Before
    public void setUp() {
        fragment = spy(new TreasureListFragment());
    }

    @Test
    public void shouldCalculateDistance() {
        Attempt attempt = new Attempt(-33.866365, 151.210816, "");
        Treasure treasure = new Treasure();
        treasure.setCoordinates(-33.866441, 151.211395);
        int distance = fragment.calculateDistance(attempt, treasure);
        assertThat(distance, is(54));
        int distance2 = fragment.calculateDistance(treasure, attempt);
        assertThat(distance2, is(54));
    }

    @Test
    public void shouldRecordAttempt() throws IOException {
        Attempt attempt = new Attempt(-33.866365, 151.210816, "the photo path");
        Treasure treasure = mock(Treasure.class);
        Game game = mock(Game.class);
        when(fragment.getCurrentPhotoPath()).thenReturn("the photo path");
        when(fragment.createAttemptForPhoto("the photo path")).thenReturn(attempt);
        when(fragment.getGame()).thenReturn(game);
        when(fragment.getSelectedTreasure()).thenReturn(treasure);

        fragment.onTreasureAttempted();

        verify(fragment).calculateDistance(treasure, attempt);
        verify(game).recordAttempt(treasure, attempt);
    }


}

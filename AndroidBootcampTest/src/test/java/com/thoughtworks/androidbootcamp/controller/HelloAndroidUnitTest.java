package com.thoughtworks.androidbootcamp.controller;

import com.thoughtworks.androidbootcamp.model.Score;
import com.thoughtworks.androidbootcamp.model.Treasure;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.io.ByteArrayOutputStream;
import java.util.List;

import retrofit.converter.GsonConverter;
import retrofit.mime.TypedOutput;

import static com.google.common.collect.Lists.newArrayList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

@Config(emulateSdk = 18)
@RunWith(RobolectricTestRunner.class)
public class HelloAndroidUnitTest {

    public static final int TREASURE_MENU_ITEM = 0;
    public static final int HIGH_SCORES_MENU_ITEM = 1;
    public static final int MAP_MENU_ITEM = 2;
    HelloAndroid activity;

    @Before
    public void setUp() {
        activity = spy(Robolectric.buildActivity(HelloAndroid.class).create().get());
    }

    @Test
    public void shouldShowTreasureListWhenFirstSpinnerItemSelected() throws Exception {
        activity.onNavigationItemSelected(TREASURE_MENU_ITEM, 0);
        verify(activity).showTreasureList();
    }

    @Test
    public void shouldShowHighScoresWhenSecondSpinnerItemSelected() throws Exception {
        activity.onNavigationItemSelected(HIGH_SCORES_MENU_ITEM, 0);
        verify(activity).showHighScores();
    }

    @Test
    public void shouldShowMapWhenThirdSpinnerItemSelected() throws Exception {
        activity.onNavigationItemSelected(MAP_MENU_ITEM, 0);
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

    @Test
    public void shouldCreateEndGameMessage() throws Exception {
        doReturn(3363).when(activity).getScore();

        assertThat(activity.getEndGameMessage(), containsString("Good game! Your final score was 3363."));
    }

    @Test
    public void shouldConstructScoreJsonViaGsonConverter() throws Exception {
        Score score = new Score("Hermione", 254, 3);
        GsonConverter converter = activity.createGsonConverter();
        TypedOutput typedOutput = converter.toBody(score);
        ByteArrayOutputStream os = new ByteArrayOutputStream(256);
        typedOutput.writeTo(os);
        String actualScoreJson = os.toString("UTF-8");
        String expectedScoreJson = "{\"game_version\":3,\"name\":\"Hermione\",\"score\":254}";
        assertThat(actualScoreJson, equalTo(expectedScoreJson));
    }



}

package com.thoughtworks.androidbootcamp.model;

import com.thoughtworks.androidbootcamp.model.Treasure;

import org.junit.Test;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Matchers.isNull;
import static org.mockito.Mockito.mock;

public class GameTest {

    public void setUp() throws Exception {
    }

    @Test
    public void shouldHaveAListOfTreasures() {
        Game game = new Game();
        assertThat(game.getTreasures().size(), is(0));
    }

    @Test
    public void shouldBeAbleToRecordAttempts() {
        Treasure one = mock(Treasure.class);
        Game game = gameWithTreasures(newArrayList(one));
        assertThat(game.getAttemptForTreasure(one), is(nullValue()));
        Attempt attempt = new Attempt(1, 2, "");
        game.recordAttempt(one, attempt);
        assertThat(game.getAttemptForTreasure(one), is(attempt));
    }

    private Game gameWithTreasures(List<Treasure> treasures) {
        Game game = new Game();
        game.setTreasures(newArrayList(treasures));
        return game;
    }

}

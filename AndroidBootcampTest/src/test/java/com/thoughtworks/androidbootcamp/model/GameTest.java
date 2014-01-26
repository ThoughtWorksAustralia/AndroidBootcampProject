package com.thoughtworks.androidbootcamp.model;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class GameTest {

    public void setUp() throws Exception {
    }

    @Test
    public void shouldDemonstrateHowPlainJUnitTestsWork() {
        Game game = new Game("example");
        assertThat(game.getPlayer(), is("example"));
    }
}

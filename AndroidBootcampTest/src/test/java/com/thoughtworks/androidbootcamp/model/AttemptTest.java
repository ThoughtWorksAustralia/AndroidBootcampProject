package com.thoughtworks.androidbootcamp.model;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by macosgrove on 4/05/2014.
 */
public class AttemptTest {

    @Test
    public void nameShouldIncludeCountAndDistance() {
        Attempt attempt = new Attempt(1, 2, "", 7);
        attempt.setDistance(53);
        assertThat(attempt.getName(), equalTo("Attempt 7: 53m"));
    }
}

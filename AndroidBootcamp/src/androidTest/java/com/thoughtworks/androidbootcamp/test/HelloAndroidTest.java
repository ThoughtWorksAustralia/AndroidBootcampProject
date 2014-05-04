package com.thoughtworks.androidbootcamp.test;

import android.test.ActivityInstrumentationTestCase2;

import com.thoughtworks.androidbootcamp.R;
import com.thoughtworks.androidbootcamp.controller.HelloAndroid;
import com.thoughtworks.androidbootcamp.test.helpers.Given;
import com.thoughtworks.androidbootcamp.test.helpers.When;

import static com.google.android.apps.common.testing.ui.espresso.Espresso.onView;
import static com.google.android.apps.common.testing.ui.espresso.assertion.ViewAssertions.matches;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.Visibility.VISIBLE;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withId;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.containsString;

/**
 * Functional test for the HelloAndroid activity
 */
public class HelloAndroidTest extends ActivityInstrumentationTestCase2<HelloAndroid> {

    @SuppressWarnings("deprecation")
    public HelloAndroidTest() {
        // This constructor was deprecated - but we want to support lower API levels.
        super("com.thoughtworks.androidbootcamp", HelloAndroid.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        // Espresso will not launch our activity for us, we must launch it via getActivity().
        getActivity();
    }

    public void testTreasureList() throws InterruptedException {
        Given.thePlayerHasEnteredTheirName();

        When.iOpenTheMenuAndSelectItem("Treasure List");

        onView(withId(R.id.section_label)).check(matches(withText(containsString("Find these treasures:"))));
    }

    public void testHighScores() throws InterruptedException {
        Given.thePlayerHasEnteredTheirName();

        When.iOpenTheMenuAndSelectItem("High Scores");

        onView(withId(R.id.section_label)).check(matches(withText(containsString("High Scores:"))));
    }

    public void testMap() throws InterruptedException {
        Given.thePlayerHasEnteredTheirName();

        When.iOpenTheMenuAndSelectItem("Map");

        onView(withId(R.id.map_container)).check(matches(withEffectiveVisibility(VISIBLE)));
    }


}

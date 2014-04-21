package com.thoughtworks.androidbootcamp.test.helpers;

import com.thoughtworks.androidbootcamp.R;

import static com.google.android.apps.common.testing.ui.espresso.Espresso.onView;
import static com.google.android.apps.common.testing.ui.espresso.action.ViewActions.click;
import static com.google.android.apps.common.testing.ui.espresso.action.ViewActions.typeText;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withId;

/**
 * Created by macosgrove on 4/01/2014.
 * Setup methods to make the functional tests more readable, in BDD style
 */
public class Given {
    public static void thePlayerHasEnteredTheirName() {
        onView(withId(R.id.player_field)).perform(typeText("Joe"));
        onView(withId(R.id.player_ok_button)).perform(click());
    }
}

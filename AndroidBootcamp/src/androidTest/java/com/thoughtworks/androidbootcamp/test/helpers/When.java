package com.thoughtworks.androidbootcamp.test.helpers;

import static com.google.android.apps.common.testing.ui.espresso.Espresso.onData;
import static com.google.android.apps.common.testing.ui.espresso.Espresso.onView;
import static com.google.android.apps.common.testing.ui.espresso.action.ViewActions.click;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsInstanceOf.instanceOf;

/**
 * Created by macosgrove on 4/01/2014.
 * Action methods to make the functional tests more readable, in BDD style
 */
public class When {
    public static void iOpenTheMenuAndSelectItem(String menuItem) {
        onView(withText("Treasure List")).perform(click());
        onData(allOf(is(instanceOf(String.class)), is(menuItem)))
                .perform(click());


    }
}

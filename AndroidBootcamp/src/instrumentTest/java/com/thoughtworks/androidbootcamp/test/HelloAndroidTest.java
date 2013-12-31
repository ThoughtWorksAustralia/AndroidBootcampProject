package com.thoughtworks.androidbootcamp.test;

import android.annotation.TargetApi;
import android.os.Build;
import android.test.ActivityInstrumentationTestCase2;

import com.thoughtworks.androidbootcamp.controller.HelloAndroid;

/**
 * Functional test for the HelloAndroid activity
 */
public class HelloAndroidTest extends ActivityInstrumentationTestCase2<HelloAndroid> {

    private HelloAndroid mActivity;

    @TargetApi(Build.VERSION_CODES.FROYO)
    public HelloAndroidTest() {
        super(HelloAndroid.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        mActivity = getActivity();
    }

    public void testSomething() {
        fail();
    }
}

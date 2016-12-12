package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.support.test.filters.SmallTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.ActivityInstrumentationTestCase2;
import android.test.ActivityUnitTestCase;
import android.util.Pair;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Created by OFFICE on 12/10/2016.
 */

@RunWith(AndroidJUnit4.class)
@SmallTest
public class MainActivityFragmentTest  implements JokesListener {


    @Test
    public void onDataAvailable() throws Exception {

        String productFlavor = com.udacity.gradle.builditbigger.BuildConfig.VERSION_NAME;
        ExecuteBackendsCalls executeBackendsCalls = new ExecuteBackendsCalls();
        executeBackendsCalls.setOnDataListener(this);
        executeBackendsCalls.execute(new Pair<Context, String>(null, productFlavor));

    }

    @Override
    public void onDataAvailable(String data) {

        assertTrue(data.length()>0);

    }
}
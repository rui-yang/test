package com.mytaxi.android_demo;

/**
 * Created by ruiyang on 2/14/2018.
 */

import android.support.test.espresso.Root;
import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.mytaxi.android_demo.activities.MainActivity;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.hamcrest.Matcher;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;


@RunWith(AndroidJUnit4.class)
public class SearchTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);

    private String mStringToSearch = "sa";
    private String mExpectedString = "Sarah Friedrich";

    @Test
    public void testSearchDriver() throws Exception{

        //search the string
        onView(withId(R.id.textSearch)).perform(typeText(mStringToSearch), closeSoftKeyboard());

        //select the driver
        Matcher<Root> rootMatcher = withDecorView(not(mActivityRule.getActivity().getWindow().getDecorView()));
        onView(withText(mExpectedString)).inRoot(rootMatcher).perform(click());

        //check the details of driver's profile
        onView(withId(R.id.textViewDriverName)).check(matches(withText(mExpectedString)));

        //click call button in DriverProfileActivity
        onView(withId(R.id.fab)).perform(click());
    }
}

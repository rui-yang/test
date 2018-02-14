package com.mytaxi.android_demo;

/**
 * Created by ruiyang on 2/14/2018.
 */

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.mytaxi.android_demo.activities.AuthenticationActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Login test
 */
@RunWith(AndroidJUnit4.class)
public class LoginTest {
    @Rule
    public ActivityTestRule<AuthenticationActivity> mActivityRule = new ActivityTestRule<>(AuthenticationActivity.class);

    private String mUserName = "whiteelephant261";;
    private String mPassword = "video";;

    @Test
    public void testLoginFailure() throws Exception {
        onView(withId(R.id.edt_username)).perform(typeText(mUserName));
        onView(withId(R.id.edt_password)).perform(typeText(mPassword));
        onView(withId(R.id.btn_login)).perform(click());
    }

    @Test
    public void testLoginSuccess() throws Exception {
        onView(withId(R.id.edt_username)).perform(typeText(mUserName));
        onView(withId(R.id.edt_password)).perform(typeText(mPassword));
        onView(withId(R.id.btn_login)).perform(click());
    }

}

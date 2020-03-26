package com.lewic.espressodemo;

/**
 * @author lewic
 * @Description:
 * @date 2020-03-24 23:26
 */

import androidx.test.espresso.IdlingRegistry;
import androidx.test.espresso.IdlingResource;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

/**
 * Same as Espresso's BasicSample, but with an Idling Resource to help with synchronization.
 */
@RunWith(AndroidJUnit4.class)
public class IdlingResourceActivityTest {

    private static final String STRING_TO_BE_TYPED = "Espresso";

    private IdlingResource mIdlingResource;

    //设置初始启动测试Activity，并启动
    @Rule
    public ActivityTestRule<IdlingResourceActivity> mActivityRule = new ActivityTestRule<>(IdlingResourceActivity.class);


    @Before
    public void registerIdlingResource() {
        mIdlingResource=mActivityRule.getActivity().getIdlingResource();
        IdlingRegistry.getInstance().register(mIdlingResource);
    }

    @Test
    public void testIdlingResource() {
        // Type text and then press the button.
        onView(withId(R.id.editTextUserInput))
                .perform(typeText(STRING_TO_BE_TYPED),closeSoftKeyboard());
        onView(withId(R.id.changeTextBt))
                .perform(click());

        // Check that the text was changed.
        onView(withId(R.id.textToBeChanged))
                .check(matches(withText(STRING_TO_BE_TYPED)));
    }

    @After
    public void unregisterIdlingResource() {
        if (mIdlingResource != null) {
            IdlingRegistry.getInstance().unregister(mIdlingResource);
        }
    }
}

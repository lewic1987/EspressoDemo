package com.lewic.espressodemo;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

/**
 * @author lewic
 * @Description:
 * @date 2020-02-24 20:27
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    //设置初始启动测试Activity，并启动
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testDemo() {

        //通过id查找
        onView(withId(R.id.sayHelloTV)).perform(click());

        //通过文本查找
        onView(withText("sayHello")).perform(click());

        onView(withId(R.id.testEditText)).perform(typeText("testEditText"));

        onView(withId(R.id.testEditText)).perform(clearText());

        onView(CustomMatchers.withTag("sayHello")).perform(click());

        onView(CustomMatchers.withText("sayHello")).perform(click());
    }

    @Test
    public void testGoRecyclerViewPage() {
        onView(withId(R.id.goRecyclerViewPageTV)).perform(click());

        //执行返回事件，返回页面
        pressBack();
    }

    @Test
    public void testGoListViewPage() {
        onView(withId(R.id.goListViewPageTV)).perform(click());

        //执行返回事件，返回页面
        pressBack();
    }

    @Test
    public void testGoIdlingResourcePage() {
        onView(withId(R.id.goIdlingResourcePageTV)).perform(click());
    }
}

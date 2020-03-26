package com.lewic.espressodemo;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.contrib.RecyclerViewActions.scrollToPosition;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

/**
 * @author lewic
 * @Description:
 * @date 2020-02-24 20:27
 */
@RunWith(AndroidJUnit4.class)
public class RecycleViewActivityTest {

    //设置初始启动测试Activity，并启动
    @Rule
    public ActivityTestRule<RecyclerViewActivity> mActivityRule = new ActivityTestRule<>(RecyclerViewActivity.class);

    @Test
    public void testRecyclerViewScroll() {

        //通过id找到RecycleView，然后执行滑动事件
        onView(withId(R.id.testRecyclerView))
                .perform(scrollToPosition(50));
    }

    @Test
    public void testClickRecyclerViewItem() {

        //通过id找到RecycleView，执行Item点击事件
        onView(withId(R.id.testRecyclerView))
                .perform(actionOnItemAtPosition(30, click()));
    }
}

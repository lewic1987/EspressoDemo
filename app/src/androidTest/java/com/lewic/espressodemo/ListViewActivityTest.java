package com.lewic.espressodemo;

import androidx.test.espresso.matcher.BoundedMatcher;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import com.lewic.espressodemo.model.ItemModel;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.instanceOf;

/**
 * @author lewic
 * @Description:
 * @date 2020-02-24 20:27
 */
@RunWith(AndroidJUnit4.class)
public class ListViewActivityTest {

    //设置初始启动测试Activity，并启动
    @Rule
    public ActivityTestRule<ListViewActivity> mActivityRule = new ActivityTestRule<>(ListViewActivity.class);

    @Test
    public void testClickListViewChildView() {

        //点击指定位置Item子view
        onData(instanceOf(ItemModel.class))
                .inAdapterView(withId(R.id.testListView))
                .atPosition(30)
                .onChildView(withId(R.id.testClickChildViewTV))
                .perform(click());
    }

    @Test
    public void testClickListViewItem() {

        //点击指定位置Item
        onData(instanceOf(ItemModel.class))
                .inAdapterView(withId(R.id.testListView))
                .atPosition(50)
                .perform(click());
    }

    @Test
    public void testClickListViewItemWithName() {

        //自定义Matcher匹配数据，withName方法返回一个自定义的Matcher
        onData(allOf(instanceOf(ItemModel.class), withName("item30")))
                .inAdapterView(withId(R.id.testListView))
                .perform(click());
    }

    @Test
    public void testClickListViewHeadView() {

        //点击特殊的 Item，如HeadView
//        onData(instanceOf(ItemModel.class))
//                .onChildView(instanceOf(HeadView.class))
//                .perform(click());
    }

    public static Matcher<Object> withName(final String name) {
        return new BoundedMatcher<Object, ItemModel>(ItemModel.class) {

            @Override
            public void describeTo(Description description) {
                description.appendText("has name:" + name);
            }

            @Override
            public boolean matchesSafely(ItemModel item) {
                return item.getName().equals(name);
            }
        };
    }
}

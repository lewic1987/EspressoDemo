package com.lewic.espressodemo;

import android.view.View;
import android.widget.TextView;

import androidx.test.espresso.matcher.BoundedMatcher;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

/**
 * @author lewic
 * @Description:
 * @date 2020-03-25 13:55
 */
public class CustomMatchers {
    /**
     * 返回具有指定 Tag 的View
     */
    public static Matcher<View> withTag(final String tag) {
        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("with key: " + tag);
            }

            @Override
            public boolean matchesSafely(View view) {
                return tag.equals(view.getTag());
            }
        };
    }

    /**
     * 返回具有指定test的TextView
     */
    public static Matcher<View> withText(final String text) {
        return new BoundedMatcher<View, TextView>(TextView.class) {
            @Override
            public void describeTo(Description description) {
                description.appendText("with text: " + text);
            }

            @Override
            public boolean matchesSafely(TextView textView) {
                return text.equals(textView.getText().toString());
            }
        };
    }
}

package com.lewic.espressodemo;

import android.content.Context;
import android.content.Intent;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author lewic
 * @Description:
 * @date 2020-02-24 20:27
 */
@RunWith(AndroidJUnit4.class)
public class SecondActivityTest {

    //设置初始启动测试Activity，ActivityTestRule的构造函数的第三个参数是否启动Activity
    @Rule
    public ActivityTestRule<SecondActivity> mActivityRule = new ActivityTestRule<>(SecondActivity.class,false,false);

    @Test
    public void testStartActivity(){
        Context context = InstrumentationRegistry.getInstrumentation().getTargetContext();
        Intent intent = new Intent(context,SecondActivity.class);
        intent.putExtra("name","testStartActivity");
        mActivityRule.launchActivity(intent);
    }
}

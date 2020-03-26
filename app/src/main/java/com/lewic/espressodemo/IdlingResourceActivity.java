package com.lewic.espressodemo;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.test.espresso.IdlingResource;

import com.lewic.espressodemo.IdlingResource.SimpleIdlingResource;

/**
 * Gets a text String from the user and displays it back after a while.
 */
public class IdlingResourceActivity extends Activity implements View.OnClickListener{

    // The TextView used to display the message inside the Activity.
    private TextView mTextView;

    // The EditText where the user types the message.
    private EditText mEditText;

    // The Idling Resource which will be null in production.
    @Nullable
    private SimpleIdlingResource mIdlingResource;

    private static final int DELAY_MILLIS = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_idling_resource);

        // Set the listeners for the buttons.
        findViewById(R.id.changeTextBt).setOnClickListener(this);

        mTextView = (TextView) findViewById(R.id.textToBeChanged);
        mEditText = (EditText) findViewById(R.id.editTextUserInput);
    }

    @Override
    public void onClick(View view) {
        // Get the text from the EditText view.
        final String text = mEditText.getText().toString();

        if (view.getId() == R.id.changeTextBt) {
            // Set a temporary text.
            mTextView.setText(R.string.waiting_msg);

            if (mIdlingResource != null) {
                //耗时操作开始，设置空闲状态为false
                mIdlingResource.setIdleState(false);
            }
            //模拟耗时操作
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    mTextView.setText(text);
                    if (mIdlingResource != null) {
                        //耗时操作结束，设置空闲状态为true
                        mIdlingResource.setIdleState(true);
                    }
                }
            }, DELAY_MILLIS);
        }
    }

    /**
     * Only called from test, creates and returns a new {@link SimpleIdlingResource}.
     */
    @VisibleForTesting
    @NonNull
    public IdlingResource getIdlingResource() {
        if (mIdlingResource == null) {
            mIdlingResource = new SimpleIdlingResource();
        }
        return mIdlingResource;
    }
}
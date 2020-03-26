package com.lewic.espressodemo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    private TextView nameTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String name = getIntent().getStringExtra("name");
        setContentView(R.layout.activity_second);
        nameTV = findViewById(R.id.nameTV);
        nameTV.setText(name);
    }

    public static Intent getStartIntent(Context context, String name) {
        Intent intent = new Intent(context, SecondActivity.class);
        intent.putExtra("name", name);
        return intent;
    }
}

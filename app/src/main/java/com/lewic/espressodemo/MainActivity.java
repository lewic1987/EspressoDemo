package com.lewic.espressodemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mian);
        findViewById(R.id.goRecyclerViewPageTV).setOnClickListener(this);
        findViewById(R.id.sayHelloTV).setOnClickListener(this);
        findViewById(R.id.sayHelloTV).setTag("sayHello");
        findViewById(R.id.goListViewPageTV).setOnClickListener(this);
        findViewById(R.id.goIdlingResourcePageTV).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.goRecyclerViewPageTV:
                intent = new Intent();
                intent.setClass(this, RecyclerViewActivity.class);
                startActivity(intent);
                break;
            case R.id.goListViewPageTV:
                intent = new Intent();
                intent.setClass(this, ListViewActivity.class);
                startActivity(intent);
                break;
            case R.id.sayHelloTV:
                Toast.makeText(this,"Hello Espresso!",Toast.LENGTH_SHORT).show();
                //int m=1/0;//模拟异常
                break;
            case R.id.goIdlingResourcePageTV:
                intent = new Intent();
                intent.setClass(this, IdlingResourceActivity.class);
                startActivity(intent);
                break;
        }
    }
}

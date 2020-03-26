package com.lewic.espressodemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.lewic.espressodemo.adapter.ListViewAdapter;
import com.lewic.espressodemo.model.ItemModel;

import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends AppCompatActivity {
    private ListView mTestListView;
    private ListViewAdapter mAdapter;
    private List<ItemModel> items = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        mTestListView = findViewById(R.id.testListView);

        for (int i = 0; i < 100; i++) {
            ItemModel item = new ItemModel();
            item.setName("item" + i);
            items.add(item);
        }
        mAdapter = new ListViewAdapter(this, items);
        mTestListView.setAdapter(mAdapter);
        mTestListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = SecondActivity.getStartIntent(ListViewActivity.this, items.get(position).getName());
                startActivity(intent);
            }
        });
    }
}

package com.lewic.espressodemo;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.lewic.espressodemo.adapter.RecycleViewAdapter;
import com.lewic.espressodemo.model.ItemModel;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private GridLayoutManager mGridLayoutManager;
    private RecycleViewAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycleview);
        
        mRecyclerView = findViewById(R.id.testRecyclerView);
        mRecyclerView.setHasFixedSize(true);
        mGridLayoutManager = new GridLayoutManager(this, 2);
        mGridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mGridLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        List<ItemModel> items = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            ItemModel item = new ItemModel();
            item.setName("item" + i);
            items.add(item);
        }
        mAdapter = new RecycleViewAdapter(this, items);
        mRecyclerView.setAdapter(mAdapter);
    }
}

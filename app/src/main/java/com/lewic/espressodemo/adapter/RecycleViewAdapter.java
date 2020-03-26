package com.lewic.espressodemo.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.lewic.espressodemo.R;
import com.lewic.espressodemo.SecondActivity;
import com.lewic.espressodemo.model.ItemModel;

import java.util.List;

/**
 * @author lewic
 * @Description:
 * @date 2017/10/11
 */
public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolder> {

    private Context context;
    private List<ItemModel> items;

    public RecycleViewAdapter(Context context, List<ItemModel> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final ItemModel item = items.get(position);
        if (item == null) {
            return;
        }
        holder.nameTV.setText(item.getName());
        holder.itemRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = SecondActivity.getStartIntent(context, item.getName());
                context.startActivity(intent);
            }
        });

        holder.testClickChildViewTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"点击："+item.getName(),Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView nameTV,testClickChildViewTV;
        public RelativeLayout itemRL;

        public ViewHolder(View itemView) {
            super(itemView);
            nameTV = itemView.findViewById(R.id.nameTV);
            itemRL = itemView.findViewById(R.id.itemRL);
            testClickChildViewTV=itemView.findViewById(R.id.testClickChildViewTV);
        }
    }
}


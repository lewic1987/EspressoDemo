package com.lewic.espressodemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.lewic.espressodemo.R;
import com.lewic.espressodemo.model.ItemModel;

import java.util.List;

public class ListViewAdapter extends BaseAdapter {

    private Context mContext;
    private List<ItemModel> items;

    public ListViewAdapter(Context context, List<ItemModel> list) {
        this.mContext = context;
        this.items = list;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.activity_item, null);
            holder = new ViewHolder();
            holder.nameTV = convertView.findViewById(R.id.nameTV);
            holder.testClickChildViewTV=convertView.findViewById(R.id.testClickChildViewTV);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        final ItemModel item = items.get(position);
        holder.nameTV.setText(item.getName());
        holder.testClickChildViewTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,"点击："+item.getName(),Toast.LENGTH_LONG).show();
            }
        });
        return convertView;
    }

    public static class ViewHolder {
        public TextView nameTV;
        public TextView testClickChildViewTV;
    }
}
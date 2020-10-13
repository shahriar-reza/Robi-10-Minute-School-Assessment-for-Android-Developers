package com.example.robi10minschool;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ListViewAdapter extends BaseAdapter {

    private List<SubItemClass> subItemsList;
    Context context;

    public ListViewAdapter(List<SubItemClass> subItemsList, Context context) {
        this.subItemsList = subItemsList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return subItemsList.size();
    }

    @Override
    public Object getItem(int position) {
        return subItemsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.sub_item_layout, null);
        }

        ImageView icon = (ImageView) convertView.findViewById(R.id.sub_item_icon);
        TextView textViewSubItemsTitle = (TextView) convertView.findViewById(R.id.sub_item_title_textView);
        TextView textViewSubItemsSubTitle = (TextView) convertView.findViewById(R.id.sub_item_subtitle_textView);

        SubItemClass subItemClass = (SubItemClass) getItem(position);
        icon.setImageResource(subItemClass.getIcon());
        textViewSubItemsTitle.setText(subItemClass.getSubItemTitle());
        textViewSubItemsSubTitle.setText(subItemClass.getSubItemSubTitle());

        return convertView;
    }
}

package com.example.robi10minschool;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

public class ExpandableLIstViewAdapter extends BaseExpandableListAdapter {

    private List<String> listMainItems;
    private HashMap<String, List<SubItemClass>> listSubItems;
    private Context context;

    public ExpandableLIstViewAdapter(Context context, List<String> listMainItems, HashMap<String, List<SubItemClass>> listSubItems) {
        this.context = context;
        this.listMainItems = listMainItems;
        this.listSubItems = listSubItems;
    }

    @Override
    public int getGroupCount() {
        return listMainItems.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return listSubItems.get(getGroup(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return listMainItems.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return listSubItems.get(getGroup(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.main_item_layout, null);
        }

        TextView textViewMainItemsTitle = (TextView) convertView.findViewById(R.id.main_item_textView);

        textViewMainItemsTitle.setText((String) getGroup(groupPosition));

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.sub_item_layout, null);
        }

        ImageView icon = (ImageView) convertView.findViewById(R.id.sub_item_icon);
        TextView textViewSubItemsTitle = (TextView) convertView.findViewById(R.id.sub_item_title_textView);
        TextView textViewSubItemsSubTitle = (TextView) convertView.findViewById(R.id.sub_item_subtitle_textView);

        SubItemClass subItemClass = (SubItemClass) getChild(groupPosition, childPosition);
        icon.setImageResource(subItemClass.getIcon());
        textViewSubItemsTitle.setText(subItemClass.getSubItemTitle());
        textViewSubItemsSubTitle.setText(subItemClass.getSubItemSubTitle());

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
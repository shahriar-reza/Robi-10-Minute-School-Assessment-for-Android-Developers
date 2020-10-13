package com.example.robi10minschool;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ExpandableListView expandableListView = (ExpandableListView) findViewById(R.id.expandable_listView);
        ListView listView = (ListView) findViewById(R.id.listView);

        final List<String> mainItemsLists = new ArrayList<>();
        mainItemsLists.add("Chapter 1");
        mainItemsLists.add("Chapter 2");
        
        List<SubItemClass> mainItemsLists1 = new ArrayList<>();
        mainItemsLists1.add(new SubItemClass("Video 1_1", "", R.drawable.ic_ondemand_video_black_24dp));
        mainItemsLists1.add(new SubItemClass("Document 1_1", "Author 1_1", R.drawable.ic_insert_drive_file_black_24dp));
        mainItemsLists1.add(new SubItemClass("Video 1_2", "", R.drawable.ic_ondemand_video_black_24dp));

        List<SubItemClass> mainItemsList2 = new ArrayList<>();
        mainItemsList2.add(new SubItemClass("Document 2_1", "Author 2_1", R.drawable.ic_insert_drive_file_black_24dp));
        mainItemsList2.add(new SubItemClass("Video 2_1", "", R.drawable.ic_ondemand_video_black_24dp));
        mainItemsList2.add(new SubItemClass("Video 2_2", "", R.drawable.ic_ondemand_video_black_24dp));
        mainItemsList2.add(new SubItemClass("Audio 2_1", "", R.drawable.ic_audiotrack_black_24dp));

        final HashMap<String, List<SubItemClass>> itemsGroups = new HashMap<>();
        itemsGroups.put(mainItemsLists.get(0), mainItemsLists1);
        itemsGroups.put(mainItemsLists.get(1), mainItemsList2);

        final ExpandableLIstViewAdapter expandableLIstViewAdapter = new ExpandableLIstViewAdapter(this, mainItemsLists, itemsGroups);

        expandableListView.setAdapter(expandableLIstViewAdapter);

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Toast.makeText(
                        getApplicationContext(),
                        itemsGroups.get(
                                mainItemsLists.get(groupPosition)).get(
                                        childPosition).getSubItemTitle()
                        , Toast.LENGTH_SHORT
                ).show();
                return false;
            }
        });

        final List<SubItemClass> listItems = new ArrayList<>();
        listItems.add(new SubItemClass("Video 3_0", "", R.drawable.ic_ondemand_video_black_24dp));
        listItems.add(new SubItemClass("Document 4_0", "Author 4_0", R.drawable.ic_insert_drive_file_black_24dp));

        final ListViewAdapter listViewAdapter = new ListViewAdapter(listItems, this);

        listView.setAdapter(listViewAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(
                        getApplicationContext(),
                        listItems.get(position).getSubItemTitle()
                        , Toast.LENGTH_SHORT
                ).show();
            }
        });

    }
}

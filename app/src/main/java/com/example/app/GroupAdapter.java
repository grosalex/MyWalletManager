package com.example.app;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by William on 01/04/2014.
 */
public class GroupAdapter extends ArrayAdapter<Group> {
    private List<Group> groupCollection;
    private final LayoutInflater mInflater;
    public GroupAdapter(Context context) {
        super(context, R.layout.group_item);
        //this.groupCollection = objects;
        mInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setData(List<Group> data) {
        clear();
        if(data!=null){
            for(Group grp : data) {
                add(grp);
            }
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (convertView == null) {
            v = mInflater.inflate(R.layout.group_item,parent,false);
        } else {
            v = convertView;
        }

        Group item = getItem(position);
        TextView textView = (TextView) v.findViewById(R.id.textView);
        textView.setText(item.getName());
        return v;
    }

}
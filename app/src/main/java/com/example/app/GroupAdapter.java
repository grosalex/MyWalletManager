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
public class GroupAdapter extends ArrayAdapter<String> {
    private List<Group> groupCollection;
    private Context ctx;
    public GroupAdapter(Context context, int resource, int textViewResourceId, List objects) {
        super(context, resource, textViewResourceId, objects);
        this.groupCollection = objects;
        this.ctx = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.group_item, parent, false);
        TextView textView = (TextView) rowView.findViewById(R.id.textView);
        textView.setText(groupCollection.get(position).getName());
        return rowView;
    }

}
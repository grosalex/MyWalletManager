package com.example.app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by William on 01/04/2014.
 */
public class UserAdapter extends ArrayAdapter <String> {
    private List<User> userCollection;
    private Context ctx;

    public UserAdapter(Context context, int resource, int textViewResourceId, List objects) {
        super(context, resource, textViewResourceId, objects);
        this.userCollection = objects;
        this.ctx = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.user_item, parent, false);
        TextView textView = (TextView) rowView.findViewById(R.id.textView);
        textView.setText(userCollection.get(position).getName());

        return rowView;
    }
}

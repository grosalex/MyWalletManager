package com.example.app;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

/**
 * Created by grosalex on 20/03/14.
 */
public class PlaceholderFragment extends ListFragment {

    //Doing string array for example...
    String[] grpList = new String[] {"grp1","grp2","grp3","grp4","grp5"};

    public PlaceholderFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                inflater.getContext(), android.R.layout.simple_list_item_1,grpList);
        setListAdapter(adapter);
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
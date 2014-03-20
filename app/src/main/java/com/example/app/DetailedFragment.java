package com.example.app;

import android.app.Fragment;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

/**
 * Created by grosalex on 20/03/14.
 */
public class DetailedFragment extends ListFragment {
    Group currentGroup;
    String[] userList = new String[] {"usr1","usr2","usr3","usr4","usr5"};

    public DetailedFragment(Group currentGroup) {
        this.currentGroup=currentGroup;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                inflater.getContext(), R.layout.user_item,R.id.textView,userList);
        setListAdapter(adapter);
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}

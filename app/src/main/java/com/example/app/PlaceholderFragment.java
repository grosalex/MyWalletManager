package com.example.app;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by grosalex on 20/03/14.
 */
public class PlaceholderFragment extends ListFragment {
    private List<Group> groupCollection;

    //Doing string array for example...
    String[] grpList = new String[] {"grp1","grp2","grp3","grp4","grp5"};

    public PlaceholderFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                inflater.getContext(), android.R.layout.group_item,grpList);
        setListAdapter(adapter);
        return super.onCreateView(inflater, container, savedInstanceState);
    }
    public Group findByName(String name) {
        for (int i = 0; i < groupCollection.size(); i++) {
            if (this.groupCollection[i].getName() == name) {
                return this.groupCollection[i];
            }
        }
        return null;
    }
    public void groupDetail(View view) {
        String groupName = ((TextView)view).getText().toString();
        Group result = this.findByName(groupName);
        getFragmentManager().beginTransaction().replace(R.id.mainFragment, new DetailedFragment(result));
        getFragmentManager().beginTransaction().commit();
    }

    public void addGroup(View view) {
    }
}
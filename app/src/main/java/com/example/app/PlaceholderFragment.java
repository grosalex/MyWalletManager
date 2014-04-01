package com.example.app;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by grosalex on 20/03/14.
 */
public class PlaceholderFragment extends ListFragment {
    private List<Group> groupCollection = new LinkedList<Group>();
    Group grp1 = new Group("grp1");
    Group grp2 = new Group("grp2");
    Group grp3 = new Group("grp3");
    GroupAdapter adapter;

    //Doing string array for example...
    //String[] grpList = new String[] {"grp1","grp2","grp3","grp4","grp5"};

    public PlaceholderFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        /*
        groupCollection.add(grp1);
        groupCollection.add(grp3);
        groupCollection.add(grp2);
        */
        this.adapter = new GroupAdapter(inflater.getContext(), R.layout.group_item,R.id.textView,groupCollection);
        setListAdapter(this.adapter);
        View view = inflater.inflate(R.layout.fragment_main,container,false);
        return view;
    }
    public Group findByName(String name) {
        for (int i = 0; i < groupCollection.size(); i++) {
            if (groupCollection.get(i).getName() == name) {
                return groupCollection.get(i);
            }
        }
        return null;
    }

    public void onListItemClick(ListView l, View v, int position, long id) {

        Group item = (Group) getListAdapter().getItem(position);
        Toast.makeText(getActivity(), item.getName() + " selected", Toast.LENGTH_SHORT).show();
        Group result = this.findByName(item.getName());
        //getFragmentManager().beginTransaction().replace(R.id.container, new DetailedFragment(result));
        //getFragmentManager().beginTransaction().commit();

        DetailedFragment d = new DetailedFragment(result);
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        ft.replace(R.id.container,d);
        ft.addToBackStack(null);
        ft.commit();
    }
    public void pushGroup(Group newGroup){
        this.groupCollection.add(newGroup);
        this.adapter.notifyDataSetChanged();
    }


}
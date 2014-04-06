package com.example.app;

import android.app.ActionBar;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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

    private ArrayAdapter<Group> adapter ;

    public PlaceholderFragment() {
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.actionbar_group,menu);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        setHasOptionsMenu(true);
        ActionBar ab = getActivity().getActionBar();
        ColorDrawable color = new ColorDrawable(Color.parseColor("#0e207f"));
        ab.setBackgroundDrawable(color);

        adapter = new ArrayAdapter<Group>(inflater.getContext(),R.layout.group_item, R.id.textView,groupCollection);
        setListAdapter(adapter);

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

        Group item = adapter.getItem(position);
        Group result = findByName(item.getName());

        DetailedFragment d = new DetailedFragment(result);
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        ft.replace(R.id.container,d,"fragmentGroupDetail");
        ft.addToBackStack(null);
        ft.commit();
    }
    public void pushGroup(Group newGroup){
        this.groupCollection.add(newGroup);
        this.adapter.notifyDataSetChanged();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.addgroup:
                AddGroupFragment addGroupFragment = new AddGroupFragment();
                addGroupFragment.show(getFragmentManager(),"showGroupForm");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
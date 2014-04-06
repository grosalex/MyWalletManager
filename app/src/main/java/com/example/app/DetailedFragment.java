package com.example.app;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by grosalex on 20/03/14.
 */
public class DetailedFragment extends ListFragment {
    Group currentGroup;
    private List<User> theUserList=new LinkedList<User>();
    private ArrayAdapter<User> adapter;


    public DetailedFragment(Group currentGroup) {
        this.currentGroup=currentGroup;
        if(this.currentGroup.getUserCollection()!=null) {
            this.theUserList = this.currentGroup.getUserCollection();
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Toast.makeText(getActivity(), "In Detailed Fragment", Toast.LENGTH_SHORT).show();
        this.adapter = new ArrayAdapter<User>(inflater.getContext(),R.layout.user_item, R.id.textView,theUserList);
        setListAdapter(this.adapter);
        View view = inflater.inflate(R.layout.fragment_detail,null);
        return view;
    }
    public void pushUser(User newUser){
        this.currentGroup.addUser(newUser);
        this.adapter.notifyDataSetChanged();
        //adapter.add(newUser);
    }
    public void onListItemClick(ListView l, View v, int position, long id) {
        User item = (User) getListAdapter().getItem(position);
        AddDetteFragment addDetteFragment = new AddDetteFragment(item, this.currentGroup);
        addDetteFragment.show(getFragmentManager(),"addDetteFrag");

    }

}

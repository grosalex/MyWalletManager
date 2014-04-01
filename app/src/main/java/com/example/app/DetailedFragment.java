package com.example.app;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by grosalex on 20/03/14.
 */
public class DetailedFragment extends ListFragment {
    Group currentGroup;
   // String[] userList = new String[] {"usr1","usr2","usr3","usr4","usr5"};
    private List<User> theUserList= new LinkedList<User>();
    private ArrayAdapter<String> adapter;

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

        this.adapter = new ArrayAdapter<String>(
                inflater.getContext(), R.layout.user_item,R.id.textView,(List)this.theUserList);
        setListAdapter(this.adapter);
        View view = inflater.inflate(R.layout.fragment_detail,null);
        return view;
    }
    public void pushUser(User newUser){
        this.theUserList.add(newUser);
        this.adapter.notifyDataSetChanged();
        this.currentGroup.addUser(newUser);
    }


}

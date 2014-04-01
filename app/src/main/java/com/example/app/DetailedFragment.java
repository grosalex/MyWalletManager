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

import java.util.List;

/**
 * Created by grosalex on 20/03/14.
 */
public class DetailedFragment extends ListFragment {
    Group currentGroup;
    String[] userList = new String[] {"usr1","usr2","usr3","usr4","usr5"};
    private List<User> theUserList;


    public DetailedFragment(Group currentGroup) {
        this.currentGroup=currentGroup;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Toast.makeText(getActivity(), "In Detailed Fragment", Toast.LENGTH_SHORT).show();

        UserAdapter adapter = new UserAdapter(
                inflater.getContext(), R.layout.user_item,R.id.textView,theUserList);
        setListAdapter(adapter);
        View view = inflater.inflate(R.layout.fragment_detail,null);
        return view;
    }


}

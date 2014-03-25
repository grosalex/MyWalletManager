package com.example.app;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.example.app.PlaceholderFragment.*;

public class MainActivity extends Activity {
    PlaceholderFragment grplist = new PlaceholderFragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fm = getFragmentManager();
        PlaceholderFragment pf = new PlaceholderFragment();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.container,pf);
        ft.commit();
    }

    public void newUser(View view) {
        AddUserFragment userFragment = new AddUserFragment();
        userFragment.show(getFragmentManager(),"showUserForm");

    }
    public void newGroup(View view) {
        //Toast.makeText(this, "new group", Toast.LENGTH_SHORT).show();
        AddGroupFragment addGroupFragment = new AddGroupFragment();
        addGroupFragment.show(getFragmentManager(),"showGroupForm");
    }

    public void createGroup(View view) {

    }

    public void createUser(View view) {
    }
}

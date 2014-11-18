package com.example.app;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActionBar;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import android.support.v7.widget.Toolbar.*;
import android.widget.Toolbar;

import static com.example.app.PlaceholderFragment.*;

public class MainActivity extends Activity {
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        ActionBar ab = getActionBar();
        ColorDrawable color = new ColorDrawable(Color.parseColor("#0e207f"));
//        ab.setBackgroundDrawable(color);
//       Window.setStatusBarColor(color);
        setActionBar(new Toolbar(getApplicationContext()));
        FragmentManager fm = getFragmentManager();
        PlaceholderFragment pf = new PlaceholderFragment();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.container,pf,"fragmentListGroup");
        ft.commit();
    }

    public void newUser(View view) {
        AddUserFragment userFragment = new AddUserFragment();
        userFragment.show(getFragmentManager(),"showUserForm");

    }
    public void newGroup(View view) {
        AddGroupFragment addGroupFragment = new AddGroupFragment();
        addGroupFragment.show(getFragmentManager(),"showGroupForm");
    }

}

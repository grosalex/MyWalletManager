package com.example.app;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by grosalex on 25/03/14.
 */
public class AddGroupFragment extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();


        builder.setView(inflater.inflate(R.layout.create_group,null));
        builder.setTitle("Nouveau groupe");
        builder.setPositiveButton("Créer le groupe", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int id) {
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                PlaceholderFragment current_frag = (PlaceholderFragment)fm.findFragmentByTag("fragmentListGroup");
                EditText nom = (EditText) getDialog().findViewById(R.id.groupNameText);
                Group current_group = new Group(nom.getText().toString());
                Toast.makeText(getActivity(), current_group.getName(), Toast.LENGTH_SHORT).show();
                current_frag.pushGroup(current_group);
                dialog.dismiss();
            }
        });
        builder.setNegativeButton("Annuler", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }
        });

        return builder.create();
    }
}

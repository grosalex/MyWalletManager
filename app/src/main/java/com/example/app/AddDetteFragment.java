package com.example.app;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

/**
 * Created by grosalex on 01/04/14.
 */
public class AddDetteFragment extends DialogFragment {
    private User current_user;
    private Group current_group;
    public AddDetteFragment(User user, Group group){
        this.current_user=user;
        this.current_group=group;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        builder.setTitle("Ajouter une dette");
        builder.setView(inflater.inflate(R.layout.create_dette,null));

        Spinner mySpinner = (Spinner)inflater.inflate(R.layout.create_dette,null).findViewById(R.id.spinnerUser);
        ArrayAdapter<User> adapter = new ArrayAdapter<User>(inflater.getContext(),android.R.layout.simple_spinner_item,android.R.layout.simple_spinner_dropdown_item,this.current_group.getUserCollection());
        mySpinner.setAdapter(adapter);

        builder.setNegativeButton("Annuler", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.setPositiveButton("Ajouter", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        return builder.create();
    }
}

package com.example.app;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by grosalex on 25/03/14.
 */
public class AddUserFragment extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        builder.setTitle("Nouvel utilisateur");
        builder.setView(inflater.inflate(R.layout.create_user, null));
        builder.setNegativeButton("Annuler",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.setPositiveButton("Créer",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                DetailedFragment current_frag = (DetailedFragment)fm.findFragmentByTag("fragmentGroupDetail");
                EditText nom = (EditText) getDialog().findViewById(R.id.editUserText);
                User current_user = new User(nom.getText().toString());

                current_frag.pushUser(current_user);
                dialog.dismiss();

            }
        });
        return builder.create();
    }

}

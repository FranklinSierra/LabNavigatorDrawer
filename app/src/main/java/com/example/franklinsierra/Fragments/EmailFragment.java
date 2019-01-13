package com.example.franklinsierra.Fragments;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.franklinsierra.labnavigatordrawer.R;


public class EmailFragment extends Fragment {

    private FloatingActionButton fabEmail;
    //private EditText editTextEmail;
    private TextView textViewEmailFrag;


    public EmailFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View vista = inflater.inflate(R.layout.fragment_email, container, false);

        //ubioo los elementos

        fabEmail = (FloatingActionButton) vista.findViewById(R.id.fab_email);
        //editTextEmail = (EditText) vista.findViewById(R.id.editTextCreateEmail);
        textViewEmailFrag = (TextView) vista.findViewById(R.id.textViewEmailFragment);

        fabEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlertCreatingEmail("EMAIL", "Type your email to be displayed in the middle of the screen");
            }
        });

        return vista;
    }


    //  +++Alert cuando presionan el FAB    ++++    //
    private void showAlertCreatingEmail(String title, String msj) {
        AlertDialog.Builder alert = new AlertDialog.Builder(getContext());

        //pongo el titulo y el msj
        if (!title.isEmpty()) alert.setTitle(title);
        if (!msj.isEmpty()) alert.setMessage(msj);

        //inflo la vista del alertDialog
        View view = LayoutInflater.from(getContext()).inflate(R.layout.dialog_create_email, null);

        //Recojo lo que escriben en el popup
        final EditText input = (EditText) view.findViewById(R.id.editTextCreateEmail);

        //le paso la vista al alertDialog
        alert.setView(view);

        alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String email = input.getText().toString().trim();
                if (!email.isEmpty()) {
                    showEmail(email);
                }
            }
        }).setNegativeButton("CANCEL", null).show();


    }


    //  ++++    Metodo que muestra lo digitado en el Fragment   ++++    //
    private void showEmail(String email) {
        textViewEmailFrag.setText(email);
    }

}

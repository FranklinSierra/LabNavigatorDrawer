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
import android.widget.Switch;
import android.widget.TextView;

import com.example.franklinsierra.labnavigatordrawer.R;


public class AlertsFragment extends Fragment {

    private FloatingActionButton fabAlert;
    private TextView textViewAlarmFrag;


    public AlertsFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View vista = inflater.inflate(R.layout.fragment_alerts, container, false);

        //ubico los elementos
        fabAlert = (FloatingActionButton) vista.findViewById(R.id.fab_alert);
        textViewAlarmFrag = (TextView) vista.findViewById(R.id.textViewAlertFragment);

        fabAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlertAlarm("EMAIL", "Allow the alerts display in the middle of the screen");
            }
        });
        return vista;
    }

    private void showAlertAlarm(String title, String msj) {
        AlertDialog.Builder alert = new AlertDialog.Builder(getContext());

        if (!title.isEmpty()) alert.setTitle(title);
        if (!msj.isEmpty()) alert.setMessage(msj);

        View vista = LayoutInflater.from(getContext()).inflate(R.layout.dialog_create_alert, null);
        final Switch switchAlert = (Switch) vista.findViewById(R.id.switch_alert);
        alert.setView(vista);

        alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (switchAlert.isChecked()) {
                    showAlertEnable();
                } else {
                    showAlertDesable();
                }
            }
        }).setNegativeButton("Cancel", null).show();
    }


    //  ++++    Metodos que muestra el contenido en el fragment  ++++    //
    private void showAlertEnable() {
        textViewAlarmFrag.setText("Alerts Enabled");
    }

    private void showAlertDesable() {
        textViewAlarmFrag.setText("Alerts Disabled");
    }

}

package com.example.franklinsierra.Fragments;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.franklinsierra.labnavigatordrawer.R;


public class InfoFragment extends Fragment {

    private FloatingActionButton fabInfo;


    public InfoFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View vista = inflater.inflate(R.layout.fragment_info, container, false);
        fabInfo = (FloatingActionButton) vista.findViewById(R.id.fab_info);

        fabInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInfo("Information",
                        "This alert is just to show an informative message to the user, nothing to interact");
            }
        });

        return vista;
    }


    //  ++++    Popup solo muesta info  ++++    //
    private void showInfo(String title, String msj) {
        AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());

        alert.setTitle(title);
        alert.setMessage(msj);
        alert.setNeutralButton("Go it",null);
        alert.show();
    }

}

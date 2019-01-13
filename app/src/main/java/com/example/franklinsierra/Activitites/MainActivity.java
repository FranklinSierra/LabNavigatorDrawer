package com.example.franklinsierra.Activitites;


import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import com.example.franklinsierra.Fragments.AlertsFragment;
import com.example.franklinsierra.Fragments.EmailFragment;
import com.example.franklinsierra.Fragments.InfoFragment;
import com.example.franklinsierra.labnavigatordrawer.R;


public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener{

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.navView);

        Switch switchBtn=(Switch)navigationView.getMenu().findItem(R.id.switch_nav_options).getActionView();
        switchBtn.setOnCheckedChangeListener(this);
        confToolbar();
        setDefaultFragment();


        //logica cuando tocan algun elemento del menu
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                boolean fragmentTransaccion = false;
                Fragment fragment = null;


                switch (item.getItemId()) {

                    case R.id.optionEmail:
                        //Creo un fragment segun el item clickeado

                        fragmentTransaccion = true;
                        fragment = new EmailFragment();
                        break;

                    case R.id.optionAlerts:

                        fragmentTransaccion = true;
                        fragment = new AlertsFragment();
                        break;

                    case R.id.optionInformation:

                        fragmentTransaccion = true;
                        fragment = new InfoFragment();
                        break;
                }

                if (fragmentTransaccion) {
                    changeFragment(fragment, item);
                    //cierro el NavigatiorMenu
                    drawerLayout.closeDrawers();
                }
                return true;
            }
        });



    }


    //  ++++ Para que por defecto este el fragment del item#1   ++++    //
    private void setDefaultFragment() {
        changeFragment(new EmailFragment(), navigationView.getMenu().getItem(0));
    }


    //  ++++    Logica que permite cambiar de fragment de acuerdo al item   ++++    //
    private void changeFragment(Fragment fragment, MenuItem item) {
        getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, fragment).commit();

        //marcamos como activo el item seleccionado
        item.setChecked(true);

        //cambio el titulo del action bar por el titulo del item
        getSupportActionBar().setTitle(item.getTitle());
    }


    private void confToolbar() {
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        //pongo como action bar el toolbar
        setSupportActionBar(myToolbar);
        //le pongo el icono del Navigator Drawer
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_home);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    //logica cuando tocan el icono home (se llama cuando lo tocan)
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }


    //  ++++    Metodo que permite interactuar con el switch del navigationView ++++    //
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked){
            Toast.makeText(MainActivity.this, "The option is checked", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(MainActivity.this, "The option is unchecked", Toast.LENGTH_SHORT).show();
        }
    }
}

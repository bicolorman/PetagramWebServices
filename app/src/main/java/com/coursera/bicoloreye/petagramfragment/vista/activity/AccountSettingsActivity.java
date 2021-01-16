package com.coursera.bicoloreye.petagramfragment.vista.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.coursera.bicoloreye.petagramfragment.R;
import com.google.android.material.snackbar.Snackbar;

public class AccountSettingsActivity extends AppCompatActivity {

    private Snackbar snackbar;
    public String cuenta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_settings);
        Toolbar miActionBar= (Toolbar) findViewById(R.id.miactionBar);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        SharedPreferences sharedPreferences = getSharedPreferences("Preferencias", Context.MODE_PRIVATE);
        String cuenta= sharedPreferences.getString("cuenta","petagram_4ndr01d");
        ((EditText)findViewById(R.id.etCuentaUsuario)).setText(cuenta);

        findViewById(R.id.btGuardarCuenta).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getSharedPreferences("Preferencias", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor= sharedPreferences.edit();
                EditText etCuenta=(EditText)findViewById(R.id.etCuentaUsuario);
                String cuenta=etCuenta.getText().toString();
                editor.putString("cuenta",cuenta);
                editor.commit();
                snackbar= Snackbar.make(view, "Cuenta Guardada", Snackbar.LENGTH_LONG);
                snackbar.setText(R.string.mensaje_cuenta_guardada);
                snackbar.show();
            }
        });
    }





}
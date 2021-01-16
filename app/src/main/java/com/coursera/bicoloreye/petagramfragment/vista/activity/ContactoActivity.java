package com.coursera.bicoloreye.petagramfragment.vista.activity;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.coursera.bicoloreye.petagramfragment.R;
import com.coursera.bicoloreye.petagramfragment.util.CorreoElectronico;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

public class ContactoActivity extends AppCompatActivity {

    private Snackbar snackbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);
        Toolbar miActionBar= (Toolbar) findViewById(R.id.miactionBar);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        findViewById(R.id.btEnviarComentarios).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int SDK_INT = android.os.Build.VERSION.SDK_INT;
                if (SDK_INT > 8)
                {
                    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                            .permitAll().build();
                    StrictMode.setThreadPolicy(policy);
                    snackbar= Snackbar.make(view, "...", Snackbar.LENGTH_LONG);
                    snackbar.setText(R.string.mensaje_espera);
                    snackbar.show();
                    enviarComentario(view);

                }


            }
        });
    }

    public void enviarComentario(View view){

        TextInputEditText nombreContacto=(TextInputEditText)findViewById(R.id.etNombreFormulario);
        TextInputEditText correoElectronicoContacto=(TextInputEditText)findViewById(R.id.etCorreoFormulario);
        TextInputEditText mensajeContacto=(TextInputEditText)findViewById(R.id.etMensajeFormulario);

        if(!(nombreContacto.getText().toString().trim().isEmpty()||correoElectronicoContacto.getText().toString().trim().isEmpty()||mensajeContacto.getText().toString().trim().isEmpty())){





            CorreoElectronico nuevoMensajeCorreo=new CorreoElectronico();
            boolean envio;
            envio=nuevoMensajeCorreo.enviarCorreoElectronico("android@bicoloreye.com", correoElectronicoContacto.getText().toString(), getResources().getString(R.string.mensaje_subject),mensajeContacto.getText().toString());
            if(envio){
                snackbar.setText(R.string.mensaje_correo_satisfactorio);
                snackbar.show();

            }
            else {
                snackbar.setText(R.string.mensaje_correo_insatisfactorio);
                snackbar.show();
            }
        }else {
            Toast.makeText(this,R.string.mensaje_vacio,Toast.LENGTH_SHORT).show();
        }

        System.out.println(nombreContacto.getText());
    }
}
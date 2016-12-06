package com.caparros.daniel.formulario;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Mostrar_Datos extends AppCompatActivity {

    private TextView tvNombre,tvFecha, tvTelefono,tvEmail,tvDescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar__datos);


        tvNombre = (TextView) findViewById(R.id.tvNombre);
        tvTelefono = (TextView) findViewById(R.id.tvTelefono);
        tvEmail = (TextView) findViewById(R.id.tvEmail);
        tvDescripcion=(TextView) findViewById(R.id.tvDescripcion);
        tvFecha=(TextView) findViewById(R.id.tvFecha);


        Bundle parametros = getIntent().getExtras();

        String nombre = parametros.getString("nombre");
        String fecha=parametros.getString("fecha");
        String telefono = parametros.getString("telefono");
        String email = parametros.getString("email");
        String descripcion=parametros.getString("descripcion");



        tvNombre.setText(nombre);
        tvFecha.setText(fecha);
        tvTelefono.setText(telefono);
        tvEmail.setText(email);
        tvDescripcion.setText(descripcion);


    }

    public void btnEditar_onClick(View v) {


        Intent intent = getIntent();
        intent.putExtra("nombre",tvNombre.getText().toString());
        intent.putExtra("fecha",tvFecha.getText().toString());
        intent.putExtra("telefono",tvTelefono.getText().toString());
        intent.putExtra("email",tvEmail.getText().toString());
        intent.putExtra("descripcion",tvDescripcion.getText().toString());

        setResult(RESULT_OK,intent);
        finish();
    }
}

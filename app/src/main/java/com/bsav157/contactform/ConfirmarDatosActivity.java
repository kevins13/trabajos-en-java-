package com.bsav157.contactform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textview.MaterialTextView;

public class ConfirmarDatosActivity extends AppCompatActivity {

    private MaterialTextView fecha;
    private MaterialTextView nombre;
    private MaterialTextView telefono;
    private MaterialTextView email;
    private MaterialTextView descripcion;
    private MaterialButton editar;
    private String[] args;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_datos);

        fecha = findViewById(R.id.tv_fecha);
        nombre = findViewById(R.id.tv_nombre);
        telefono = findViewById(R.id.tv_telefono);
        email = findViewById(R.id.tv_email);
        descripcion = findViewById(R.id.tv_descripcion);
        editar = findViewById(R.id.editar_datos);

        getExtras();
        setData();

        editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getApplication(), MainActivity.class);
                in.putExtra("args", args);
                startActivity(in);

            }
        });

    }

    private void getExtras(){
        args = new String[5];
        args[0] = getIntent().getExtras().getString("nombre");
        args[1] = getIntent().getExtras().getString("date");
        args[2] = getIntent().getExtras().getString("telefono");
        args[3] = getIntent().getExtras().getString("email");
        args[4] = getIntent().getExtras().getString("descripcion");
    }

    private void setData(){
        nombre.setText(args[0]);
        fecha.setText("Fecha de nacimiento: " + args[1]);
        telefono.setText("Tel: " + args[2]);
        email.setText("Email: " + args[3]);
        descripcion.setText("Descripción: " + args[4]);
    }
}
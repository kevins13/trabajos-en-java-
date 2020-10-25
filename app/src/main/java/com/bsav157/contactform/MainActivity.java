package com.bsav157.contactform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {


    private DatePicker datePicker;
    private TextInputEditText nombre;
    private TextInputEditText telefono;
    private TextInputEditText email;
    private TextInputEditText descripcion;
    private MaterialButton siguiente;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        datePicker = findViewById(R.id.picker_fecha);
        nombre = findViewById(R.id.nombre_completo);
        telefono = findViewById(R.id.telefono);
        email = findViewById(R.id.email);
        descripcion = findViewById(R.id.descripcion);
        siguiente = findViewById(R.id.button_siguiente);


        if(getIntent().getExtras() != null){
            String[] args = getIntent().getExtras().getStringArray("args");
            nombre.setText(args[0]);
            telefono.setText(args[2]);
            email.setText(args[3]);
            descripcion.setText(args[4]);

            String[] dat = args[1].split("/");
            datePicker.updateDate(Integer.parseInt(dat[2]), Integer.parseInt(dat[0]) - 1 , Integer.parseInt(dat[1]));
        }


        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getApplication(), ConfirmarDatosActivity.class);
                in.putExtra("nombre", Objects.requireNonNull(nombre.getText()).toString());
                in.putExtra("telefono", Objects.requireNonNull(telefono.getText()).toString());
                in.putExtra("email", Objects.requireNonNull(email.getText()).toString());
                in.putExtra("descripcion", Objects.requireNonNull(descripcion.getText()).toString());
                in.putExtra("date", Objects.requireNonNull((datePicker.getMonth() + 1) + "/" + datePicker.getDayOfMonth()+ "/" + datePicker.getYear()));
                startActivity(in);
            }
        });

    }
}
package com.example.primeraentregagreengarden;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class PantallaRegistroAbono extends AppCompatActivity {

    private EditText abono;
    private EditText consumoAbono;
    private Spinner spMesAbono;
    private Button btnGuardarAbono;
    private Button btnRegresarAbono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_registro_abono);
        inicializar();
        btnGuardarAbono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validacion_vacio();
                validacion_formato();
            }
        });
        btnRegresarAbono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentRegresoAbono=new Intent(PantallaRegistroAbono.this,PantallaCategorias.class);
                startActivity(intentRegresoAbono);
            }
        });
    }

    private void inicializar(){
        abono=findViewById(R.id.txtAbono);
        consumoAbono=findViewById(R.id.txtConsumoAbono);
        spMesAbono=findViewById(R.id.spMesAbono);
        String arrayMes[]={"Seleccione Mes","Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio",
                "Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
        ArrayAdapter spiner_mes=new ArrayAdapter(this, android.R.layout.simple_spinner_item , arrayMes);
        spMesAbono.setAdapter(spiner_mes);
        btnGuardarAbono=findViewById(R.id.btnGuardarAbono);
        btnRegresarAbono=findViewById(R.id.btnRegresarAbono);
    }
    private void validacion_vacio(){
        abono=findViewById(R.id.txtAbono);
        String datoReturn=abono.getText().toString();
        consumoAbono=findViewById(R.id.txtConsumoAbono);
        String datoReturn2=consumoAbono.getText().toString();
        if (datoReturn.isEmpty()){
            Toast.makeText(this,"Debe ingrsar el o los datos faltantes",Toast.LENGTH_LONG).show();
        }
        if (datoReturn2.isEmpty()){
            Toast.makeText(this,"Debe ingrsar el o los datos faltantes",Toast.LENGTH_LONG).show();
        }
    }
    private void validacion_formato(){
        String datoReturn=consumoAbono.getText().toString();
        try {
            int num=Integer.parseInt(datoReturn);
        }
        catch (Exception err){
            Toast.makeText(this, "Formato incorrecto", Toast.LENGTH_LONG).show();
        }
    }
}
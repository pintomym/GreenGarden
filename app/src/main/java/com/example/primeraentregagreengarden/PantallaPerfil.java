package com.example.primeraentregagreengarden;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class PantallaPerfil extends AppCompatActivity {
    private Button btnLogOut;
    private Button btnCategoriasPerfil;
    private Button btnEstadisticasPerfil;
    private Button btnConsejosPerfil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_perfil);
        inicializar();
        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intenLogOut=new Intent(PantallaPerfil.this,PantallaInicioSesion.class);
                startActivity(intenLogOut);
            }
        });
        btnCategoriasPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentCategoria=new Intent(PantallaPerfil.this,PantallaCategorias.class);
                startActivity(intentCategoria);
            }
        });
        btnEstadisticasPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentEstad=new Intent(PantallaPerfil.this,PantallaEstadisticas.class);
                startActivity(intentEstad);
            }
        });
        btnConsejosPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentConsejo=new Intent(PantallaPerfil.this,PantallaConsejos.class);
                startActivity(intentConsejo);
            }
        });

    }
    private void inicializar() {
        btnLogOut = findViewById(R.id.btnLogOut);
        btnCategoriasPerfil=findViewById(R.id.btnCategoriasPerfil);
        btnEstadisticasPerfil=findViewById(R.id.btnEstadisticasPerfil);
        btnConsejosPerfil=findViewById(R.id.btnConsejosPerfil);
    }


}
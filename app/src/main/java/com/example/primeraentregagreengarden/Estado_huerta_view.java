package com.example.primeraentregagreengarden;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.echo.holographlibrary.Bar;
import com.echo.holographlibrary.BarGraph;

import java.util.ArrayList;

public class Estado_huerta_view extends AppCompatActivity {

    private BarGraph gb;
    private RecyclerView datos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estado_huerta_view);
        inicializar();
        grafBar();
    }

    private void inicializar(){
        gb = findViewById(R.id.graphBar);
        datos = findViewById(R.id.datos);
    }

    private void grafBar(){
        //Damos por hecho que el usuario quiere registrar estos meses
        String [] mes={"Enero","Febrero","Marzo"};
        //Con estos valores factura,consumo, ahorro
        int [] dat={9,5,7};

        ArrayList<Bar> points = new ArrayList<Bar>();


        for (int i = 0; i<mes.length; i++){
            Bar d = new Bar();
            d.setColor(Color.GREEN);
            d.setName(mes[i]);
            d.setValue(dat[i]);
            points.add(d);
        }

        gb.setBars(points);
    }
}
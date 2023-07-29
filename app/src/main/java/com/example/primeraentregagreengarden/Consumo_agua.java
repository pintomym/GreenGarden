package com.example.primeraentregagreengarden;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.echo.holographlibrary.Bar;
import com.echo.holographlibrary.BarGraph;

import java.util.ArrayList;
import java.util.HashMap;

public class Consumo_agua extends AppCompatActivity {

    private BarGraph gb;
    private Spinner servicio;
    private RecyclerView consEnerg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consumo_agua);
        inicializar();

        servicio.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                int j = j(servicio.getSelectedItem().toString());
                grafBar(servicio.getSelectedItem().toString(),j);
            } // to close the onItemSelected
            public void onNothingSelected(AdapterView<?> parent)
            {

            }
        });
    }

    private void inicializar(){
        gb = findViewById(R.id.graphBar);
        servicio = findViewById(R.id.servicio);
        consEnerg = findViewById(R.id.consEnerg);

        String arrayServ [] ={"Factura","Consumo","Ahorro"};
        ArrayAdapter<String> pr = new ArrayAdapter(this, android.R.layout.simple_spinner_item,arrayServ);
        servicio.setAdapter(pr);


        //Diccionario para tabla de datos
        HashMap<String, HashMap<String, Integer>> diccionario = new HashMap<>();

    }
    private int j (String select) {
        int j=0;
        switch (select) {
            case "Factura":
                j=0;
                break;
            case "Consumo":
                j=1;
                break;
            case "Ahorro":
                j=2;
                break;
        }

        return j;
    }
    private void grafBar(String select, int j){
        //Damos por hecho que el usuario quiere registrar estos meses
        String [] mes={"Enero","Febrero","Marzo"};
        //Con estos valores factura,consumo, ahorro
        int [] [] dat={{5,2,2},{1,2,5},{0,4,2}};

        ArrayList<Bar> points = new ArrayList<Bar>();


        for (int i = 0; i<mes.length; i++){
            Bar d = new Bar();
            d.setColor(Color.CYAN);
            d.setName(mes[i]);
            d.setValue(dat[j][i]);

            points.add(d);
        }

        gb.setBars(points);
    }

}
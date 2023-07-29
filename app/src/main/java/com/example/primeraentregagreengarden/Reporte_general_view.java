package com.example.primeraentregagreengarden;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.echo.holographlibrary.Bar;
import com.echo.holographlibrary.BarGraph;

import java.util.ArrayList;

public class Reporte_general_view extends AppCompatActivity {

    private BarGraph gb;
    private TextView dateInit, dateEnd, date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reporte_general_view);
        inicializar();
        grafBar();

    }

    private void inicializar(){
        gb = (BarGraph) findViewById(R.id.graphBar);
        dateInit = findViewById(R.id.dateInit);
        dateEnd = findViewById(R.id.dateEnd);
        date = findViewById(R.id.date);
    }

    private void grafBar(){
        ArrayList<Bar> points = new ArrayList<Bar>();
        Bar d = new Bar();
        d.setColor(Color.RED);
        d.setName("Huerta");
        d.setValue(40);
        Bar d2 = new Bar();
        d2.setColor(Color.GREEN);
        d2.setName("Energia");
        d2.setValue(30);
        Bar d3 = new Bar();
        d3.setColor(Color.CYAN);
        d3.setName("Agua");
        d3.setValue(20);
        points.add(d);
        points.add(d2);
        points.add(d3);

        gb.setBars(points);
    }
}
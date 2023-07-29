package com.example.primeraentregagreengarden;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.echo.holographlibrary.Line;
import com.echo.holographlibrary.LineGraph;
import com.echo.holographlibrary.LinePoint;
import com.echo.holographlibrary.PieGraph;
import com.echo.holographlibrary.PieSlice;

public class PantallaEstadisticas extends AppCompatActivity {

    private Button bttnGeneral, bttnHuerta, bttnAgua, bttnEnergia;
    private TextView porcHuerta, porcEner, porcAgua;
    private PieGraph pg;
    private PieSlice ps1,ps2,ps3;

    private LineGraph lg1,lg2,lg3;
    private Line l1,l2,l3;
    private LinePoint p1,p2,p3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_estadisticas);
        inicializar();
        graficarPie();
        graficarLinea();

        bttnGeneral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentPrincipal = new Intent(PantallaEstadisticas.this,
                        Reporte_general_view.class);
                startActivity(intentPrincipal);
            }
        });

        bttnHuerta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intenSecundario = new Intent(PantallaEstadisticas.this,
                        Estado_huerta_view.class);
                startActivity(intenSecundario);
            }
        });

        bttnEnergia.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentSecundario = new Intent(PantallaEstadisticas.this,
                        Consumo_energia_view.class);
                startActivity(intentSecundario);
            }
        }));

        bttnAgua.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentSecundario = new Intent(PantallaEstadisticas.this,
                        Consumo_agua.class);
                startActivity(intentSecundario);
            }
        }));



    }

    private void inicializar(){
        bttnGeneral = (Button) findViewById(R.id.bttnGeneral);
        bttnHuerta = (Button) findViewById(R.id.bttnHuerta);
        bttnEnergia = (Button) findViewById(R.id.bttnEnergia);
        bttnAgua = (Button) findViewById(R.id.bttnAgua);

        porcHuerta = (TextView) findViewById(R.id.porcHuerta);
        porcEner = (TextView) findViewById(R.id.porcEner);
        porcAgua = (TextView) findViewById(R.id.porcAgua);

        porcHuerta.setBackgroundColor(Color.RED);
        porcEner.setBackgroundColor(Color.GREEN);
        porcAgua.setBackgroundColor(Color.CYAN);

    }
    private void graficarPie (){
        int item1=40,item2=32,item3=28;
        pg = (PieGraph) findViewById(R.id.graphGeneral);

        ps1 = new PieSlice();
        ps1.setColor(Color.RED);
        ps1.setValue(item1);

        ps2 = new PieSlice();
        ps2.setColor(Color.GREEN);
        ps2.setValue(item2);

        ps3 = new PieSlice();
        ps3.setColor(Color.CYAN);
        ps3.setValue(item3);

        pg.addSlice(ps1);
        pg.addSlice(ps2);
        pg.addSlice(ps3);
    }

    private void graficarLinea (){
        l1 = new Line();
        l2 = new Line();
        l3 = new Line();

        p1 = new LinePoint();
        p2 = new LinePoint();
        p3 = new LinePoint();

        lg1 = (LineGraph) findViewById(R.id.lineHuerta);
        lg2 = (LineGraph) findViewById(R.id.lineEnergia);
        lg3 = (LineGraph) findViewById(R.id.lineAgua);

        p1.setX(0);
        p1.setY(1);
        l1.addPoint(p1);
        p1 = new LinePoint();
        p1.setX(2);
        p1.setY(5);
        l1.addPoint(p1);
        p1 = new LinePoint();
        p1.setX(10);
        p1.setY(6);
        l1.addPoint(p1);
        l1.setColor(Color.RED);
        lg1.addLine(l1);
        lg1.setRangeY(0,10);

        int[] item1= {0,3,4}, item2= {3,0,8},item3 ={0,1,2};

        for (int i=0;i < item1.length;i++) {
            p2.setX(item1[i]);
            p2.setY(item3[i]);
            l2.addPoint(p2);

            p3.setX(item2[i]);
            p3.setY(item3[i]);
            l3.addPoint(p3);

            p2 =new LinePoint();
            p3 =new LinePoint();

        }

        l2.setColor(Color.GREEN);
        lg2.addLine(l2);
        lg2.setRangeY(0,10);

        l3.setColor(Color.CYAN);
        lg3.addLine(l3);
        lg3.setRangeY(0,10);


    }

}
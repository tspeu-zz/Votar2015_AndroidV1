package com.gofiodevelop.jm.votar2015_1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.gofiodevelop.jm.votar2015_1.adaptador.AdaptadorPortada;
import com.gofiodevelop.jm.votar2015_1.bd.Datos;
import com.gofiodevelop.jm.votar2015_1.vista.VistaPortada;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    private RecyclerView recycler;
    //private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;
    private AdaptadorPortada adapter;
        //base de Datos
    private Datos dataSource;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //va a tener el icono home
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Crear nuevo objeto base de datos.crea
        //dataSource = new Datos(this);


        List<VistaPortada> items = new ArrayList<>();
        // Inicializar Animes
        items.add(new VistaPortada(R.drawable.ele2015, "Partidos Politicos"));
        items.add(new VistaPortada(R.drawable.easel, "Estadisticas"));
        items.add(new VistaPortada(R.drawable.balloon, "Encuestas"));
        items.add(new VistaPortada(R.drawable.ads, "Informacion"));

        // Obtener el Recycler
        recycler = (RecyclerView) findViewById(R.id.rvList);
        recycler.setHasFixedSize(true);

        // Crear un nuevo adaptador
        adapter = new AdaptadorPortada(items);
        //setear el clistener a el metodo de su clase
        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos =  recycler.getChildLayoutPosition(v);
                switch (pos){
                    case 0 : Intent in = new Intent(MainActivity.this, ListaPartidos.class);
                             startActivity(in);
                             break;

                    case 1 : Toast.makeText(getApplicationContext(), "marcado POs 1", Toast.LENGTH_SHORT).show();
                        break;
                    case 2 : Toast.makeText(getApplicationContext(), "marcado  POs 2" , Toast.LENGTH_SHORT).show();
                        break;
                    case 3 : Toast.makeText(getApplicationContext(), "marcado  POs 3" , Toast.LENGTH_SHORT).show();
                        break;

                }

            }
        });


        // Usar un administrador para LinearLayout
        lManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(lManager);


        recycler.setAdapter(adapter);


/*//...


        final AdaptadorTitulares adaptador = new AdaptadorTitulares(datos);

        adaptador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("DemoRecView", "Pulsado el elemento " + recView.getChildPosition(v));
            }
        });

        recView.setAdapter(adaptador);

        recView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        //...



        */

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}

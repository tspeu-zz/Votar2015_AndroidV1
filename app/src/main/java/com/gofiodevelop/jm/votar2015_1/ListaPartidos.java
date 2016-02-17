package com.gofiodevelop.jm.votar2015_1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.gofiodevelop.jm.votar2015_1.adaptador.AdaptadorListaPartido;
import com.gofiodevelop.jm.votar2015_1.vista.Partido;

/**
 * Created by JM_B on 25-Apr-15.
 */
public class ListaPartidos extends ActionBarActivity {

    private ListView lista;
    private Partido[] listaPartidos;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listapartidos);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //va a tener el icono home
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        lista = (ListView) findViewById(R.id.listViewListaPartidos);
        listaPartidos =  new Partido[]{
                new Partido("PartidoPopular","Lorem ipsum dolor sit amet",R.drawable.pp),
                new Partido("PSOE","Lorem ipsum dolor sit amet",R.drawable.psoe),
                new Partido("Podemos","Lorem ipsum dolor sit amet",R.drawable.podemos),
                new Partido("Ciudadanos","Lorem ipsum dolor sit amet",R.drawable.ciudadans),
                new Partido("IzquierdaUnida ",", consectetur adipiscing",R.drawable.izqu),
                new Partido("Colision Canaria ","Lorem ipsum dolor sit amet",R.drawable.ccanaria),
                new Partido("Convergencia U ","Lorem ipsum dolosit amet",R.drawable.ciu),
                new Partido("UnioProgreso Demo ",", consectetur adipiscing",R.drawable.upd),
                new Partido("Partido Naci Vasco","Lorem ipsm dolor sit amet",R.drawable.pnv)
        };

        AdaptadorListaPartido adp = new AdaptadorListaPartido(this, listaPartidos);
        lista.setAdapter(adp);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(getApplicationContext(),"pulsado" + listaPartidos[position].getTitulo(), Toast.LENGTH_SHORT).show();

               Bundle datos = new Bundle();
                datos.putString("nombrePartido", listaPartidos[position].getTitulo());
                datos.putInt("imagenPartido", listaPartidos[position].getImg());
                Intent in = new Intent(ListaPartidos.this, DetallePartido.class);

                // datos.put
                in.putExtras(datos);
                startActivity(in);

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_listapartidos, menu);
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
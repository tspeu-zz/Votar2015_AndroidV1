package com.gofiodevelop.jm.votar2015_1.adaptador;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.gofiodevelop.jm.votar2015_1.R;
import com.gofiodevelop.jm.votar2015_1.vista.Partido;

/**
 * Created by JM_B on 25-Apr-15.
 */
public class AdaptadorListaPartido extends ArrayAdapter {

    Activity contexto;
    Partido[] listaPartidos;


    public AdaptadorListaPartido (Activity cont, Partido[] datos) {
        //contructor la actividad, el layaout del xml, y la clase
        super(cont, R.layout.activity_listapartidos, datos);
        this.listaPartidos = datos;
        this.contexto= cont;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //genera desde el xml la vista
        LayoutInflater inflater = contexto.getLayoutInflater();
        // infla la vista desde el xml
        View item = inflater.inflate(R.layout.modelolistapartidos,null);
        //rellenar datos
        TextView NombrePartido = (TextView) item.findViewById(R.id.textViewNobrePartido);
        NombrePartido.setText(listaPartidos[position].getTitulo());
       /* TextView descPartido = (TextView) item.findViewById(R.id.textViewDescPartido);
        descPartido.setText(listaPartidos[position].getDescripcion());*/
        ImageView imagenPartido = (ImageView) item.findViewById(R.id.imageViewLogoPartido);
        imagenPartido.setImageResource(listaPartidos[position].getImg());

        return item;
    }


}

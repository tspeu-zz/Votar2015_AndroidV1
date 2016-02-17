package com.gofiodevelop.jm.votar2015_1.adaptador;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gofiodevelop.jm.votar2015_1.R;
import com.gofiodevelop.jm.votar2015_1.vista.VistaPortada;

import java.util.List;

/**
 * Created by JM_B on 20-Apr-15.
 */
public class AdaptadorPortada  extends  RecyclerView.Adapter<AdaptadorPortada.PortadaViewHolder>
        implements View.OnClickListener {

    private List<VistaPortada> items;
    private View.OnClickListener listener;
    private static Context sContext; //nuevo

    public static class PortadaViewHolder extends RecyclerView.ViewHolder {
        public ImageView imagenPortada;
        public TextView nombrePortada;


        public  PortadaViewHolder(View v) {
            super(v);
            imagenPortada =  (ImageView) v.findViewById(R.id.imageViewPortada);
            nombrePortada = (TextView) v.findViewById(R.id.textViewPortada);


        }

    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }


    public AdaptadorPortada (List items) {
        this.items = items;
    }

    @Override
    public PortadaViewHolder onCreateViewHolder(ViewGroup vg, int viewType) {
        View v = LayoutInflater.from(vg.getContext()).inflate(R.layout.modeloportada, vg, false);

        PortadaViewHolder holder = new PortadaViewHolder(v);
//        holder.nombrePortada.setClickable(true);
//        holder.nombrePortada.setOnClickListener(AdaptadorPortada.this);
//        holder.imagenPortada.setOnClickListener(AdaptadorPortada.this);
//        //holder.mNameTextView.setOnClickListener(MyCustomAdapter.this);
        v.setOnClickListener(this);
        holder.nombrePortada.setTag(holder);
        return holder;

    }

    @Override
    public void onBindViewHolder(PortadaViewHolder holder, int position) {
        holder.imagenPortada.setImageResource(items.get(position).getImagenListaPortada());
        holder.nombrePortada.setText(items.get(position).getNombreListaPortda());
    }

    @Override
    public void onClick(View view) {
        if(listener != null)
            listener.onClick(view);

    }

 /*
    *
    @Override
    public void onClick(View v) {
        if(listener != null)
            listener.onClick(v);

    }
    */



    @Override
    public int getItemCount() {
        return items.size();
    }



    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
//public class ApatadorBotones extends  RecyclerView.Adapter<ApatadorBotones.BotonesViewHolder>



}

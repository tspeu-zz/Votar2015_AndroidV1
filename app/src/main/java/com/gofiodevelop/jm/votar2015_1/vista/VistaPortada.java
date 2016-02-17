package com.gofiodevelop.jm.votar2015_1.vista;

/**
 * Created by JM_B on 20-Apr-15.
 */
public class VistaPortada {

    private int imagenListaPortada;
    private String nombreListaPortda;

    public VistaPortada(int imagenListaPortada, String nombreListaPortda) {
        this.imagenListaPortada = imagenListaPortada;
        this.nombreListaPortda = nombreListaPortda;
    }


    public int getImagenListaPortada() {
        return imagenListaPortada;
    }

    public void setImagenListaPortada(int imagenListaPortada) {
        this.imagenListaPortada = imagenListaPortada;
    }

    public String getNombreListaPortda() {
        return nombreListaPortda;
    }

    public void setNombreListaPortda(String nombreListaPortda) {
        this.nombreListaPortda = nombreListaPortda;
    }
}

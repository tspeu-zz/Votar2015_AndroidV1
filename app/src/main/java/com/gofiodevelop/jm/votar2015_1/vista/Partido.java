package com.gofiodevelop.jm.votar2015_1.vista;

/**
 * Created by JM_B on 25-Apr-15.
 */
public class Partido {
    private String titulo, descripcion;
    private int img;

    public Partido(String titulo, String descripcion, int img) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.img = img;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}

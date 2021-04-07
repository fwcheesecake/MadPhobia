package entidades;

import javax.swing.*;

public class Entidad {
    protected String nombre;
    protected int imagen;

    public Entidad() {
        setNombre("");
        setImagen(0);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int icono) {
        this.imagen = icono;
    }
}
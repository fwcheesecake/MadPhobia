package entidades;

import entidades.Entidad;

public class Objeto extends Entidad {
    protected String descripcion;

    public Objeto() {
        super();
        setDescripcion("");
    }

    public Objeto(String nombre, int imagen, String descripcion) {
        super(nombre, imagen);
        setDescripcion(descripcion);
    }

    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}

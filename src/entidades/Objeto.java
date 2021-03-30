package entidades;

import entidades.Entidad;

public class Objeto extends Entidad {
    protected String descripcion;

    public Objeto() {
        super();
        setDescripcion("");
    }

    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}

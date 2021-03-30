package entidades;

public class Consumible extends Objeto {
    private int regeneracion;

    public Consumible() {
        super();
        setRegeneracion(0);
    }

    public int getRegeneracion() {
        return regeneracion;
    }
    public void setRegeneracion(int regeneracion) {
        this.regeneracion = regeneracion;
    }
}

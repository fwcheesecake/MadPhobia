package entidades;


import enumerados.Tipo;

public class Enemigo extends Ser {
    protected Tipo fortaleza;
    protected Tipo debilidad;
    public Enemigo() {
        super();
        setFortaleza(Tipo.MELEE);
        setDebilidad(Tipo.MELEE);
    }
    public Tipo getFortaleza() {
        return fortaleza;
    }
    public void setFortaleza(Tipo fortaleza) {
        this.fortaleza = fortaleza;
    }
    public Tipo getDebilidad() {
        return debilidad;
    }
    public void setDebilidad(Tipo debilidad) {
        this.debilidad = debilidad;
    }

}

package entidades;


import enumerados.Tipo;

import javax.swing.*;

public class Enemigo extends Ser {
    protected Tipo fortaleza;
    protected Tipo debilidad;

    public static ImageIcon[] iconos = {
            new ImageIcon(Enemigo.class.getResource("/imagenes/enemigos/arana.png"))
    };

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

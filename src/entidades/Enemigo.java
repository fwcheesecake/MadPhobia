package entidades;


import enumerados.Tipo;

import javax.swing.*;

public class Enemigo extends Ser {
    protected Tipo fortaleza;
    protected Tipo debilidad;

    public static ImageIcon[] iconos = {
            new ImageIcon(Enemigo.class.getResource("/sprites/pjs/enemigos/saqueadores/saqueador.png")),
            new ImageIcon(Enemigo.class.getResource("/sprites/pjs/enemigos/saqueadores/saqueador2.png")),
            new ImageIcon(Enemigo.class.getResource("/sprites/pjs/enemigos/saqueadores/saqueador3.png")),
            new ImageIcon(Enemigo.class.getResource("/sprites/pjs/enemigos/saqueadores/saqueador4.png")),

            new ImageIcon(Enemigo.class.getResource("/sprites/pjs/enemigos/soldados/soldado.png")),
            new ImageIcon(Enemigo.class.getResource("/sprites/pjs/enemigos/soldados/soldado2.png")),

            new ImageIcon(Enemigo.class.getResource("/sprites/pjs/enemigos/monos/cosa.gif")),
            new ImageIcon(Enemigo.class.getResource("/sprites/pjs/enemigos/monos/doscabezas.gif")),
            new ImageIcon(Enemigo.class.getResource("/sprites/pjs/enemigos/monos/tripas.gif"))
    };

    public static void inicializarIconos() {
        iconos[0].setDescription("Saqueador");
        iconos[1].setDescription("Saqueador");
        iconos[2].setDescription("Saqueador");
        iconos[3].setDescription("Saqueador");

        iconos[4].setDescription("Soldado");
        iconos[5].setDescription("Soldado");

        iconos[6].setDescription("Cosa");
        iconos[7].setDescription("Dos Cabezas");
        iconos[8].setDescription("Guts");
    }

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

package entidades;

import enumerados.Tipo;

import javax.swing.*;

public class Arma extends Objeto {
    int dano;
    Tipo tipo;

    public static ImageIcon[] iconos = {
            new ImageIcon(Arma.class.getResource("/sprites/armas/explosivo/granada.png")),
            new ImageIcon(Arma.class.getResource("/sprites/armas/explosivo/molotov.png")),

            new ImageIcon(Arma.class.getResource("/sprites/armas/fuego/glock.png")),
            new ImageIcon(Arma.class.getResource("/sprites/armas/fuego/revolver.png")),
            new ImageIcon(Arma.class.getResource("/sprites/armas/fuego/shotgun.png")),
            new ImageIcon(Arma.class.getResource("/sprites/armas/fuego/uzi.png")),

            new ImageIcon(Arma.class.getResource("/sprites/armas/meele/bottle.png"))
    };

    public Arma() {
        super();
        setDano(0);
        setTipo(Tipo.MELEE);
    }

    public int getDano() {
        return dano;
    }
    public void setDano(int dano) {
        this.dano = dano;
    }

    public Tipo getTipo() {
        return tipo;
    }
    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
}
package entidades;

import enumerados.Tipo;

import javax.swing.*;

public class Arma extends Objeto {
    public static ImageIcon[] iconos = {
            new ImageIcon(Arma.class.getResource("/sprites/armas/explosivo/granada.png")),
            new ImageIcon(Arma.class.getResource("/sprites/armas/explosivo/molotov.png")),

            new ImageIcon(Arma.class.getResource("/sprites/armas/fuego/glock.png")),
            new ImageIcon(Arma.class.getResource("/sprites/armas/fuego/revolver.png")),
            new ImageIcon(Arma.class.getResource("/sprites/armas/fuego/shotgun.png")),
            new ImageIcon(Arma.class.getResource("/sprites/armas/fuego/uzi.png")),

            new ImageIcon(Arma.class.getResource("/sprites/armas/meele/bottle.png")),
            new ImageIcon(Arma.class.getResource("/sprites/armas/meele/bat.png"))
    };

    public static void inicializarIconos() {
        iconos[0].setDescription("Granada");
        iconos[1].setDescription("Molotov");

        iconos[2].setDescription("Glock");
        iconos[3].setDescription("Revolver");
        iconos[4].setDescription("Shot Gun");
        iconos[5].setDescription("Uzi");

        iconos[6].setDescription("Botella");
        iconos[7].setDescription("Bate");
    }

    public static String[] descripcion = {
            "Gran explosion",
            "Poder de fuego",
            "Velocidad y poder por igual",
            "Un arma poderosa",
            "Le desinstala MadPhobia al enemigo",
            "UziXD",
            "Que dijistes del america",
            "Home Run"
    };

    int dano;
    Tipo tipo;


    public Arma() {
        super();
        setDano(0);
        setTipo(Tipo.MELEE);
    }

    public Arma(String nombre, int imagen, String descripcion, int dano, Tipo tipo) {
        super(nombre, imagen, descripcion);
        setDano(dano);
        setTipo(tipo);
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
package entidades;

import javax.swing.*;

public class Escudo extends Objeto {
    private int escudo;

    public static ImageIcon[] iconos = {
            new ImageIcon(Escudo.class.getResource("/sprites/consumibles/escudos/chaleco.png")),
            new ImageIcon(Escudo.class.getResource("/sprites/consumibles/escudos/chalecopesado.png")),
            new ImageIcon(Escudo.class.getResource("/sprites/consumibles/escudos/mascara.png"))
    };

    public static String[] descripcion = {
            "Chaleco normal, no proteje suficiente",
            "Chaleco pesado, es muy bueno pero es pesado",
            "Mascara de gas, protege del gas"
    };

    public static void inicializarIconos() {
        iconos[0].setDescription("Chaleco");
        iconos[1].setDescription("Chaleco Pesado");
        iconos[2].setDescription("Mascara");
    }

    public Escudo() {
        super();
        setEscudo(0);
    }

    public Escudo(String nombre, int imagen, String descripcion, int escudo) {
        super(nombre, imagen, descripcion);
        setEscudo(escudo);
    }

    public int getEscudo() {
        return escudo;
    }
    public void setEscudo(int escudo) {
        this.escudo = escudo;
    }
}

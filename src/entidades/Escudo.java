package entidades;

import javax.swing.*;

public class Escudo extends Objeto {
    private int escudo;

    public static ImageIcon[] iconos = {
            new ImageIcon(Escudo.class.getResource("/sprites/consumibles/escudos/chaleco.png")),
            new ImageIcon(Escudo.class.getResource("/sprites/consumibles/escudos/chalecopesado.png")),
            new ImageIcon(Escudo.class.getResource("/sprites/consumibles/escudos/mascara.png"))
    };

    public Escudo() {
        super();
        setEscudo(0);
    }

    public int getEscudo() {
        return escudo;
    }
    public void setEscudo(int escudo) {
        this.escudo = escudo;
    }
}

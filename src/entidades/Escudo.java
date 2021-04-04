package entidades;

import javax.swing.*;

public class Escudo extends Objeto {
    private int escudo;

    public static ImageIcon[] iconos = {
            new ImageIcon(Consumible.class.getResource("/imagenes/objetos/consumibles/lata.png"))
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

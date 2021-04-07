package entidades;

import javax.swing.*;

public class Consumible extends Objeto {
    public static ImageIcon[] iconos = {
            new ImageIcon(Consumible.class.getResource("/sprites/consumibles/salud/lata.png")),
            new ImageIcon(Consumible.class.getResource("/sprites/consumibles/salud/lata2.png"))
    };
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

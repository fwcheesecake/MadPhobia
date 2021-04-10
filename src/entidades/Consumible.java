package entidades;

import javax.swing.*;

public class Consumible extends Objeto {
    private int regeneracion;
    public static ImageIcon[] iconos = {
            new ImageIcon(Consumible.class.getResource("/sprites/consumibles/salud/lata.png")),
            new ImageIcon(Consumible.class.getResource("/sprites/consumibles/salud/lata2.png"))
    };
    public static String[] descripcion = {
            "Lata de La coste*a",
            "Atun tu*y para gran deleite"
    };


    public static void inicializarIconos() {
        iconos[0].setDescription("Lanta");
        iconos[1].setDescription("Lata2");
    }

    public Consumible() {
        super();
        setRegeneracion(0);
    }

    public Consumible(String nombre, int imagen, String descrpcion, int regeneracion) {
        super(nombre, imagen, descrpcion);
        setRegeneracion(regeneracion);
    }

    public int getRegeneracion() {
        return regeneracion;
    }
    public void setRegeneracion(int regeneracion) {
        this.regeneracion = regeneracion;
    }
}

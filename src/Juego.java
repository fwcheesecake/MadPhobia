import elementos.Habitacion;

import javax.swing.*;

public class Juego extends JFrame {
    Juego() {
        Habitacion habitacion = new Habitacion();
        add(habitacion);
    }

    public static void main(String[] args) {
        Juego juego = new Juego();
        
        juego.setVisible(true);
        juego.setTitle("MadPhobia");
        juego.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
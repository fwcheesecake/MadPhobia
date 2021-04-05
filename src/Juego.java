import elementos.Habitacion;
import elementos.Indicador;

import javax.swing.*;
import java.awt.*;

public class Juego extends JFrame {
    private JLayeredPane contentPane;
    private final JPanel indicadorInventario;

    int width, height;

    Juego() {
        setBackground(new Color(0x2F2F2F));
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        width = (int) screen.getWidth();
        height = (int) screen.getHeight();

        contentPane = new JLayeredPane();
        contentPane.setOpaque(true);
        contentPane.setBackground(new Color(0x2F2F2F));
        contentPane.setBounds(0, 0, width, height);
        add(contentPane);

        Habitacion habitacion = new Habitacion();
        habitacion.setBackground(new Color(0x2F2F2F));
        habitacion.setBounds((width - height - 10) / 2, 10, height - 20, height - 20);
        contentPane.add(habitacion, Integer.valueOf(0));

        Indicador indicadorJugador1 = new Indicador();
        int wIndicador = width / 8, hIndicador = height / 12;
        indicadorJugador1.setBorder(BorderFactory.createLineBorder(new Color(0xFFFFFF), 3));
        indicadorJugador1.setOpaque(false);
        indicadorJugador1.setBounds(0, 0, wIndicador, hIndicador);
        contentPane.add(indicadorJugador1, Integer.valueOf(1));

        Indicador indicadorJugador2 = new Indicador();
        int xIndicador2 = width - wIndicador;
        indicadorJugador2.setBorder(BorderFactory.createLineBorder(new Color(0xFFFFFF), 3));
        indicadorJugador2.setOpaque(false);
        indicadorJugador2.setBounds(xIndicador2, 0, wIndicador, hIndicador);
        contentPane.add(indicadorJugador2, Integer.valueOf(1));

        Indicador indicadorJugador3 = new Indicador();
        int yIndicador3 = height - hIndicador;
        indicadorJugador3.setOpaque(false);
        indicadorJugador3.setBorder(BorderFactory.createLineBorder(new Color(0xFFFFFF), 3));
        indicadorJugador3.setBounds(0, yIndicador3, wIndicador, hIndicador);
        contentPane.add(indicadorJugador3, Integer.valueOf(1));

        indicadorInventario = new JPanel();
        indicadorInventario.setOpaque(false);
        indicadorInventario.setBorder(BorderFactory.createLineBorder(new Color(0xFFFFFF), 3));
        indicadorInventario.setBounds(xIndicador2, yIndicador3, wIndicador, hIndicador);
        contentPane.add(indicadorInventario, Integer.valueOf(1));
    }

    public static void main(String[] args) {
        Juego juego = new Juego();

        juego.setFullscreen();
        juego.setVisible(true);
        juego.setTitle("MadPhobia");
        juego.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void setFullscreen() {
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
    }
}
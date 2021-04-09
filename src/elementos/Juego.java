package elementos;

import entidades.Enemigo;
import entidades.Jugador;

import javax.swing.*;
import java.awt.*;

public class Juego extends JFrame  {
    private JLayeredPane contentPane;
    private JPanel indicadorInventario;
    private JPanel indicadorCasilla;
    int width, height;

    public static Jugador jugador1 = new Jugador("Jonathan", 0, 100, 0, 15, new Point(0, 0)),
            jugador2 = new Jugador("Antonio", 1, 100, 0, 15, new Point(0, 0)),
            jugador3 = new Jugador("Daniela", 2, 100, 0, 15, new Point(0, 0));

    public static Jugador jugadorActual = jugador1;

    Juego() {
        setCursor(Cursores.POR_DEFECTO);

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

        int wIndicador = width / 8, hIndicador = height / 12;
        jugador1.getIndicador().setBorder(BorderFactory.createLineBorder(new Color(0xFFFFFF), 3));
        jugador1.getIndicador().setOpaque(false);
        jugador1.getIndicador().setBounds(0, 0, wIndicador, hIndicador);
        contentPane.add(jugador1.getIndicador(), Integer.valueOf(1));

        int xIndicador2 = width - wIndicador;
        jugador2.getIndicador().setBorder(BorderFactory.createLineBorder(new Color(0xFFFFFF), 3));
        jugador2.getIndicador().setOpaque(false);
        jugador2.getIndicador().setBounds(xIndicador2, 0, wIndicador, hIndicador);
        contentPane.add(jugador2.getIndicador(), Integer.valueOf(1));

        int yIndicador3 = height - hIndicador;
        jugador3.getIndicador().setOpaque(false);
        jugador3.getIndicador().setBorder(BorderFactory.createLineBorder(new Color(0xFFFFFF), 3));
        jugador3.getIndicador().setBounds(0, yIndicador3, wIndicador, hIndicador);
        contentPane.add(jugador3.getIndicador(), Integer.valueOf(1));

        indicadorInventario = new JPanel();
        indicadorInventario.setOpaque(false);
        indicadorInventario.setBorder(BorderFactory.createLineBorder(new Color(0xFFFFFF), 3));
        indicadorInventario.setBounds(xIndicador2, yIndicador3, wIndicador, hIndicador);

        contentPane.add(indicadorInventario, Integer.valueOf(1));

        indicadorCasilla = new JPanel();
        indicadorCasilla.setOpaque(false);
        indicadorCasilla.setBorder(BorderFactory.createLineBorder(new Color(0xFFFFFF), 3));
        int gap = height - hIndicador * 2;
        indicadorCasilla.setBounds(xIndicador2, hIndicador + gap / 10, wIndicador, gap - (gap / 10) * 2);
        contentPane.add(indicadorCasilla, Integer.valueOf(1));

        contentPane.add(jugador1.getInventario(), Integer.valueOf(2));
        jugador1.getInventario().crearInventarioGlobal();

        contentPane.add(jugador2.getInventario(), Integer.valueOf(2));
        jugador2.getInventario().crearInventarioGlobal();

        contentPane.add(jugador3.getInventario(), Integer.valueOf(2));
        jugador3.getInventario().crearInventarioGlobal();
    }

    public static void main(String[] args) {
        Juego juego = new Juego();

        Enemigo.inicializarIconos();

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
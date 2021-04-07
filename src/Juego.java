import elementos.Habitacion;
import elementos.Indicador;
import entidades.Jugador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Juego extends JFrame  {
    private JLayeredPane contentPane;
    private final JPanel indicadorInventario;
    JButton inventariob;
    int width, height;

    public static Jugador
            jugador1 = new Jugador(),
            jugador2 = new Jugador(),
            jugador3 = new Jugador();

    public Jugador jugadorActual = jugador1;

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

        inventariob = new JButton("Inventario");
        inventariob.setBackground(new Color(0x2A2929));
        inventariob.setBounds(450,200,50,100);
        inventariob.setBorder(BorderFactory.createLineBorder(Color.black));

        inventariob.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jugadorActual.getInventario().setVisible(true);
            }
        });

        indicadorInventario.add(inventariob);
        contentPane.add(indicadorInventario, Integer.valueOf(1));

        contentPane.add(jugador1.getInventario(), Integer.valueOf(2));
        jugador1.getInventario().crearInventarioGlobal();

        contentPane.add(jugador2.getInventario(), Integer.valueOf(2));
        jugador2.getInventario().crearInventarioGlobal();

        contentPane.add(jugador3.getInventario(), Integer.valueOf(2));
        jugador3.getInventario().crearInventarioGlobal();
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
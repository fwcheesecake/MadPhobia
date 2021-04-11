package elementos;

import entidades.*;

import javax.swing.*;
import java.awt.*;

public class Juego extends JFrame {
    private JLayeredPane contentPane;
    private JPanel indicadorInventario;
    private  JLayeredPane indicadorCasilla;
    JLabel feed1, feed2;
    int width, height;
    ImageIcon im1;
    JLabel a1;
    int wIndicador, hIndicador, xIndicador2, yIndicador3;

    public static JLabel fondo = new JLabel();

    public static Jugador jugador1 = new Jugador("Jonathan", 0, 100, 0, 15, new Point(0, 0), Jugador.iconos[0]),
            jugador2 = new Jugador("Antonio", 1, 100, 0, 15, new Point(0, 0), Jugador.iconos[1]),
            jugador3 = new Jugador("Daniela", 2, 100, 0, 15, new Point(0, 0), Jugador.iconos[2]);

    public static Jugador jugadorActual = jugador1;

    public static boolean gameOver() {
        return jugador1.estaMuerto() && jugador2.estaMuerto() && jugador3.estaMuerto();
    }

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

        fondo.setBounds((width - height - 10) / 2, 10, height - 20, height - 20);
        fondo.setIcon(Habitacion.getPiso());
        fondo.setHorizontalAlignment(JLabel.CENTER);
        fondo.setVerticalAlignment(JLabel.CENTER);
        fondo.setVerticalTextPosition(JLabel.CENTER);
        fondo.setHorizontalTextPosition(JLabel.CENTER);
        contentPane.add(fondo, Integer.valueOf(0));

        Habitacion habitacion = new Habitacion();
        habitacion.setBackground(new Color(0x2F2F2F));
        habitacion.setBounds((width - height - 10) / 2, 10, height - 20, height - 20);
        contentPane.add(habitacion, Integer.valueOf(1));
        habitacion.setOpaque(false);

        addIndicadoresDeJugador();
        addIndicadorCasilla();

        indicadorInventario = new JPanel();
        JButton Mochila=new JButton("");
        JLabel Arma1=new JLabel("");
        JLabel Arma2=new JLabel("");
        indicadorInventario.add(Arma2);
        indicadorInventario.add(Arma1);
        indicadorInventario.add(Mochila);
        indicadorInventario.setOpaque(false);
        indicadorInventario.setBorder(BorderFactory.createLineBorder(new Color(0xFFFFFF), 3));
        indicadorInventario.setBounds(xIndicador2, yIndicador3, wIndicador, hIndicador);
        indicadorInventario.setLayout(new GridLayout(1,3));
        contentPane.add(indicadorInventario, Integer.valueOf(1));

        contentPane.add(jugador1.getInventario(), Integer.valueOf(2));
        jugador1.getInventario().crearInventarioGlobal();

        contentPane.add(jugador2.getInventario(), Integer.valueOf(2));
        jugador2.getInventario().crearInventarioGlobal();

        contentPane.add(jugador3.getInventario(), Integer.valueOf(2));
        jugador3.getInventario().crearInventarioGlobal();
    }

    public void addIndicadorCasilla() {

        indicadorCasilla =new  JLayeredPane();

        indicadorCasilla.setOpaque(false);
        int gap = height - hIndicador * 2;
        a1= new JLabel();
        im1 = new ImageIcon(getClass().getResource("/sprites/hud/feed.png"));
        a1.setIcon(im1);
        a1.setBounds(0, 0, 400, 420);
        indicadorCasilla.add(a1, Integer.valueOf(0));
        im1.setImage(im1.getImage().getScaledInstance(400, 420, Image.SCALE_DEFAULT));
        indicadorCasilla.setBounds(1620,200 + gap /10, 400,500);

        feed1 = new JLabel("bb");
        feed1.setBounds(143,30,115,125);
        feed1.setBorder(BorderFactory.createLineBorder(Color.black));
        indicadorCasilla.add(feed1, Integer.valueOf(1));

        feed2 = new JLabel("AA");
        feed2.setBounds(123,185,153,195);
        feed2.setBorder(BorderFactory.createLineBorder(Color.black));
        indicadorCasilla.add(feed2, Integer.valueOf(1));
        contentPane.add(indicadorCasilla,Integer.valueOf(1));


    }
    public void addIndicadoresDeJugador() {
        wIndicador = width / 8;
        hIndicador = height / 12;
        jugador1.getIndicador().setBorder(BorderFactory.createLineBorder(new Color(0xFFFFFF), 3));
        jugador1.getIndicador().setOpaque(false);
        jugador1.getIndicador().setBounds(0, 0, 248, 104);
        contentPane.add(jugador1.getIndicador(), Integer.valueOf(1));

        xIndicador2 = width - wIndicador;
        jugador2.getIndicador().setBorder(BorderFactory.createLineBorder(new Color(0xFFFFFF), 3));
        jugador2.getIndicador().setOpaque(false);
        jugador2.getIndicador().setBounds(1670, 0, 248, 104);
        contentPane.add(jugador2.getIndicador(), Integer.valueOf(1));

        yIndicador3 = height - hIndicador;
        jugador3.getIndicador().setOpaque(false);
        jugador3.getIndicador().setBorder(BorderFactory.createLineBorder(new Color(0xFFFFFF), 3));
        jugador3.getIndicador().setBounds(0, 975, 248, 104);
        contentPane.add(jugador3.getIndicador(), Integer.valueOf(1));
    }

    public static void main(String[] args) {
        Juego juego = new Juego();

        Enemigo.inicializarIconos();
        Consumible.inicializarIconos();
        Arma.inicializarIconos();
        Escudo.inicializarIconos();

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
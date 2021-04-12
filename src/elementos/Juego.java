package elementos;

import entidades.*;

import javax.swing.*;
import java.awt.*;

public class Juego extends JFrame {
    private JLayeredPane contentPane;
    private JPanel indicadorInventario;
    private  JLayeredPane indicadorCasilla;

    static JLabel feedIcon;
    static JTextArea feedDescripcion;


    int width, height;
    static ImageIcon im1;
    static JLabel a1;

    int wIndicador, hIndicador, xIndicador2, yIndicador3;

    public static JLabel fondo = new JLabel();

    public static Jugador jugador1 = new Jugador("Jonathan", 0, 100, 0, 15, new Point(0, 0), Jugador.iconos[0]),
            jugador2 = new Jugador("Antonio", 1, 100, 0, 15, new Point(0, 0), Jugador.iconos[1]),
            jugador3 = new Jugador("Daniela", 2, 100, 0, 15, new Point(0, 0), Jugador.iconos[2]);

    public static Jugador jugadorActual = jugador1;

    public static JFrame derrotado;

    public static void crearFrameDerrota() {
        derrotado = new JFrame();
        derrotado.setLayout(null);

        JLabel fondo = new JLabel(new ImageIcon(Juego.class.getResource("/sprites/screens/muerte.png")));
        fondo.setBounds(0, 0, 400, 300);
        derrotado.getContentPane().add(fondo);
        fondo.setVisible(true);

        derrotado.setBounds(500, 300, 400, 300);
        derrotado.setLocationRelativeTo(null);
        derrotado.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

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
        indicadorCasilla = new  JLayeredPane();

        indicadorCasilla.setOpaque(false);
        int gap = height - hIndicador * 2;
        a1 = new JLabel();
        im1 = new ImageIcon(getClass().getResource("/sprites/hud/feed.png"));
        a1.setIcon(im1);
        a1.setBounds(0, 0, 400, 420);
        indicadorCasilla.add(a1, Integer.valueOf(0));
        im1.setImage(im1.getImage().getScaledInstance(400, 420, Image.SCALE_DEFAULT));
        indicadorCasilla.setBounds(1620,200 + gap / 10, 400,500);

        feedIcon = new JLabel();
        feedIcon.setBounds(143,30,115,125);
        feedIcon.setBorder(BorderFactory.createLineBorder(Color.black));
        feedIcon.setHorizontalAlignment(JLabel.CENTER);
        feedIcon.setVerticalAlignment(JLabel.CENTER);
        feedIcon.setHorizontalAlignment(JLabel.CENTER);
        feedIcon.setHorizontalTextPosition(JLabel.CENTER);
        indicadorCasilla.add(feedIcon, Integer.valueOf(1));

        feedDescripcion = new JTextArea();
        feedDescripcion.setBounds(123,190,148,190);
        feedDescripcion.setOpaque(false);
        setBackground(Color.gray);
        feedDescripcion.setBorder(BorderFactory.createLineBorder(Color.black));
        feedDescripcion.setLineWrap(true);
        feedDescripcion.setWrapStyleWord(true);
        indicadorCasilla.add(feedDescripcion, Integer.valueOf(1));
        contentPane.add(indicadorCasilla,Integer.valueOf(1));
    }

    private static ImageIcon scaleIcon(ImageIcon icon, int w, int h) {
        return new ImageIcon(icon.getImage().getScaledInstance(w, h, Image.SCALE_DEFAULT));
    }

    public static void actualizarFeed() {
        feedIcon.setIcon(null);
        feedDescripcion.setText("");
    }

    public static void actualizarFeed(Enemigo entidad) {
        if(entidad == null) {
            feedIcon.setIcon(null);
            feedDescripcion.setText("");
        } else {
            feedIcon.setIcon(scaleIcon(Enemigo.iconos[entidad.getImagen()], 115, 115));
            feedDescripcion.setText("" + entidad.getNombre() + "\n" +
                    "Vida: " + entidad.getVida() + "\n" +
                    "Escudo: " + entidad.getEscudo() + "\n" +
                    "Ataque: " + entidad.getFuerza() + "\n");
        }
    }
    public static void actualizarFeed(Consumible entidad) {
        if(entidad == null) {
            feedIcon.setIcon(null);
            feedDescripcion.setText("");
        } else {
            feedIcon.setIcon(scaleIcon(Consumible.iconos[entidad.getImagen()], 115, 115));
            feedDescripcion.setText("" + entidad.getNombre() + "\n" +
                    "Regenera +" + entidad.getRegeneracion() + " puntos de salud\n" +
                    "Descripcion: \n" + Consumible.descripcion[entidad.getImagen()]);
        }
    }
    public static void actualizarFeed(Arma entidad) {
        if(entidad == null) {
            feedIcon.setIcon(null);
            feedDescripcion.setText("");
        } else {
            feedIcon.setIcon(scaleIcon(Arma.iconos[entidad.getImagen()], 115, 115));
            feedDescripcion.setText("" + entidad.getNombre() + "\n" +
                    "+" + entidad.getDano() + " de ataque adicional\n" +
                    "Descripcion: \n" + Arma.descripcion[entidad.getImagen()]);
        }
    }
    public static void actualizarFeed(Escudo entidad) {
        if(entidad == null) {
            feedIcon.setIcon(null);
            feedDescripcion.setText("");
        } else {
            feedIcon.setIcon(scaleIcon(Escudo.iconos[entidad.getImagen()], 115, 115));
            feedDescripcion.setText("" + entidad.getNombre() + "\n" +
                    "+" + entidad.getEscudo() + " de defensa adicional\n" +
                    "Descripcion: \n" + Escudo.descripcion[entidad.getImagen()]);
        }
    }

    public void addIndicadoresDeJugador() {
        wIndicador = width / 8;
        hIndicador = height / 12;
        jugador1.getIndicador().setBorder(BorderFactory.createLineBorder(new Color(0xFFFFFF), 3));
        jugador1.getIndicador().setOpaque(false);
        jugador1.getIndicador().setBounds(0, 0, 248, 104);
        jugador1.getIndicador().ImgJugador.setIcon(Jugador.iconos[0]);
        jugador1.getIndicador().ImgJugador.setHorizontalAlignment(JLabel.CENTER);
        contentPane.add(jugador1.getIndicador(), Integer.valueOf(1));

        xIndicador2 = width - wIndicador;
        jugador2.getIndicador().setBorder(BorderFactory.createLineBorder(new Color(0xFFFFFF), 3));
        jugador2.getIndicador().setOpaque(false);
        jugador2.getIndicador().setBounds(1670, 0, 248, 104);
        jugador2.getIndicador().ImgJugador.setIcon(Jugador.iconos[1]);
        jugador2.getIndicador().ImgJugador.setHorizontalAlignment(JLabel.CENTER);
        contentPane.add(jugador2.getIndicador(), Integer.valueOf(1));

        yIndicador3 = height - hIndicador;
        jugador3.getIndicador().setOpaque(false);
        jugador3.getIndicador().setBorder(BorderFactory.createLineBorder(new Color(0xFFFFFF), 3));
        jugador3.getIndicador().setBounds(0, 975, 248, 104);
        jugador3.getIndicador().ImgJugador.setIcon(Jugador.iconos[2]);
        jugador3.getIndicador().ImgJugador.setHorizontalAlignment(JLabel.CENTER);
        contentPane.add(jugador3.getIndicador(), Integer.valueOf(1));
    }

    public static void main(String[] args) {
        Enemigo.inicializarIconos();
        Consumible.inicializarIconos();
        Arma.inicializarIconos();
        Escudo.inicializarIconos();
        crearFrameDerrota();

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
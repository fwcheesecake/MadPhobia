package elementos;

import entidades.Arma;
import entidades.Escudo;
import entidades.Objeto;

import javax.swing.*;
import java.awt.*;

public class Inventario extends JLayeredPane {
    private Arma armaEquipada;
    private Escudo escudoEquipado;
    private Objeto[] mochila;
    private JPanel PanelContenedor;
    public JLabel FondoPanel,Arma1,Arma2;
    public JButton Flecha,usar,tirar;
    public ImageIcon im,im2;

    public Inventario() {
        setArmaEquipada(null);
        setEscudoEquipado(null);
        setMochila(new Objeto[9]);

    }

    public void crearInventarioGlobal() {
        Dimension parentDimension = getParent().getSize();
        int w = (int) ((int) parentDimension.getWidth() * 0.4),
                h = (int) ((int) parentDimension.getHeight() * 0.4);
        int x = (int) (parentDimension.getWidth() - w) / 2,
                y = (int) (parentDimension.getHeight() - h) / 2;

        FondoPanel = new JLabel();
        im = new ImageIcon(getClass().getResource("/sprites/hud/mochila.png"));
        FondoPanel.setIcon(im);
        FondoPanel.setHorizontalAlignment(FondoPanel.CENTER);
        FondoPanel.setBounds(0, 0,400 , 400);
        im.setImage(im.getImage().getScaledInstance(400, 400, Image.SCALE_DEFAULT));
        add(FondoPanel, Integer.valueOf(0));

        Flecha = new JButton();
        im2 = new ImageIcon(getClass().getResource("/sprites/hud/iconos/flecha.png"));
        Flecha.setIcon(im2);
        Flecha.setHorizontalAlignment(FondoPanel.CENTER);
        Flecha.setBounds(3, -3,80 , 80);
        Flecha.setBorder(null);
        Flecha.setOpaque(false);
        Flecha.setBackground(Color.darkGray);
        im2.setImage(im2.getImage().getScaledInstance(90, 99, Image.SCALE_DEFAULT));
        add(Flecha, Integer.valueOf(1));

        usar =new JButton("USAR");
        usar.setBackground(Color.darkGray);
        usar.setForeground(Color.black);
        usar.setBounds(54, 340,73 , 39);
        usar.setBorder(BorderFactory.createLineBorder(Color.black));
        add(usar, Integer.valueOf(1));

        tirar =new JButton("TIRAR");
        tirar.setBackground(Color.darkGray);
        tirar.setForeground(Color.black);
        tirar.setBounds(135, 340,73 , 39);
        tirar.setBorder(BorderFactory.createLineBorder(Color.black));
        add(tirar, Integer.valueOf(1));

        Arma1 = new JLabel("");
        Arma1.setEnabled(false);
        Arma1.setBounds(220,324,65,62);
        Arma1.setBackground(Color.darkGray);
        Arma1.setBorder(BorderFactory.createLineBorder(Color.black));
        add(Arma1, Integer.valueOf(1));

        Arma2 = new JLabel("");
        Arma2.setEnabled(false);
        Arma2.setBackground(Color.darkGray);
        Arma2.setBounds(290,324,65,62);
        Arma2.setBorder(BorderFactory.createLineBorder(Color.black));
        add(Arma2, Integer.valueOf(1));

        PanelContenedor = new JPanel();

        JButton b1=new JButton("1");
        b1.setBackground(Color.darkGray);
        b1.setBorder(BorderFactory.createLineBorder(Color.black));
        JButton b2=new JButton("2");
        b2.setBackground(Color.darkGray);
        b2.setBorder(BorderFactory.createLineBorder(Color.black));
        JButton b3=new JButton("3");
        b3.setBackground(Color.darkGray);
        b3.setBorder(BorderFactory.createLineBorder(Color.black));
        JButton b4=new JButton("4");
        b4.setBackground(Color.darkGray);
        b4.setBorder(BorderFactory.createLineBorder(Color.black));
        JButton b5=new JButton("5");
        b5.setBackground(Color.darkGray);
        b5.setBorder(BorderFactory.createLineBorder(Color.black));
        JButton b6=new JButton("6");
        b6.setBackground(Color.darkGray);
        b6.setBorder(BorderFactory.createLineBorder(Color.black));
        JButton b7=new JButton("7");
        b7.setBackground(Color.darkGray);
        b7.setBorder(BorderFactory.createLineBorder(Color.black));
        JButton b8=new JButton("8");
        b8.setBackground(Color.darkGray);
        b8.setBorder(BorderFactory.createLineBorder(Color.black));
        JButton b9=new JButton("9");
        b9.setBackground(Color.darkGray);
        b9.setBorder(BorderFactory.createLineBorder(Color.black));

        PanelContenedor.add(b1);PanelContenedor.add(b2);PanelContenedor.add(b3);PanelContenedor.add(b4);PanelContenedor.add(b5);
        PanelContenedor.add(b6);PanelContenedor.add(b7);PanelContenedor.add(b8);PanelContenedor.add(b9);
        PanelContenedor.setLayout(new GridLayout(3,3));
        PanelContenedor.setBounds(55,7,300,300);
        PanelContenedor.setVisible(true);
        add(PanelContenedor, Integer.valueOf(1));

        setBounds(5, 200, 600, 600);
        setVisible(false);
    }

    public Objeto[] getMochila() {
        return mochila;
    }
    public void setMochila(Objeto[] mochila) {
        this.mochila = mochila;
    }

    public void tirar(int objeto) {
        getMochila()[objeto] = null;
    }

    public void equipar(int objeto) {
        Objeto objetoSeleccionado = getMochila()[objeto];
        Objeto objetoACambiar;
        if(getMochila()[objeto] instanceof Arma) {
            objetoACambiar = armaEquipada;
            armaEquipada = (Arma) objetoSeleccionado;
        } else {
            objetoACambiar = escudoEquipado;
            escudoEquipado = (Escudo) objetoSeleccionado;
        }
        getMochila()[objeto] = objetoACambiar;
    }

    public void desequipar(int objeto) {
        if(objeto == 0) {
            for(int i = 0; i < 9; i++) {
                if(getMochila()[i] == null) {
                    getMochila()[i] = armaEquipada;
                    armaEquipada = null;
                }
            }
        } else {
            for(int i = 0; i < 9; i++) {
                if(getMochila()[i] == null) {
                    getMochila()[i] = escudoEquipado;
                    escudoEquipado = null;
                }
            }
        }
    }

    public Arma getArmaEquipada() {
        return armaEquipada;
    }

    public void setArmaEquipada(Arma armaEquipada) {
        this.armaEquipada = armaEquipada;
    }

    public Escudo getEscudoEquipado() {
        return escudoEquipado;
    }

    public void setEscudoEquipado(Escudo escudoEquipado) {
        this.escudoEquipado = escudoEquipado;
    }
}
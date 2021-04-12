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
    private JPanel panelContenedor;
    public JLabel FondoPanel, arma, escudo;
    public JButton Flecha,usar,tirar;
    public ImageIcon im,im2;

    public JButton[] botonesDeMochila = new JButton[9];

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

        arma = new JLabel("");
        arma.setBounds(220,324,65,62);
        arma.setHorizontalAlignment(JLabel.CENTER);
        arma.setBackground(Color.darkGray);
        arma.setBorder(BorderFactory.createLineBorder(Color.black));
        add(arma, Integer.valueOf(1));

        escudo = new JLabel("");
        escudo.setBackground(Color.darkGray);
        escudo.setHorizontalAlignment(JLabel.CENTER);
        escudo.setBounds(290,324,65,62);
        escudo.setBorder(BorderFactory.createLineBorder(Color.black));
        add(escudo, Integer.valueOf(1));

        panelContenedor = new JPanel();
        panelContenedor.setLayout(new GridLayout(3,3));

        for(int i = 0; i < 9; i++) {
            botonesDeMochila[i] = new JButton();
            botonesDeMochila[i].setBackground(Color.darkGray);
            botonesDeMochila[i].setBorder(BorderFactory.createLineBorder(Color.black));
            botonesDeMochila[i].setHorizontalAlignment(JButton.CENTER);
            panelContenedor.add(botonesDeMochila[i]);
        }

        panelContenedor.setBounds(55,7,300,300);
        panelContenedor.setVisible(true);
        add(panelContenedor, Integer.valueOf(1));

        setBounds(5, 200, 600, 600);
        setVisible(true);
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
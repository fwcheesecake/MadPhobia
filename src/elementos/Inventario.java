package elementos;

import entidades.Arma;
import entidades.Consumible;
import entidades.Escudo;
import entidades.Objeto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Inventario extends JLayeredPane {
    private Arma armaEquipada;
    private Escudo escudoEquipado;
    private Objeto[] mochila;
    private JPanel panelContenedor;
    public JLabel FondoPanel, arma, escudo;
    public JButton flecha,usar,tirar;
    public ImageIcon im,im2;

    public int botonSeleccionado = -1;

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

        flecha = new JButton();
        im2 = new ImageIcon(getClass().getResource("/sprites/hud/iconos/flecha.png"));
        flecha.setIcon(im2);
        flecha.setHorizontalAlignment(FondoPanel.CENTER);
        flecha.setBounds(3, -3,80 , 80);
        flecha.setBorder(null);
        flecha.setOpaque(false);
        flecha.setBackground(Color.darkGray);
        flecha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        im2.setImage(im2.getImage().getScaledInstance(90, 99, Image.SCALE_DEFAULT));
        add(flecha, Integer.valueOf(1));

        usar =new JButton("USAR");
        usar.setBackground(Color.darkGray);
        usar.setForeground(Color.black);
        usar.setBounds(54, 340,73 , 39);
        usar.setBorder(BorderFactory.createLineBorder(Color.black));
        usar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mochila[botonSeleccionado] instanceof Arma) {
                    equipar(botonSeleccionado);
                } else if(mochila[botonSeleccionado] instanceof Escudo) {
                    equipar(botonSeleccionado);
                } else {
                    botonesDeMochila[botonSeleccionado].setIcon(null);
                    Consumible consumible = (Consumible) mochila[botonSeleccionado];
                    if(consumible != null) {
                        Juego.jugadorActual.usarComestible(consumible.getRegeneracion());
                        mochila[botonSeleccionado] = null;
                    }
                }
            }
        });
        add(usar, Integer.valueOf(1));

        tirar = new JButton("TIRAR");
        tirar.setBackground(Color.darkGray);
        tirar.setForeground(Color.black);
        tirar.setBounds(135, 340,73 , 39);
        tirar.setBorder(BorderFactory.createLineBorder(Color.black));
        tirar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(botonSeleccionado == -1)
                    return;
                mochila[botonSeleccionado] = null;
                botonesDeMochila[botonSeleccionado].setIcon(null);
            }
        });
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
            botonesDeMochila[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    for(int i = 0; i < 9; i++)
                        if(e.getSource().equals(botonesDeMochila[i]))
                            botonSeleccionado = i;
                }
            });
            panelContenedor.add(botonesDeMochila[i]);
        }

        panelContenedor.setBounds(55,7,300,300);
        panelContenedor.setVisible(true);
        add(panelContenedor, Integer.valueOf(1));

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

    private ImageIcon returnScaledImage(ImageIcon icon, int w, int h) {
        return new ImageIcon(icon.getImage().getScaledInstance(w, h, Image.SCALE_DEFAULT));
    }

    public void equipar(int objeto) {
        Objeto objetoSeleccionado = getMochila()[objeto];
        Objeto objetoACambiar;
        if(getMochila()[objeto] instanceof Arma) {
            objetoACambiar = armaEquipada;
            botonesDeMochila[objeto].setIcon(Arma.iconos[objetoACambiar.getImagen()]);
            arma.setIcon(Arma.iconos[objetoSeleccionado.getImagen()]);
            Juego.jugadorActual.getIndicador().arma.setIcon(returnScaledImage(Arma.iconos[objetoSeleccionado.getImagen()], 40, 40));
            setArmaEquipada((Arma) objetoSeleccionado);
        } else {
            objetoACambiar = escudoEquipado;
            botonesDeMochila[objeto].setIcon(Escudo.iconos[objetoACambiar.getImagen()]);
            escudo.setIcon(Escudo.iconos[objetoSeleccionado.getImagen()]);
            Juego.jugadorActual.getIndicador().escudo.setIcon(returnScaledImage(Escudo.iconos[objetoSeleccionado.getImagen()], 40, 40));
            setEscudoEquipado((Escudo) objetoSeleccionado);
        }
        getMochila()[objeto] = objetoACambiar;
        Juego.jugadorActual.updateArmaEscudo();
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
package elementos;

import com.sun.jdi.IntegerValue;
import entidades.Consumible;
import entidades.Jugador;

import javax.swing.*;
import java.awt.*;

public class Indicador extends JLayeredPane {
    public JLabel pic;
    public JLabel ImgJugador;
    public JLabel Arma1 , Arma2;
    public ImageIcon im,im1,im2,im3,im4,im5,im6;
    public JLabel icon1,icon2,icon3,icon4,icon5,icon6;
    public JLabel texDAño,texVida,texEsc;

    public Indicador() {
        setLayout(null);
        pic = new JLabel();

        ImgJugador = new JLabel("");
        ImgJugador.setOpaque(false);
        ImgJugador.setBounds(46,10,64,60);
        ImgJugador.setBackground(Color.darkGray);
        ImgJugador.setBorder(BorderFactory.createLineBorder(Color.black));
        add(ImgJugador, Integer.valueOf(1));

        Arma1 = new JLabel("");
        Arma1.setEnabled(false);
        Arma1.setBounds(117,31,40,40);
        Arma1.setBackground(Color.darkGray);
        Arma1.setBorder(BorderFactory.createLineBorder(Color.black));
        add(Arma1, Integer.valueOf(1));

        Arma2 = new JLabel("");
        Arma2.setEnabled(false);
        Arma2.setBackground(Color.darkGray);
        Arma2.setBounds(162,31,40,40);
        Arma2.setBorder(BorderFactory.createLineBorder(Color.black));
        add(Arma2, Integer.valueOf(1));

        //Icono de fuego
        icon1 = new JLabel();
        im1 = new ImageIcon(getClass().getResource("/sprites/hud/iconos/fuego.png"));
        icon1.setIcon(im1);
        icon1.setBounds(45, 73, 20, 20);
        icon1.setHorizontalAlignment(icon1.CENTER);
        icon1.setBorder(BorderFactory.createLineBorder(Color.black));
        im1.setImage(im1.getImage().getScaledInstance(15, 15, Image.SCALE_DEFAULT));
        icon1.setVisible(false);
        add(icon1, Integer.valueOf(1));

        //Icono de radiacion
        icon2 = new JLabel();
        im2 = new ImageIcon(getClass().getResource("/sprites/hud/iconos/radia.png"));
        icon2.setIcon(im2);
        icon2.setHorizontalAlignment(icon1.CENTER);
        icon2.setBounds(68, 73, 20, 20);
        icon2.setBorder(BorderFactory.createLineBorder(Color.black));
        im2.setImage(im2.getImage().getScaledInstance(10, 15, Image.SCALE_DEFAULT));
        icon2.setVisible(false);
        add(icon2, Integer.valueOf(1));

        //Icono de sangre
        icon3 = new JLabel();
        im3 = new ImageIcon(getClass().getResource("/sprites/hud/iconos/sangre.png"));
        icon3.setIcon(im3);
        icon3.setHorizontalAlignment(icon3.CENTER);
        icon3.setBounds(90, 73, 20, 20);
        icon3.setBorder(BorderFactory.createLineBorder(Color.black));
        im3.setImage(im3.getImage().getScaledInstance(15, 12, Image.SCALE_DEFAULT));
        icon3.setVisible(false);
        add(icon3, Integer.valueOf(1));

        //icono de daño
        icon4 = new JLabel();
        im4 = new ImageIcon(getClass().getResource("/sprites/hud/iconos/dano.png"));
        icon4.setIcon(im4);
        icon4.setHorizontalAlignment(icon4.CENTER);
        icon4.setBounds(116, 73, 20, 20);
        icon4.setBorder(BorderFactory.createLineBorder(Color.black));
        im4.setImage(im4.getImage().getScaledInstance(15, 15, Image.SCALE_DEFAULT));
        add(icon4, Integer.valueOf(1));

        texDAño = new JLabel("15");
        texDAño.setBounds(137, 73, 20, 20);
        texDAño.setForeground(Color.WHITE);
        add(texDAño, Integer.valueOf(1));

        //Icono de vida
        icon5 = new JLabel();
        im5 = new ImageIcon(getClass().getResource("/sprites/hud/iconos/salud.png"));
        icon5.setIcon(im5);
        icon5.setHorizontalAlignment(icon5.CENTER);
        icon5.setBounds(118, 9, 20, 20);
        icon5.setBorder(BorderFactory.createLineBorder(Color.black));
        im5.setImage(im5.getImage().getScaledInstance(15, 15, Image.SCALE_DEFAULT));
        add(icon5, Integer.valueOf(1));

        texVida = new JLabel("100");
        texVida.setBounds(140, 9, 20, 20);
        texVida.setForeground(Color.WHITE);
        add(texVida, Integer.valueOf(1));

        //Icono deEscudo
        icon6 = new JLabel();
        im6 = new ImageIcon(getClass().getResource("/sprites/hud/iconos/escudo.png"));
        icon6.setIcon(im6);
        icon6.setHorizontalAlignment(icon6.CENTER);
        icon6.setBounds(164, 9, 20, 20);
        icon6.setBorder(BorderFactory.createLineBorder(Color.black));
        im6.setImage(im6.getImage().getScaledInstance(15, 15, Image.SCALE_DEFAULT));
        add(icon6, Integer.valueOf(1));

        texEsc = new JLabel("0");
        texEsc.setBounds(185, 9, 20, 20);
        texEsc.setForeground(Color.WHITE);
        add(texEsc, Integer.valueOf(1));

    }
}

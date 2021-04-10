package elementos;

import entidades.Consumible;
import entidades.Jugador;

import javax.swing.*;
import java.awt.*;

public class Indicador extends JPanel {

    JLabel pic;
    JLabel nombreJugador;
    JProgressBar indicadorVida;
    JProgressBar indicadorEscudo;
    JLabel indicadorDano;

    JPanel contenedorEfectos;

    public Indicador() {
        GridBagConstraints layout = new GridBagConstraints();
        setLayout(new GridBagLayout());

        pic = new JLabel();
        nombreJugador = new JLabel("Nombre");
        indicadorVida = new JProgressBar();
        indicadorEscudo = new JProgressBar();
        indicadorDano = new JLabel("Dano");

        contenedorEfectos = new JPanel();

        layout.fill = GridBagConstraints.BOTH;

        pic.setPreferredSize(new Dimension(66, 66));

        pic.setIcon(Jugador.iconos[0]);

        pic.setHorizontalAlignment(JLabel.CENTER);
        pic.setVerticalAlignment(JLabel.CENTER);
        pic.setHorizontalTextPosition(JLabel.CENTER);
        pic.setVerticalTextPosition(JLabel.CENTER);

        pic.setBorder(BorderFactory.createLineBorder(new Color(0x0000FF)));

        layout.gridx = 0;
        layout.gridy = 0;
        layout.gridwidth = 3;
        layout.gridheight = 3;

        add(pic, layout);

        contenedorEfectos.setPreferredSize(new Dimension(66, 18));
        contenedorEfectos.setBorder(BorderFactory.createLineBorder(new Color(0xF700FF)));

        layout.gridx = 0;
        layout.gridy = 3;
        layout.gridwidth = 3;
        layout.gridheight = 1;

        add(contenedorEfectos, layout);

        nombreJugador.setPreferredSize(new Dimension(106, 18));
        nombreJugador.setBorder(BorderFactory.createLineBorder(new Color(0xFF0000)));

        layout.gridx = 3;
        layout.gridy = 0;
        layout.gridwidth = 1;
        layout.gridheight = 1;

        add(nombreJugador, layout);

        indicadorVida.setPreferredSize(new Dimension(168, 20));
        indicadorVida.setBorder(BorderFactory.createLineBorder(new Color(0xFFA300)));

        layout.gridx = 3;
        layout.gridy = 1;
        layout.gridwidth = 1;
        layout.gridheight = 1;

        add(indicadorVida, layout);

        indicadorEscudo.setPreferredSize(new Dimension(168, 20));
        indicadorEscudo.setBorder(BorderFactory.createLineBorder(new Color(0x00FFE5)));

        layout.gridx = 3;
        layout.gridy = 2;
        layout.gridwidth = 1;
        layout.gridheight = 1;

        add(indicadorEscudo, layout);

        indicadorDano.setPreferredSize(new Dimension(106, 18));
        indicadorDano.setBorder(BorderFactory.createLineBorder(new Color(0x37FF00)));

        layout.gridx = 3;
        layout.gridy = 3;
        layout.gridwidth = 1;
        layout.gridheight = 1;

        add(indicadorDano, layout);

    }
}

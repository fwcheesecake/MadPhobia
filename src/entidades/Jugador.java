package entidades;

import elementos.Indicador;
import elementos.Inventario;

import javax.swing.*;

import java.awt.*;

public class Jugador extends Ser {
    public static ImageIcon[] iconos = {
            new ImageIcon(Jugador.class.getResource("/sprites/pjs/protagonistas/jonathan.gif")),
            new ImageIcon(Jugador.class.getResource("/sprites/pjs/protagonistas/antonio.gif")),
            new ImageIcon(Jugador.class.getResource("/sprites/pjs/protagonistas/daniela.gif"))
    };

    private Inventario inventario;
    private Indicador indicador;
    private ImageIcon icono;

    private Point casilla;

    public Jugador() {
        super();
        setInventario(new Inventario());
        setIndicador(new Indicador());
        setCasilla(new Point(0, 0));
    }

    public Jugador(String nombre, int imagen, int vida, int escudo, int fuerza, Point casilla, ImageIcon icono) {
        super(nombre, imagen, vida, escudo, fuerza);
        setInventario(new Inventario());
        setIndicador(new Indicador());
        setCasilla(casilla);
        setIcono(icono);
    }


    public Inventario getInventario() { return inventario; }
    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }

    private ImageIcon returnScaledImage(ImageIcon icon, int w, int h) {
        return new ImageIcon(icon.getImage().getScaledInstance(w, h, Image.SCALE_DEFAULT));
    }

    public void recogerObjeto(Objeto objeto) {
        if(objeto instanceof Arma && getInventario().getArmaEquipada() == null) {
            Arma arma = (Arma) objeto;
            getIndicador().texDAño.setText("" + (arma.getDano() + getFuerza()));
            getInventario().setArmaEquipada(arma);
            getIndicador().arma.setIcon(returnScaledImage(Arma.iconos[arma.getImagen()], 40, 40));
            getInventario().arma.setIcon(returnScaledImage(Arma.iconos[arma.getImagen()], 62, 62));
        } else if(objeto instanceof Escudo && getInventario().getEscudoEquipado() == null) {
            Escudo escudo = (Escudo) objeto;
            getIndicador().texEsc.setText("" + escudo.getEscudo());
            setEscudo(escudo.getEscudo());
            getInventario().setEscudoEquipado(escudo);
            getIndicador().escudo.setIcon(returnScaledImage(Escudo.iconos[escudo.getImagen()], 40, 40));
            getInventario().escudo.setIcon(returnScaledImage(Escudo.iconos[escudo.getImagen()], 62, 62));
        } else {
            for (int i = 0; i < 9; i++) {
                if (getInventario().getMochila()[i] == null) {
                    getInventario().getMochila()[i] = objeto;
                    if(objeto instanceof Arma) {
                        getInventario().botonesDeMochila[i].setIcon(
                                returnScaledImage(Arma.iconos[objeto.getImagen()], 62, 62));
                    } else if(objeto instanceof Escudo) {
                        getInventario().botonesDeMochila[i].setIcon(
                                returnScaledImage(Escudo.iconos[objeto.getImagen()], 62, 62));
                    } else {
                        getInventario().botonesDeMochila[i].setIcon(
                                returnScaledImage(Consumible.iconos[objeto.getImagen()], 62, 62));
                    }
                    break;
                }
            }
        }
    }
    public void abririnventario(){
        for(int i = 0; i < 9; i++) {

        }
    }

    public Indicador getIndicador() {
        return indicador;
    }

    public void setIndicador(Indicador indicador) {
        this.indicador = indicador;
    }

    public Point getCasilla() {
        return casilla;
    }

    public void setCasilla(Point casilla) {
        this.casilla = casilla;
    }

    public ImageIcon getIcono() {
        return icono;
    }

    public void setIcono(ImageIcon icono) {
        this.icono = icono;
    }
}

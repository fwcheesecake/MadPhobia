package elementos;

import entidades.Arma;
import entidades.Escudo;
import entidades.Objeto;

import javax.swing.*;
import java.awt.*;

public class Inventario extends JPanel {
    private Arma armaEquipada;
    private Escudo escudoEquipado;
    private Objeto[] mochila;

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

        setBounds(x, y, w, h);
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
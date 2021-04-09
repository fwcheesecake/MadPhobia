package entidades;

import elementos.Indicador;
import elementos.Inventario;

import javax.swing.*;

import java.awt.*;

public class Jugador extends Ser {
    public static ImageIcon[] iconos = {
            new ImageIcon(Escudo.class.getResource("/sprites/pjs/protagonistas/jonathan.gif")),
            new ImageIcon(Escudo.class.getResource("/sprites/pjs/protagonistas/antonio.gif")),
            new ImageIcon(Escudo.class.getResource("/sprites/pjs/protagonistas/daniela.gif"))
    };

    private Inventario inventario;
    private Indicador indicador;

    private Point casilla;

    public Jugador() {
        super();
        setInventario(new Inventario());
        setIndicador(new Indicador());
        setCasilla(new Point(0, 0));
    }

    public Jugador(String nombre, int imagen, int vida, int escudo, int fuerza, Point casilla) {
        super(nombre, imagen, vida, escudo, fuerza);
        setInventario(new Inventario());
        setIndicador(new Indicador());
        setCasilla(casilla);
    }


    public Inventario getInventario() { return inventario; }
    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }

    public void Avanzar(){

    }
    public void RecogerObjeto(){

    }
    public void Abririnventario(){

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
}

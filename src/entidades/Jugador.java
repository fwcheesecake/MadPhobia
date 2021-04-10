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

    public ImageIcon getIcono() {
        return icono;
    }

    public void setIcono(ImageIcon icono) {
        this.icono = icono;
    }
}

package entidades;

import elementos.Indicador;
import elementos.Inventario;

import javax.swing.*;

import java.awt.*;

public class Jugador extends Ser {
    private Inventario inventario;
    private Indicador indicador;

    private Point casilla;

    public Jugador() {
        super();
        setInventario(new Inventario());
        setIndicador(new Indicador());
        setCasilla(new Point(0, 0));
    }

    public static void inicializarIconos() {
        iconos[0].setDescription("Antonio");
        iconos[1].setDescription("Daniela");
        iconos[2].setDescription("Jonathan");

    }
    public Inventario getInventario() { return inventario; }
    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }
    public static ImageIcon[] iconos = {
            new ImageIcon(Escudo.class.getResource("/sprites/pjs/protagonistas/antonio.gif")),
            new ImageIcon(Escudo.class.getResource("/sprites/pjs/protagonistas/daniela.gif")),
            new ImageIcon(Escudo.class.getResource("/sprites/pjs/protagonistas/jonathan.gif"))
    };

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

package entidades;

import elementos.Casilla;
import elementos.Indicador;
import elementos.Inventario;

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

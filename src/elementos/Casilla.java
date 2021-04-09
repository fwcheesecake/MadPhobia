package elementos;

import entidades.Entidad;
import enumerados.Estado;

import javax.swing.*;

public class Casilla extends JButton {
    private int posX;
    private int posY;
    private Estado estado;
    private Entidad entidad;

    public Casilla() {
        super();
        setPosX(-1);
        setPosY(-1);
        setEstado(Estado.NORMAL);
        setEntidad(new Entidad());
        setCursor(Cursores.POR_ENCIMA);
    }

    public Casilla(int x, int y) {
        super();
        setPosX(x);
        setPosY(y);
        setEstado(Estado.NORMAL);
        setEntidad(new Entidad());
        setCursor(Cursores.POR_ENCIMA);
    }

    public int getPosX() {
        return posX;
    }
    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }
    public void setPosY(int posY) {
        this.posY = posY;
    }

    public Estado getEstado() {
        return estado;
    }
    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    public boolean esNormal() {
        return getEstado() == Estado.NORMAL;
    }
    public boolean esPuerta() {
        return getEstado() == Estado.PUERTA;
    }
    public boolean esEntrada() {
        return getEstado() == Estado.ENTRADA;
    }
    public boolean esPared() {
        return getEstado() == Estado.PARED;
    }
    public boolean estaOcupada() {
        return getEstado() == Estado.OCUPADO;
    }
    public boolean hayJugador() {
        return getEstado() == Estado.JUGADOR;
    }

    public Entidad getEntidad() {
        return entidad;
    }
    public void setEntidad(Entidad entidad) {
        this.entidad = entidad;
    }
}

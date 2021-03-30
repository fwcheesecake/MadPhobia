package elementos;

import entidades.Entidad;

import javax.swing.*;

public class Casilla extends JButton {
    private int posX;
    private int posY;
    private byte estado;
    private Entidad entidad;

    public Casilla() {
        setPosX(-1);
        setPosY(-1);
        setEstado((byte) -1);
        setEntidad(new Entidad());
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

    public byte getEstado() {
        return estado;
    }
    public void setEstado(byte estado) {
        this.estado = estado;
    }

    public Entidad getEntidad() {
        return entidad;
    }
    public void setEntidad(Entidad entidad) {
        this.entidad = entidad;
    }
}

package elementos;

import entidades.Arma;
import entidades.Objeto;

public class Inventario {
    private Objeto[] equipados;
    private Objeto[] mochila;

    public Inventario() {
        setEquipados(new Objeto[2]);
        setMochila(new Objeto[9]);
    }

    public Objeto[] getEquipados() {
        return equipados;
    }
    public void setEquipados(Objeto[] equipados) {
        this.equipados = equipados;
    }

    public Objeto[] getMochila() {
        return mochila;
    }
    public void setMochila(Objeto[] mochila) {
        this.mochila = mochila;
    }

    public void tirar(int objeto) {
        mochila[objeto] = null;
    }

    public void equipar(int objeto) {
        Objeto objetoSeleccionado = mochila[objeto];
        Objeto objetoACambiar;
        if(mochila[objeto] instanceof Arma) {
            objetoACambiar = equipados[0];
            equipados[0] = objetoSeleccionado;
        } else {
            objetoACambiar = equipados[1];
            equipados[1] = objetoSeleccionado;
        }
        mochila[objeto] = objetoACambiar;
    }

    public void desequipar(int objeto) {

    }
}
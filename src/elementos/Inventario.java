package elementos;

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

    }

    public void equipar(int objeto) {

    }

    public void desequipar(int objeto) {

    }
}

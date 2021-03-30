package entidades;

import enumerados.Tipo;

public class Arma extends Objeto {
    int dano;
    Tipo tipo;

    public Arma() {
        super();
        setDano(0);
        setTipo(Tipo.MELEE);
    }

    public int getDano() {
        return dano;
    }
    public void setDano(int dano) {
        this.dano = dano;
    }

    public Tipo getTipo() {
        return tipo;
    }
    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
}
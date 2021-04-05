package entidades;

import elementos.Casilla;
import elementos.Indicador;
import elementos.Inventario;

public class Jugador {
    private Inventario inventario;
    public Jugador() {
        super();
        setInventario(null);
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
}

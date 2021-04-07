package entidades;

public class Ser extends Entidad{
    private int vida;
    private int escudo;
    private int fuerza;

    public Ser() {
        super();
        setVida(100);
        setEscudo(100);
        setFuerza(15);
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getEscudo() {
        return escudo;
    }

    public void setEscudo(int escudo) {
        this.escudo = escudo;
    }

    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }
}

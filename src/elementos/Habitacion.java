package elementos;

import javax.swing.*;
import java.awt.*;

public class Habitacion extends JPanel {
    private int filas;
    private int columnas;
    private Casilla[][] casillas;

    public Habitacion() {
        setFilas(3);
        setColumnas(3);
        setCasillas(new Casilla[filas][columnas]);

        setLayout(new GridLayout(filas, columnas));

        for(int i = 0; i < filas; i++) {
            for(int j = 0; j < columnas; j++) {
                casillas[i][j] = new Casilla();
                add(casillas[i][j]);
            }
        }
    }

    public int getFilas() {
        return filas;
    }
    public void setFilas(int filas) {
        this.filas = filas;
    }

    public int getColumnas() {
        return columnas;
    }
    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }

    public Casilla[][] getCasillas() {
        return casillas;
    }
    public void setCasillas(Casilla[][] casillas) {
        this.casillas = casillas;
    }
}

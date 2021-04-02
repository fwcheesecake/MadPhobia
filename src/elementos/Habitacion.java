package elementos;

import entidades.Consumible;
import entidades.Enemigo;
import enumerados.Estado;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Habitacion extends JPanel implements ActionListener {
    private int filas;
    private int columnas;
    private Casilla[][] casillas;

    private Random rand;
    private int x, y;

    private final int[][][] dungeons =
            {
                    //First set
                    {
                            {1, 1, 1},
                            {0, 0, 1},
                            {0, 0, 1}
                    },
                    {
                            {1, 0, 0},
                            {1, 0, 0},
                            {1, 1, 1}
                    },
                    {
                            {1, 1, 1},
                            {1, 0, 0},
                            {1, 0, 0}
                    },
                    {
                            {0, 0, 1},
                            {0, 0, 1},
                            {1, 1, 1}
                    },
                    //Second set
                    {
                            {1, 1, 1},
                            {0, 0, 0},
                            {0, 0, 0}
                    },
                    {
                            {1, 0, 0},
                            {1, 0, 0},
                            {1, 0, 0}
                    },
                    {
                            {0, 0, 0},
                            {0, 0, 0},
                            {1, 1, 1}
                    },
                    {
                            {1, 1, 1},
                            {0, 0, 0},
                            {0, 0, 0}
                    },
                    //Third set
                    {
                            {1, 0, 1},
                            {0, 0, 0},
                            {0, 0, 0}
                    },
                    {
                            {1, 0, 0},
                            {0, 0, 0},
                            {1, 0, 0}
                    },
                    {
                            {0, 0, 0},
                            {0, 0, 0},
                            {1, 0, 1}
                    },
                    {
                            {0, 0, 1},
                            {0, 0, 0},
                            {0, 0, 1}
                    },
                    //Fourth set
                    {
                            {1, 0, 0},
                            {1, 0, 1},
                            {0, 0, 1}
                    },
                    {
                            {1, 1, 0},
                            {0, 0, 0},
                            {0, 1, 1}
                    },
                    {
                            {0, 0, 1},
                            {1, 0, 1},
                            {1, 0, 0}
                    },
                    {
                            {0, 1, 1},
                            {0, 0, 0},
                            {1, 1, 0}
                    },
                    //Fifth set
                    {
                            {0, 0, 0},
                            {0, 1, 0},
                            {0, 0, 0}
                    },
                    {
                            {1, 0, 0},
                            {0, 0, 0},
                            {0, 0, 1}
                    },
                    {
                            {0, 0, 1},
                            {0, 0, 0},
                            {1, 0, 0}
                    },
                    {
                            {0, 0, 0},
                            {0, 0, 0},
                            {0, 0, 0}
                    }
            };

    public Habitacion() {
        rand = new Random(System.currentTimeMillis());
        int fc = 2 + rand.nextInt(2);

        setFilas(fc * 3);
        setColumnas(fc * 3);
        setCasillas(new Casilla[filas][columnas]);

        setLayout(new GridLayout(filas, columnas));

        agregarCasillas();
        agregarPuerta();
        agregarConsumibles();
        agregarEnemigos();
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

    @Override
    public void actionPerformed(ActionEvent e) {
        Casilla casillaSeleccionada = (Casilla) e.getSource();
        if(casillaSeleccionada.getEstado() == Estado.PUERTA) {
            crearNuevaHabitacion();
        } else if(casillaSeleccionada.getEstado() == Estado.PARED) {
            System.out.println("Es pared");
        }
    }

    private void agregarCasillas() {
        int a = rand.nextInt(20);
        int b = filas / 3;

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                rellenarBloque(a, i, j, b);
            }
        }

        for(int i = 0; i < filas; i++) {
            for(int j = 0; j < columnas; j++) {
                add(casillas[i][j]);
            }
        }
    }

    private void agregarPuerta() {
        do {
            x = rand.nextInt(filas);
            y = rand.nextInt(columnas);
        } while(casillas[x][y].esPared());
        casillas[x][y].setEstado(Estado.PUERTA);
        casillas[x][y].setBackground(new Color(0x2A2AEC));

        do {
            x = rand.nextInt(filas);
            y = rand.nextInt(columnas);
        } while(casillas[x][y].esPuerta() || casillas[x][y].esPared());
        casillas[x][y].setEstado(Estado.ENTRADA);
        casillas[x][y].setBackground(new Color(0x52EF47));
    }

    private void agregarConsumibles() {
        for(int i = 0; i < filas/ 3 - 1; i++) {
            do {
                x = rand.nextInt(filas);
                y = rand.nextInt(columnas);
            } while(casillas[x][y].esPared() || casillas[x][y].esEntrada() || casillas[x][y].esPuerta() || casillas[x][y].estaOcupada());
            casillas[x][y].setIcon(Consumible.iconos[0]);
            casillas[x][y].setEstado(Estado.OCUPADO);
        }
    }

    private void agregarEnemigos() {
        for(int i = 0; i < filas; i++) {
            do {
                x = rand.nextInt(filas);
                y = rand.nextInt(columnas);
            } while(casillas[x][y].esPared() || casillas[x][y].esEntrada() || casillas[x][y].esPuerta() || casillas[x][y].estaOcupada());
            casillas[x][y].setIcon(Enemigo.iconos[0]);
            casillas[x][y].setEstado(Estado.OCUPADO);
        }
    }

    private void rellenarBloque(int i, int j, int k, int e) {
        if(dungeons[i][j][k] == 0) {
            for(int l = j * e; l < j * e + e; l++) {
                for(int m = k * e; m < k * e + e; m++) {
                    casillas[l][m] = new Casilla(l, m);
                    casillas[l][m].addActionListener(this);
                    casillas[l][m].setBackground(new Color(0x181818));
                }
            }
        } else {
            for(int l = j * e; l < j * e + e; l++) {
                for(int m = k * e; m < k * e + e; m++) {
                    casillas[l][m] = new Casilla(l, m);
                    casillas[l][m].setBorder(null);
                    casillas[l][m].setOpaque(false);
                    casillas[l][m].setBackground(new Color(0x000000));
                    casillas[l][m].setEnabled(false);
                    casillas[l][m].setEstado(Estado.PARED);
                }
            }
        }
    }

    private void crearNuevaHabitacion() {
        removeAll();
        repaint();
        revalidate();

        Random rand = new Random(System.currentTimeMillis());
        int fc = 2 + rand.nextInt(2);
        setFilas(fc * 3);
        setColumnas(fc * 3);
        setCasillas(new Casilla[filas][columnas]);

        setLayout(new GridLayout(filas, columnas));

        agregarCasillas();
        agregarPuerta();
        agregarConsumibles();
        agregarEnemigos();
    }
}

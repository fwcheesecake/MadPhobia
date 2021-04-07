package elementos;

import entidades.Arma;
import entidades.Consumible;
import entidades.Enemigo;
import entidades.Escudo;
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
        agregarEnemigos();
        agregarConsumibles();
        agregarArmas();
        agregarEscudos();
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
        if(casillaSeleccionada.esPuerta()) {
            crearNuevaHabitacion();
        } else if(casillaSeleccionada.estaOcupada()) {
            if(casillaSeleccionada.getEntidad() instanceof Consumible) {
                int index = casillaSeleccionada.getEntidad().getImagen();
                scaleImage(Consumible.iconos[index], casillaSeleccionada.getSize());
                casillaSeleccionada.setIcon(Consumible.iconos[index]);
            } else if(casillaSeleccionada.getEntidad() instanceof Escudo) {

            } else if(casillaSeleccionada.getEntidad() instanceof Arma) {

            } else {
                int index = casillaSeleccionada.getEntidad().getImagen();
                scaleImage(Enemigo.iconos[index], casillaSeleccionada.getSize());
                casillaSeleccionada.setIcon(Enemigo.iconos[index]);
            }
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
        casillas[x][y].setBackground(new Color(0xFFFFFF));
    }

    private void agregarConsumibles() {
        Random rand = new Random(System.currentTimeMillis());
        int cota = Consumible.iconos.length;

        for(int i = 0; i < filas/ 3 - 1; i++) {
            do {
                x = rand.nextInt(filas);
                y = rand.nextInt(columnas);
            } while(casillas[x][y].esPared() || casillas[x][y].esEntrada() || casillas[x][y].esPuerta() || casillas[x][y].estaOcupada());

            Consumible entidad = new Consumible();

            entidad.setImagen(rand.nextInt(cota));

            casillas[x][y].setEntidad(entidad);
            casillas[x][y].setBackground(new Color(0x6EFD47));
            casillas[x][y].setEstado(Estado.OCUPADO);
        }
    }

    private void agregarEnemigos() {
        Random rand = new Random(System.currentTimeMillis());
        int cota = Enemigo.iconos.length;

        for(int i = 0; i < filas; i++) {
            do {
                x = rand.nextInt(filas);
                y = rand.nextInt(columnas);
            } while(casillas[x][y].esPared() || casillas[x][y].esEntrada() || casillas[x][y].esPuerta() || casillas[x][y].estaOcupada());

            Enemigo entidad = new Enemigo();

            entidad.setImagen(rand.nextInt(cota));

            casillas[x][y].setEntidad(entidad);
            casillas[x][y].setBackground(new Color(0xEA1E1E));
            casillas[x][y].setEstado(Estado.OCUPADO);
        }
    }

    private void agregarArmas() {
        Random rand = new Random(System.currentTimeMillis());
        int cota = Arma.iconos.length;
        int nArmas = rand.nextInt(2);

        for(int i = 0; i < nArmas; i++) {
            do {
                x = rand.nextInt(filas);
                y = rand.nextInt(columnas);
            } while(casillas[x][y].esPared() || casillas[x][y].esEntrada() || casillas[x][y].esPuerta() || casillas[x][y].estaOcupada());

            Arma entidad = new Arma();

            entidad.setImagen(rand.nextInt(cota));

            casillas[x][y].setEntidad(entidad);
            casillas[x][y].setBackground(new Color(0xE9572D));
            casillas[x][y].setEstado(Estado.OCUPADO);
        }
    }

    private void agregarEscudos() {
        Random rand = new Random(System.currentTimeMillis());
        int cota = Escudo.iconos.length;
        int nEscudos= rand.nextInt(2);

        for(int i = 0; i < nEscudos; i++) {
            do {
                x = rand.nextInt(filas);
                y = rand.nextInt(columnas);
            } while(casillas[x][y].esPared() || casillas[x][y].esEntrada() || casillas[x][y].esPuerta() || casillas[x][y].estaOcupada());

            Escudo entidad = new Escudo();

            entidad.setImagen(rand.nextInt(cota));

            casillas[x][y].setEntidad(entidad);
            casillas[x][y].setBackground(new Color(0x2A81CD));
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

    private void scaleImage(ImageIcon icon, Dimension d) {
        if(d.getHeight() == icon.getIconHeight() && d.getWidth() == icon.getIconWidth())
            return;
        Image scaled = icon.getImage();
        int w = (int) d.getWidth(), h = (int) d.getHeight();
        Image ret = scaled.getScaledInstance(w, h, Image.SCALE_DEFAULT);
        icon.setImage(ret);
    }
}

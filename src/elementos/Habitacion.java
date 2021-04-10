package elementos;

import entidades.*;
import enumerados.Estado;
import enumerados.Tipo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Habitacion extends JPanel implements ActionListener {
    public static int nivel = 0;
    public static int turno = 0;

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
        int fc = 3; //+ rand.nextInt(2);

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

        Point p = Juego.jugadorActual.getCasilla();
        casillas[(int) p.getX()][(int) p.getY()].setIcon(null);

        scaleImage(Juego.jugadorActual.getIcono(), casillaSeleccionada.getSize());
        casillaSeleccionada.setIcon(Juego.jugadorActual.getIcono());

        if(casillaSeleccionada.esPuerta()) {
            crearNuevaHabitacion();
        } else if(casillaSeleccionada.estaOcupada()) {
            if(casillaSeleccionada.getEntidad() instanceof Consumible) {

            } else if(casillaSeleccionada.getEntidad() instanceof Escudo) {

            } else if(casillaSeleccionada.getEntidad() instanceof Arma) {

            } else {
                Enemigo enemigo = (Enemigo) casillaSeleccionada.getEntidad();
                int danoRecebido = enemigo.getFuerza();
                int danoRealizado = Juego.jugadorActual.getFuerza();

                int escudoJugador = Juego.jugadorActual.getEscudo();
                int vidaJugador = Juego.jugadorActual.getVida();

                escudoJugador -= danoRecebido;
                if(escudoJugador < 0) {
                    danoRecebido = Math.abs(escudoJugador);
                    escudoJugador = 0;
                } else {
                    danoRecebido = 0;
                }
                vidaJugador -= danoRecebido;
                if(vidaJugador < 0)
                    vidaJugador = 0;

                int vidaEnemigo = enemigo.getVida() - danoRealizado;
                if(vidaEnemigo < 0)
                    vidaEnemigo = 0;

                Juego.jugadorActual.setEscudo(escudoJugador);
                Juego.jugadorActual.setVida(vidaJugador);

                enemigo.setVida(vidaEnemigo);

                System.out.println("Nombre: " + Juego.jugadorActual.getNombre());
                System.out.println("Vida: " + Juego.jugadorActual.getVida());
                System.out.println("Escudo: " + Juego.jugadorActual.getEscudo());

                System.out.println("Nombre: " + enemigo.getNombre());
                System.out.println("Vida: " + enemigo.getVida());

                if(enemigo.estaMuerto()) {
                    casillaSeleccionada.setEstado(Estado.NORMAL);
                    casillaSeleccionada.setEntidad(null);
                }
            }
        }

        if(Juego.gameOver()) {
            System.exit(0);
        }
        do {
            Juego.jugadorActual.setCasilla(new Point(casillaSeleccionada.getPosX(), casillaSeleccionada.getPosY()));
            turno = (turno + 1) % 3;
            switch (turno) {
                case 0 -> Juego.jugadorActual = Juego.jugador1;
                case 1 -> Juego.jugadorActual = Juego.jugador2;
                case 2 -> Juego.jugadorActual = Juego.jugador3;
            }
        } while(Juego.jugadorActual.estaMuerto());
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
        } while (casillas[x][y].esPuerta() || casillas[x][y].esPared());

        casillas[x][y].setEstado(Estado.ENTRADA);
        casillas[x][y].setBackground(new Color(0xFFFFFF));

        Juego.jugador1.setCasilla(new Point(x, y));
        Juego.jugador2.setCasilla(new Point(x, y));
        Juego.jugador3.setCasilla(new Point(x, y));
        scaleImage(Jugador.iconos[0], new Dimension(90, 90));
        scaleImage(Jugador.iconos[1], new Dimension(90, 90));
        scaleImage(Jugador.iconos[2], new Dimension(90, 90));

        casillas[x][y].setIcon(Jugador.iconos[0]);
    }

    private void agregarConsumibles() {
        Random rand = new Random(System.currentTimeMillis());
        int cota = Consumible.iconos.length;

        for(int i = 0; i < filas/ 3 - 1; i++) {
            do {
                x = rand.nextInt(filas);
                y = rand.nextInt(columnas);
            } while(casillas[x][y].esPared() || casillas[x][y].esEntrada() || casillas[x][y].esPuerta() || casillas[x][y].estaOcupada());

            int index = rand.nextInt(cota);
            String nombre = Enemigo.iconos[index].getDescription();

            Consumible entidad = new Consumible(nombre, index, Consumible.descripcion[index], 15);

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

            int index = rand.nextInt(cota);
            String nombre = Enemigo.iconos[index].getDescription();
            Tipo fortaleza = fortalezaEnemigo(nombre);
            Tipo debilidad = debilidadEnemigo(nombre);

            Enemigo entidad = new Enemigo(nombre, index, 100, 0, 15, fortaleza, debilidad);

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

            int index = rand.nextInt(cota);
            String nombre = Enemigo.iconos[index].getDescription();

            Arma entidad = new Arma(nombre, index, Arma.descripcion[index], 15, tipoRandom(rand.nextInt()));

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

            int index = rand.nextInt(cota);
            String nombre = Enemigo.iconos[index].getDescription();

            Escudo entidad = new Escudo(nombre, index, Arma.descripcion[index], 15);

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
        nivel++;
        removeAll();
        repaint();
        revalidate();
        //Random rand = new Random(System.currentTimeMillis());
        int fc = 3; //+ rand.nextInt(2);
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

    public Tipo tipoRandom(int x) {
        int y = x % 4;
        switch (y) {
            case 0 -> {
                return Tipo.MELEE;
            }
            case 1 -> {
                return Tipo.EXPLOSIVO;
            }
            case 2 -> {
                return Tipo.FUEGO;
            }
            case 3 -> {
                return Tipo.RADIACTIVO;
            }
        }
        return Tipo.MELEE;
    }

    public Tipo debilidadEnemigo(String name) {
        switch (name) {
            case "Saqueador" -> {
                return Tipo.FUEGO;
            } case "Soldado" -> {
                return Tipo.RADIACTIVO;
            } case "Cosa", "Dos Cabezas", "Guts" -> {
                return Tipo.EXPLOSIVO;
            }
        }
        return Tipo.MELEE;
    }

    public Tipo fortalezaEnemigo(String name) {
        switch (name) {
            case "Saqueador" -> {
                return Tipo.MELEE;
            } case "Soldado" -> {
                return Tipo.FUEGO;
            } case "Cosa", "Dos Cabezas", "Guts" -> {
                return Tipo.RADIACTIVO;
            }
        }
        return Tipo.MELEE;
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

package elementos;

import entidades.*;
import enumerados.Efectos;
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
    private int click = 0;

    public static ImageIcon piso1 = new ImageIcon(Habitacion.class.getResource("/sprites/suelos/piso1.png"));
    public static ImageIcon piso2 = new ImageIcon(Habitacion.class.getResource("/sprites/suelos/piso2.png"));
    public static ImageIcon piso3 = new ImageIcon(Habitacion.class.getResource("/sprites/suelos/piso3.png"));

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

    public static ImageIcon getPiso() {
        if(nivel < 35)
            return piso1;
        else if(nivel < 70)
            return piso2;
        return piso3;
    }

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
        click++;

        Point p = Juego.jugadorActual.getCasilla();
        casillas[(int) p.getX()][(int) p.getY()].setIcon(null);

        scaleImage(Juego.jugadorActual.getIcono(), casillaSeleccionada.getSize());
        casillaSeleccionada.setIcon(Juego.jugadorActual.getIcono());
        Juego.jugadorActual.setCasilla(new Point(casillaSeleccionada.getPosX(), casillaSeleccionada.getPosY()));

        if(casillaSeleccionada.esPuerta()) {
            click = 2;
            Juego.actualizarFeed();
            crearNuevaHabitacion();
        } else if(casillaSeleccionada.estaOcupada()) {
            if(casillaSeleccionada.getEntidad() instanceof Consumible) {
                if(click == 2) {
                    Juego.jugadorActual.recogerObjeto((Consumible) casillaSeleccionada.getEntidad());
                    casillaSeleccionada.setEstado(Estado.NORMAL);
                    casillaSeleccionada.setEntidad(null);
                }
                Juego.actualizarFeed((Consumible) casillaSeleccionada.getEntidad());
            } else if(casillaSeleccionada.getEntidad() instanceof Escudo) {
                if(click == 2) {
                    Juego.jugadorActual.recogerObjeto((Escudo) casillaSeleccionada.getEntidad());
                    casillaSeleccionada.setEstado(Estado.NORMAL);
                    casillaSeleccionada.setEntidad(null);
                }
                Juego.actualizarFeed((Escudo) casillaSeleccionada.getEntidad());
            } else if(casillaSeleccionada.getEntidad() instanceof Arma) {
                if(click == 2) {
                    Juego.jugadorActual.recogerObjeto((Arma) casillaSeleccionada.getEntidad());
                    casillaSeleccionada.setEstado(Estado.NORMAL);
                    casillaSeleccionada.setEntidad(null);
                }
                Juego.actualizarFeed((Arma) casillaSeleccionada.getEntidad());
            } else {
                if(click == 2)
                    ataque(casillaSeleccionada);
                Juego.actualizarFeed((Enemigo) casillaSeleccionada.getEntidad());
            }
        } else {
            Juego.actualizarFeed();
            click = 2;
        }

        System.out.println("----------------------------------------------------------------");
        System.out.println("Nombre: " + Juego.jugadorActual.getNombre() + "\n" +
                "Vida: " + Juego.jugadorActual.getVida() + "\n" +
                "Escudo: " + Juego.jugadorActual.getEscudo() + "\n" +
                "Inventario: ");
        if(Juego.jugadorActual.getInventario().getArmaEquipada() != null)
            System.out.println("Arma: " + Juego.jugadorActual.getInventario().getArmaEquipada().getNombre());
        if(Juego.jugadorActual.getInventario().getEscudoEquipado() != null)
            System.out.println("Escudo: " + Juego.jugadorActual.getInventario().getEscudoEquipado().getNombre());
        for (int j = 0; j < Juego.jugadorActual.getInventario().getMochila().length; j++) {
            if(Juego.jugadorActual.getInventario().getMochila()[j] != null) {
                System.out.println(j + ": " + Juego.jugadorActual.getInventario().getMochila()[j].getNombre());
            }
        }
        System.out.println("----------------------------------------------------------------");

        if(Juego.gameOver()) {
            Derrotado d = new Derrotado();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
            System.exit(0);
        }

        if(click == 2) {
            do {
                Juego.jugadorActual.setCasilla(new Point(casillaSeleccionada.getPosX(), casillaSeleccionada.getPosY()));
                turno = (turno + 1) % 3;
                switch (turno) {
                    case 0 -> Juego.jugadorActual = Juego.jugador1;
                    case 1 -> Juego.jugadorActual = Juego.jugador2;
                    case 2 -> Juego.jugadorActual = Juego.jugador3;
                }

                if(Juego.jugadorActual.estaMuerto()
                        && Juego.jugadorActual.getIndicador().isEnabled()) {
                    Juego.jugadorActual.getIndicador().setOpaque(false);
                    Juego.jugadorActual.getIndicador().setEnabled(false);
                }
            } while (Juego.jugadorActual.estaMuerto());
            click = 0;
        }
    }
    private int hayOtrosJugadores(Casilla casillaSeleccionada) {
        int retDano = 0;
        int x = casillaSeleccionada.getPosX(), y = casillaSeleccionada.getPosY();

        if(!Juego.jugador1.equals(Juego.jugadorActual) && Juego.jugador1.getCasilla().getX() == x
                && Juego.jugador1.getCasilla().getY() == y) {
            retDano += Juego.jugador1.getFuerza();
            if(Juego.jugador1.getInventario().getArmaEquipada() != null)
                retDano += Juego.jugador1.getInventario().getArmaEquipada().getDano();
        }
        if(!Juego.jugador2.equals(Juego.jugadorActual) && Juego.jugador2.getCasilla().getX() == x
                && Juego.jugador2.getCasilla().getY() == y) {
            retDano += Juego.jugador2.getFuerza();
            if(Juego.jugador2.getInventario().getArmaEquipada() != null)
                retDano += Juego.jugador2.getInventario().getArmaEquipada().getDano();
        }
        if(!Juego.jugador3.equals(Juego.jugadorActual) && Juego.jugador3.getCasilla().getX() == x
                && Juego.jugador3.getCasilla().getY() == y) {
            retDano += Juego.jugador3.getFuerza();
            if(Juego.jugador3.getInventario().getArmaEquipada() != null)
                retDano += Juego.jugador3.getInventario().getArmaEquipada().getDano();
        }
        return retDano;
    }
    private Efectos getEfecto(String nombre) {
        int p = rand.nextInt(10);
        if(p < 3) {
            return Efectos.SANGRADO;
        } else if(p <= 6) {
            return switch (nombre) {
                case "Saqueador" -> null;
                case "Soldado" -> Efectos.FUEGO;
                default -> Efectos.RADIACION;
            };
        }
        return null;
    }
    private void ataque(Casilla casillaSeleccionada) {
        Enemigo enemigo = (Enemigo) casillaSeleccionada.getEntidad();

        Efectos efecto = getEfecto(enemigo.getNombre());
        if(efecto != null) {
            Efecto.nuevoEfecto(Juego.jugadorActual, efecto);
        }

        int danoRecebido = enemigo.getFuerza();
        int danoRealizado = Juego.jugadorActual.getFuerza();

        if(Juego.jugadorActual.getInventario().getArmaEquipada() != null)
            danoRealizado += Juego.jugadorActual.getInventario().getArmaEquipada().getDano();

        danoRealizado += hayOtrosJugadores(casillaSeleccionada);

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

        Juego.jugadorActual.getIndicador().texVida.setText("" + Juego.jugadorActual.getVida());
        Juego.jugadorActual.getIndicador().texEsc.setText("" + Juego.jugadorActual.getEscudo());

        if(enemigo.estaMuerto()) {
            casillaSeleccionada.setEstado(Estado.NORMAL);
            casillaSeleccionada.setEntidad(null);
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
        casillas[x][y].setOpaque(true);
        casillas[x][y].setBackground(new Color(0x2A2AEC));

        do {
            x = rand.nextInt(filas);
            y = rand.nextInt(columnas);
        } while (casillas[x][y].esPuerta() || casillas[x][y].esPared());

        casillas[x][y].setEstado(Estado.ENTRADA);

        Juego.jugador1.setCasilla(new Point(x, y));
        Juego.jugador2.setCasilla(new Point(x, y));
        Juego.jugador3.setCasilla(new Point(x, y));
        scaleImage(Jugador.iconos[0], new Dimension(90, 90));
        scaleImage(Jugador.iconos[1], new Dimension(90, 90));
        scaleImage(Jugador.iconos[2], new Dimension(90, 90));

        if (Juego.jugador1.equals(Juego.jugadorActual)) {
            casillas[x][y].setIcon(Jugador.iconos[0]);
        } else if (Juego.jugador2.equals(Juego.jugadorActual)) {
            casillas[x][y].setIcon(Jugador.iconos[1]);
        } else {
            casillas[x][y].setIcon(Jugador.iconos[2]);
        }
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
            String nombre = Consumible.iconos[index].getDescription();
            int regeneracion = switch (nombre) {
                case "Frijoles enlatados" -> 50;
                case "Atun enlatado" -> 70;
                default -> 50;
            };

            Consumible entidad = new Consumible(nombre, index, Consumible.descripcion[index], regeneracion + nivel);

            casillas[x][y].setEntidad(entidad);
            casillas[x][y].setBackground(new Color(0x6EFD47));
            casillas[x][y].setOpaque(true);
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
            int fuerza = switch (nombre) {
                case "Saqueador" -> 15;
                case "Soldado" -> 20;
                default -> 25;
            };
            Tipo fortaleza = fortalezaEnemigo(nombre);
            Tipo debilidad = debilidadEnemigo(nombre);

            Enemigo entidad = new Enemigo(nombre, index, 100, 0, fuerza + nivel, fortaleza, debilidad);

            casillas[x][y].setEntidad(entidad);
            casillas[x][y].setBackground(new Color(0xEA1E1E));
            casillas[x][y].setOpaque(true);
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
            String nombre = Arma.iconos[index].getDescription();
            int dano = switch (nombre) {
                case "Granada", "Molotov" -> 25;
                case "Glock", "Uzi" -> 15;
                case "Revolver", "Shot Gun" -> 20;
                case "Bate", "Bottle" -> 10;
                default -> 10;
            };

            Arma entidad = new Arma(nombre, index, Arma.descripcion[index], dano + nivel / 10, tipoRandom(rand.nextInt()));

            casillas[x][y].setEntidad(entidad);
            casillas[x][y].setBackground(new Color(0xE9572D));
            casillas[x][y].setOpaque(true);
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
            String nombre = Escudo.iconos[index].getDescription();
            int escudo = switch (nombre) {
                case "Chaleco" -> 50;
                case "Chaleco Pesado" -> 100;
                case "Mascara" -> 70;
                default -> 70;
            };

            Escudo entidad = new Escudo(nombre, index, Arma.descripcion[index], escudo + nivel * 2);


            casillas[x][y].setEntidad(entidad);
            casillas[x][y].setBackground(new Color(0x2A81CD));
            casillas[x][y].setOpaque(true);
            casillas[x][y].setEstado(Estado.OCUPADO);
        }
    }
    private void rellenarBloque(int i, int j, int k, int e) {
        if(dungeons[i][j][k] == 0) {
            for(int l = j * e; l < j * e + e; l++) {
                for(int m = k * e; m < k * e + e; m++) {
                    casillas[l][m] = new Casilla(l, m);
                    casillas[l][m].addActionListener(this);
                    casillas[l][m].setOpaque(false);
                    casillas[l][m].setBackground(new Color(0x000000));
                    casillas[l][m].setFocusPainted(false);
                    casillas[l][m].setBorder(BorderFactory.createLineBorder(new Color(0xA4C1C1C1, true)));
                }
            }
        } else {
            for(int l = j * e; l < j * e + e; l++) {
                for(int m = k * e; m < k * e + e; m++) {
                    casillas[l][m] = new Casilla(l, m);
                    casillas[l][m].setBorder(null);
                    casillas[l][m].setBackground(new Color(0xDC000000, true));
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

        Juego.fondo.setIcon(getPiso());

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

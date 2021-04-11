package elementos;

import entidades.Jugador;
import enumerados.Efectos;

public class Efecto {
    public static void nuevoEfecto(Jugador jugador, Efectos efecto) {
        Thread aplicacion = new Thread(new Runnable() {
            @Override
            public void run() {
                if(efecto == Efectos.SANGRADO) {
                    if(jugador.getIndicador().icon3.isVisible())
                        return;
                    jugador.getIndicador().icon3.setVisible(true);
                    for(int i = 0; i < 10; i++) {
                        jugador.setVida(jugador.getVida() - 2);
                        jugador.getIndicador().texVida.setText("" + jugador.getVida());
                        if(jugador.estaMuerto())
                            break;
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    jugador.getIndicador().icon3.setVisible(false);
                } else if(efecto == Efectos.FUEGO) {
                    if(jugador.getIndicador().icon1.isVisible())
                        return;
                    jugador.getIndicador().icon1.setVisible(true);
                    for(int i = 0; i < 5; i++) {
                        jugador.setVida(jugador.getVida() - 10);
                        jugador.getIndicador().texVida.setText("" + jugador.getVida());
                        if(jugador.estaMuerto())
                            break;
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    jugador.getIndicador().icon1.setVisible(false);
                } else {
                    if(jugador.getIndicador().icon2.isVisible())
                        return;
                    jugador.getIndicador().icon2.setVisible(true);
                    for(int i = 0; i < 70; i++) {
                        jugador.setVida(jugador.getVida() - 1);
                        jugador.getIndicador().texVida.setText("" + jugador.getVida());
                        if(jugador.estaMuerto())
                            break;
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    jugador.getIndicador().icon2.setVisible(false);
                }
            }
        });
        aplicacion.start();
    }
}

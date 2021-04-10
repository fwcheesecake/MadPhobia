package elementos;

import javax.swing.*;
import java.awt.*;

public class Cursores {
    public static Cursor POR_DEFECTO = Toolkit.getDefaultToolkit().createCustomCursor(
            new ImageIcon(Cursores.class.getResource("/imagenes/cursores/pixil-frame-0.png")).getImage()
            , new Point(0, 0), "Cursor por defecto");
    public static Cursor POR_ENCIMA = Toolkit.getDefaultToolkit().createCustomCursor(
            new ImageIcon(Cursores.class.getResource("/imagenes/cursores/pixil-frame-0 (1).png")).getImage()
            , new Point(0, 0), "Cursor sobre componentes");
    public static Cursor PRESIONADO = Toolkit.getDefaultToolkit().createCustomCursor(
            new ImageIcon(Cursores.class.getResource("/imagenes/cursores/pixil-frame-0 (2).png")).getImage()
            , new Point(0, 0), "Cursor al presionar");
}

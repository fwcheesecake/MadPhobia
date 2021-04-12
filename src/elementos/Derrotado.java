package elementos;

import javax.swing.*;

public class Derrotado extends JFrame {
    private final JLabel fondo;
    public Derrotado() {
        fondo = new JLabel();
        fondo.setIcon(new ImageIcon(getClass().getResource("/sprites/screens/muerte.png")));
        fondo.setBounds(0, 0, 400, 300);
        getContentPane().add(fondo);

        setResizable(false);
        setBounds(400, 500, 400, 300);
        setVisible(true);
    }
}

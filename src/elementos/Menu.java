package elementos;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Menu extends JLayeredPane {

    JLabel fondoPanel;
    ImageIcon im;
    int width, height;
    JButton b1,b2;
   Menu(){

       Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
       width = (int) screen.getWidth();
       height = (int) screen.getHeight();

       setBounds(0, 0, width, height);

       fondoPanel = new JLabel();
       im = new ImageIcon(getClass().getResource("/screens/menu.png"));
       fondoPanel.setIcon(im);
       fondoPanel.setHorizontalAlignment(fondoPanel.CENTER);
       fondoPanel.setBounds(0, 0, width, height);
       im.setImage(im.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
       add(fondoPanel, Integer.valueOf(0));

       b1 = new JButton();
       b1.setBounds(732,430,1100,100);
       b1.setBorder(null);
       b1.setFocusPainted(false);
       b1.setOpaque(false);
       b1.setBackground(Color.darkGray);
       add(b1, Integer.valueOf(1));

       b2 = new JButton();
       b2.setBounds(1120,600,250,100);
       b2.setBorder(null);
       b2.setFocusPainted(false);
       b2.setOpaque(false);
       b2.setBackground(Color.darkGray);
       add(b2, Integer.valueOf(1));

       setVisible(false);
   }
}

package elementos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Menu extends JFrame {
    JLayeredPane contentPane = new JLayeredPane();

    public static Juego juego;
    public static Menu menu;

    JLabel fondoPanel;
    ImageIcon im;
    int width, height;
    JButton b1,b2;
   Menu(){

       Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
       width = (int) screen.getWidth();
       height = (int) screen.getHeight();

       setLayout(null);
       setBounds(0, 0, width, height);
       setLocationRelativeTo(null);

       contentPane.setBounds(0, 0, width, height);
       add(contentPane);

       fondoPanel = new JLabel();
       im = new ImageIcon(getClass().getResource("/sprites/screens/menu.png"));
       fondoPanel.setIcon(im);
       fondoPanel.setHorizontalAlignment(fondoPanel.CENTER);
       fondoPanel.setBounds(0, 0, width, height);
       im.setImage(im.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
       contentPane.add(fondoPanel, Integer.valueOf(0));

       b1 = new JButton("");
       b1.setBounds(732,430,1100,100);
       b1.setBorder(null);
       b1.setFocusPainted(false);
       b1.setOpaque(false);
       b1.setBackground(Color.darkGray);
       b1.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               juego = new Juego();

               juego.setFullscreen();
               juego.setVisible(true);
               juego.setTitle("MadPhobia");
               juego.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

               menu.dispose();
           }
       });
       contentPane.add(b1, Integer.valueOf(1));

       b2 = new JButton("");
       b2.setBounds(1120,600,250,100);
       b2.setBorder(null);
       b2.setFocusPainted(false);
       b2.setOpaque(false);
       b2.setBackground(Color.darkGray);
       b2.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               System.exit(0);
           }
       });
       contentPane.add(b2, Integer.valueOf(1));

       setVisible(true);
   }
}

package elementos;

import entidades.Arma;
import entidades.Objeto;

import javax.swing.*;
import java.awt.*;

public class Inventario extends JPanel{

    private Objeto[] equipados;
    private Objeto[] mochila;
    JPanel Inf;
    Inventario inv = new Inventario();
    Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
    JButton [][] BInventario;
    JButton usar, tirar;
    JButton Princ1, Princ2;
    public Inventario() {
        setEquipados(new Objeto[2]);
        setMochila(new Objeto[9]);

        Inf = new JPanel();
        Inf.setBounds(0,0,600,800);
        Inf.setLayout(null);
        Inf.setBackground(new Color(0x3D3B3B));
        Inf.setVisible(true);

        setBounds(0, 0 ,600,600);
        setBackground(new Color(0x181818));
        setLayout(new GridLayout(3, 3));

        usar = new JButton("Usar/Equipar");
        usar.setBackground(new Color(0x2A2929));
        usar.setBounds(630,400,100,50);
        usar.setForeground(Color.black);
        usar.setBorder(BorderFactory.createLineBorder(Color.black));
        Inf.add(usar);

        tirar = new JButton("Tirar");
        tirar.setBackground(new Color(0x2A2929));
        tirar.setBounds(745,400,100,50);
        tirar.setForeground(Color.black);
        tirar.setBorder(BorderFactory.createLineBorder(Color.black));
        Inf.add(tirar);

        Princ1 = new JButton();
        Princ1.setBackground(new Color(0x2A2929));
        Princ1.setBounds(620,250,120,120);
        Princ1.setBorder(BorderFactory.createLineBorder(Color.black));
        Inf.add(Princ1);

        Princ2 = new JButton();
        Princ2.setBackground(new Color(0x2A2929));
        Princ2.setBounds(745,250,120,120);
        Princ2.setBorder(BorderFactory.createLineBorder(Color.black));
        Inf.add(Princ2);

        BInventario = new JButton[3][3];
        for (int i=0;i<3;i++){
            for(int j=0; j<3;j++){
                BInventario[i][j]= new JButton();
                BInventario[i][j].setBackground(new Color(0x181818));
                BInventario[i][j].setBounds(20, 10,50,50);
                add(BInventario[i][j]);
                setVisible(true);
            }
        }

        Inf.add(inv);
        add(Inf, Integer.valueOf(1));



    }



    public Objeto[] getEquipados() {
        return equipados;
    }
    public void setEquipados(Objeto[] equipados) {
        this.equipados = equipados;
    }

    public Objeto[] getMochila() {
        return mochila;
    }
    public void setMochila(Objeto[] mochila) {
        this.mochila = mochila;
    }

    public void tirar(int objeto) {
        mochila[objeto] = null;
    }

    public void equipar(int objeto) {
        Objeto objetoSeleccionado = mochila[objeto];
        Objeto objetoACambiar;
        if(mochila[objeto] instanceof Arma) {
            objetoACambiar = equipados[0];
            equipados[0] = objetoSeleccionado;
        } else {
            objetoACambiar = equipados[1];
            equipados[1] = objetoSeleccionado;
        }
        mochila[objeto] = objetoACambiar;
    }

    public void desequipar(int objeto) {

    }

}
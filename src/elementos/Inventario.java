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

    public Inventario() {
        setEquipados(new Objeto[2]);
        setMochila(new Objeto[9]);

        setBounds(0, 0 ,600,600);
        setBackground(new Color(0x181818));
        setLayout(new GridLayout(3, 3));

        usar = new JButton("Usar/Equipar");
        usar.setBackground(new Color(0x2A2929));
        usar.setBounds(650,200,50,100);
        usar.setBorder(BorderFactory.createLineBorder(Color.black));

        tirar = new JButton("Tirar");
        tirar.setBackground(new Color(0x2A2929));
        tirar.setBounds(650,260,50,100);
        tirar.setBorder(BorderFactory.createLineBorder(Color.black));

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


        add(inv, Integer.valueOf(1));



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
//Guillermo Bértola 303665 y Santiago Durán 351471
package Interfaz;

import java.util.*;
import Dominio.*;

public class Bienvenida extends javax.swing.JFrame {

    public Bienvenida(Sistema sis) {
        initComponents();
        modelo = sis;
        cerrarConTimer();
    }
    
    public void cerrarConTimer(){
        Timer reloj = new Timer();
        TimerTask cerrar = new TimerTask(){
           @Override
           public void run(){
                ElegirSistema vent = new ElegirSistema(modelo);
                vent.setLocationRelativeTo(null);
                vent.setVisible(true);
                dispose();
           } 
        };
        reloj.schedule(cerrar, 500);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        logo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        logo.setText("jLabel1");
        getContentPane().add(logo);
        logo.setBounds(40, 60, 90, 70);

        jLabel1.setText("Guillermo Bértola 303665");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(210, 70, 180, 16);

        jLabel2.setText("Santiago Durán 351471");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(210, 110, 180, 16);

        setBounds(0, 0, 454, 210);
    }// </editor-fold>//GEN-END:initComponents

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel logo;
    // End of variables declaration//GEN-END:variables
    private Sistema modelo;
}

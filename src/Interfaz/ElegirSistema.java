//Guillermo Bértola 303665 y Santiago Durán 351471
package Interfaz;

import Dominio.*;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import javax.swing.JOptionPane;
public class ElegirSistema extends javax.swing.JFrame {

    public ElegirSistema(Sistema sis) {
        initComponents();
        modelo = sis;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSisPrecargado = new javax.swing.JButton();
        btnSisNuevo = new javax.swing.JButton();
        btnSisGuardado = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Comenzar con...");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().setLayout(null);

        btnSisPrecargado.setText("Sistema con datos precargados");
        btnSisPrecargado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSisPrecargadoActionPerformed(evt);
            }
        });
        getContentPane().add(btnSisPrecargado);
        btnSisPrecargado.setBounds(360, 90, 240, 40);

        btnSisNuevo.setText("Sistema nuevo");
        btnSisNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSisNuevoActionPerformed(evt);
            }
        });
        getContentPane().add(btnSisNuevo);
        btnSisNuevo.setBounds(20, 90, 140, 40);

        btnSisGuardado.setText("Sistema guardado");
        btnSisGuardado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSisGuardadoActionPerformed(evt);
            }
        });
        getContentPane().add(btnSisGuardado);
        btnSisGuardado.setBounds(190, 90, 140, 40);

        setBounds(0, 0, 670, 228);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSisPrecargadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSisPrecargadoActionPerformed
        modelo.datosPrecargados();
        abrirMenu();
    }//GEN-LAST:event_btnSisPrecargadoActionPerformed

    private void btnSisGuardadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSisGuardadoActionPerformed
        if(desserializar()){
            abrirMenu();
        }
    }//GEN-LAST:event_btnSisGuardadoActionPerformed

    private void btnSisNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSisNuevoActionPerformed
        abrirMenu();
    }//GEN-LAST:event_btnSisNuevoActionPerformed

    
    public boolean desserializar(){
        boolean todoOk = true;
        try{
            FileInputStream arch = new FileInputStream("Datos");
            ObjectInputStream leer = new ObjectInputStream(arch);
            modelo = (Sistema) leer.readObject();
            leer.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Error al recuperar los datos guardados, elija otra opción", "error", 0);
            todoOk = false;
        }
        return todoOk;
    }
    
    
    public void abrirMenu(){
        Menu vent = new Menu(modelo);
        vent.setVisible(true);
        vent.setLocationRelativeTo(null);
        dispose();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSisGuardado;
    private javax.swing.JButton btnSisNuevo;
    private javax.swing.JButton btnSisPrecargado;
    // End of variables declaration//GEN-END:variables
    private Sistema modelo;
}

package Interfaz;

import Dominio.*;
public class Bienvenida extends javax.swing.JFrame {

    
    public Bienvenida(Sistema sis) {
        initComponents();
        modelo = sis;
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSisPrecargado = new javax.swing.JButton();
        btnSisNuevo = new javax.swing.JButton();
        btnSisGuardado = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
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
        btnSisPrecargado.setBounds(360, 90, 210, 40);

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

        setBounds(0, 0, 605, 228);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSisPrecargadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSisPrecargadoActionPerformed
        datosPrecargados();
        abrirMenu();
    }//GEN-LAST:event_btnSisPrecargadoActionPerformed

    private void btnSisGuardadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSisGuardadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSisGuardadoActionPerformed

    private void btnSisNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSisNuevoActionPerformed
        abrirMenu();
    }//GEN-LAST:event_btnSisNuevoActionPerformed

    public void datosPrecargados(){
        modelo.agregarArea(new Area("Personal", "Reclutamiento de personal, promociones, gestión de cargos", 100000));
        modelo.agregarArea(new Area("RRHH", "Relacionamiento en la empresa, organigrama, gestión de equipos", 80000));
        modelo.agregarArea(new Area("Seguridad", "Seguridad física, vigilancia, seguridad informática, protocolos y políticas de seguridad", 120000));
        modelo.agregarArea(new Area("Comunicaciones", "Comunicaciones internas, reglas y protocolos, comunicaciones con proveedores y clientes", 20000));
        modelo.agregarArea(new Area("Marketing", "Acciones planificadas, publicidad en medios masivos, publicidad en redes, gestión de redes", 95000));
        modelo.agregarManager(new Manager("4.568.369-1", "Ana Martínez", 10, "099 123456"));
        modelo.agregarManager(new Manager("3.214.589-3", "Ricardo Morales", 4, "094 121212"));
        modelo.agregarManager(new Manager("3.589.257-5", "Laura Torales", 1, "099 654321"));
        modelo.agregarManager(new Manager("4.555.197-7", "Juan Pablo Zapata", 5, "099 202020"));
    }
    
    public void abrirMenu(){
        Menu vent = new Menu(modelo);
        vent.setVisible(true);
        dispose();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSisGuardado;
    private javax.swing.JButton btnSisNuevo;
    private javax.swing.JButton btnSisPrecargado;
    // End of variables declaration//GEN-END:variables
    private Sistema modelo;
}

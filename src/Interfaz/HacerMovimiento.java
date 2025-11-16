package Interfaz;

import Dominio.*;
import java.util.*;
import javax.swing.*;


public class HacerMovimiento extends javax.swing.JFrame implements Observer{
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(HacerMovimiento.class.getName());

    public HacerMovimiento(Sistema sis) {
        initComponents();
        modelo = sis;
        cargarCombo();
        cargarAlgunasListas();
        modelo.addObserver(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        combo = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaEmpleados = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaDestinos = new javax.swing.JList();
        jScrollPane3 = new javax.swing.JScrollPane();
        listaOrigen = new javax.swing.JList();
        btnAceptar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboActionPerformed(evt);
            }
        });
        getContentPane().add(combo);
        combo.setBounds(60, 40, 72, 22);

        jScrollPane1.setViewportView(listaEmpleados);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(160, 120, 47, 130);

        listaDestinos.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(listaDestinos);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(270, 120, 47, 146);

        listaOrigen.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        listaOrigen.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                origenCambiado(evt);
            }
        });
        jScrollPane3.setViewportView(listaOrigen);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(60, 120, 48, 146);

        btnAceptar.setText("Hacer cambio");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAceptar);
        btnAceptar.setBounds(240, 40, 120, 23);

        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCerrar);
        btnCerrar.setBounds(180, 80, 72, 23);

        setBounds(0, 0, 462, 308);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        Movimiento mov = new Movimiento();
        boolean todoOk = true;
        int unMes = mov.mesANum((String) combo.getSelectedItem());
        mov.setMes(unMes);
        Area origen = (Area) listaOrigen.getSelectedValue();
        mov.setAreaOrigen(origen);
        Area destino = (Area) listaDestinos.getSelectedValue();
        if(destino == null){
            todoOk = false;
        }else{
            mov.setAreaDestino(destino);
        }
        Empleado unEmpleado = (Empleado) listaEmpleados.getSelectedValue();
        mov.setEmpleado(unEmpleado);
        if(unEmpleado != null && todoOk){
            if(destino.presupuestoSuficiente(unEmpleado, unMes)){
                modelo.agregarMovimiento(mov);
                unEmpleado.setArea(destino);
                origen.restarAlPresupuestoRestante((13-unMes)*unEmpleado.getSalario());
                JOptionPane.showMessageDialog(this, " Movimiento echo con exito", "Confirmacion", 1);
                listaOrigen.clearSelection();
                listaEmpleados.clearSelection();
                listaDestinos.clearSelection();
            }else{
                JOptionPane.showMessageDialog(this, "No hay presupuesto suficiente en " + destino + " para realizar el cambio", "Error", 2);
            }
        }else{
            JOptionPane.showMessageDialog(this, "Haga una seleccion en todos los campos", "Error", 2);
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void origenCambiado(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_origenCambiado
        cargarListaEmpleados();
    }//GEN-LAST:event_origenCambiado

    private void comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboActionPerformed

    public void cargarCombo(){
        combo.removeAllItems();
        String [] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Setiembre", "Octubre", "Noviembre", "Diciembre"};
        for (int i = 0; i < meses.length; i++) {
            combo.addItem(meses[i]);  
        }
    }
    
    public void cargarAlgunasListas(){
        listaOrigen.setListData(modelo.getListaAreas().toArray());
        listaDestinos.setListData(modelo.getListaAreas().toArray());
    }
    
    public void cargarListaEmpleados(){
        Area areaSelec = (Area) listaOrigen.getSelectedValue();
        if(areaSelec != null){
            listaEmpleados.setListData(modelo.listarEmpleadosArea(areaSelec).toArray());
        }
    }
    
    public void cargarListas(){
        cargarAlgunasListas();
        cargarListaEmpleados();
    }
    
    @Override
    public void update(Observable o, Object arg) {
        cargarListas();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JComboBox<String> combo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList listaDestinos;
    private javax.swing.JList listaEmpleados;
    private javax.swing.JList listaOrigen;
    // End of variables declaration//GEN-END:variables
    public Sistema modelo;

}

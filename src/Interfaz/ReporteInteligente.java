package Interfaz;

import Dominio.*;
import java.util.*;
import javax.swing.*;


public class ReporteInteligente extends javax.swing.JFrame implements Observer{
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ReporteInteligente.class.getName());

    public ReporteInteligente(Sistema sis) {
        initComponents();
        modelo = sis;
        cargarAlgunasListas();
        modelo.addObserver(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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

        jScrollPane1.setViewportView(listaEmpleados);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(160, 100, 47, 140);

        listaDestinos.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(listaDestinos);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(270, 100, 47, 146);

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
        jScrollPane3.setBounds(60, 100, 47, 146);

        btnAceptar.setText("Pedir Reporte");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAceptar);
        btnAceptar.setBounds(220, 40, 120, 23);

        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCerrar);
        btnCerrar.setBounds(70, 40, 72, 23);

        setBounds(0, 0, 462, 308);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void origenCambiado(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_origenCambiado
        cargarListaEmpleados();
    }//GEN-LAST:event_origenCambiado
    
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList listaDestinos;
    private javax.swing.JList listaEmpleados;
    private javax.swing.JList listaOrigen;
    // End of variables declaration//GEN-END:variables
    public Sistema modelo;

}

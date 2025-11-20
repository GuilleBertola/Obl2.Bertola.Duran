//Guillermo Bértola 303665 y Santiago Durán 351471
package Interfaz;

import Dominio.*;
import java.io.File;
import javax.swing.*;
import java.util.*;
import Archivos.*;

public class BajaAreas extends javax.swing.JFrame implements Observer {

    public BajaAreas(Sistema sis) {
        modelo = sis;
        initComponents();
        cargarLista();
        modelo.addObserver(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        ListaAreasSinE = new javax.swing.JList();
        SinE = new javax.swing.JLabel();
        botonEliminar = new javax.swing.JButton();
        cajaArea = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        ListaAreasSinE.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        ListaAreasSinE.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                ListaAreasSinEValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(ListaAreasSinE);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(16, 48, 150, 146);

        SinE.setText("Areas sin empleados:");
        getContentPane().add(SinE);
        SinE.setBounds(35, 6, 140, 36);

        botonEliminar.setText("Eliminar");
        botonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(botonEliminar);
        botonEliminar.setBounds(50, 220, 73, 23);
        getContentPane().add(cajaArea);
        cajaArea.setBounds(230, 60, 140, 22);

        setBounds(0, 0, 414, 308);
    }// </editor-fold>//GEN-END:initComponents

    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarActionPerformed
        Area a = (Area) ListaAreasSinE.getSelectedValue();
        modelo.eliminarArea(a);
    }//GEN-LAST:event_botonEliminarActionPerformed

    private void ListaAreasSinEValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_ListaAreasSinEValueChanged
        Area a = (Area) ListaAreasSinE.getSelectedValue();
        if(a==null){
            cajaArea.setText("");
        }
        else{
            cajaArea.setText(a.getNombre());
        }
    }//GEN-LAST:event_ListaAreasSinEValueChanged


    
    public void cargarLista(){
        ListaAreasSinE.setListData(modelo.areasSinE().toArray());
    }
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList ListaAreasSinE;
    private javax.swing.JLabel SinE;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JTextField cajaArea;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
    private Sistema modelo;

    @Override
    public void update(Observable o, Object arg) {
        cargarLista();
    }
}

package Interfaz;

import Dominio.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ReporteDeMov extends javax.swing.JFrame {
    DefaultTableModel mt = new DefaultTableModel();

public ReporteDeMov(Sistema sis) {
    modelo = sis;
    initComponents();

    mt = new DefaultTableModel();
    mt.setColumnIdentifiers(new Object[]{"Movimientos", "Mes", "Origen", "Destino", "Empleado"});
    JTable1.setModel(mt);
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        JTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        JTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Movimiento", "Més", "Area de origen", "Area de destino", "Nombre del empleado"
            }
        ));
        jScrollPane1.setViewportView(JTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(0, 0, 400, 180);

        jButton1.setText("Boton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(150, 200, 75, 23);

        setBounds(0, 0, 414, 308);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int cant=1;
        for(int i =0;i<modelo.getListaMovimientos().size();i++){
            
            Movimiento o=modelo.getListaMovimientos().get(i);
            mt.addRow(new Object[]{cant,o.getMes(),o.getAreaOrigen(),o.getAreaDestino(),o.getEmpleado().getNombre()});

            cant++;
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JTable1;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
    private Sistema modelo;
}
//Como no hay empleados pre-cargados voy a suponer que funciona, falta hacer lo del orden por mes y la primera columna
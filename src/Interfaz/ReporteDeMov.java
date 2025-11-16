package Interfaz;

import Dominio.*;
import java.util.ArrayList;
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
    cargarListaOrigen();
    cargarListaDestino();
    cargarListaMes();
    cargarListaEmpleados();
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        JTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        btnOrigen = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaOrigen = new javax.swing.JList();
        btnDestino = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        listaDestino = new javax.swing.JList();
        btnMeses = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        listaMes = new javax.swing.JList<>();
        btnEmp = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        listaEmp = new javax.swing.JList();

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
        jButton1.setBounds(230, 200, 75, 23);

        btnOrigen.setText("Filtrar por area de origen:");
        btnOrigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrigenActionPerformed(evt);
            }
        });
        getContentPane().add(btnOrigen);
        btnOrigen.setBounds(0, 260, 190, 23);

        listaOrigen.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        listaOrigen.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaOrigenValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(listaOrigen);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(30, 290, 100, 110);

        btnDestino.setText("Filtrar por area de destino:");
        btnDestino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDestinoActionPerformed(evt);
            }
        });
        getContentPane().add(btnDestino);
        btnDestino.setBounds(250, 260, 170, 23);

        listaDestino.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(listaDestino);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(280, 290, 90, 110);

        btnMeses.setText("Filtrar por mes");
        btnMeses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMesesActionPerformed(evt);
            }
        });
        getContentPane().add(btnMeses);
        btnMeses.setBounds(525, 10, 140, 23);

        listaMes.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane4.setViewportView(listaMes);

        getContentPane().add(jScrollPane4);
        jScrollPane4.setBounds(560, 40, 60, 146);

        btnEmp.setText("Flitrar por empleado");
        btnEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmpActionPerformed(evt);
            }
        });
        getContentPane().add(btnEmp);
        btnEmp.setBounds(500, 260, 150, 23);

        listaEmp.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane5.setViewportView(listaEmp);

        getContentPane().add(jScrollPane5);
        jScrollPane5.setBounds(537, 290, 70, 110);

        setBounds(0, 0, 704, 428);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int cant=1;
        mt.setRowCount(0);
        for(int i =0;i<modelo.getListaMovimientos().size();i++){
            
            Movimiento o=modelo.getListaMovimientos().get(i);
            mt.addRow(new Object[]{cant,o.getMes(),o.getAreaOrigen(),o.getAreaDestino(),o.getEmpleado().getNombre()});

            cant++;
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void listaOrigenValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaOrigenValueChanged
                
    }//GEN-LAST:event_listaOrigenValueChanged

    private void btnOrigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrigenActionPerformed
        int cant=1;
        mt.setRowCount(0);
        for(int i =0;i<modelo.getListaMovimientos().size();i++){            
            Movimiento o=modelo.getListaMovimientos().get(i);
            Area a=modelo.getListaMovimientos().get(i).getAreaOrigen();
            if(a==listaOrigen.getSelectedValue()){
                mt.addRow(new Object[]{cant,o.getMes(),o.getAreaOrigen(),o.getAreaDestino(),o.getEmpleado().getNombre()});
            }
            cant++;
        } 
    }//GEN-LAST:event_btnOrigenActionPerformed

    private void btnDestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDestinoActionPerformed
        int cant=1;
        mt.setRowCount(0);
        for(int i =0;i<modelo.getListaMovimientos().size();i++){            
            Movimiento o=modelo.getListaMovimientos().get(i);
            Area a=modelo.getListaMovimientos().get(i).getAreaDestino();
            if(a==listaDestino.getSelectedValue()){
                mt.addRow(new Object[]{cant,o.getMes(),o.getAreaOrigen(),o.getAreaDestino(),o.getEmpleado().getNombre()});
            }
            cant++;
        } 
    }//GEN-LAST:event_btnDestinoActionPerformed

    private void btnMesesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMesesActionPerformed
        int cant=1;
        mt.setRowCount(0);
        Movimiento mov= new Movimiento();
        for(int i =0;i<modelo.getListaMovimientos().size();i++){            
            Movimiento o=modelo.getListaMovimientos().get(i);
            int m=modelo.getListaMovimientos().get(i).getMes();
            if(m==(mov.mesANum(listaMes.getSelectedValue()))){
                mt.addRow(new Object[]{cant,o.getMes(),o.getAreaOrigen(),o.getAreaDestino(),o.getEmpleado().getNombre()});
            }
            cant++;
        }
    }//GEN-LAST:event_btnMesesActionPerformed

    private void btnEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmpActionPerformed
        int cant=1;
        mt.setRowCount(0);
        for(int i =0;i<modelo.getListaMovimientos().size();i++){            
            Movimiento o=modelo.getListaMovimientos().get(i);
            Empleado e=modelo.getListaMovimientos().get(i).getEmpleado();
            if(e==listaEmp.getSelectedValue()){
                mt.addRow(new Object[]{cant,o.getMes(),o.getAreaOrigen(),o.getAreaDestino(),o.getEmpleado().getNombre()});
            }
            cant++;
        }
    }//GEN-LAST:event_btnEmpActionPerformed

    public void cargarListaOrigen(){
        Area [] a= new Area[modelo.getListaMovimientos().size()];
        for (int i = 0; i < modelo.getListaMovimientos().size(); i++) {
            a[i] = modelo.getListaMovimientos().get(i).getAreaOrigen();
        }
        listaOrigen.setListData(a);        
    }
    
    public void cargarListaDestino(){
        Area [] a= new Area[modelo.getListaMovimientos().size()];
        for (int i = 0; i < modelo.getListaMovimientos().size(); i++) {
            a[i] = modelo.getListaMovimientos().get(i).getAreaDestino();
        }
        listaDestino.setListData(a);        
    }
    
    public void cargarListaMes(){
        String [] m = {"", "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Setiembre", "Octubre", "Noviembre", "Diciembre"};
        listaMes.setListData(m);        
    }
    
    public void cargarListaEmpleados(){
        Empleado [] e= new Empleado[modelo.getListaMovimientos().size()];
        for (int i = 0; i < modelo.getListaMovimientos().size(); i++) {
            e[i] = modelo.getListaMovimientos().get(i).getEmpleado();
        }
        listaEmp.setListData(e);        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JTable1;
    private javax.swing.JButton btnDestino;
    private javax.swing.JButton btnEmp;
    private javax.swing.JButton btnMeses;
    private javax.swing.JButton btnOrigen;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JList listaDestino;
    private javax.swing.JList listaEmp;
    private javax.swing.JList<String> listaMes;
    private javax.swing.JList listaOrigen;
    // End of variables declaration//GEN-END:variables
    private Sistema modelo;
}
//Como no hay empleados pre-cargados voy a suponer que funciona, falta hacer lo del orden por mes y la primera columna
//Guillermo Bértola 303665 y Santiago Durán 351471
package Interfaz;

import Dominio.*;
import javax.swing.*;
import java.util.*;

public class ModificacionManagers extends javax.swing.JFrame implements Observer{
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ModificacionManagers.class.getName());

    public ModificacionManagers(Sistema sis) {
        modelo = sis;
        initComponents();
        cargarLista();
        modelo.addObserver(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        listaManagers = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        txtNom = new javax.swing.JTextField();
        txtAntig = new javax.swing.JTextField();
        txtCi = new javax.swing.JTextField();
        txtCel = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnCerrar = new javax.swing.JButton();
        btnIngresar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtCant = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ingresar managers");
        getContentPane().setLayout(null);

        listaManagers.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        listaManagers.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaManagersValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(listaManagers);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(50, 80, 110, 160);

        jLabel1.setText("Managers");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(80, 60, 60, 16);

        txtNom.setEditable(false);
        getContentPane().add(txtNom);
        txtNom.setBounds(260, 80, 110, 22);

        txtAntig.setEditable(false);
        getContentPane().add(txtAntig);
        txtAntig.setBounds(260, 160, 110, 22);

        txtCi.setEditable(false);
        getContentPane().add(txtCi);
        txtCi.setBounds(260, 120, 110, 22);
        getContentPane().add(txtCel);
        txtCel.setBounds(260, 200, 110, 22);

        jLabel2.setText("Nombre:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(190, 80, 70, 16);

        jLabel3.setText("Cedula:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(190, 120, 40, 16);

        jLabel4.setText("Celular:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(190, 200, 50, 16);

        jLabel5.setText("Antiguedad:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(190, 160, 70, 16);

        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCerrar);
        btnCerrar.setBounds(90, 290, 72, 23);

        btnIngresar.setText("Modificar");
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });
        getContentPane().add(btnIngresar);
        btnIngresar.setBounds(220, 290, 130, 23);

        jLabel6.setText("Empleados a cargo:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(190, 240, 110, 16);

        txtCant.setEditable(false);
        getContentPane().add(txtCant);
        txtCant.setBounds(310, 240, 60, 22);

        setBounds(0, 0, 468, 374);
    }// </editor-fold>//GEN-END:initComponents

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        String cel = txtCel.getText();
        String ci = txtCi.getText();
        modelo.getManager(ci).setCelular(cel);
        JOptionPane.showMessageDialog(this, "Modificación hecha con éxito", "Confirmación", 1);
        cargarLista();
        listaManagers.clearSelection();
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void listaManagersValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaManagersValueChanged
        Manager man = (Manager) listaManagers.getSelectedValue();
        if(man == null){
            txtNom.setText("");
            txtCi.setText("");
            txtCel.setText("");
            txtAntig.setText("");
            txtCant.setText("");
        }else{
            txtNom.setText(man.getNombre());
            txtCi.setText(man.getCedula());
            txtCel.setText(man.getCelular());
            txtAntig.setText("" + man.getAntiguedad());
            txtCant.setText("" + modelo.listarEmpleadosMan(man).size());
        }
    }//GEN-LAST:event_listaManagersValueChanged

    public void cargarLista(){
        modelo.ordenarListaManagers();
        listaManagers.setListData(modelo.getListaManagers().toArray());
    }
    
    @Override
    public void update(Observable o, Object arg) {
        cargarLista();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnIngresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList listaManagers;
    private javax.swing.JTextField txtAntig;
    private javax.swing.JTextField txtCant;
    private javax.swing.JTextField txtCel;
    private javax.swing.JTextField txtCi;
    private javax.swing.JTextField txtNom;
    // End of variables declaration//GEN-END:variables
    private Sistema modelo;
}

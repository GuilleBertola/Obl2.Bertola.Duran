//Guillermo Bértola 303665 y Santiago Durán 351471
package Interfaz;

import Dominio.*;
import javax.swing.*;

public class AltaManagers extends javax.swing.JFrame {

    public AltaManagers(Sistema sis) {
        modelo = sis;
        initComponents();
        cargarLista();
        
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ingresar managers");
        getContentPane().setLayout(null);

        listaManagers.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listaManagers);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(50, 80, 110, 160);

        jLabel1.setText("Managers");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(80, 60, 60, 16);
        getContentPane().add(txtNom);
        txtNom.setBounds(260, 80, 110, 22);
        getContentPane().add(txtAntig);
        txtAntig.setBounds(260, 160, 110, 22);
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
        btnCerrar.setBounds(180, 290, 72, 23);

        btnIngresar.setText("Ingresar manager");
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });
        getContentPane().add(btnIngresar);
        btnIngresar.setBounds(210, 240, 150, 23);

        setBounds(0, 0, 468, 374);
    }// </editor-fold>//GEN-END:initComponents

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        String nom = txtNom.getText();
        String ci = txtCi.getText();
        int antig = -1;
        String cel = txtCel.getText();
        boolean todoOk = !modelo.existeCi(ci);
        try{
            antig = Integer.parseInt(txtAntig.getText());
        }catch(NumberFormatException e){
            todoOk = false;
            JOptionPane.showMessageDialog(this, "Ingrese un numero en antiguedad", "error", 0);
            txtAntig.setText("");
        }
        if(nom.equals("") || ci.equals("")){
            todoOk = false;
            JOptionPane.showMessageDialog(this, "Complete todos los campos.", "error", 0);
        }
        if(todoOk){
            modelo.agregarManager(new Manager(ci, nom, antig, cel));
            JOptionPane.showMessageDialog(this, nom + " agregado con exito", "Confirmacion", 1);
            cargarLista();
            txtNom.setText("");
            txtCi.setText("");
            txtCel.setText("");
            txtAntig.setText("");
        }
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    public void cargarLista(){
        modelo.ordenarListaManagers();
        listaManagers.setListData(modelo.getListaManagers().toArray());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnIngresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList listaManagers;
    private javax.swing.JTextField txtAntig;
    private javax.swing.JTextField txtCel;
    private javax.swing.JTextField txtCi;
    private javax.swing.JTextField txtNom;
    // End of variables declaration//GEN-END:variables
    private Sistema modelo;
}

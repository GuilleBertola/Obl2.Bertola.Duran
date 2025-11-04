package Interfaz;

import Dominio.*;
import javax.swing.*;

public class AltaAreas extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(AltaAreas.class.getName());

    public AltaAreas(Sistema sis) {
        initComponents();
        modelo = sis;
        listaAreas.setListData(modelo.getListaAreas().toArray());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        listaAreas = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        txtNom = new javax.swing.JTextField();
        txtDescripcion = new javax.swing.JTextField();
        txtPresupuesto = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnCrearArea = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(null);
        setSize(new java.awt.Dimension(0, 0));
        getContentPane().setLayout(null);

        listaAreas.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listaAreas);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(40, 80, 89, 159);

        jLabel1.setText("Areas");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(70, 60, 37, 16);
        getContentPane().add(txtNom);
        txtNom.setBounds(250, 100, 180, 22);
        getContentPane().add(txtDescripcion);
        txtDescripcion.setBounds(250, 140, 180, 22);
        getContentPane().add(txtPresupuesto);
        txtPresupuesto.setBounds(250, 180, 180, 22);

        jLabel2.setText("Nombre:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(170, 100, 50, 16);

        jLabel3.setText("Descripcion:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(170, 140, 80, 16);

        jLabel4.setText("Presupuesto");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(170, 180, 70, 16);

        btnCrearArea.setText("Ingresar area");
        btnCrearArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearAreaActionPerformed(evt);
            }
        });
        getContentPane().add(btnCrearArea);
        btnCrearArea.setBounds(240, 220, 110, 23);

        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCerrar);
        btnCerrar.setBounds(200, 270, 75, 23);

        jLabel5.setText("Nueva area");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(250, 60, 70, 16);

        setBounds(0, 0, 498, 370);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnCrearAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearAreaActionPerformed
        String nom = txtNom.getText();
        String desc = txtDescripcion.getText();
        int presupuesto = -1;
        boolean todoOk = modelo.nombreAreaDisponible(nom);
        try{
            presupuesto = Integer.parseInt(txtPresupuesto.getText());
        }catch(NumberFormatException e){
            todoOk = false;
            JOptionPane.showMessageDialog(this, "Ingrese un numero en presupuesto", "error", 0);
        }
        if(todoOk){
            modelo.agregarArea(new Area(nom, desc, presupuesto));
            JOptionPane.showMessageDialog(this, nom + " agregado con exito", "Confirmacion", 1);
            listaAreas.setListData(modelo.getListaAreas().toArray());
        }
    }//GEN-LAST:event_btnCrearAreaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnCrearArea;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList listaAreas;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtNom;
    private javax.swing.JTextField txtPresupuesto;
    // End of variables declaration//GEN-END:variables
    private Sistema modelo;
}

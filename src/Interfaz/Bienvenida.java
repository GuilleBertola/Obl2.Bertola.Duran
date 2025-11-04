package Interfaz;


public class Bienvenida extends javax.swing.JFrame {

    
    public Bienvenida() {
        initComponents();
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
        btnSisPrecargado.setBounds(300, 90, 210, 40);

        btnSisNuevo.setText("Sistema nuevo");
        btnSisNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSisNuevoActionPerformed(evt);
            }
        });
        getContentPane().add(btnSisNuevo);
        btnSisNuevo.setBounds(20, 90, 110, 40);

        btnSisGuardado.setText("Sistema guardado");
        btnSisGuardado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSisGuardadoActionPerformed(evt);
            }
        });
        getContentPane().add(btnSisGuardado);
        btnSisGuardado.setBounds(150, 90, 130, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSisPrecargadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSisPrecargadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSisPrecargadoActionPerformed

    private void btnSisGuardadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSisGuardadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSisGuardadoActionPerformed

    private void btnSisNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSisNuevoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSisNuevoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSisGuardado;
    private javax.swing.JButton btnSisNuevo;
    private javax.swing.JButton btnSisPrecargado;
    // End of variables declaration//GEN-END:variables
}

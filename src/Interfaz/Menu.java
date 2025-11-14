package Interfaz;

import Dominio.*;
import Interfaz.*;
import javax.swing.*;


public class Menu extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Menu.class.getName());

    
    public Menu(Sistema sis) {
        modelo = sis;
        initComponents();
        addKeyListener(new java.awt.event.KeyAdapter() {
        @Override
        public void keyPressed(java.awt.event.KeyEvent e) {
            if (e.getKeyCode() == java.awt.event.KeyEvent.VK_F1) {
                JOptionPane.showMessageDialog(null, "Guillermo Bértola: 303665 y Santiago Durán: 351471");
            }
        }
    });
  
    this.setFocusable(true);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        areas = new javax.swing.JMenu();
        AreaAlt = new javax.swing.JMenuItem();
        AreaBaj = new javax.swing.JMenuItem();
        AreaMod = new javax.swing.JMenuItem();
        AreaMov = new javax.swing.JMenuItem();
        ManAlt = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        ManBaj = new javax.swing.JMenuItem();
        ManMod = new javax.swing.JMenuItem();
        EmpleAlt = new javax.swing.JMenu();
        altaEmpleados = new javax.swing.JMenuItem();
        RepoInt = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        RepoEst = new javax.swing.JMenuItem();
        RepoMod = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                antesDeCerrar(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });
        getContentPane().setLayout(null);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/guillefoto.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        jLabel2.setMaximumSize(new java.awt.Dimension(381, 640));
        jLabel2.setMinimumSize(new java.awt.Dimension(381, 640));
        getContentPane().add(jLabel2);
        jLabel2.setBounds(-150, 0, 650, 600);

        areas.setText("Áreas");
        areas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                areasActionPerformed(evt);
            }
        });

        AreaAlt.setText("Alta");
        AreaAlt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AreaAltActionPerformed(evt);
            }
        });
        areas.add(AreaAlt);

        AreaBaj.setText("Baja");
        AreaBaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AreaBajActionPerformed(evt);
            }
        });
        areas.add(AreaBaj);

        AreaMod.setText("Modificación");
        AreaMod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AreaModActionPerformed(evt);
            }
        });
        areas.add(AreaMod);

        AreaMov.setText("Realizar Movimiento");
        AreaMov.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AreaMovActionPerformed(evt);
            }
        });
        areas.add(AreaMov);

        jMenuBar1.add(areas);

        ManAlt.setText("Managers");

        jMenuItem5.setText("Alta");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        ManAlt.add(jMenuItem5);

        ManBaj.setText("Baja");
        ManBaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ManBajActionPerformed(evt);
            }
        });
        ManAlt.add(ManBaj);

        ManMod.setText("Modificación");
        ManAlt.add(ManMod);

        jMenuBar1.add(ManAlt);

        EmpleAlt.setText("Empleados");

        altaEmpleados.setText("Alta");
        altaEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                altaEmpleadosActionPerformed(evt);
            }
        });
        EmpleAlt.add(altaEmpleados);

        jMenuBar1.add(EmpleAlt);

        RepoInt.setText("Reportes");

        jMenuItem9.setText("Reporte inteligente");
        RepoInt.add(jMenuItem9);

        RepoEst.setText("Reporte de estado de áreas");
        RepoInt.add(RepoEst);

        RepoMod.setText("Reporte de movimientos");
        RepoInt.add(RepoMod);

        jMenuBar1.add(RepoInt);

        setJMenuBar(jMenuBar1);

        setBounds(0, 0, 611, 358);
    }// </editor-fold>//GEN-END:initComponents

    private void areasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_areasActionPerformed
        
    }//GEN-LAST:event_areasActionPerformed

    private void AreaModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AreaModActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AreaModActionPerformed

    private void altaEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_altaEmpleadosActionPerformed
        AltaEmpleados vent = new AltaEmpleados(modelo);
        vent.setVisible(true);
    }//GEN-LAST:event_altaEmpleadosActionPerformed

    private void AreaAltActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AreaAltActionPerformed
        AltaAreas vent = new AltaAreas(modelo);
        vent.setVisible(true);
    }//GEN-LAST:event_AreaAltActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        AltaManagers vent = new AltaManagers(modelo);
        vent.setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void AreaMovActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AreaMovActionPerformed
        HacerMovimiento vent = new HacerMovimiento(modelo);
        vent.setVisible(true);
    }//GEN-LAST:event_AreaMovActionPerformed

    private void antesDeCerrar(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_antesDeCerrar
        modelo.serializar();
    }//GEN-LAST:event_antesDeCerrar

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_formKeyPressed

    private void AreaBajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AreaBajActionPerformed
        BajaAreas vent= new BajaAreas(modelo);
        vent.setVisible(true);
    }//GEN-LAST:event_AreaBajActionPerformed

    private void ManBajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ManBajActionPerformed
        BajaManagers vent= new BajaManagers(modelo);
        vent.setVisible(true);
    }//GEN-LAST:event_ManBajActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AreaAlt;
    private javax.swing.JMenuItem AreaBaj;
    private javax.swing.JMenuItem AreaMod;
    private javax.swing.JMenuItem AreaMov;
    private javax.swing.JMenu EmpleAlt;
    private javax.swing.JMenu ManAlt;
    private javax.swing.JMenuItem ManBaj;
    private javax.swing.JMenuItem ManMod;
    private javax.swing.JMenuItem RepoEst;
    private javax.swing.JMenu RepoInt;
    private javax.swing.JMenuItem RepoMod;
    private javax.swing.JMenuItem altaEmpleados;
    private javax.swing.JMenu areas;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem9;
    // End of variables declaration//GEN-END:variables
    private Sistema modelo;
}

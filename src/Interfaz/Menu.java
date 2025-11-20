//Guillermo Bértola 303665 y Santiago Durán 351471
package Interfaz;

import Dominio.*;
import javax.swing.*;


public class Menu extends javax.swing.JFrame {
    
   // private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Menu.class.getName());

    
    public Menu(Sistema sis) {
        modelo = sis;
        initComponents();
        addKeyListener(new java.awt.event.KeyAdapter() {//esto a mi no me funca
        @Override
        public void keyPressed(java.awt.event.KeyEvent e) {
            if (e.getKeyCode() == java.awt.event.KeyEvent.VK_F1) {
                JOptionPane.showMessageDialog(null, "Guillermo Bértola: 303665 y Santiago Durán: 351471");
            }
        }
    });
  
    this.setFocusable(true); //Que es esto??
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
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

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
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

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Logo1.png"))); // NOI18N
        jLabel1.setMaximumSize(new java.awt.Dimension(20, 8));
        jLabel1.setMinimumSize(new java.awt.Dimension(20, 8));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(-40, -60, 801, 740);

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
        ManMod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ManModActionPerformed(evt);
            }
        });
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
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        RepoInt.add(jMenuItem9);

        RepoEst.setText("Reporte de estado de áreas");
        RepoEst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RepoEstActionPerformed(evt);
            }
        });
        RepoInt.add(RepoEst);

        RepoMod.setText("Reporte de movimientos");
        RepoMod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RepoModActionPerformed(evt);
            }
        });
        RepoInt.add(RepoMod);

        jMenuBar1.add(RepoInt);

        setJMenuBar(jMenuBar1);

        setBounds(0, 0, 766, 706);
    }// </editor-fold>//GEN-END:initComponents

    private void areasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_areasActionPerformed
        
    }//GEN-LAST:event_areasActionPerformed

    private void AreaModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AreaModActionPerformed
        ModificacionAreas vent = new ModificacionAreas(modelo);
        vent.setVisible(true);
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


    private void ManModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ManModActionPerformed
        ModificacionManagers vent= new ModificacionManagers(modelo);
        vent.setVisible(true);
    }//GEN-LAST:event_ManModActionPerformed

    private void RepoEstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RepoEstActionPerformed
        ReporteEstado vent= new ReporteEstado(modelo);
        vent.setVisible(true);
    }//GEN-LAST:event_RepoEstActionPerformed
 

    private void RepoModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RepoModActionPerformed
        ReporteDeMov vent= new ReporteDeMov(modelo);
        vent.setVisible(true);
    }//GEN-LAST:event_RepoModActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        ReporteInteligente vent= new ReporteInteligente(modelo);
        vent.setVisible(true);
    }//GEN-LAST:event_jMenuItem9ActionPerformed


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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
    private Sistema modelo;
}

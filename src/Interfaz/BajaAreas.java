package Interfaz;
import Dominio.*;

public class BajaAreas extends javax.swing.JFrame {


    public BajaAreas(Sistema sis) {
        modelo = sis;
        initComponents();
        cargarLista();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        ListaAreasSinE = new javax.swing.JList();
        SinE = new javax.swing.JLabel();
        botonEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        ListaAreasSinE.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(ListaAreasSinE);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(16, 48, 150, 146);

        SinE.setText("Areas sin empleados:");
        getContentPane().add(SinE);
        SinE.setBounds(35, 6, 112, 36);

        botonEliminar.setText("Eliminar");
        botonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(botonEliminar);
        botonEliminar.setBounds(50, 220, 73, 23);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarActionPerformed
        //xcvbnm,.
    }//GEN-LAST:event_botonEliminarActionPerformed

    public void cargarLista(){
        ListaAreasSinE.setListData(modelo.areasSinE().toArray());
    }
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList ListaAreasSinE;
    private javax.swing.JLabel SinE;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
    private Sistema modelo;
}

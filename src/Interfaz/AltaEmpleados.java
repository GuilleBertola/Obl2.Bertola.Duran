package Interfaz;

import Dominio.*;

public class AltaEmpleados extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(AltaEmpleados.class.getName());

    //Como vamos a mostrar los datos del empleado?
    public AltaEmpleados(Sistema sis) {
        modelo = sis;
        initComponents();
        cargarListas();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        listaEmpleados = new javax.swing.JList();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaManagers = new javax.swing.JList();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        listaAreas = new javax.swing.JList();
        btnCerrar = new javax.swing.JButton();
        btnIngresar = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ingresar empleados");
        getContentPane().setLayout(null);

        listaEmpleados.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        listaEmpleados.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaEmpleadosValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(listaEmpleados);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(80, 70, 120, 146);
        getContentPane().add(jTextField1);
        jTextField1.setBounds(330, 60, 180, 22);
        getContentPane().add(jTextField2);
        jTextField2.setBounds(330, 90, 180, 22);
        getContentPane().add(jTextField3);
        jTextField3.setBounds(330, 150, 180, 22);

        jLabel1.setText("Nombre:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(280, 60, 60, 16);

        jLabel2.setText("Cedula:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(280, 90, 50, 16);

        jLabel3.setText("Celular:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(280, 150, 50, 16);

        jLabel4.setText("Curriculum:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(90, 260, 70, 16);
        getContentPane().add(jTextField4);
        jTextField4.setBounds(330, 120, 180, 22);

        jLabel5.setText("Salario:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(280, 120, 73, 16);

        jLabel6.setText("Manager:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(380, 210, 70, 16);

        listaManagers.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(listaManagers);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(380, 230, 130, 146);

        jLabel7.setText("Area:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(560, 60, 37, 16);

        listaAreas.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(listaAreas);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(560, 80, 110, 146);

        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCerrar);
        btnCerrar.setBounds(270, 420, 72, 23);

        btnIngresar.setText("Ingresar empleado");
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });
        getContentPane().add(btnIngresar);
        btnIngresar.setBounds(390, 420, 130, 23);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane4.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane4);
        jScrollPane4.setBounds(90, 280, 240, 90);

        jLabel8.setText("Empleados:");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(80, 50, 70, 16);

        setBounds(0, 0, 760, 515);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void listaEmpleadosValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaEmpleadosValueChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_listaEmpleadosValueChanged

    
    public void cargarListas(){
        modelo.ordenarListaEmpleados();
        listaEmpleados.setListData(modelo.getListaEmpleados().toArray());
        listaManagers.setListData(modelo.getListaManagers().toArray());
        listaAreas.setListData(modelo.getListaAreas().toArray());
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
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JList listaAreas;
    private javax.swing.JList listaEmpleados;
    private javax.swing.JList listaManagers;
    // End of variables declaration//GEN-END:variables
    Sistema modelo;
}

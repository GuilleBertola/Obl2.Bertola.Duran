package Interfaz;

import Dominio.*;

public class AltaEmpleados extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(AltaEmpleados.class.getName());

    //Como vamos a mostrar los datos del empleado?
    public AltaEmpleados(Sistema sis) {
        modelo = sis;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        listaEmpleados = new javax.swing.JList<>();
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
        listaManagers = new javax.swing.JList<>();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        listaAreas = new javax.swing.JList<>();
        btnCerrar = new javax.swing.JButton();
        btnIngresar = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        listaEmpleados.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listaEmpleados);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(60, 50, 120, 146);

        jTextField1.setText("jTextField1");
        getContentPane().add(jTextField1);
        jTextField1.setBounds(370, 60, 130, 22);

        jTextField2.setText("jTextField2");
        getContentPane().add(jTextField2);
        jTextField2.setBounds(370, 90, 130, 22);

        jTextField3.setText("jTextField3");
        getContentPane().add(jTextField3);
        jTextField3.setBounds(370, 150, 130, 22);

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
        jLabel4.setBounds(280, 180, 70, 16);

        jTextField4.setText("jTextField4");
        getContentPane().add(jTextField4);
        jTextField4.setBounds(370, 120, 130, 22);

        jLabel5.setText("Salario:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(280, 120, 73, 16);

        jLabel6.setText("Manager:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(70, 250, 70, 16);

        listaManagers.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(listaManagers);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(140, 240, 130, 146);

        jLabel7.setText("Area:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(330, 250, 37, 16);

        listaAreas.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(listaAreas);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(380, 280, 110, 146);

        btnCerrar.setText("Cerrar");
        getContentPane().add(btnCerrar);
        btnCerrar.setBounds(190, 420, 72, 23);

        btnIngresar.setText("Ingresar empleado");
        getContentPane().add(btnIngresar);
        btnIngresar.setBounds(310, 440, 130, 23);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane4.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane4);
        jScrollPane4.setBounds(370, 180, 240, 90);

        setBounds(0, 0, 666, 495);
    }// </editor-fold>//GEN-END:initComponents

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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JList<String> listaAreas;
    private javax.swing.JList<String> listaEmpleados;
    private javax.swing.JList<String> listaManagers;
    // End of variables declaration//GEN-END:variables
    Sistema modelo;
}

package Interfaz;

import Dominio.*;
import java.io.File;
import javax.swing.*;
import java.util.*;
import Archivos.*;

public class AltaEmpleados extends javax.swing.JFrame implements Observer{
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(AltaEmpleados.class.getName());

    //Como vamos a mostrar los datos del empleado?
    public AltaEmpleados(Sistema sis) {
        modelo = sis;
        initComponents();
        cargarListas();
        modelo.addObserver(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        listaEmpleados = new javax.swing.JList();
        txtNom = new javax.swing.JTextField();
        txtCi = new javax.swing.JTextField();
        txtCel = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtSal = new javax.swing.JTextField();
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
        txtCv = new javax.swing.JTextArea();
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
        getContentPane().add(txtNom);
        txtNom.setBounds(330, 60, 180, 22);
        getContentPane().add(txtCi);
        txtCi.setBounds(330, 90, 180, 22);
        getContentPane().add(txtCel);
        txtCel.setBounds(330, 150, 180, 22);

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
        getContentPane().add(txtSal);
        txtSal.setBounds(330, 120, 180, 22);

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

        txtCv.setColumns(20);
        txtCv.setRows(5);
        jScrollPane4.setViewportView(txtCv);

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
        String nom = txtNom.getText();
        String cel = txtCel.getText();
        String ci = txtCi.getText();
        int salario = -1;
        Manager man = (Manager) listaManagers.getSelectedValue();
        Area ar = (Area) listaAreas.getSelectedValue();
        boolean todoOk = !modelo.existeCi(ci);
        if(ar == null || man == null || txtCv.getText() == ""){
            JOptionPane.showMessageDialog(this, "Asegurese de completar todos los datos", "error", 0);
            todoOk = false;
        }
        try{
            salario = Integer.parseInt(txtSal.getText());
        }catch(NumberFormatException e){
            todoOk = false;
            JOptionPane.showMessageDialog(this, "Ingrese un numero en salario", "error", 0);
        }
        if(todoOk) {
           Empleado nuevo = new Empleado(ci, nom, cel, salario, man, ar);
           if(ar.presupuestoSuficiente(nuevo, 0)){
                modelo.agregarEmpleado(new Empleado(ci, nom, cel, salario, man, ar));
                guardarCv(ci);
                listaManagers.clearSelection();
                listaAreas.clearSelection();
                txtNom.setText("");
                txtCel.setText("");
                txtCi.setText("");
                txtSal.setText("");
                JOptionPane.showMessageDialog(this, "Ingresado con exito", "Confirmacion", 1);
           }else{
               JOptionPane.showMessageDialog(this, "Presupuesto insuficiente", "error", 0);
           }
        }
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void listaEmpleadosValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaEmpleadosValueChanged
        Empleado e = (Empleado) listaEmpleados.getSelectedValue();
        if(e != null){
            String nom = e.getNombre();
            String ci = e.getCedula();
            String cel = e.getCelular();
            int sal = e.getSalario();
            Manager man = e.getManager();
            Area area = e.getArea();
            ArchivoLectura leer = new ArchivoLectura(System.getProperty("user.dir")+ File.separator + "cvs" + "/CV" + ci + ".txt");
            String curr = "";
            while(leer.hayMasLineas()){
                curr +=  leer.linea();
            }
            leer.cerrar();
            String texto = "Nombre: " + nom + "\n" + 
                           "Cedula: " + ci + "\n" +
                           "Numero de telefono: " + cel + "\n" +
                           "Salario: " + sal + "\n" +
                           "Manager: " + man + "\n" +
                           "Area: " + area + "\n" +
                           "Curriculum: " + curr;
            
            JOptionPane.showMessageDialog(this, texto, "Informacion empleados", 1);
        }
        
    }//GEN-LAST:event_listaEmpleadosValueChanged

    @Override
    public void update(Observable o, Object arg) {
        cargarListas();
    }
    
    public void cargarListas(){
        modelo.ordenarListaEmpleados();
        listaEmpleados.setListData(modelo.getListaEmpleados().toArray());
        listaManagers.setListData(modelo.getListaManagers().toArray());
        listaAreas.setListData(modelo.getListaAreas().toArray());
    }
    
    public void guardarCv(String cedula){
        File prueba = new File(System.getProperty("user.dir") + File.separator + "cvs");
        if(!prueba.exists()){
            prueba.mkdir();
        }
        ArchivoGrabacion cv = new ArchivoGrabacion(System.getProperty("user.dir")+ File.separator + "cvs" + "/CV" + cedula + ".txt");
        cv.grabarLinea(txtCv.getText());
        cv.cerrar();
        txtCv.setText("");
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
    private javax.swing.JList listaAreas;
    private javax.swing.JList listaEmpleados;
    private javax.swing.JList listaManagers;
    private javax.swing.JTextField txtCel;
    private javax.swing.JTextField txtCi;
    private javax.swing.JTextArea txtCv;
    private javax.swing.JTextField txtNom;
    private javax.swing.JTextField txtSal;
    // End of variables declaration//GEN-END:variables
    Sistema modelo;
}

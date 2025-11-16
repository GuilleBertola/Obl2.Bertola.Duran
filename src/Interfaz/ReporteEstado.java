package Interfaz;

import Archivos.ArchivoLectura;
import Dominio.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.*;
import javax.swing.*;

public class ReporteEstado extends javax.swing.JFrame {
    
    //private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ReporteEstado.class.getName());

    public ReporteEstado(Sistema sis) {
        modelo = sis;
        initComponents();
        cargarLista();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        listaAreas = new javax.swing.JList();
        panelEmpleados = new javax.swing.JPanel();
        txtInfo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        listaAreas.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        listaAreas.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaAreasValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(listaAreas);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(50, 70, 60, 146);

        panelEmpleados.setLayout(new java.awt.GridLayout(0, 3, 5, 5));
        getContentPane().add(panelEmpleados);
        panelEmpleados.setBounds(120, 70, 320, 130);

        txtInfo.setText("Aca hay una etiqueta");
        getContentPane().add(txtInfo);
        txtInfo.setBounds(200, 30, 170, 16);

        setBounds(0, 0, 603, 332);
    }// </editor-fold>//GEN-END:initComponents

    private void listaAreasValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaAreasValueChanged
        Area a = (Area) listaAreas.getSelectedValue();
        if(a == null){
            panelEmpleados.removeAll();
            txtInfo.setText("");
        }else{
            float porcentaje = (((float)a.getPresupuesto()-(float)a.getPresupuestoRestante())/(float)a.getPresupuesto())*100;
            txtInfo.setText(a.getNombre() + ": %" + porcentaje);
            ArrayList<Empleado> empleados = modelo.listarEmpleadosArea(a);
            panelEmpleados.removeAll();
            for(Empleado emp : empleados){
                JButton nuevo = new JButton(" ");
                nuevo.setMargin(new Insets(-5, -5, -5, -5));
                //int brillo = metodo que de un numero del 1 al 100 dependiendo el sueldo
                int col = modelo.colorBtn(emp);
                nuevo.setBackground(new Color(0, 0, col)); //Da un color en RGB
                nuevo.setForeground(Color.WHITE);
                nuevo.setText(emp.getNombre());
                nuevo.setName(emp.getCedula());
                nuevo.addActionListener(new AreaListener());
                panelEmpleados.add(nuevo); 
            }
        }
        //Dos lineas de gemini para recargar el panel
        panelEmpleados.revalidate(); 
        panelEmpleados.repaint();
    }//GEN-LAST:event_listaAreasValueChanged

    private class AreaListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // este código se ejecutará al presionar el botón, obtengo cuál botón
            JButton cual = ((JButton) e.getSource());
            String quien = cual.getName();
            Empleado emp = modelo.getEmpleado(quien);
            String nom = emp.getNombre();
            String cel = emp.getCelular();
            int sal = emp.getSalario();
            Manager man = emp.getManager();
            Area area = emp.getArea();
            ArchivoLectura leer = new ArchivoLectura(System.getProperty("user.dir")+ File.separator + "cvs" + "/CV" + quien + ".txt");
            String curr = "";
            while(leer.hayMasLineas()){
                curr +=  leer.linea();
            }
            leer.cerrar();
            String texto = "Nombre: " + nom + "\n" + 
                           "Cedula: " + quien + "\n" +
                           "Numero de telefono: " + cel + "\n" +
                           "Salario: " + sal + "\n" +
                           "Manager: " + man + "\n" +
                           "Area: " + area + "\n" +
                           "Curriculum: " + curr;
            JOptionPane.showMessageDialog(null, texto, "Informacion empleados", 1);
        }
    }

    public void cargarLista(){
        modelo.ordenarListaAreasXPresupuesto();
        listaAreas.setListData(modelo.getListaAreas().toArray());
        //listaAreas.setCellRenderer(cellRenderer); Averiguar que es un cellRenderer
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList listaAreas;
    private javax.swing.JPanel panelEmpleados;
    private javax.swing.JLabel txtInfo;
    // End of variables declaration//GEN-END:variables
    private Sistema modelo;
}


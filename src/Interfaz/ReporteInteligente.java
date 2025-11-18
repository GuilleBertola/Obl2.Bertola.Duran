package Interfaz;

import Dominio.*;
import java.util.*;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
//import javax.swing.*;


public class ReporteInteligente extends javax.swing.JFrame implements Observer{
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ReporteInteligente.class.getName());

    public ReporteInteligente(Sistema sis) {
        initComponents();
        modelo = sis;
        cargarAlgunasListas();
        modelo.addObserver(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        listaEmpleados = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaDestinos = new javax.swing.JList();
        jScrollPane3 = new javax.swing.JScrollPane();
        listaOrigen = new javax.swing.JList();
        btnAceptar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtRespuesta = new javax.swing.JTextArea();
        img = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jScrollPane1.setViewportView(listaEmpleados);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(160, 100, 47, 140);

        listaDestinos.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(listaDestinos);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(270, 100, 47, 146);

        listaOrigen.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        listaOrigen.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                origenCambiado(evt);
            }
        });
        jScrollPane3.setViewportView(listaOrigen);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(60, 100, 47, 146);

        btnAceptar.setText("Pedir Reporte");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAceptar);
        btnAceptar.setBounds(220, 40, 120, 23);

        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCerrar);
        btnCerrar.setBounds(70, 40, 72, 23);

        txtRespuesta.setColumns(20);
        txtRespuesta.setRows(5);
        jScrollPane4.setViewportView(txtRespuesta);

        getContentPane().add(jScrollPane4);
        jScrollPane4.setBounds(380, 110, 330, 300);
        getContentPane().add(img);
        img.setBounds(120, 280, 140, 140);

        setBounds(0, 0, 760, 476);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        img.setIcon(new ImageIcon(getClass().getResource("/imagenes/Reloj.gif")));//Las imagenes son muuy grandes
        img.updateUI();//No carga la imagen hasta despues del reporte
        Area origen = (Area)listaOrigen.getSelectedValue();
        Area destino = (Area)listaDestinos.getSelectedValue();
        Empleado empleado = (Empleado)listaEmpleados.getSelectedValue();
        String respuesta = "Esperando respuesta";
        int cant = 0;
        while(respuesta.length() < 25 && cant <= 3){ //Asumo que el reporte va a tener mas de 25 caracteres de largo
            respuesta = pedirRespuesta(origen, destino, empleado);
        }
        if(respuesta.equals("ERROR")){
            txtRespuesta.setText("El modelo no pudo responder, vuelva a probar");
            img.setIcon(new ImageIcon(getClass().getResource("/imagenes/Cruz.png")));
        }else{
            txtRespuesta.setText(respuesta);
            img.setIcon(new ImageIcon(getClass().getResource("/imagenes/check.png")));
        }
        

    }//GEN-LAST:event_btnAceptarActionPerformed

    private void origenCambiado(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_origenCambiado
        cargarListaEmpleados();
    }//GEN-LAST:event_origenCambiado
    
    public void cargarAlgunasListas(){
        listaOrigen.setListData(modelo.getListaAreas().toArray());
        listaDestinos.setListData(modelo.getListaAreas().toArray());
    }
    
    public void cargarListaEmpleados(){
        Area areaSelec = (Area) listaOrigen.getSelectedValue();
        if(areaSelec != null){
            listaEmpleados.setListData(modelo.listarEmpleadosArea(areaSelec).toArray());
        }
    }
    
    public String pedirRespuesta(Area origen, Area destino, Empleado empleado){
        String res = "";
        HacerReporteIA reporte = new HacerReporteIA();
        if(!reporte.errorDeApi()){
            String prompt = reporte.construirPrompt(origen, destino, empleado);
            try{
                res = reporte.obtenerReporteGemini(prompt);
            }
            catch(RuntimeException e){
                res = "ERROR";
            }
            catch(Exception e){
                System.out.println(e);
            }
        }else{
            res = "Error al leer la API KEY \n asegurese que este gurdada en un variable de entorno llamada ERP_API_KEY";
        }
        
        return res;
    }
    
    public void cargarListas(){
        cargarAlgunasListas();
        cargarListaEmpleados();
    }
    
    @Override
    public void update(Observable o, Object arg) {
        cargarListas();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JLabel img;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JList listaDestinos;
    private javax.swing.JList listaEmpleados;
    private javax.swing.JList listaOrigen;
    private javax.swing.JTextArea txtRespuesta;
    // End of variables declaration//GEN-END:variables
    public Sistema modelo;

}

//Guillermo Bértola 303665 y Santiago Durán 351471
package Interfaz;

import Dominio.*;
import java.util.*;
import java.util.concurrent.ExecutionException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
//import javax.swing.*;


public class ReporteInteligente extends javax.swing.JFrame implements Observer{
    
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Reporte Inteligente");
        getContentPane().setLayout(null);

        jScrollPane1.setViewportView(listaEmpleados);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(160, 90, 47, 140);

        listaDestinos.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(listaDestinos);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(50, 280, 47, 146);

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
        jScrollPane3.setBounds(40, 90, 47, 146);

        btnAceptar.setText("Pedir Reporte");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAceptar);
        btnAceptar.setBounds(260, 70, 120, 23);

        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCerrar);
        btnCerrar.setBounds(150, 390, 72, 23);

        txtRespuesta.setColumns(20);
        txtRespuesta.setRows(5);
        jScrollPane4.setViewportView(txtRespuesta);

        getContentPane().add(jScrollPane4);
        jScrollPane4.setBounds(260, 140, 460, 300);
        getContentPane().add(img);
        img.setBounds(420, 40, 70, 70);

        jLabel1.setText("Area de destino");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(40, 250, 100, 16);

        jLabel2.setText("Area de origen");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 60, 110, 16);

        jLabel3.setText("Empleados");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(160, 60, 80, 16);

        setBounds(0, 0, 760, 476);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        Area origen = (Area)listaOrigen.getSelectedValue();
        Area destino = (Area)listaDestinos.getSelectedValue();
        Empleado empleado = (Empleado)listaEmpleados.getSelectedValue();

        img.setIcon(new ImageIcon(getClass().getResource("/imagenes/reloj.gif")));
        txtRespuesta.setText("Generando reporte.");
        
        hacerDeFondo worker = new hacerDeFondo(origen, destino, empleado);
        worker.execute();
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void origenCambiado(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_origenCambiado
        cargarListaEmpleados();
    }//GEN-LAST:event_origenCambiado
    
    private class hacerDeFondo extends SwingWorker<String, Void> {

        private Area origen;
        private Area destino;
        private Empleado empleado;

        public hacerDeFondo(Area origen, Area destino, Empleado empleado) {
            this.origen = origen;
            this.destino = destino;
            this.empleado = empleado;
        }

        @Override
        protected String doInBackground() throws Exception {
            String respuesta = "Esperando respuesta";
            int cant = 0;

            while (respuesta.length() < 25 && cant <= 3) { //Asumo que el reporte va a ser de mas de 25 caracteres y tomo eso como señal de que lo hizo correctamente
                cant++;
                respuesta = pedirRespuesta(origen, destino, empleado);
            }
            return respuesta;
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
                res = "Error al leer la API KEY";
            }

            return res;
        }

        //Hace el done despues del doInBackground
        @Override
        protected void done() {
            try {
                // devuelve el resultado de doInBackground
                String respuesta = get(); 

                if (respuesta.equals("ERROR") || respuesta.equals("Error al leer la API KEY")) {
                    if(respuesta.equals("ERROR")){
                        txtRespuesta.setText("El modelo no pudo responder, vuelva a probar");
                    }else{
                        txtRespuesta.setText(respuesta);
                    }
                    img.setIcon(new ImageIcon(getClass().getResource("/imagenes/Cruz.png")));
                } else {
                    txtRespuesta.setText(respuesta);
                    img.setIcon(new ImageIcon(getClass().getResource("/imagenes/check.png")));
                }

            } catch (InterruptedException | ExecutionException e) {
                // Manejar errores de ejecución del Worker (si fue cancelado o falló)
                txtRespuesta.setText("Error fatal en el proceso: " + e.getMessage());
                img.setIcon(new ImageIcon(getClass().getResource("/imagenes/cruz.png")));
            }
        }
    }
    
    public void cargarAlgunasListas(){
        modelo.ordenarListaAreas();
        listaOrigen.setListData(modelo.getListaAreas().toArray());
        listaDestinos.setListData(modelo.getListaAreas().toArray());
    }
    
    public void cargarListaEmpleados(){
        Area areaSelec = (Area) listaOrigen.getSelectedValue();
        if(areaSelec != null){
            modelo.ordenarListaEmpleados();
            listaEmpleados.setListData(modelo.listarEmpleadosArea(areaSelec).toArray());
        }
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
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

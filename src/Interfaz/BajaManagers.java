package Interfaz;
import Dominio.*;

public class BajaManagers extends javax.swing.JFrame {

    public BajaManagers(Sistema sis) {
        modelo=sis;
        initComponents();
        cargarLista();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        ListaManSinE = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        CajaManager = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        ListaManSinE.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        ListaManSinE.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                ListaManSinEValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(ListaManSinE);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 70, 190, 131);

        jLabel1.setText("Lista de Managers sin empleados:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 50, 210, 16);
        getContentPane().add(CajaManager);
        CajaManager.setBounds(280, 80, 71, 22);

        jLabel2.setText("Manager seleccionado:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(252, 50, 150, 16);

        setBounds(0, 0, 414, 308);
    }// </editor-fold>//GEN-END:initComponents

    private void ListaManSinEValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_ListaManSinEValueChanged
        Manager m = (Manager) ListaManSinE.getSelectedValue();
        CajaManager.setText(m.getNombre());
    }//GEN-LAST:event_ListaManSinEValueChanged

    public void cargarLista(){
        ListaManSinE.setListData(modelo.managersSinE().toArray());
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CajaManager;
    private javax.swing.JList ListaManSinE;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
    private Sistema modelo;
}

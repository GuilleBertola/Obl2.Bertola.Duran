//Guillermo Bértola 303665 y Santiago Durán 351471
package Dominio;

import java.awt.Component;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.DefaultListCellRenderer;

public class comoPintarLaTabla extends DefaultListCellRenderer{
    
    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, 
                                                  boolean isSelected, boolean cellHasFocus) {
        
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        
        if (value != null) {
            Area a = (Area) value;
            
            float porcentaje = 100*((float)a.getPresupuesto()-(float)a.getPresupuestoRestante())/(float)a.getPresupuesto();
            
            if (porcentaje >= 90) {
                setBackground(Color.RED); 
                setForeground(Color.WHITE);
            } else {
                if (porcentaje >=70) {
                    setBackground(Color.YELLOW); 
                    setForeground(Color.WHITE); 
                } else {
                    setBackground(Color.WHITE); 
                    setForeground(Color.BLACK); 
                }
            }
            
        }
        
        return this;
    }
    
}


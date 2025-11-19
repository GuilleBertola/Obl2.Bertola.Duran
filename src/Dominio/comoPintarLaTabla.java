//Guillermo Bértola 303665 y Santiago Durán 351471
package Dominio;

import java.awt.Component;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.DefaultListCellRenderer;

public class comoPintarLaTabla extends DefaultListCellRenderer{
    // Sobrescribe el método que se llama para dibujar cada elemento
    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, 
                                                  boolean isSelected, boolean cellHasFocus) {
        
        // **1. Llamar al método base**
        // Esto configura el texto, la fuente y el comportamiento estándar (selección/foco)
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        
        // **2. Aplicar lógica de color condicional**
        if (value != null) {
            Area a = (Area) value;
            
            int porcentaje = 100*(a.getPresupuesto()-a.getPresupuestoRestante())/a.getPresupuesto();
            // Ejemplo de lógica: si el texto empieza con "A", pinta de azul.
            if (porcentaje >= 90) {
                setBackground(Color.RED); // Fondo Azul Claro
                setForeground(Color.WHITE);      // Texto Azul Oscuro
            } else {
                if (porcentaje >=70) {
                    setBackground(Color.YELLOW); // Fondo Azul Claro
                    setForeground(Color.WHITE);      // Texto Azul Oscuro
                } else {
                    setBackground(Color.WHITE); // Fondo blanco por defecto
                    setForeground(Color.BLACK); // Texto negro por defecto
                }
            }
            
            // Manejar la selección por separado es crucial
            /*else if (isSelected) {
                // Si está seleccionado, usa los colores predeterminados de selección
                setBackground(list.getSelectionBackground());
                setForeground(list.getSelectionForeground());
            } */
            // Si no tiene lógica personalizada y no está seleccionado
            
        }
        
        return this;
    }
}


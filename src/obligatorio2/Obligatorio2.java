//Guillermo Bértola 303665 y Santiago Durán 351471
package obligatorio2;

import Interfaz.*;
import Dominio.*;

public class Obligatorio2 {

    public static void main(String[] args) {
        Sistema sistema = new Sistema();
        
        Bienvenida vent = new Bienvenida(sistema);
        vent.setLocationRelativeTo(null);
        vent.setVisible(true);
    }
    
}

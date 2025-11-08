package obligatorio2;
import Interfaz.*;
import Dominio.*;

public class Obligatorio2 {

    
    public static void main(String[] args) {
        System.out.println("Hellow world, ir a la carpeta de netbeans, hacer un git init, git add ., git commit -m(una version nueva, cuando amerita subirse, va con un mensaje), el commit es la instancia para subir, seleccionamos la rama, por ahora nos quedamso con el main(lineas de codigo en github, le decimos que repositorio queremos que lo guarde, push ");
        Sistema sistema = new Sistema();
        
        AltaAreas vent = new AltaAreas(sistema);
        vent.setLocationRelativeTo(null);
        vent.setVisible(true);
        
        Menu vent1 = new Menu(sistema);
        vent1.setLocationRelativeTo(null);
        vent1.setVisible(true);
    }//para bajar lo que ya tengo subido, copio el link de github, git clone elLink
    
    
    //falta poner en las ventanas que no se cierren las demas si cierro una
}

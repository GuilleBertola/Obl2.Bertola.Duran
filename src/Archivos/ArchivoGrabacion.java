//Guillermo Bértola 303665 y Santiago Durán 351471
package Archivos;

import java.io.*;
import java.util.*;

public class ArchivoGrabacion {
    
    private Formatter out;
    
    public ArchivoGrabacion(String nombre){
        try{
            out = new Formatter(nombre);
        }
        catch(FileNotFoundException e){
            System.out.println("Error al crear el archivo");
        }
    }
    //Dimos otro constructor para continuar escribiendo en archivos ya creados, no lo hice porque no lo necesitamos
    public void grabarLinea(String linea){
        out.format("%s%n", linea);
    }
    public void cerrar(){
        out.close();
    }
}

//Guillermo Bértola 303665 y Santiago Durán 351471
package Dominio;

import java.io.Serializable;

public class Manager implements Comparable<Manager>, Serializable{
    private String cedula;
    private String nombre;
    private int antiguedad;
    private String celular;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAntiguedad() { 
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCedula() {
        return cedula;
    }

    public Manager(String cedula, String nombre, int antiguedad, String celular) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.antiguedad = antiguedad;
        this.celular = celular;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
    @Override
    public int compareTo(Manager unManager){
        return unManager.getAntiguedad()-this.getAntiguedad();
    }
      
}

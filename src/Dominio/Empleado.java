//Guillermo Bértola 303665 y Santiago Durán 351471
package Dominio;

import java.io.Serializable;

public class Empleado implements Comparable<Empleado>, Serializable{ //deberian los manager y empleados heredar de lo mismo??
    private String cedula;
    private String nombre;
    private String celular;
    private int salario;
    private Manager manager;
    private Area area;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public String getCedula() {
        return cedula;
    }//no hice setCedula porque una persona no puede cambiar su cedula

    public Empleado(String cedula, String nombre, String celular, int salario, Manager manager, Area area) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.celular = celular;
        this.salario = salario;
        this.manager = manager;
        this.area = area;
    }

    @Override
    public String toString() { //ver que queremos que tenga el toString
        return nombre;
    }
    @Override
    public int compareTo(Empleado unEmpleado){
        return this.getSalario()-unEmpleado.getSalario();
    }
    
    
}

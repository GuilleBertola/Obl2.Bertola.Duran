package Dominio;

import java.io.Serializable;
import java.util.Objects;

public class Area implements Comparable<Area>, Serializable{
    private String nombre;
    private String descripcion;
    private int presupuesto;
    private int presupuestoRestante;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(int presupuesto) {
        this.presupuesto = presupuesto;
    }

    public int getPresupuestoRestante() {
        return presupuestoRestante;
    }
    
    

    public Area(String nombre, String descripcion, int presupuesto) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.presupuesto = presupuesto;
        this.presupuestoRestante = presupuesto;
    }
    
    @Override
    public String toString() {//ver que queremos que tenga el toString
        return nombre;
    }
    
    @Override
    public int compareTo(Area unArea){
        return this.getNombre().compareTo(unArea.getNombre());
    }

    public boolean equals(Area unArea) {
        return this.getNombre().equals(unArea.getNombre());
    }
    
    public boolean presupuestoSuficiente(Empleado unEmpleado, int mes){
        boolean sePuede = false;
        int mesesRestantes = 12 - mes;
        this.presupuestoRestante -= mesesRestantes*unEmpleado.getSalario();
        if(this.presupuestoRestante >= 0){
            sePuede = true;
        }else{
            this.presupuestoRestante += mesesRestantes*unEmpleado.getSalario();
        }
        return sePuede;
    }
    
    
}

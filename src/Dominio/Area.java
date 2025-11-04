package Dominio;

public class Area implements Comparable<Area>{
    private String nombre;
    private String descripcion;
    private int presupuesto;

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

    public Area(String nombre, String descripcion, int presupuesto) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.presupuesto = presupuesto;
    }

    @Override
    public String toString() {//ver que queremos que tenga el toString
        return nombre;
    }
    
    @Override
    public int compareTo(Area unArea){
        return this.getNombre().compareTo(unArea.getNombre());
    }
    
}

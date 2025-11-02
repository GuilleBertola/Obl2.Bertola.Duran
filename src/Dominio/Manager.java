package Dominio;

public class Manager {
    private String cedula;
    private String nombre;
    private int antiguedad; //leer letra sobre antiguedad
    private String celular;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {//que tan necesario es un set nombre??
        this.nombre = nombre;
    }

    public int getAntiguedad() { 
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) { //es necesario??, lo mas intuitivo seria una funcion que sume una a antiguedad
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
        this.antiguedad = antiguedad; //deberia empezar en 0??
        this.celular = celular;
    }

    @Override
    public String toString() {
        return nombre;
    }
      
}

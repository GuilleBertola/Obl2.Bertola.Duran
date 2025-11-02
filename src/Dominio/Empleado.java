package Dominio;

public class Empleado { //deberian los manager y empleados heredar de lo mismo??
    private String cedula;
    private String nombre;
    private String celular;
    private String curriculum; //???
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

    public String getCurriculum() {
        return curriculum;
    }

    public void setCurriculum(String curriculum) {
        this.curriculum = curriculum;
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

    public Empleado(String cedula, String nombre, String celular, String curriculum, int salario, Manager manager, Area area) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.celular = celular;
        this.curriculum = curriculum;
        this.salario = salario;
        this.manager = manager;
        this.area = area;
    }

    @Override
    public String toString() { //ver que queremos que tenga el toString
        return nombre;
    }
    
    
    
}

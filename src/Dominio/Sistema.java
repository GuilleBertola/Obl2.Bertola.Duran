package Dominio;

import java.util.ArrayList;

public class Sistema {
    private ArrayList<Area> listaAreas;
    private ArrayList<Manager> listaManagers;
    private ArrayList<Empleado> listaEmpleados;
    private ArrayList<Movimiento> listaMovimientos;
    
    public void agregarArea(Area unArea){
        listaAreas.add(unArea);
    }
    public void agregarManager(Manager unManager){
        listaManagers.add(unManager);
    }
    public void agregarEmpleado(Empleado unEmpleado){
        listaEmpleados.add(unEmpleado);
    }
    public void agregarMovimiento(Movimiento unMovimineto){
        listaMovimientos.add(unMovimineto);
    }
    public void eliminarArea(Area unArea){
        listaAreas.remove(unArea);
    }
    public void eliminarManager(Manager unManager){
        listaManagers.remove(unManager);
    }
    public void eliminarEmpleado(Empleado unEmpleado){
        listaEmpleados.remove(unEmpleado);
    }
    public Sistema(){
        listaAreas = new ArrayList<>();
        listaManagers = new ArrayList<>();
        listaEmpleados = new ArrayList<>();
        listaMovimientos = new ArrayList<>();
    }
    
    
}

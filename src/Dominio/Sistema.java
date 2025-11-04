package Dominio;

import java.util.*;

public class Sistema {
    private ArrayList<Area> listaAreas;
    private ArrayList<Manager> listaManagers;
    private ArrayList<Empleado> listaEmpleados;
    private ArrayList<Movimiento> listaMovimientos;

    public ArrayList<Area> getListaAreas() {
        return listaAreas;
    }

    public ArrayList<Manager> getListaManagers() {
        return listaManagers;
    }

    public ArrayList<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public ArrayList<Movimiento> getListaMovimientos() {
        return listaMovimientos;
    }
    
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
       
    public void ordenarListaMoviminetos(){
        Collections.sort(listaMovimientos);        
    }
    
    public boolean nombreAreaDisponible(String unNombre){
        boolean existe = false;
        for(Area area:getListaAreas()){
            if(area.getNombre().equals(unNombre)){
                existe = true;
            }
        }
        return !existe;
    }
    
    public boolean existeCi(String unCi){
        boolean existe = false;
        for(Empleado e : listaEmpleados){
            if(e.getCedula().equals(unCi)){
                existe = true;
            }
        }
        for(Manager m : listaManagers){
            if(m.getCedula().equals(unCi)){
                existe = true;
            }
        }
        return existe;
    }
}

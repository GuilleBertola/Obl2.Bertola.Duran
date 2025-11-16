package Dominio;

import java.util.*;
import java.io.*;

public class Sistema extends Observable implements Serializable {
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
        notificar();
        
    }
    public void agregarManager(Manager unManager){
        listaManagers.add(unManager);
        notificar();
    }
    public void agregarEmpleado(Empleado unEmpleado){
        listaEmpleados.add(unEmpleado);
        notificar();
    }
    public void agregarMovimiento(Movimiento unMovimineto){
        listaMovimientos.add(unMovimineto);
        notificar();
    }
    public void eliminarArea(Area unArea){
        listaAreas.remove(unArea);
        notificar();
    }
    public void eliminarManager(Manager unManager){
        listaManagers.remove(unManager);
        notificar();
    }
    public void eliminarEmpleado(Empleado unEmpleado){
        listaEmpleados.remove(unEmpleado);
    }
    public Area getArea(String nom){
        Area ret = null;
        for(Area a : this.listaAreas){
            if(a.getNombre().equals(nom)){
                ret = a;
            }
        }
        return ret;
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
    public void ordenarListaAreas(){
        Collections.sort(listaAreas);
    }
    public void ordenarListaManagers(){
        Collections.sort(listaManagers);
    }
    public void ordenarListaEmpleados(){
        Collections.sort(listaEmpleados);
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
    
    public ArrayList<Empleado> listarEmpleadosArea(Area unArea){
        ArrayList<Empleado> empleados = new ArrayList<>();
        for(Empleado unEmpleado : this.listaEmpleados){
            if(unEmpleado.getArea().equals(unArea)){
                empleados.add(unEmpleado);
            }
        }
        return empleados;
    }
    
        public ArrayList<Empleado> listarEmpleadosMan(Manager unManager){
        ArrayList<Empleado> empleados = new ArrayList<>();
        for(Empleado unEmpleado : this.listaEmpleados){
            if(unEmpleado.getManager().equals(unManager)){
                empleados.add(unEmpleado);
            }
        }
        return empleados;
    }
    
    public void serializar(){
        try{
            FileOutputStream arch = new FileOutputStream("Datos");
            ObjectOutputStream grabar = new ObjectOutputStream(arch);
            grabar.writeObject(this);
            grabar.close();
        }catch(IOException e){
            System.out.println("Error al serializar");
        }
    }
    
    public ArrayList<Area> areasSinE(){
        ArrayList<Area> lista=new ArrayList<>();
        for (int i = 0; i<this.listaAreas.size(); i++) {
            if(listarEmpleadosArea(this.listaAreas.get(i)).isEmpty()){
                lista.add(listaAreas.get(i));
            }
        }
        return lista;
    }
    
    public ArrayList<Manager> managersSinE(){
        ArrayList<Manager> lista=new ArrayList<>();
        for (int i = 0; i < this.listaManagers.size(); i++) {
            if(listarEmpleadosMan(this.listaManagers.get(i)).isEmpty()){
                lista.add(listaManagers.get(i));
            }
        }
        return lista;
    }
    
    public void datosPrecargados(){
        agregarArea(new Area("Personal", "Reclutamiento de personal, promociones, gestión de cargos", 100000));
        agregarArea(new Area("RRHH", "Relacionamiento en la empresa, organigrama, gestión de equipos", 80000));
        agregarArea(new Area("Seguridad", "Seguridad física, vigilancia, seguridad informática, protocolos y políticas de seguridad", 120000));
        agregarArea(new Area("Comunicaciones", "Comunicaciones internas, reglas y protocolos, comunicaciones con proveedores y clientes", 20000));
        agregarArea(new Area("Marketing", "Acciones planificadas, publicidad en medios masivos, publicidad en redes, gestión de redes", 95000));
        agregarManager(new Manager("4.568.369-1", "Ana Martínez", 10, "099 123456"));
        agregarManager(new Manager("3.214.589-3", "Ricardo Morales", 4, "094 121212"));
        agregarManager(new Manager("3.589.257-5", "Laura Torales", 1, "099 654321"));
        agregarManager(new Manager("4.555.197-7", "Juan Pablo Zapata", 5, "099 202020"));
    }
    
    public void notificar(){
        setChanged();
        notifyObservers();
    }
    
    
    
    
}

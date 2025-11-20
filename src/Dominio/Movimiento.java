//Guillermo Bértola 303665 y Santiago Durán 351471
package Dominio;

import java.io.Serializable;

public class Movimiento implements Comparable<Movimiento>, Serializable{
    private int mes;
    private Area areaOrigen;
    private Area areaDestino;
    private Empleado empleado;
    private String[] meses;

    public int getMes() {
        return mes;
    }

    public Area getAreaOrigen() {
        return areaOrigen;
    }

    public Area getAreaDestino() {
        return areaDestino;
    }

    public Empleado getEmpleado() {
        return empleado;
    }
    
    public String[] getMeses(){
        return meses;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public void setAreaOrigen(Area areaOrigen) {
        this.areaOrigen = areaOrigen;
    }

    public void setAreaDestino(Area areaDestino) {
        this.areaDestino = areaDestino;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
    
    public Movimiento() {
        this.meses = crearMeses();
    }
    
    @Override
    public String toString() {
        return "Movimiento{" + "mes=" + mes + ", areaOrigen=" + areaOrigen + ", areaDestino=" + areaDestino + ", empleado=" + empleado + '}';
    }
    
    @Override
    public int compareTo(Movimiento unMovimiento) {
        return this.getMes() - unMovimiento.getMes();        
    }
    
    public int mesANum(String month){
        int pos = -1;
        for (int i = 1; i < meses.length; i++) {
            if(month.equals(meses[i])){
                pos = i;
            }
        }
        return pos;
    }
    
    public String[] crearMeses(){
        String [] months = {"", "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Setiembre", "Octubre", "Noviembre", "Diciembre"};
        return months;
    }
}

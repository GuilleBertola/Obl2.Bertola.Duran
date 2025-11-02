package Dominio;

public class Movimiento {
    private int mes;
    private Area areaOrigen;
    private Area areaDestino;
    private Empleado empleado;

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
    //no hice setter porque el proposito de la clase es almacenar informacion, no veo motivo de modificacion
    public Movimiento(int mes, Area areaOrigen, Area areaDestino, Empleado empleado) {
        this.mes = mes;
        this.areaOrigen = areaOrigen;
        this.areaDestino = areaDestino;
        this.empleado = empleado;
    }

    @Override
    public String toString() {
        return "Movimiento{" + "mes=" + mes + ", areaOrigen=" + areaOrigen + ", areaDestino=" + areaDestino + ", empleado=" + empleado + '}';
    }
    
    
    
}

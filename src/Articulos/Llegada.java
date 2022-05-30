/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Articulos;
import Maqueta.Maqueta;
import java.util.Date;

/**
 *
 * @author admin
 */
public class Llegada implements Maqueta {
   private String id;
   private int cantidad;
   private Date fecha;
   private Date fechaLlegada;
   private double precio;
   private boolean estado;

    public Llegada(String id,int cantidad, Date fecha, Date fechaLlegada, double precio, boolean estado) {
        this.id=id;
        this.cantidad = cantidad;
        this.fecha = fecha;
        this.fechaLlegada = fechaLlegada;
        this.precio = precio;
        this.estado = estado;
    }

    public String getID() {
        return id;
    }

    public void setID(String id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(Date fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Llegada(String referencia) {
        this.id = referencia;
    }

   @Override
    public void recuperaDatos(){
        
    }
    @Override
    public void registrar(){
        
    }
    @Override
    public void eliminar(){
        
    }
    @Override
    public void actualizar(){
        
    }  
}

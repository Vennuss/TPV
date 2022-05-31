/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ofertas;

import Articulos.Articulo;
import Maqueta.Maqueta;
import bd.bd;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronal Arrayaza DAM1C
 */
public class Cesta implements Maqueta {

    private int cantidad;
    private double dto;
    private Articulo articulo;    
    private String dni;

    public Cesta(Articulo articulo, String DNI, int cantidad, double dto) {
        this.articulo = articulo;
        this.dni = DNI;
        this.cantidad=cantidad;
        this.dto=dto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getDto() {
        return dto;
    }

    public void setDto(double dto) {
        this.dto = dto;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }


    public boolean isRegistrado() {
        boolean retorno = false;

        String sql = "select * from cestas where articuloref='" + this.articulo.getReferencia() + "' and dnicliente='" + this.dni + "'";
        int contador = 0;
        try {
            
            ResultSet rs = bd.Consulta(sql);
            while (rs.next()) {
                contador++;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        if(contador==1){
            retorno=true;
        }

        return retorno;
    }

    @Override
    public void recuperaDatos() {

    }

    @Override
    public void registrar() {
        if (this.isRegistrado()) {
            this.actualizar();
        } else {
            String sql = "insert into cestas(dnicliente, articuloref, cantidad, dto) values('" + this.dni
                    + "','" + this.articulo.getReferencia() + "'," + this.getCantidad() + "," + this.dto + ")";
            int resultado = bd.Sentencia(sql);
            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Registro Exitoso");
            }
        }
    }

    @Override
    public boolean eliminar() {
        String sql = "delete from ofertas where dniCliente='" + this.dni + "' and articuloref='" + this.getArticulo().getReferencia() + "'";
        int resultado = bd.Sentencia(sql);
        if (resultado > 0) {
            JOptionPane.showMessageDialog(null, "La operacion se ha realizado con Exito");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "No se ha podido realizar la operacion");
            return false;
        }
    }

    @Override
    public void actualizar() {
        String sql = "UPDATE cestas set cantidad=(cantidad+" + this.getCantidad() + "), dto=" + this.getDto()
                + "where articuloref='" + this.articulo.getReferencia() + "' and dnicliente='" + this.dni + "'";
        int resultado = bd.Sentencia(sql);
        if (resultado > 0) {
            JOptionPane.showMessageDialog(null, "Registro Exitoso");
        }
    }

}

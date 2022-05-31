/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ofertas;

import Maqueta.Maqueta;
import bd.bd;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronal Arrayaza DAM1C
 */
public class Aplican implements Maqueta {

    private int ofertasId;
    private String Referencia;
    private double descuento;
    private double cantidad;

    public Aplican() {

    }

    public Aplican(int ofertasId, String Referencia) {
        this.ofertasId = ofertasId;
        this.Referencia = Referencia;
    }

    public int getOfertasId() {
        return ofertasId;
    }

    public void setOfertasId(int ofertasId) {
        this.ofertasId = ofertasId;
    }

    public String getReferencia() {
        return Referencia;
    }

    public void setReferencia(String Referencia) {
        this.Referencia = Referencia;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public Aplican(int ofertasId, String Referencia, double descuento, double cantidad) {
        this.ofertasId = ofertasId;
        this.Referencia = Referencia;
        this.descuento = descuento;
        this.cantidad = cantidad;
    }

    @Override
    public void recuperaDatos() {
        String sql = "select * from aplican where ofertasid=" + this.getOfertasId() + " and articulosref='" + this.getReferencia() + "'";

        try {

            ResultSet rs = bd.Consulta(sql);
            while (rs.next()) {
                this.setDescuento(rs.getDouble("descuento"));
                this.setCantidad(rs.getDouble("cantidad"));
            }
            bd.cerrarConexion();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void registrar() {
        String sql = "insert into aplican(ofertasId, articulosRef, descuento, cantidad) values(" + this.getOfertasId() + ",'" + this.getReferencia() + "',"
                + this.getDescuento() + "," + this.getCantidad() + ")";
        int resultado = bd.Sentencia(sql);
        if (resultado > 0) {
            // JOptionPane.showMessageDialog(null, "Registro Exitoso");

        }
    }

    @Override
    public boolean eliminar() {
        String sql = "delete from aplican where ofertasId=" + this.getOfertasId() + " and articulosRef='" + this.getReferencia() + "'";
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
        String sql = "update aplican set cantidad=" + this.getCantidad() + ", descuento=" + this.getDescuento() + " where ofertasID=" + this.getOfertasId() + " and articulosRef='" + this.getReferencia() + "'";
        int resultado = bd.Sentencia(sql);
        if (resultado > 0) {
            JOptionPane.showMessageDialog(null, "Registro Exitoso");

        }
    }

}

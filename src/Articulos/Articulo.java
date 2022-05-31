/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Articulos;

import Maqueta.Maqueta;
import bd.bd;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronal Arrayaza DAM1C
 * 
 */
public class Articulo implements Maqueta{
    

    /**
     * Representa la referencia del Articulo
     */
    private String referencia;
    /**
     * Descripcion del articulo
     */
    private String descripcion;
    /**
     * Notas realacionadas al articulo
     */
    private String notas;
    /**
     * Marca del articulo
     */
    private String marca;
    private double pvp;
    private int stock;
    private String rutaImg;
    private Familia fa;

    public Articulo(String referencia, String descripcion, double pvp, int idFamilia) {
        this.referencia = referencia;
        this.descripcion = descripcion;
        this.marca = "";
        this.pvp = pvp;
        this.notas = "";
        this.rutaImg = "";
        this.fa = new Familia(idFamilia);
    }

    public Articulo(String referencia) {
        this.referencia = referencia;
        this.descripcion = "";
        this.marca = "";
        this.pvp = -1;
        this.notas = "";
        this.rutaImg = "";
        this.fa = new Familia();
    }
    /**
     * Constructor sin parametros
     */
    public Articulo() {
        this.referencia = "";
        this.descripcion = "";
        this.marca = "";
        this.pvp = -1;
        this.notas = "";
        this.rutaImg = "";
        this.fa = new Familia();
    }

    @Override
    public void recuperaDatos() {
        String sql = "select * from articulos where ref='" + this.getReferencia()+"'";
        try {

            ResultSet rs = bd.Consulta(sql);
            while (rs.next()) {
                this.setReferencia(rs.getString("ref"));
                this.setDescripcion(rs.getString("descripcion"));
                this.setMarca(rs.getString("marca"));
                this.setPvp(rs.getDouble("pvp"));
                this.setStock(rs.getInt("stock"));
                this.setNotas(rs.getString("notas"));
                this.setRutaImg(rs.getString("rutaImg"));
                this.fa = new Familia(rs.getInt("idfamilia"));
                fa.recuperaDatos();
            }
            bd.cerrarConexion();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void registrar() {
        String sql = "INSERT INTO articulos (ref, descripcion, notas, marca, PVP, stock, rutaimg, idfamilia) VALUES ('"
                + this.getReferencia() + "', '" + this.getDescripcion() + "', '" + this.getNotas() + "', '" +
                this.getMarca() + "', '" + this.getPvp() + "', '" + this.getStock() +
                "', '" + this.getRutaImg() + "'," + this.fa.getId() + " )";
        int resultado = bd.Sentencia(sql);
        if (resultado > 0) {
            JOptionPane.showMessageDialog(null, "Registro Exitoso");
        }
    }

    @Override
    public boolean eliminar() {
        String sql = "delete from articulos where ref='" + this.getReferencia() + "'";
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
        String sql = "UPDATE articulos set descripcion='" + this.getDescripcion() + "', notas='" + this.getNotas() + 
                "', marca='" + this.getMarca() + "', PVP=" + this.getPvp() + ", stock=" + this.getStock() + ", rutaimg='" + this.getRutaImg() + 
                "', idfamilia=" + this.fa.getId() + " where ref='" + this.getReferencia() + "'";
        int resultado = bd.Sentencia(sql);
        if (resultado > 0) {
            JOptionPane.showMessageDialog(null, "Registro Exitoso");
        }
    }


    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPvp() {
        return pvp;
    }

    public void setPvp(double pvp) {
        this.pvp = pvp;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public String getRutaImg() {
        return rutaImg;
    }

    public void setRutaImg(String rutaImg) {
        this.rutaImg = rutaImg;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Familia getFa() {
        return fa;
    }

    public void setFa(Familia fa) {
        this.fa = fa;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Articulos;

import bd.bd;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author admin
 */
public class Familia {

    private int id;
    private String nombre;
    private String notas;

    public Familia(int id, String nombre, String notas) {
        this.id = id;
        this.nombre = nombre;
        this.notas = notas;
    }

    public Familia() {
        this.id = -1;

    }

    public Familia(int id) {
        this.id = id;
        this.nombre = "";
        this.notas = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    /*
    
     */
    public void recuperaDatos() {
        String sql = "select * from familias where id=" + this.getId();
        try {

            ResultSet rs = bd.Consulta(sql);
            while (rs.next()) {
                this.setId(rs.getInt("id"));
                this.setNombre(rs.getString("nombre"));
                this.setNotas(rs.getString("notas"));
            }
            bd.cerrarConexion();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void registrar() {
        String sql = "insert into familias(nombre, notas) values('" + this.getNombre() + "','" + this.getNotas() + "')";
        int resultado = bd.Sentencia(sql);
        if (resultado > 0) {
            JOptionPane.showMessageDialog(null, "Registro Exitoso");

        }
    }

    public void eliminar() {
        String sql = "delete from familias where id=" + this.getId();
        int resultado = bd.Sentencia(sql);
        if (resultado > 0) {
            JOptionPane.showMessageDialog(null, "La operacion se ha realizado con Exito");
        } else {
            JOptionPane.showMessageDialog(null, "No se ha podido realizar la operacion");
        }
    }

    public void actualizar() {
        String sql = "update familias set nombre='" + this.getNombre() + "', notas='" + this.getNotas() + "' where id=" + this.getId();
        int resultado = bd.Sentencia(sql);
        if (resultado > 0) {
            JOptionPane.showMessageDialog(null, "Registro Exitoso");
            System.out.println("Se ha detenido y no sale");
        }
    }
}

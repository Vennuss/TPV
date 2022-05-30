/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persona;


import Maqueta.Maqueta;
import bd.bd;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Familia
 */
public class Cliente extends Persona implements Maqueta{

    public Cliente(String dni) {
        super(dni);
    }

    public Cliente() {
    }
    
    
    @Override
    public void recuperaDatos() {
        String sql = "select * from clientes where dni='" + this.getDni()+"'";
        try {

            ResultSet rs = bd.Consulta(sql);
            while (rs.next()) {
                this.setApellidos(rs.getString("apellidos"));
                this.setCorreo(rs.getString("correo"));
                this.setNombres(rs.getString("nombres"));
                this.setPass(rs.getString("pass"));
                this.setRutaImg(rs.getString("rutaimg"));
            }
            bd.cerrarConexion();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void registrar() {
        String sql = "INSERT INTO clientes (dni, nombres, apellidos, pass, correo, rutaimg) VALUES ('"
                + this.getDni() + "', '" + this.getNombres() + "', '" + this.getApellidos() + "', '" +
                this.getPass() + "', '" + this.getCorreo() + "', '" + this.getRutaImg() + "')";
        int resultado = bd.Sentencia(sql);
        if (resultado > 0) {
            JOptionPane.showMessageDialog(null, "Registro Exitoso");
        }
    }

    @Override
    public void eliminar() {
        String sql = "delete from clientes where dni='" + this.getDni() + "'";
        int resultado = bd.Sentencia(sql);
        if (resultado > 0) {
            JOptionPane.showMessageDialog(null, "La operacion se ha realizado con Exito");
        } else {
            JOptionPane.showMessageDialog(null, "No se ha podido realizar la operacion");
        }
    }

    @Override
    public void actualizar() {
        String sql = "UPDATE clientes set nombres='" + this.getNombres() + "', apellidos='" + this.getApellidos() + 
                "', pass='" + this.getPass() + "', correo='" + this.getCorreo() + "', rutaimg='" + this.getRutaImg() + 
                "' where dni='" + this.getDni() + "'";
        int resultado = bd.Sentencia(sql);
        if (resultado > 0) {
            JOptionPane.showMessageDialog(null, "Registro Exitoso");
        }
    }
}

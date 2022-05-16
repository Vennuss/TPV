/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clientes;

import bd.bd;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author admin
 */
public class Cliente {

    private String dni;
    private String nombres;
    private String apellidos;
    private String email;
    private String usuario;
    private String password;

    public Cliente(String dni, String nombre, String apellidos, String email, String usuario, String password) {
        this.dni = dni;
        this.nombres = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.usuario = usuario;
        this.password = password;
    }

    public Cliente(String dni) {
        this.dni = dni;
        
            this.recuperaDatos();
    }

    public Cliente() {
        this.dni = null;
        this.nombres = null;
        this.apellidos = null;
        this.email = null;
        this.usuario = null;
        this.password = null;
    }

    public String getDni() {
        return dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setIdCliente(String dni) {
        this.dni = dni;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombre) {
        this.nombres = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void recuperaDatos() {
        String sql = "select * from clientes where dni=" + this.getDni();
        Connection con = bd.Conexion();
        if (con != null) {
            // Informamos que la conexión es correcta
            try {
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    this.setApellidos(rs.getString("apellidos"));
                    this.setEmail(rs.getString("email"));
                    this.setNombres(rs.getString("nombres"));
                    this.setUsuario(rs.getString("usuario"));
                    this.setPassword(rs.getString("password"));
                }
            } catch (Exception ex) {
                
            }
        } else { // Sino informamos que no nos podemos conectar.
            System.out.println("No hay conexion");
        }
    }

    public void registrar() {      
        String sql = "insert into clientes(idCliente,nombres, apellidos, email, usuario, password) VALUES (NULL,"+
                 "'" + this.getNombres() + "','" + this.getApellidos() + "','" + this.getEmail() + "','" + this.getUsuario() + "','" + this.getPassword() + "')";
//        int nr = stmt.executeUpdate
        Connection con = bd.Conexion();
        try {
            Statement st = con.createStatement();
            int nr = st.executeUpdate(sql);
            System.out.println("numero de registros actualizados:" + nr);
        } catch (Exception ex) {
            System.out.println("Error de Registro");
        }

        //Registro de Cliente     
    }

    public void actualizar() {
        //Actualizar la ficha del Cliente
        String sql = "update clientes set nombres='" + this.getNombres() + "', apellidos='" + this.getApellidos() + "', email='" + this.getEmail() + "', usuario='" + this.getUsuario() + "', password='" + this.getPassword() + "' where dni=" + this.getDni();
        Connection con = bd.Conexion();
        try {
            Statement st = con.createStatement();
            int nr = st.executeUpdate(sql);
            System.out.println("numero de registros actualizados:" + nr);
        } catch (Exception ex) {

        }

    }

    /*public void cargarIdNuevo() {
        String sql = "select last_insert_id() as id from clientes;";
        Connection con = bd.Conexion();
        if (con != null) {
            // Informamos que la conexión es correcta
            try {
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    this.setIdCliente(rs.getInt("id"));
                }
            } catch (Exception ex) {

            }
        } else { // Sino informamos que no nos podemos conectar.

        }

    }*/

    public void eliminar() {
        String sql = "delete from clientes where dni=" + this.getDni();
        Connection con = bd.Conexion();
        try {
            Statement st = con.createStatement();
            int nr = st.executeUpdate(sql);
            System.out.println("numero de registros actualizados:" + nr);
        } catch (Exception ex) {

        }
    }

}

package Pedidos;

import bd.bd;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author admin
 */
public class Pedido {
    
    //final private String url = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=CONVERT_TO_NULL";
    private static final bd bd = new bd();
    private int id;
    private boolean estadoPago;
    private String fecha = null, formaPago, cliente;
    
    public Pedido(String _fecha, String _formaPago, boolean _estadoPago, String _cliente){
        this.fecha = _fecha;
        this.formaPago = _formaPago;
        this.estadoPago = _estadoPago;
        this.cliente = _cliente;
    }
    
    public Pedido(String _formaPago, boolean _estadoPago, String _cliente){
        this.formaPago = _formaPago;
        this.estadoPago = _estadoPago;
        this.cliente = _cliente;
    }
    
    public Pedido(int _id){
        this.id = _id;
        recuperarDatos();
    }

    public Pedido() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getId() {
        return id;
    }

    public boolean isEstadoPago() {
        return estadoPago;
    }

    public String getFecha() {
        return fecha;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public String getCliente() {
        return cliente;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEstadoPago(boolean estadoPago) {
        this.estadoPago = estadoPago;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
    
    public void recuperarDatos() {
        String sql = "select * from pedidos where id = " + this.id;
            try {
                ResultSet rs = bd.Consulta(sql);
                while (rs.next()) {
                    this.fecha = rs.getString("fecha");
                    this.formaPago = rs.getString("formaPago");
                    this.estadoPago = Boolean.getBoolean("estadoPago");
                    this.cliente = rs.getString("cliete");
                }
            } catch (Exception ex) {}
        
    }
    
    public void registrar() {
        String sql;
        if (fecha == null){
            sql = "insert into pedidos (formaPago, estadoPago, cliente) "
                    + "VALUES('" + formaPago +"'," + estadoPago +",'" + cliente + "');";
        }
        else{
            sql = "insert into pedidos (fecha, formaPago, estadoPago, cliente) "
                    + "VALUES('" + fecha + "','"+ formaPago +"'," + estadoPago +",'" + cliente + "');";
        }
//        int nr = stmt.executeUpdate
        int resultado = bd.Sentencia(sql);
        if (resultado > 0) JOptionPane.showMessageDialog(null, "Registro Exitoso");
        else JOptionPane.showMessageDialog(null, "Error al Registrar");
    }
    
    public void actualizar() {
        //Actualizar la ficha del Cliente
        String sql = "update pedidos set " + " fecha = '" + this.fecha +"', formaPago = '" + this.formaPago + "', estadoPago = '" + this.estadoPago + "',cliente = '" + this.cliente 
                + "' where id = " + this.id;
        try {
            bd.Sentencia(sql);
        } catch (Exception ex) {}
    }
    
    public void eliminar() {
        String sql = "delete from pedidos where id = " + this.id;
        try {
            bd.Sentencia(sql);
        } catch (Exception ex) {}
    }
}

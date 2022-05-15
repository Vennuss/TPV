package Pedidos;

import bd.bd;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Hugo
 */
public class ArticuloPedido {
    final private int pedidoId;
    private int articuloRef, cantidad;
    private double precio;
    
    public ArticuloPedido(int _articulo, int _pedido, int _cantidad){
        this.articuloRef = _articulo;
        this.pedidoId = _pedido;
        this.cantidad = _cantidad;
    }
    
    public ArticuloPedido(int _articulo, int _pedido){
        this.articuloRef = _articulo;
        this.pedidoId = _pedido;
        recuperarDatos();
    }

    public int getArticuloRef() {
        return articuloRef;
    }

    public int getPedidoId() {
        return pedidoId;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    public void recuperarDatos() {
        String sql = "select * from contiene where articulosRef = " + this.articuloRef + " and pedidosId = " + this.pedidoId;
        Connection con = bd.Conexion();
        if (con != null) {
            // Informamos que la conexión es correcta
            try {
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    this.cantidad = rs.getInt("cantidad");
                    this.precio = (double) rs.getLong("precio");
                }
            } catch (Exception ex) {}
        } else { // Sino informamos que no nos podemos conectar.
            System.out.println("No hay conexion");
        }
    }
    
    public void registrar() {
        String sql = "insert into contiene VALUES(" + this.articuloRef + "," + this.pedidoId + "," + this.cantidad + "," + this.precio + ")";
        
//        int nr = stmt.executeUpdate
        Connection con = bd.Conexion();
        try {
            Statement st = con.createStatement();
            int nr = st.executeUpdate(sql);
            System.out.println("numero de registros actualizados:" + nr);
        } catch (Exception ex) {
            System.out.println("Error de Registro");
        }   
    }
    
    public void actualizar() {
        //Actualizar la ficha del Cliente
        String sql = "update contiene set " + " articulosRef = '" + this.articuloRef +"', pedidosID = '" + this.pedidoId + "', cantidad = '" + this.cantidad + "',precio = '" + this.precio + "'"
                + " where articulosRef = " + this.articuloRef + " and pedidosId = " + this.pedidoId;
        Connection con = bd.Conexion();
        try {
            Statement st = con.createStatement();
            int nr = st.executeUpdate(sql);
            System.out.println("numero de registros actualizados:" + nr);
        } catch (Exception ex) {}
    }
    
    public void eliminar() {
        String sql = "delete from contiene where articulosRef = " + this.articuloRef + " and pedidosId = " + this.pedidoId;
        Connection con = bd.Conexion();
        try {
            Statement st = con.createStatement();
            int nr = st.executeUpdate(sql);
            System.out.println("numero de registros actualizados:" + nr);
        } catch (Exception ex) {}
    }
    
}

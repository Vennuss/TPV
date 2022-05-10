package Pedidos;

import bd.bd;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author admin
 */
public class ArticuloPedido {
    final private int pedidoId;
    private int articuloId, cantidad;
    private double precio;
    
    public ArticuloPedido(int _articulo, int _pedido, int _cantidad){
        this.articuloId = _articulo;
        this.pedidoId = _pedido;
        this.cantidad = _cantidad;
    }
    
    public ArticuloPedido(int _articulo, int _pedido){
        this.articuloId = _articulo;
        this.pedidoId = _pedido;
        recuperarDatos();
    }

    public int getArticuloId() {
        return articuloId;
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
        String sql = "select * from contiene where articulosID = " + this.articuloId + " and pedidosId = " + this.pedidoId;
        Connection con = bd.Conexion();
        if (con != null) {
            // Informamos que la conexión es correcta
            try {
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
//                    this.fecha = rs.getString("fecha");
//                    this.formaPago = rs.getString("formaPago");
//                    this.estadoPago = Boolean.getBoolean("estadoPago");
//                    this.cliente = rs.getString("cliete");
                }
            } catch (Exception ex) {}
        } else { // Sino informamos que no nos podemos conectar.
            System.out.println("No hay conexion");
        }
    }
    
}

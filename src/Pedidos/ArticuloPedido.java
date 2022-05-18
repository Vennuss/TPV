package Pedidos;

import bd.bd;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author admin
 */
public class ArticuloPedido {
    private static final bd bd = new bd();
    final private int pedidoId;
    private String articuloRef;
    private int cantidad;
    private double precio, articuloPrecio;
    
    public ArticuloPedido(String _articulo, int _pedido, int _cantidad) throws SQLException{
        this.articuloRef = _articulo;
        this.pedidoId = _pedido;
        this.cantidad = _cantidad;
        setArticuloPrecio();
    }
    
    public ArticuloPedido(String _articulo, int _pedido) throws SQLException{
        this.articuloRef = _articulo;
        this.pedidoId = _pedido;
        recuperarDatos();
        setArticuloPrecio();
    }

    public String getArticuloRef() {
        return articuloRef;
    }

    public double getArticuloPrecio() {
        return articuloPrecio;
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

    public void setArticuloPrecio() throws SQLException {
        String sql = "select PVP from articulos where ref = '" + this.articuloRef + "';";
        ResultSet rs = bd.Consulta(sql);
        try{
            while (rs.next()) {
                this.articuloPrecio = (double) rs.getLong("pvp");
            }
        }
        catch(Exception e){
            System.out.println("No se pudo obtener el precio del articulo");
        }
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setPrecio() {
        this.precio = this.cantidad * this.articuloPrecio;
    }
    
    public void recuperarDatos() {
        String sql = "select * from contiene where articulosRef = " + this.articuloRef + " and pedidosId = " + this.pedidoId;
            // Informamos que la conexión es correcta
            try {
               ResultSet rs = bd.Consulta(sql);
                while (rs.next()) {
                    this.cantidad = rs.getInt("cantidad");
                    this.precio = (double) rs.getLong("precio");
                }
            } catch (Exception ex) {}
        
    }
    
    public void registrar() {
        setPrecio();
        String sql = "insert into contiene VALUES('" + this.articuloRef + "'," + this.pedidoId + "," + this.cantidad + "," + this.precio + ");";
        try {
            int nr = bd.Sentencia(sql);
            System.out.println("numero de registros actualizados:" + nr);
        } catch (Exception ex) {
            System.out.println("Error de Registro");
        }   
    }
    
    public void actualizar() {
        //Actualizar la ficha del Cliente
        String sql = "update contiene set " + " articulosRef = '" + this.articuloRef +"', pedidosID = '" + this.pedidoId + "', cantidad = '" + this.cantidad + "',precio = '" + this.precio + "'"
                + " where articulosRef = " + this.articuloRef + " and pedidosId = " + this.pedidoId;
        try {
            int nr = bd.Sentencia(sql);
            System.out.println("numero de registros actualizados:" + nr);
        } catch (Exception ex) {}
    }
    
    public void eliminar() {
        String sql = "delete from contiene where articulosRef = " + this.articuloRef + " and pedidosId = " + this.pedidoId;
        try {
            int nr = bd.Sentencia(sql);
            System.out.println("numero de registros actualizados:" + nr);
        } catch (Exception ex) {}
    }
    
}

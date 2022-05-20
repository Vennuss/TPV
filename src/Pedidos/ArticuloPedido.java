package Pedidos;

import bd.bd;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Hugo de la Torre Pizarro
 */
public class ArticuloPedido {
    private static final bd bd = new bd();
    final private int pedidoId;
    private String articuloRef;
    private int cantidad;
    private double precio, articuloPrecio;
    
    /**
     *
     * @param _articulo
     * @param _pedido
     * @param _cantidad
     * @throws SQLException
     */
    public ArticuloPedido(String _articulo, int _pedido, int _cantidad) throws SQLException{
        this.articuloRef = _articulo;
        this.pedidoId = _pedido;
        this.cantidad = _cantidad;
        setArticuloPrecio();
    }
    
    /**
     *
     * @param _articulo
     * @param _pedido
     * @throws SQLException
     */
    public ArticuloPedido(String _articulo, int _pedido) throws SQLException{
        this.articuloRef = _articulo;
        this.pedidoId = _pedido;
        recuperarDatos();
        setArticuloPrecio();
    }

    /**
     *
     * @return
     */
    public String getArticuloRef() {
        return articuloRef;
    }

    /**
     *
     * @return
     */
    public double getArticuloPrecio() {
        return articuloPrecio;
    }

    /**
     *
     * @return
     */
    public int getPedidoId() {
        return pedidoId;
    }

    /**
     *
     * @return
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     *
     * @return
     */
    public double getPrecio() {
        return precio;
    }

    /**
     *
     * @throws SQLException
     */
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

    /**
     *
     * @param cantidad
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     *
     */
    public void setPrecio() {
        this.precio = this.cantidad * this.articuloPrecio;
    }
    
    /**
     *
     */
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
    
    /**
     *
     */
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
    
    /**
     *
     */
    public void actualizar() {
        //Actualizar la ficha del Cliente
        String sql = "update contiene set " + " articulosRef = '" + this.articuloRef +"', pedidosID = '" + this.pedidoId + "', cantidad = '" + this.cantidad + "',precio = '" + this.precio + "'"
                + " where articulosRef = " + this.articuloRef + " and pedidosId = " + this.pedidoId;
        try {
            int nr = bd.Sentencia(sql);
            System.out.println("numero de registros actualizados:" + nr);
        } catch (Exception ex) {}
    }
    
    /**
     *
     */
    public void eliminar() {
        String sql = "delete from contiene where articulosRef = " + this.articuloRef + " and pedidosId = " + this.pedidoId;
        try {
            int nr = bd.Sentencia(sql);
            System.out.println("numero de registros actualizados:" + nr);
        } catch (Exception ex) {}
    }
    
}

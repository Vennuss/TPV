package Pedidos;

import Articulos.Articulo;
import bd.bd;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

/**
 * Clase encargada de los articulos por pedido.
 * @author Hugo de la Torre Pizarro
 * @version 0.1
 * @see bd
 */
public class ArticuloPedido {
    /**
     * Variable encargada de conectarse con la Base de Datos
     * @see bd
     */
    private static final bd bd = new bd();
    /**
     * Variable final, no modificable una vez creada la clase.
     * Es la referencia a su pedido.
     */
    final private int pedidoId;
    /**
     * Referencia del articulo en la Base de Datos.
     */
    private String articuloRef;
    /**
     * Cantidad a cmprar.
     */
    private int cantidad;
    /**
     * Precio final:
     * 
     *      <ul>
     *          <li>articuloPrecio * cantidad</li>
     *          <li>-descuentos</li>
     *      </ul>
     * @see cantidad
     * @see articuloPrecio
     */
    private double precio;
    /**
     * Precio del articulo en la Base de Datos;
     */
    private double articuloPrecio;
    
    private int descuento = 0;
    
    /**
     * Crea la clase ArticuloPedido especificando la cantidad a comprar.
     * Crea un nuevo ArticuloPedido.
     * @param _articulo
     * @param _pedido
     * @param _cantidad
     * @throws SQLException
     * @see setArticuloPrecio()
     */
    public ArticuloPedido(String _articulo, int _pedido, int _cantidad) throws SQLException{
        this.articuloRef = _articulo;
        this.pedidoId = _pedido;
        this.cantidad = _cantidad;
        setArticuloPrecio();
    }
    
    public ArticuloPedido(String _articulo, int _pedido, int _cantidad, int _descuento) throws SQLException{
        this.articuloRef = _articulo;
        this.pedidoId = _pedido;
        this.cantidad = _cantidad;
        this.descuento = _descuento;
        setArticuloPrecio();
    }
    
    /**
     * Recupera informacion de un articulo que ya estaba en un pedido.
     * @param _articulo
     * @param _pedido
     * @throws SQLException
     * @see recuperarDatos()
     * @see setArticuloPrecio()
     */
    public ArticuloPedido(String _articulo, int _pedido) throws SQLException{
        this.articuloRef = _articulo;
        this.pedidoId = _pedido;
        recuperarDatos();
        setArticuloPrecio();
    }
    
    
    public ArticuloPedido(Articulo _articulo, int _cant, int _dto) throws SQLException{
        this.articuloRef = _articulo.getReferencia();
        this.cantidad = _cant;
        this.descuento = _dto;
        this.pedidoId = -1;
        setArticuloPrecio();
    }

    /**
     * 
     * @return local articuloRef
     */
    public String getArticuloRef() {
        return articuloRef;
    }

    /**
     *
     * Al crear la clase se llamo a setArticuloPrecio()
     * @return local articuloPrecio
     * @see setArticuloPrecio()
     */
    public double getArticuloPrecio() {
        return articuloPrecio;
    }

    /**
     *
     * @return local pedidoId
     */
    public int getPedidoId() {
        return pedidoId;
    }

    /**
     *
     * @return local cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    public int getDescuento() {
        return descuento;
    }

    /**
     * Llama a setPrecio() antes de returnar precio.
     * @return local precio
     * @see setPrecio()
     */
    public double getPrecio() {
        setPrecio();
        return precio;
    }

    /**
     * Llama a la Base de Datos para recuperar el precio del articulo
     * y se lo aplica a articuloPrecio.
     * @throws SQLException
     * @see articuloPrecio
     * @see bd
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
     * Modifica la cantidad y llama a setPrecio()
     * @param cantidad
     * @see setPrecio
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
        setPrecio();
    }

    /**
     * Iguala precio a cantidad * articuloPrecio
     * @see articuloPrecio
     * @see cantidad
     * @see precio
     */
    public void setPrecio() {
        this.precio = this.cantidad * this.articuloPrecio;
        this.precio *= (100.00 - this.descuento) / 100.00;
    }
    
    /**
     * Recupera cantidad y precio de la Base de Datos utilizando:
     *      <ul>
     *          <li>articuloRef</li>
     *          <li>PedidoId</li>
     *      </ul>
     * Tiene que ser un articulo ya añadido a un pedido en la tabla "Contiene"
     * @see bd
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
     * Registra en la Base de Datos el
     * articuloPedido en la tabla contiene
     * @see bd
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
     * Actualiza un articuloPedido ya existente en la Base de Datos
     * con los valores de las variables locales.
     * @see bd
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
     * Elimina un articuloPedido ya existente en la base de datos utilizando:
     *      <ul>
     *          <li>articuloRef</li>
     *          <li>PedidoId</li>
     *      </ul>
     * @see bd
     */
    public void eliminar() {
        String sql = "delete from contiene where articulosRef = '" + this.articuloRef + "' and pedidosId = " + this.pedidoId + ";";
        System.out.println(sql);
        try {
            int nr = bd.Sentencia(sql);
            System.out.println("numero de registros actualizados:" + nr);
        } catch (Exception ex) {}
    }
    
}

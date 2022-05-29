package Pedidos;

import Articulos.Articulo;
import Persona.Cliente;

import bd.bd;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase encargada de las opercaiones con los pedidos.
 * @author Hugo de la Torre Pizarro
 * @version 0.1
 * @see bd
 */
public class Pedido {
    /**
     * Variable encargada de conectarse con la Base de Datos
     * @see bd
     */
    private static final bd bd = new bd();
    /**
     * Id de cada pedido.
     * Autoincrement en la base de datos.
     * No setear.
     */
    
    private ArrayList<ArticuloPedido> articulos = new ArrayList();
    
    public ArrayList<ArticuloPedido> getArticulos() {
        return articulos;
    }
    
    private int id;
    /**
     * true: Ha sido pagado.
     * false: Pendiente de pago.
     */
    private boolean estadoPago;
    /**
     * Fecha de inscripción del pedido.
     * Si no se setea, por defecto es la hora actual.
     */
    private String fecha = null;
    /**
     * Tipo de pago.
     * Ej. ("Visa", "Efectivo", etc...)
     */
    private String formaPago;
    /**
     * Dni de un cliente existente.
     * Importante ser 9 caracteres exactamente.
     */
    private Cliente cliente;
    
    /**
     * Crea un pedido localmente con todos los datos.
     * @param _fecha
     * @param _formaPago
     * @param _estadoPago
     * @param _cliente
     */
    public Pedido(String _fecha, String _formaPago, boolean _estadoPago, String _cliente){
        this.fecha = _fecha;
        this.formaPago = _formaPago;
        this.estadoPago = _estadoPago;
        this.cliente = new Cliente(_cliente);
    }
    
    /**
     * Crea un pedido localmente con todos los datos menos fecha inicial.
     * @param _formaPago
     * @param _estadoPago
     * @param _cliente
     * @see fecha
     */
    public Pedido(String _formaPago, boolean _estadoPago, String _cliente){
        this.formaPago = _formaPago;
        this.estadoPago = _estadoPago;
        this.cliente = new Cliente(_cliente);
    }
    
    /**
     * Recupera la informacion de un pedido ya registrado en la Base de Datos
     * añadiendo a cada variable su correspondencia de la Base de Datos.
     * @see recuperarDatos()
     * @param _id
     * @see bd
     */
    public Pedido(int _id){
        this.id = _id;
        recuperarDatos();
    }
    
    public Pedido(Cliente _cliente){
        
    }
    
    public final ArticuloPedido addArticulo(Articulo _art, int _cant, int _dto){
        try {
            ArticuloPedido ap = new ArticuloPedido(_art.getReferencia(), this.getId() , _cant, _dto);
            articulos.add(ap);
            getprecioFinal();
            return ap;
        } catch (SQLException ex) {
            Logger.getLogger(Carrito.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public final void modArticulo(final int _i, final ArticuloPedido _artP){
        articulos.set(id, _artP);
    }
    
    public final void delArticulo(final int _i){
        ArrayList<ArticuloPedido> articulos2 = new ArrayList();
        for(int i = 0; i < articulos.size(); i++){
            if(i != _i){
                articulos2.add(articulos.get(i));
            }
        }
        articulos = null;
        articulos = articulos2;
    }
    
    public final void redoArticulos(ArrayList<ArticuloPedido> _ap){
        articulos = null;
        articulos = _ap;
    }
    
    public double getprecioFinal(){
        double pf = 0;
        for(ArticuloPedido a: articulos){
            pf += a.getPrecio();
        }
        return pf;
    }

    /**
     * No usar.
     */
    public Pedido() {
        
    }

    /**
     * 
     * @return local id.
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @return local estadoPago.
     */
    public boolean getEstadoPago() {
        return estadoPago;
    }

    /**
     * @return local fecha.
     * @see fecha
     * Puede ser null en caso de no haberlo especificado.
     * al crearlo con 3 parametros.
     */
    public String getFecha() {
        return fecha;
    }

    /**
     *
     * @return local formaPago.
     */
    public String getFormaPago() {
        return formaPago;
    }

    /**
     *
     * @return local cliente.
     * @see cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param estadoPago sets local estadoPago.
     * Luego se traducira a 1 o 0 en la Base de Datos.
     */
    public void setEstadoPago(boolean estadoPago) {
        this.estadoPago = estadoPago;
    }

    /**
     *
     * @param fecha sets local fecha.
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     *
     * @param formaPago sets local formaPago.
     */
    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    /**
     *
     * @param cliente sets local cliente.
     * @see cliente
     */
    public void setCliente(String cliente) {
        this.cliente = new Cliente(cliente);
    }
    
     public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    /**
     * Recupera la informacion de un pedido ya registrado en la Base de Datos
     * añadiendo a cada variable su correspondencia mediante su Id.
     * @see bd
     * @see id
     * @see fecha
     * @see formaPago
     * @see estadoPago
     * @see cliente
     */
    public void recuperarDatos() {
        String sql = "select * from pedidos where id = " + this.id;
            try {
                ResultSet rs = bd.Consulta(sql);
                while (rs.next()) {
                    this.fecha = rs.getString("fecha");
                    this.formaPago = rs.getString("formaPago");
                    this.estadoPago = Boolean.getBoolean("estadoPago");
                    this.cliente = new Cliente(rs.getString("cliete"));
                }
            } catch (SQLException ex) {
                System.out.println(ex.getCause());
            }
        
    }
    
    /**
     * Registra el pedido local en la Base de Datos.
     * <ol>
     *     <li><h2>fecha es null</h2></li>
     *     <li><h2>fecha tiene valor</h2></li>
     * </ol>
     * <hr>
     * <ol>
     *     <li>Si fecha es null se insertara el pedido en la bd
     *         y se le pondra la hora actual</li>
     * 
     *     <li>Si fecha tiene valor se le pondra con 
     *        la fecha correspondiente</li>
     * </ol>
     * @see bd
     * @see id
     * @see fecha
     * @see formaPago
     * @see estadoPago
     * @see cliente
     */
    public void registrar() {
        String sql;
        if (getFecha() == null){
            sql = "insert into pedidos (formaPago, estadoPago, cliente) "
                    + "VALUES('" + getFormaPago() +"'," + getEstadoPago() +",'" + cliente.getDni() + "');";
        }
        else{
            sql = "insert into pedidos (fecha, formaPago, estadoPago, cliente) "
                    + "VALUES('" + getFecha() + "','"+ getFormaPago() +"'," + getEstadoPago() +",'" + cliente.getDni() + "');";
        }
        int pedidoId = bd.Sentencia2(sql);
        for(ArticuloPedido a: getArticulos()){
            a.setPedidoId(pedidoId);
            a.registrar();
        }
    }
    
    /**
     * Actualiza el pedido ya existente en la Base de Datos con las variables locales.
     * En caso de solo querer acutalizar un valor, recuperarDatos() modifica la variable
     * y actualizar().
     * @see bd
     * @see id
     * @see fecha
     * @see formaPago
     * @see estadoPago
     * @see cliente
     */
    public void actualizar() {
        //Actualizar la ficha del Cliente
        String sql = "update pedidos set " + " fecha = '" + this.fecha +"', formaPago = '" + this.formaPago + "', estadoPago = '" + this.estadoPago + "',cliente = '" + this.cliente 
                + "' where id = " + this.id;
        try {
            bd.Sentencia(sql);
        } catch (Exception ex) {}
    }
    
    /**
     * Borra todos los articulos referenciados al pedido (tabla contiene)
     * @see ArticuloPedido
     * @throws SQLException 
     */
    private void eliminarArticulosPedido() throws SQLException{
        String sql = "select * from contiene where pedidosId = " + this.id + ";";
            try {
                ResultSet rs = bd.Consulta(sql);
                while (rs.next()) {
                    String _ref = rs.getString("articulosRef");
                    System.out.println(_ref);
                    ArticuloPedido ap = new ArticuloPedido(_ref, this.id);
                    ap.eliminar();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getCause());
            }
    }
    
    /**
     * Elimina el pedido de la Base de Datos con el id local.
     * @see id
     */
    public void eliminar() {
        String sql = "delete from pedidos where id = " + this.id + " ;";
        System.out.println(sql);
        try {
            eliminarArticulosPedido();
            bd.Sentencia(sql);
        } catch (SQLException ex) {
            System.out.println(ex.getCause());
        }
    }
}

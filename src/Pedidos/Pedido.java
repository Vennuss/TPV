package Pedidos;

import Articulos.Articulo;
import Clientes.Cliente;
import bd.bd;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

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
    private String cliente;
    
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
        this.cliente = _cliente;
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
        this.cliente = _cliente;
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
    
    public Pedido(Cliente _cliente, boolean _admin){
        
    }
    
    public final void añadirArticulo(Articulo _articulo, int _cant, int _dto) throws SQLException{
        ArticuloPedido ap = new ArticuloPedido(_articulo.getReferencia(), this.id, _cant, _dto);
    }

    /**
     * No usar.
     * @throws UnsupportedOperationException
     */
    public Pedido() {
        throw new UnsupportedOperationException("Not supported yet.");
        // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
    public boolean isEstadoPago() {
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
    public String getCliente() {
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
                    this.cliente = rs.getString("cliete");
                }
            } catch (Exception ex) {}
        
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
        if (fecha == null){
            sql = "insert into pedidos (formaPago, estadoPago, cliente) "
                    + "VALUES('" + formaPago +"'," + estadoPago +",'" + cliente + "');";
        }
        else{
            sql = "insert into pedidos (fecha, formaPago, estadoPago, cliente) "
                    + "VALUES('" + fecha + "','"+ formaPago +"'," + estadoPago +",'" + cliente + "');";
        }
        int resultado = bd.Sentencia(sql);
        if (resultado > 0) JOptionPane.showMessageDialog(null, "Registro Exitoso");
        else JOptionPane.showMessageDialog(null, "Error al Registrar");
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
            } catch (Exception ex) {System.out.println(ex.getMessage());}
    }
    
    /**
     * Elimina el pedido de la Base de Datos con el id local.
     * @see id
     */
    public void eliminar() {
        String sql = "delete from pedidos where id = " + this.id + ";";
        System.out.println(sql);
        try {
            eliminarArticulosPedido();
            bd.Sentencia(sql);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}

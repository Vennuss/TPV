package Pedidos;

import Articulos.Articulo;
import Clientes.Cliente;
import bd.bd;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Vennuss
 */
public class Carrito extends Pedido{
    
    private static final bd bd = new bd();
    
    private ArrayList<ArticuloPedido> articulos = new ArrayList();
    private final Cliente client;
    private final boolean admin;
    
    public Carrito(Cliente client, boolean admin){
        this.client = client;
        this.admin = admin;
    }

    public ArrayList<ArticuloPedido> getArticulos() {
        return articulos;
    }

    public Cliente getClient() {
        return client;
    }
    
    public final ArticuloPedido addArticulo(Articulo _art, int _cant, int _dto){
        try {
            ArticuloPedido ap = new ArticuloPedido(_art.getReferencia(), this.getId() , _cant, _dto);
            articulos.add(ap);
            return ap;
        } catch (SQLException ex) {
            Logger.getLogger(Carrito.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    @Override
    public void registrar() {
        String sql;
        if (getFecha() == null){
            sql = "insert into pedidos (formaPago, estadoPago, cliente) "
                    + "VALUES('" + getFormaPago() +"'," + getEstadoPago() +",'" + getCliente() + "');";
        }
        else{
            sql = "insert into pedidos (fecha, formaPago, estadoPago, cliente) "
                    + "VALUES('" + getFecha() + "','"+ getFormaPago() +"'," + getEstadoPago() +",'" + getCliente() + "');";
        }
        int resultado = bd.Sentencia(sql);
        if (resultado > 0) JOptionPane.showMessageDialog(null, "Registro Exitoso");
        else JOptionPane.showMessageDialog(null, "Error al Registrar");
    }
    
    private void registrarArticulos(){
        for (ArticuloPedido articulo : articulos) {
        }
    }
}

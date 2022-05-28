package Pedidos;

import Articulos.Articulo;
import Persona.Cliente;
import bd.bd;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Vennuss
 */
public class Carrito extends Pedido{
    
    private static final bd bd = new bd();
    
    private final Cliente client;
    
    public Carrito(Cliente client){
        this.client = client;
        setEstadoPago(false);
        recuperarArticulos();
    }

    public Cliente getClient() {
        return client;
    }
    
    public ArrayList<ArticuloPedido> recuperarArticulos(){
        String sql = "select * from cestas where dniCliente = '" + client.getDni() + "';";
        ResultSet rs = bd.Consulta(sql);
        try {
            while(rs.next()){
                addArticulo(new Articulo(rs.getString("articuloRef")), rs.getInt("cantidad"), rs.getInt("dto"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Carrito.class.getName()).log(Level.SEVERE, null, ex);
        }
        return getArticulos();
    }
    
    @Override
    public void registrar() {
        super.registrar();
        String sql = "delete from cestas where dnicliente = '" + client.getDni() + "';";
        bd.Sentencia(sql);
    }
}

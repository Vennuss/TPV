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
 * Ereda de Pedido ya que basicamente es uno, pero tiene funcionalidad como
 * borrar los articulos de cestas, y de obtener los datos de cestas con tansolo
 * enviarle el Cliente.
 * @author Hugo de la Torre Pizarro
 * @version 0.1
 */
public final class Carrito extends Pedido{
    
    /**
     * Variable encargada de conectarse con la Base de Datos
     * @see bd
     */
    private static final bd bd = new bd();
    
    /**
     * Recupera la cesta del cliente especificado y tansolo espera confirmación.
     * @param client
     */
    public Carrito(Cliente client){
        super.setCliente(client);
        setEstadoPago(false);
        recuperarArticulos();
    }
    
    /**
     * De la cesta que pertenezca al Cliente, Los combierte de Articulo a
     * ArticuloPedido y lo añade a pd.articulos
     * @return ArrayList< ArticuloPedido >
     */
    public ArrayList<ArticuloPedido> recuperarArticulos(){
        String sql = "select * from cestas where dniCliente = '" + super.getCliente().getDni() + "';";
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
    
    /**
     * Registra en la base de datos el Pedido y ademas borra los Articulos de la
     * cesta del Cliente
     */
    @Override
    public void registrar() {
        super.registrar();
        String sql = "delete from cestas where dnicliente = '" + super.getCliente().getDni() + "';";
        bd.Sentencia(sql);
    }
}

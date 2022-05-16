/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bd;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author admin
 */
public class bd {

    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String bbdd = "jdbc:mysql://localhost:3306/tpv?zeroDateTimeBehavior=CONVERT_TO_NULL";
    private static final String usuario = "root";
    private static final String clave = "";
    private static Connection conex=null;

    public static boolean cargarDriver() {
        try {
            System.out.print("Cargando Driver...");
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            System.out.println("OK!");
            return true;
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            return false;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    public static Connection Conexion() {
        /*Declaramos una variable para almacenar la cadena de conexión.
    Primero la iniciamos en null.*/
         

        //Controlamos la excepciones que puedan surgir al conectarnos a la BBDD
        try {
            //Registrar el driver
            Class.forName( "com.mysql.cj.jdbc.Driver").newInstance();;
            //Creamos una conexión a la Base de Datos
            conex = DriverManager.getConnection(bbdd, usuario, clave);

            // Si hay errores informamos al usuario. 
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
           
            System.out.println("Error al conectar con la base de datos.\n"
                    + e.getMessage());
        }
        // Devolvemos la conexión.
        return conex;    
    }
    
    public static int Sentencia(String sql){        
        int numFilas=-1;
        Connection con = Conexion();
        try {
            Statement st = con.createStatement();
            numFilas = st.executeUpdate(sql);
            System.out.println("numero de registros actualizados:" + numFilas);
        } catch (Exception ex) {            
            System.out.println("");
        }
        
        return numFilas;        
    }
    
    public static void close(){
        
    }
    
    public static ResultSet Consulta(String sql){
        Connection cone=Conexion();
        ResultSet rs=null;
         if (cone != null) {
            // Informamos que la conexión es correcta
            try {
                Statement st = cone.createStatement();
                rs = st.executeQuery(sql);                
               // st.close();
               // cone.close();
            } catch (Exception ex) {
                
            }
        } else { // Sino informamos que no nos podemos conectar.

        }
        return rs;
    }    
}

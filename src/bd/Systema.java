/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bd;

import java.io.File;
import javax.swing.JOptionPane;


/**
 *
 * @author admin
 */
public class Systema {
    public static String rutaSistema="";
    public static String rutaArticulos="";
    public static String rutaClientes="";
    public static String rutaUsuarios="";
    public static String getRutaSistema() {
        return rutaSistema;
    }

    public static void setRutaSistema(String rutaSistema) {
        File sis=new File(rutaSistema);
        Systema.rutaSistema = sis.getAbsolutePath();
       
        Systema.rutaArticulos=rutaSistema+"\\Imagenes\\Articulos\\";
        Systema.rutaClientes=rutaSistema+"\\Imagenes\\Clientes\\";
        Systema.rutaUsuarios=rutaSistema+"\\Imagenes\\Usuarios\\";
      /*//  JOptionPane.showMessageDialog(null, "Ruta Sistema: "+System.getProperty("user.dir"));
        JOptionPane.showMessageDialog(null, "Ruta Sistema: "+rutaSistema);
        JOptionPane.showMessageDialog(null, "Ruta Clientes: "+rutaClientes);
        JOptionPane.showMessageDialog(null, "Ruta Usuarios: "+rutaUsuarios);
        JOptionPane.showMessageDialog(null, "Ruta Articulos: "+rutaArticulos);  */      
    }
    
    public static boolean verificarRutas(){
        File sys=new File(rutaSistema);
        if(sys.exists()){
           File arti=new File(rutaArticulos) ;
           if(!arti.exists()){
               arti.mkdirs();                             
           }
           File cli=new File(rutaClientes) ;
           if(!cli.exists()){
               cli.mkdirs();
           }           
           File usu=new File(rutaUsuarios) ;
           if(!usu.exists()){
               usu.mkdirs();
           }
        }
        return true;
    }

    public static String getRutaArticulos() {
        return rutaArticulos;
    }

    public static void setRutaArticulos(String rutaArticulos) {
        Systema.rutaArticulos = rutaArticulos;
    }

    public static String getRutaClientes() {
        return rutaClientes;
    }

    public static void setRutaClientes(String rutaClientes) {
        Systema.rutaClientes = rutaClientes;
    }

    public static String getRutaUsuarios() {
        return rutaUsuarios;
    }

    public static void setRutaUsuarios(String rutaUsuarios) {
        Systema.rutaUsuarios = rutaUsuarios;
    }
    
    
}


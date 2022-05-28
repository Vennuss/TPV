/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bd;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Familia
 */
public class validaciones {

    public static SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

    public static boolean vDouble(String valor) {

        try {
            double aux = Double.parseDouble(valor);
            return true;
        } catch (Exception ex) {
            return false;
        }

    }

    public static boolean vInt(String valor) {
        try {
            int aux = Integer.parseInt(valor);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public static boolean vFecha(String valor) {
        try {
            Date aux = formato.parse(valor);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public static boolean vBoolean(String valor) {
        try {
            boolean aux = Boolean.parseBoolean(valor);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

}

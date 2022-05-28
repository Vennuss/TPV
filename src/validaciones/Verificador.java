/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validaciones;

import java.awt.Color;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Familia
 */
public class Verificador extends InputVerifier {

    JLabel Etiqueta;

    public Verificador(JLabel l) {
        this.Etiqueta = l;
    }

    @Override
    public boolean verify(JComponent input) {

        JTextField campo = (JTextField) input;
        Pattern pattern;
        Matcher matcher;

        if (campo.getToolTipText().contains("DNI")) {
            campo.setText(campo.getText().toUpperCase());
            pattern = Pattern.compile("(([0-9]{7,8}[A-Z])|((X|Y)[1-9]{7}[A-Z]))");
            matcher = pattern.matcher(campo.getText());
            System.out.printf(campo.getToolTipText());
            if (matcher.matches()) {
                Etiqueta.setForeground(new Color(0,0,0));
                return true;
            } else {
                Etiqueta.setForeground(Color.RED);
                return false;
            }

        } else if (campo.getToolTipText().contains("MOVIL")) {
            pattern = Pattern.compile("[1-9]{1}+[0-9]{8}");
            matcher = pattern.matcher(campo.getText());
            if (matcher.matches()) {
                Etiqueta.setForeground(new Color(0,0,0));
                return true;
            } else {
                Etiqueta.setForeground(Color.RED);
                return false;
            }
        } else if (campo.getToolTipText().contains("FIJO")) {
            pattern = Pattern.compile("[1-9]{1}+[0-9]{10}");
            matcher = pattern.matcher(campo.getText());
            if (matcher.matches()) {
                Etiqueta.setForeground(new Color(0,0,0));
                return true;
            } else {
                Etiqueta.setForeground(Color.RED);
                return false;
            }
        } else if (campo.getToolTipText().contains("CORREO")) {
            pattern = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");
            matcher = pattern.matcher(campo.getText());
            campo.setText(campo.getText().toLowerCase());
            if (matcher.matches()) {                
                Etiqueta.setForeground(new Color(0,0,0));
                return true;
            } else {
                Etiqueta.setForeground(Color.RED);
                return false;
            }
        } else {
            return true;
        }
    }
}

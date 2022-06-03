/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validaciones;

import bd.bd;
import java.awt.Color;
import java.sql.ResultSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Ronal Arrayaza DAM1C
 */
public class Verificador extends InputVerifier {

    JLabel Etiqueta;
    String comparativa;

    public Verificador(JLabel etiqueta) {
        this.Etiqueta = etiqueta;
    }

    public Verificador(JLabel etiqueta, String campo) {
        this.Etiqueta = etiqueta;
        this.comparativa = campo;
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
                Etiqueta.setForeground(new Color(0, 0, 0));
                return true;
            } else {
                Etiqueta.setForeground(Color.RED);
                return false;
            }

        } else if (campo.getToolTipText().contains("IDENTIFICACION")) {
            campo.setText(campo.getText().toUpperCase());
            pattern = Pattern.compile("(([0-9]{7,8}[A-Z])|((X|Y)[1-9]{7}[A-Z]))");
            matcher = pattern.matcher(campo.getText());
            if (matcher.matches()) {
                String sql = "select dni from clientes where dni='" + campo.getText() + "'";
                int contador = 0;
                try {
                    ResultSet rs = bd.Consulta(sql);
                    while (rs.next()) {
                        contador++;
                    }
                    bd.cerrarConexion();
                    if (contador == 0) {
                        Etiqueta.setForeground(new Color(0, 0, 0));
                        return true;
                    } else {
                        JOptionPane.showMessageDialog(campo, "DNI ya Registrado");
                        Etiqueta.setForeground(Color.RED);
                        return false;
                    }
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                    return false;
                }
            } else {
                Etiqueta.setForeground(Color.RED);
                return false;
            }
        } else if (campo.getToolTipText().contains("DOCUMENTO")) {
            campo.setText(campo.getText().toUpperCase());
            pattern = Pattern.compile("(([0-9]{7,8}[A-Z])|((X|Y)[1-9]{7}[A-Z]))");
            matcher = pattern.matcher(campo.getText());
            if (matcher.matches()) {
                String sql = "select dni from usuarios where dni='" + campo.getText() + "'";
                int contador = 0;
                try {
                    ResultSet rs = bd.Consulta(sql);
                    while (rs.next()) {
                        contador++;
                    }
                    bd.cerrarConexion();
                    if (contador == 0) {
                        Etiqueta.setForeground(new Color(0, 0, 0));
                        return true;
                    } else {
                        JOptionPane.showMessageDialog(campo, "Documento ya Registrado");
                        Etiqueta.setForeground(Color.RED);
                        return false;
                    }
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                    return false;
                }
            } else {
                Etiqueta.setForeground(Color.RED);
                return false;
            }
        } else if (campo.getToolTipText().contains("MOVIL")) {
            pattern = Pattern.compile("[1-9]{1}+[0-9]{8}");
            matcher = pattern.matcher(campo.getText());
            if (matcher.matches()) {
                Etiqueta.setForeground(new Color(0, 0, 0));
                return true;
            } else {
                Etiqueta.setForeground(Color.RED);
                return false;
            }
        } else if (campo.getToolTipText().contains("FIJO")) {
            pattern = Pattern.compile("[1-9]{1}+[0-9]{10}");
            matcher = pattern.matcher(campo.getText());
            if (matcher.matches()) {
                Etiqueta.setForeground(new Color(0, 0, 0));
                return true;
            } else {
                Etiqueta.setForeground(Color.RED);
                return false;
            }
        } else if (campo.getToolTipText().contains("CORREO")) {
            pattern = Pattern.compile("^(([^<>()\\[\\]\\\\.,;:\\s@”]+(\\.[^<>()\\[\\]\\\\.,;:\\s@”]+)*)"
                    + "|(“.+”))@((\\[[0–9]{1,3}\\.[0–9]{1,3}\\.[0–9]{1,3}\\.[0–9]{1,3}])|(([a-zA-Z\\-0–9]+\\.)+[a-zA-Z]{2,}))$");
            matcher = pattern.matcher(campo.getText());
            campo.setText(campo.getText().toLowerCase());
            if (matcher.matches()) {
                Etiqueta.setForeground(new Color(0, 0, 0));
                return true;
            } else {
                Etiqueta.setForeground(Color.RED);
                return false;
            }
        } else if (campo.getToolTipText().contains("NUMERICO")) {
            //
            pattern = Pattern.compile("((^[0-9]+([,][0-9]+)?$)|(^[0-9]+([.][0-9]+)?$))");
            matcher = pattern.matcher(campo.getText());
            campo.setText(campo.getText().toLowerCase());
            if (matcher.matches()) {
                Etiqueta.setForeground(new Color(0, 0, 0));
                return true;
            } else {
                Etiqueta.setForeground(Color.RED);
                return false;
            }
        } else if (campo.getToolTipText().contains("ENTERO")) {
            //
            pattern = Pattern.compile("^[0-9]*");
            matcher = pattern.matcher(campo.getText());
            campo.setText(campo.getText().toLowerCase());
            if (matcher.matches()) {
                Etiqueta.setForeground(new Color(0, 0, 0));
                return true;
            } else {
                Etiqueta.setForeground(Color.RED);
                return false;
            }
        } else if (campo.getToolTipText().contains("ACTUAL")) {
            //
            if (campo.getText().equals(comparativa)) {
                Etiqueta.setForeground(new Color(0, 0, 0));
                return true;
            } else {
                Etiqueta.setForeground(Color.RED);
                return false;
            }
        } else if (campo.getToolTipText().contains("NUEVA")) {
            //
            pattern = Pattern.compile("^[0-9]*");
            matcher = pattern.matcher(campo.getText());
            campo.setText(campo.getText().toLowerCase());
            if (matcher.matches()) {
                Etiqueta.setForeground(new Color(0, 0, 0));
                return true;
            } else {
                Etiqueta.setForeground(Color.RED);
                return false;
            }
        } else if (campo.getToolTipText().contains("MAIL")) {
            pattern = Pattern.compile("^(([^<>()\\[\\]\\\\.,;:\\s@”]+(\\.[^<>()\\[\\]\\\\.,;:\\s@”]+)*)"
                    + "|(“.+”))@((\\[[0–9]{1,3}\\.[0–9]{1,3}\\.[0–9]{1,3}\\.[0–9]{1,3}])|(([a-zA-Z\\-0–9]+\\.)+[a-zA-Z]{2,}))$");
            matcher = pattern.matcher(campo.getText());
            campo.setText(campo.getText().toLowerCase());
            if (matcher.matches()) {
                String sql = "select correo from clientes where correo='" + campo.getText() + "'";
                int contador = 0;
                try {
                    ResultSet rs = bd.Consulta(sql);
                    while (rs.next()) {
                        contador++;
                    }
                    bd.cerrarConexion();
                    if (contador == 0) {
                        Etiqueta.setForeground(new Color(0, 0, 0));
                        return true;
                    } else {
                        Etiqueta.setForeground(Color.RED);
                        JOptionPane.showMessageDialog(campo, "Correo ya Registrado");
                        return false;
                    }
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                    return false;
                }
            } else {
                Etiqueta.setForeground(Color.RED);
                return false;
            }
        }else if (campo.getToolTipText().contains("FECHA")) {            
            pattern = Pattern.compile("^([0-2][0-9]|3[0-1])(\\/|-)(0[1-9]|1[0-2])\\2(\\d{4})((\\s)([0-1][0-9]|2[0-3])(:)([0-5][0-9]))?$");
            matcher = pattern.matcher(campo.getText());
            campo.setText(campo.getText().toLowerCase());
            if (matcher.matches()) {
                Etiqueta.setForeground(new Color(0, 0, 0));
                return true;
            } else {
                Etiqueta.setForeground(Color.RED);
                return false;
            }
        }
        else if (campo.getToolTipText().contains("USUARIO")) {
            pattern = Pattern.compile("[A-Za-z0-9_.]+");
            matcher = pattern.matcher(campo.getText());
            //campo.setText(campo.getText().toLowerCase());
            if (matcher.matches()) {
                String sql = "select login from usuarios where login='" + campo.getText() + "'";
                int contador = 0;
                try {
                    ResultSet rs = bd.Consulta(sql);
                    while (rs.next()) {
                        contador++;
                    }
                    bd.cerrarConexion();
                    if (contador == 0) {
                        Etiqueta.setForeground(new Color(0, 0, 0));
                        return true;
                    } else {
                        Etiqueta.setForeground(Color.RED);
                        JOptionPane.showMessageDialog(campo, "Login para Usuario ya Registrado");
                        return false;
                    }
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                    return false;
                }
            } else {
                Etiqueta.setForeground(Color.RED);
                return false;
            }
        } else {
            return true;
        }
    }
}

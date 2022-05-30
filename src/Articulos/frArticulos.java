/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package Articulos;

import bd.bd;
import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import validaciones.Verificador;

/**
 *
 * @author Familia
 */
public class frArticulos extends javax.swing.JDialog {

    /**
     * Creates new form Articulos
     */
    final Articulo art;
    private boolean operacion = false;
    private int result = JOptionPane.CANCEL_OPTION;
    private String rutaorigen = "";

    public frArticulos(Articulo art, boolean operacion, java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.cargarIcono("/Imagenes/lupa.png", this.btFamilia);
        this.operacion = operacion;
        this.art = art;
        this.txtReferencia.setInputVerifier(new Verificador(this.lReferencia));
        this.txtPvp.setInputVerifier(new Verificador(this.lPvp));
        this.txtStock.setInputVerifier(new Verificador(this.lStock));

        if (!operacion) {
            this.txtReferencia.setEnabled(false);
            this.txtReferencia.setText(art.getReferencia());
            this.txtANotas.setText(art.getNotas());
            this.txtStock.setText(String.valueOf(art.getStock()).replace(",", "."));
            this.txtPvp.setText(String.valueOf(art.getPvp()).replace(",", "."));
            this.txtDescripcion.setText(art.getDescripcion());
            this.txtMarca.setText(art.getMarca());
            this.txtFamilia.setText(String.valueOf(art.getFa().getId()));
            this.lFamilia.setText(art.getFa().getNombre());
            this.cargarImg("/Imagenes/" + art.getRutaImg(), true);
        } else {
            this.cargarImg("/Imagenes/predeArt.png", true);
            art.setRutaImg("predeArt.png");
        }
    }

    private void validarRuta(String url) {
        if (url.length() > 0) {
            String nombre = "";
            try {
                URL main = getClass().getResource("/Imagenes/");

                if (!"file".equalsIgnoreCase(main.getProtocol())) {
                    throw new IllegalStateException("Main class is not stored in a file.");
                }
                File rutaSis = new File(main.getPath());

                File origen = new File(url);
                File destino = new File(rutaSis.getParent().replace("%20", " ") + "/Imagenes/" + origen.getName());
                nombre = origen.getName();

                System.out.println("Ruta origen:" + origen.getAbsolutePath());
                System.out.println("Ruta Destino:" + destino.getAbsolutePath());

                ///Files.copy(origen.toPath(), destino.toPath(),)
                System.out.println(destino.getPath());

                if (origen.exists()) {
                    //origen.renameTo(destino);
                    Files.copy(origen.toPath(), destino.toPath(), StandardCopyOption.REPLACE_EXISTING);
                    nombre = destino.getName();
                }
            } catch (Exception ex) {
                System.out.println("Error:" + ex.getMessage());
            }
            if (nombre.equals("")) {

            } else {
                this.art.setRutaImg(nombre);
            }
        }
    }

    public boolean validarCampos() {
        boolean retorno = true;
        if (this.txtReferencia.getText().isEmpty()) {
            retorno = false;
        } else {

        }
        return retorno;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    private void cargarIcono(String url, JButton boton) {
        try {
            ImageIcon icon = new ImageIcon(getClass().getResource(url));
            ImageIcon icono = new ImageIcon(icon.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
            boton.setIcon(icono);
        } catch (Exception ex) {

        }
    }

    private void cargarImg(String url, boolean almacen) {
        try {
            ImageIcon icon;
            if (almacen) {
                icon = new ImageIcon(getClass().getResource(url));
            } else {
                icon = new ImageIcon(url);
            }

            ImageIcon icono = new ImageIcon(icon.getImage().getScaledInstance(this.lImg.getWidth(), this.lImg.getHeight(), Image.SCALE_DEFAULT));
            this.lImg.setIcon(icono);
        } catch (Exception ex) {

        }
    }

    public boolean validarReferencia() {
        boolean retorno = true;
        if (this.operacion) {
            String sql = "select * from articulos where ref='" + this.txtReferencia.getText() + "'";
            try {
                int cantFilas = 0;
                ResultSet rs = bd.Consulta(sql);
                while (rs.next()) {
                    cantFilas++;
                }
                retorno = cantFilas <= 0;
                bd.cerrarConexion();
            } catch (SQLException ex) {
                retorno = false;
            }
        }
        return retorno;
    }

    public boolean validarFamilia() {
        boolean retorno = false;
        if (this.operacion) {
            String sql = "select * from familias where id=" + this.art.getFa().getId();
            try {
                int cantFilas = 0;
                ResultSet rs = bd.Consulta(sql);
                while (rs.next()) {
                    cantFilas++;
                }
                retorno = cantFilas == 1;
                bd.cerrarConexion();
            } catch (SQLException ex) {
                retorno = false;
            }
        }
        return retorno;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lPvp = new javax.swing.JLabel();
        lFamilia = new javax.swing.JLabel();
        txtReferencia = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtANotas = new javax.swing.JTextArea();
        txtPvp = new javax.swing.JTextField();
        lStock = new javax.swing.JLabel();
        btImg = new javax.swing.JButton();
        btAceptar = new javax.swing.JButton();
        lImg = new javax.swing.JLabel();
        btCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        lFamiliav = new javax.swing.JLabel();
        txtMarca = new javax.swing.JTextField();
        txtFamilia = new javax.swing.JTextField();
        lReferencia = new javax.swing.JLabel();
        btFamilia = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtStock = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lPvp.setText("P.V.P.:");

        lFamilia.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lFamilia.setText("Familia");

        txtReferencia.setToolTipText("REFERENCIA");
        txtReferencia.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtReferenciaFocusLost(evt);
            }
        });

        txtANotas.setColumns(20);
        txtANotas.setRows(5);
        jScrollPane1.setViewportView(txtANotas);

        txtPvp.setText("0");
        txtPvp.setToolTipText("PVP NUMERICO");
        txtPvp.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPvpFocusLost(evt);
            }
        });
        txtPvp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPvpActionPerformed(evt);
            }
        });

        lStock.setText("Stocks:");

        btImg.setText("Localizar IMG");
        btImg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btImgActionPerformed(evt);
            }
        });

        btAceptar.setText("Aceptar");
        btAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAceptarActionPerformed(evt);
            }
        });

        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        jLabel1.setText("Descripción");

        jLabel2.setText("Marca:");

        lFamiliav.setText("Familia:");

        txtFamilia.setEditable(false);
        txtFamilia.setToolTipText("FAMILIA");
        txtFamilia.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFamiliaFocusLost(evt);
            }
        });
        txtFamilia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFamiliaActionPerformed(evt);
            }
        });
        txtFamilia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtFamiliaKeyPressed(evt);
            }
        });

        lReferencia.setText("Referencia:");

        btFamilia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/edit.png"))); // NOI18N
        btFamilia.setMaximumSize(new java.awt.Dimension(30, 30));
        btFamilia.setMinimumSize(new java.awt.Dimension(30, 30));
        btFamilia.setPreferredSize(new java.awt.Dimension(30, 30));
        btFamilia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFamiliaActionPerformed(evt);
            }
        });

        jLabel7.setText("Notas:");

        txtStock.setText("0");
        txtStock.setToolTipText("STOCK ENTERO");
        txtStock.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtStockFocusLost(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btImg, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                    .addComponent(lImg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lPvp, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lStock, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lReferencia, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lFamiliav, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtPvp, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(txtMarca))
                    .addComponent(txtReferencia)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lFamilia, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(txtFamilia, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btFamilia, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                    .addComponent(txtStock, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(28, 28, 28))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btAceptar)
                .addGap(18, 18, 18)
                .addComponent(btCancelar)
                .addGap(169, 169, 169))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(lImg, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btImg))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lReferencia))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lFamiliav)
                            .addComponent(txtFamilia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btFamilia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lFamilia))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPvp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lPvp))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lStock))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btAceptar)
                    .addComponent(btCancelar))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btImgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btImgActionPerformed

        System.out.println(getClass().getResource(""));
        File nn = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().getPath());

        JFileChooser files = new JFileChooser();
        files.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        FileNameExtensionFilter imgFilter = new FileNameExtensionFilter("JPG & GIF Images", "png", "jpg", "gif");
        files.setFileFilter(imgFilter);
        int result = files.showOpenDialog(this);

        if (result != JFileChooser.CANCEL_OPTION) {

            File origen = files.getSelectedFile();

            if ((origen == null) || (origen.getName().equals(""))) {

            } else {

                System.out.println(origen.getAbsolutePath());
                rutaorigen = origen.getAbsolutePath();
                cargarImg(rutaorigen, false);
                // String hola=validarRuta(rutaorigen);
            }
        }
    }//GEN-LAST:event_btImgActionPerformed

    private void btAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAceptarActionPerformed
        if (validarFamilia()) {
            art.setDescripcion(this.txtDescripcion.getText());
            art.setNotas(this.txtANotas.getText());
            art.setMarca(this.txtMarca.getText());
            art.setPvp(Double.parseDouble(this.txtPvp.getText().replace(",", ".")));
            art.setStock(Integer.parseInt(this.txtStock.getText().replace(",", ".")));
            validarRuta(rutaorigen);
            if (operacion) {
                art.setReferencia(this.txtReferencia.getText());
                art.registrar();
                this.result = JOptionPane.OK_OPTION;
                this.setVisible(false);
                this.dispose();
            } else {
                art.actualizar();
                this.result = JOptionPane.OK_OPTION;
                this.setVisible(false);
                this.dispose();
            }
        }
        else{
            JOptionPane.showMessageDialog(this, "Seleccione Familia");
        }

    }//GEN-LAST:event_btAceptarActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        this.result = JOptionPane.CANCEL_OPTION;
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btFamiliaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFamiliaActionPerformed
        PanelFamilias dialog = new PanelFamilias(true, new javax.swing.JFrame(), true);
        dialog.setVisible(true);

        if (dialog.getResult() == JOptionPane.OK_OPTION) {
            this.art.setFa(dialog.getFamilia());
            this.txtFamilia.setText(String.valueOf(this.art.getFa().getId()));
            this.lFamilia.setText(this.art.getFa().getNombre());
        }
    }//GEN-LAST:event_btFamiliaActionPerformed

    private void txtPvpFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPvpFocusLost

    }//GEN-LAST:event_txtPvpFocusLost

    private void txtFamiliaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFamiliaKeyPressed
        String sql = "select * from familias where id=" + this.txtFamilia.getText();


    }//GEN-LAST:event_txtFamiliaKeyPressed

    private void txtStockFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtStockFocusLost

    }//GEN-LAST:event_txtStockFocusLost

    private void txtReferenciaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtReferenciaFocusLost
        if (this.txtReferencia.getText().isEmpty()) {
            this.lReferencia.setForeground(new Color(0, 0, 0));
        } else {
            if (!this.validarReferencia()) {
                lReferencia.setForeground(Color.red);
                JOptionPane.showMessageDialog(null, "Entrada no valido");
            } else {
                this.lReferencia.setForeground(new Color(0, 0, 0));
            }
        }
    }//GEN-LAST:event_txtReferenciaFocusLost

    private void txtPvpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPvpActionPerformed

    }//GEN-LAST:event_txtPvpActionPerformed

    private void txtFamiliaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFamiliaFocusLost
        if (this.txtFamilia.getText().isEmpty()) {
            this.txtFamilia.setVisible(true);
        } else {

        }
    }//GEN-LAST:event_txtFamiliaFocusLost

    private void txtFamiliaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFamiliaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFamiliaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frArticulos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frArticulos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frArticulos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frArticulos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frArticulos dialog = new frArticulos(new Articulo(), true, new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAceptar;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btFamilia;
    private javax.swing.JButton btImg;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lFamilia;
    private javax.swing.JLabel lFamiliav;
    private javax.swing.JLabel lImg;
    private javax.swing.JLabel lPvp;
    private javax.swing.JLabel lReferencia;
    private javax.swing.JLabel lStock;
    private javax.swing.JTextArea txtANotas;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtFamilia;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtPvp;
    private javax.swing.JTextField txtReferencia;
    private javax.swing.JTextField txtStock;
    // End of variables declaration//GEN-END:variables
}

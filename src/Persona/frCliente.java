/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package Persona;

import bd.Systema;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import validaciones.Verificador;

/**
 *
 * @author Familia
 */
public class frCliente extends javax.swing.JDialog {

    final Cliente cliente;
    private boolean operacion = false;
    private int result = JOptionPane.CANCEL_OPTION;
    private String rutaorigen = "";

    /**
     * Creates new form frCliente
     */

    public frCliente(Cliente cli, boolean operacion, java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.cliente = cli;
        this.operacion = operacion;
        this.txtDni.setInputVerifier(new Verificador(this.lDNI));
        this.txtCorreo.setInputVerifier(new Verificador(this.lCorreo));
        if (!operacion) {
            this.setTitle("ACTUALIZACIÓN DE CLIENTES");
            this.txtDni.setText(cli.getDni());
            this.txtDni.setEnabled(false);
            this.txtApellidos.setText(cli.getApellidos());
            this.txtNombres.setText(cli.getNombres());
            this.txtCorreo.setText(cli.getCorreo());
            this.txtApellidos.setText(cli.getApellidos());
            this.txtPassword.setText(cli.getPass());
            if(cli.getRutaImg().equals("predePer.png")){
                this.cargarImg("/Imagenes/predePer.png", true);
            }else{
                this.cargarImg(Systema.getRutaClientes() + cli.getRutaImg(), false);
            }
            
        }
        else{
            this.setTitle("REGISTRO DE CLIENTES");
            this.cargarImg("/Imagenes/predePer.png", true);
            cli.setRutaImg("predePer.png");
        }

    }
    
    public boolean validarCampos(){
        boolean retorno=false;
        if(this.txtDni.getText().length()>0 && this.txtCorreo.getText().length()>0){
            retorno=true;
        }
        else{
            retorno=false;
        }
        return retorno;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
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
    private void validarRuta(String url) {
        if (url.length() > 0) {
            String nombre = "";
            try {
                File origen = new File(url);
                File destino=new File(Systema.getRutaClientes()+origen.getName());
                nombre = origen.getName();
                System.out.println("Ruta origen:" + origen.getAbsolutePath());
                System.out.println("Ruta Destino:" + destino.getAbsolutePath());
                System.out.println(destino.getPath());
                if (origen.exists()) {
                    Files.copy(origen.toPath(), destino.toPath(), StandardCopyOption.REPLACE_EXISTING);
                    nombre = destino.getName();
                }
            } catch (IOException ex) {
                System.out.println("Error:" + ex.getMessage());
            }
            if (!nombre.equals("")) {
                this.cliente.setRutaImg(nombre);
            }
        }
    }

   /* private void validarRuta(String url) {
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
                this.cliente.setRutaImg(nombre);
            }
        }
    }*/

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btAceptar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        btAyuda = new javax.swing.JButton();
        txtPassword = new javax.swing.JPasswordField();
        lDNI = new javax.swing.JLabel();
        txtDni = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtApellidos = new javax.swing.JTextField();
        lCorreo = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btImg = new javax.swing.JButton();
        lImg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btAceptar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btAceptar.setText("Aceptar");
        btAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAceptarActionPerformed(evt);
            }
        });

        btCancelar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        btAyuda.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btAyuda.setText("Ayuda");
        btAyuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAyudaActionPerformed(evt);
            }
        });

        txtPassword.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lDNI.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lDNI.setText("DNI:");

        txtDni.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtDni.setToolTipText("DOCUMENTO IDENTIFICACION");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Nombres:");

        txtNombres.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Apellidos:");

        txtApellidos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lCorreo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lCorreo.setText("Correo:");

        txtCorreo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCorreo.setToolTipText("MAIL");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Contraseña:");

        btImg.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btImg.setText("Localizar IMG");
        btImg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btImgActionPerformed(evt);
            }
        });

        lImg.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btImg, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lImg, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lCorreo, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lDNI, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btAceptar)
                        .addGap(18, 18, 18)
                        .addComponent(btCancelar)
                        .addGap(18, 18, 18)
                        .addComponent(btAyuda)
                        .addGap(54, 54, 54))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombres, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                            .addComponent(txtApellidos)
                            .addComponent(txtCorreo)
                            .addComponent(txtPassword))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btAceptar)
                            .addComponent(btCancelar)
                            .addComponent(btAyuda))
                        .addGap(6, 6, 6))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lImg, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lDNI)
                                    .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lCorreo)
                                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(9, 9, 9)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btImg)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAceptarActionPerformed
if(validarCampos()){
    cliente.setApellidos(this.txtApellidos.getText());

        cliente.setNombres(this.txtNombres.getText());
        cliente.setCorreo(this.txtCorreo.getText());
        String pass = String.valueOf(this.txtPassword.getPassword());
        cliente.setPass(pass);
        validarRuta(rutaorigen);
        if (operacion) {
            cliente.setDni(this.txtDni.getText());
            cliente.registrar();
            this.result = JOptionPane.OK_OPTION;
            this.setVisible(false);
            this.dispose();
        } else {
            cliente.actualizar();
            this.result = JOptionPane.OK_OPTION;
            this.setVisible(false);
            this.dispose();
        }}
else{
    JOptionPane.showMessageDialog(null, "Existen Campos no Validos");
}
    }//GEN-LAST:event_btAceptarActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
       this.result = JOptionPane.CANCEL_OPTION;
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btAyudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAyudaActionPerformed
        Cliente cl = new Cliente("555");
        cl.eliminar();
        cl = null;
    }//GEN-LAST:event_btAyudaActionPerformed

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
            java.util.logging.Logger.getLogger(frCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frCliente dialog = new frCliente(new Cliente(), true, new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btAyuda;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btImg;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lCorreo;
    private javax.swing.JLabel lDNI;
    private javax.swing.JLabel lImg;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JPasswordField txtPassword;
    // End of variables declaration//GEN-END:variables
}

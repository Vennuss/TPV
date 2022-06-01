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
 * @author 
 */
public class frUsuario extends javax.swing.JDialog {

    final Usuario usuario;
    private boolean operacion = false;
    private int result = JOptionPane.CANCEL_OPTION;
    private String rutaorigen = "";

    /**
     * Creates new form frUsuario
     * @param usuario
     * @param operacion true--> Registro nuevo false-->Actualizacion
     * @param parent
     * @param modal
     */
    public frUsuario(Usuario usuario, boolean operacion, java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.usuario = usuario;
        this.operacion = operacion;
        this.txtDni.setInputVerifier(new Verificador(this.lDNI));
        this.txtCorreo.setInputVerifier(new Verificador(this.lCorreo));
        System.out.println("El color es: " + this.lDNI.getForeground().toString() + " ");
        /*this.txtDni.setInputVerifier(
          new InputVerifier() {
            @Override
            public boolean verify(JComponent input) {
              boolean isValid = false;

              String text = ((JTextField) input).getText();
              if (text != null && text.matches("[0-9]{7,8}[A-Z]")) {
                isValid = true;
                ((JTextField) input).setBackground(null);
              }
              if (!isValid) {
               ((JTextField) input).setBackground(Color.red);
              }
              return isValid;
            }
          });
        this.txtCorreo.setInputVerifier(
          new InputVerifier() {
            @Override
            public boolean verify(JComponent input) {
              boolean isValid = false;

              String text = ((JTextField) input).getText();
              if (text != null && text.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
                isValid = true;
                ((JTextField) input).setBackground(null);
              }
              if (!isValid) {
               ((JTextField) input).setBackground(Color.red);
              }
              return isValid;
            }
          });*/
        if (!operacion) {
            this.setTitle("ACTUALIZACION DE USUARIOS");
            this.txtDni.setText(this.usuario.getDni());
            this.txtDni.setEnabled(false);
            this.txtApellidos.setText(this.usuario.getApellidos());
            this.txtNombres.setText(this.usuario.getNombres());
            this.txtCorreo.setText(this.usuario.getCorreo());
            this.txtApellidos.setText(this.usuario.getApellidos());
            this.txtPassword.setText(this.usuario.getPass());
            this.txtUsuario.setText(this.usuario.getLogin());
            if(usuario.getRutaImg().equals("predePer.png")){
                this.cargarImg("/Imagenes/predePer.png", true);
            }else{
                this.cargarImg(Systema.getRutaUsuarios()+ this.usuario.getRutaImg(), false);
            }
            
        } else {
            this.setTitle("REGISTRO DE USUARIOS");
            this.cargarImg("/Imagenes/predePer.png", true);
            this.usuario.setRutaImg("predePer.png");
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
    private void validarRuta(String url) {
        if (url.length() > 0) {
            String nombre = "";
            try {
                File origen = new File(url);
                File destino=new File(Systema.getRutaUsuarios()+origen.getName());
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
                this.usuario.setRutaImg(nombre);
            }
        }
    }

    /*private void validarRuta(String url) {
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
                System.out.println(destino.getPath());
                if (origen.exists()) {
                    //origen.renameTo(destino);
                    Files.copy(origen.toPath(), destino.toPath(), StandardCopyOption.REPLACE_EXISTING);
                    nombre = destino.getName();
                }
            } catch (IOException | IllegalStateException ex) {
                System.out.println("Error:" + ex.getMessage());
            }
            if (nombre.equals("")) {

            } else {
                this.usuario.setRutaImg(nombre);
            }
        }
    }*/

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtNombres = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtApellidos = new javax.swing.JTextField();
        btImg = new javax.swing.JButton();
        btAceptar = new javax.swing.JButton();
        lCorreo = new javax.swing.JLabel();
        btCancelar = new javax.swing.JButton();
        txtCorreo = new javax.swing.JTextField();
        btAyuda = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        lImg = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        txtUsuario = new javax.swing.JTextField();
        lDNI = new javax.swing.JLabel();
        txtDni = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        txtNombres.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Apellidos:");

        txtApellidos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btImg.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btImg.setText("Localizar IMG");
        btImg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btImgActionPerformed(evt);
            }
        });

        btAceptar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btAceptar.setText("Aceptar");
        btAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAceptarActionPerformed(evt);
            }
        });

        lCorreo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lCorreo.setText("Correo:");
        lCorreo.setToolTipText("CORREO");

        btCancelar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        txtCorreo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCorreo.setToolTipText("CORREO");

        btAyuda.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btAyuda.setText("Ayuda");
        btAyuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAyudaActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Usuario:");

        lImg.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Contraseña:");

        txtPassword.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtUsuario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lDNI.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lDNI.setText("DNI:");
        lDNI.setToolTipText("DNI");

        txtDni.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtDni.setToolTipText("DNI");
        txtDni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDniActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Nombres:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lImg, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(btImg, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(lCorreo)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel5)
                            .addComponent(lDNI))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtUsuario)
                            .addComponent(txtPassword)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtCorreo)
                            .addComponent(txtApellidos, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtNombres)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 126, Short.MAX_VALUE)
                        .addComponent(btAceptar)
                        .addGap(18, 18, 18)
                        .addComponent(btCancelar)
                        .addGap(18, 18, 18)
                        .addComponent(btAyuda)
                        .addGap(54, 54, 54)))
                .addGap(5, 5, 5))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lDNI))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lCorreo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(lImg, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btAceptar)
                    .addComponent(btCancelar)
                    .addComponent(btAyuda)
                    .addComponent(btImg))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
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
        usuario.setApellidos(this.txtApellidos.getText());
        usuario.setNombres(this.txtNombres.getText());
        usuario.setCorreo(this.txtCorreo.getText());
        usuario.setPass(this.txtPassword.getText());
        usuario.setLogin(this.txtUsuario.getText());
        validarRuta(rutaorigen);
        if (operacion) {
            usuario.setDni(this.txtDni.getText());
            validarRuta(rutaorigen);
            usuario.registrar();
            this.result = JOptionPane.OK_OPTION;
            this.setVisible(false);
            this.dispose();
        } else {
            usuario.actualizar();
            this.result = JOptionPane.OK_OPTION;
            this.setVisible(false);
            this.dispose();
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

    private void txtDniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDniActionPerformed

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
            java.util.logging.Logger.getLogger(frUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frUsuario dialog = new frUsuario(new Usuario(), true, new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lCorreo;
    private javax.swing.JLabel lDNI;
    private javax.swing.JLabel lImg;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}

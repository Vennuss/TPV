/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package Persona;

import bd.Systema;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import validaciones.Verificador;

/**
 *
 * @author Ronal Arrayaza DAM1C
 */
public class frPerfil extends javax.swing.JDialog {

    private int result = JOptionPane.CANCEL_OPTION;
    private String rutaorigen = "";
    final Cliente cliente;

    /**
     * Creates new form frPerfil
     */
    public frPerfil(Cliente cliente, java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.cliente = cliente;
        this.txtActual.setInputVerifier(new Verificador(this.lActual, cliente.getPass()));
        this.txtDni.setText(this.cliente.getDni());
        this.txtApellidos.setText(this.cliente.getApellidos());
        this.txtNombres.setText(this.cliente.getNombres());
        this.txtCorreo.setText(this.cliente.getCorreo());
        this.txtApellidos.setText(this.cliente.getApellidos());
        this.txtPassword.setText(this.cliente.getPass());
        if (this.cliente.getRutaImg().equals("predePer.png")) {
            this.cargarImg("/Imagenes/predePer.png", true);
        } else {
            this.cargarImg(Systema.getRutaClientes() + this.cliente.getRutaImg(), false);
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
                File destino=new File(Systema.getRutaClientes()+origen.getName());
                nombre = origen.getName();
                System.out.println(destino.getPath());
                if (origen.exists()) {
                    Files.copy(origen.toPath(), destino.toPath(), StandardCopyOption.REPLACE_EXISTING);
                    nombre = destino.getName();
                }
            } catch (IOException ex) {                
            }
            if (!nombre.equals("")) {
                this.cliente.setRutaImg(nombre);
            }
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btCancelar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btImg = new javax.swing.JButton();
        txtPassword = new javax.swing.JPasswordField();
        lImg = new javax.swing.JLabel();
        lDNI = new javax.swing.JLabel();
        txtDni = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtApellidos = new javax.swing.JTextField();
        lCorreo = new javax.swing.JLabel();
        btAceptar = new javax.swing.JButton();
        txtCorreo = new javax.swing.JTextField();
        pnPass = new javax.swing.JPanel();
        txtNueva = new javax.swing.JPasswordField();
        txtRepita = new javax.swing.JPasswordField();
        txtActual = new javax.swing.JPasswordField();
        lActual = new javax.swing.JLabel();
        lNueva = new javax.swing.JLabel();
        lRepita = new javax.swing.JLabel();
        chkPassword = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("ACTUALIZACIÓN DEL PERFIL");

        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Contraseña:");

        btImg.setText("Cambiar IMG");
        btImg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btImgActionPerformed(evt);
            }
        });

        txtPassword.setEditable(false);
        txtPassword.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lDNI.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lDNI.setText("DNI:");

        txtDni.setEditable(false);
        txtDni.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtDni.setToolTipText("Entrada DNI ");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Nombres:");

        txtNombres.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Apellidos:");

        txtApellidos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lCorreo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lCorreo.setText("Correo:");

        btAceptar.setText("Guardar Cambios");
        btAceptar.setToolTipText("");
        btAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAceptarActionPerformed(evt);
            }
        });

        txtCorreo.setEditable(false);
        txtCorreo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCorreo.setToolTipText("CORREO");

        pnPass.setBorder(javax.swing.BorderFactory.createTitledBorder("Contraseña"));

        txtNueva.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtNueva.setToolTipText("CONTRASEÑA NUEVA");
        txtNueva.setEnabled(false);

        txtRepita.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtRepita.setToolTipText("REPITA CONTRASEÑA");
        txtRepita.setEnabled(false);

        txtActual.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtActual.setToolTipText("ACTUAL");
        txtActual.setEnabled(false);

        lActual.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lActual.setText("Actual:");

        lNueva.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lNueva.setText("Contraseña Nueva:");

        lRepita.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lRepita.setText("Repita Contraseña:");

        javax.swing.GroupLayout pnPassLayout = new javax.swing.GroupLayout(pnPass);
        pnPass.setLayout(pnPassLayout);
        pnPassLayout.setHorizontalGroup(
            pnPassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnPassLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnPassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lActual)
                    .addComponent(lNueva)
                    .addComponent(lRepita))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnPassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtActual, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                    .addComponent(txtNueva)
                    .addComponent(txtRepita))
                .addGap(6, 6, 6))
        );
        pnPassLayout.setVerticalGroup(
            pnPassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnPassLayout.createSequentialGroup()
                .addGroup(pnPassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtActual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lActual))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnPassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNueva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lNueva))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnPassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRepita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lRepita))
                .addContainerGap())
        );

        chkPassword.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        chkPassword.setText("Cambiar Contraseña");
        chkPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkPasswordActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("ACTUALIZACIÓN DE PERFIL");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lImg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(btImg, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(chkPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(pnPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(lDNI))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtDni, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                                    .addComponent(txtNombres)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(lCorreo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(12, 12, 12))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lDNI)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
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
                                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(chkPassword))
                            .addComponent(lImg, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btAceptar)
                            .addComponent(btCancelar))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btImg)
                        .addGap(117, 117, 117))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        this.result = JOptionPane.CANCEL_OPTION;
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_btCancelarActionPerformed

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
        cliente.setApellidos(this.txtApellidos.getText());
        cliente.setNombres(this.txtNombres.getText());
        validarRuta(rutaorigen);
        if (this.chkPassword.isSelected()) {
            if (String.valueOf(this.txtNueva.getPassword()).equals(String.valueOf(this.txtRepita.getText()))) {
                cliente.setPass(this.txtNueva.getText());
            } else {
                System.out.println("no compara");
            }
        }
        cliente.actualizar();
        this.result = JOptionPane.OK_OPTION;
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_btAceptarActionPerformed

    private void chkPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkPasswordActionPerformed
        if (this.chkPassword.isSelected()) {
            this.txtActual.setEnabled(true);
            this.txtNueva.setEnabled(true);
            this.txtRepita.setEnabled(true);
        } else {
            this.txtActual.setEnabled(false);
            this.txtNueva.setEnabled(false);
            this.txtRepita.setEnabled(false);
        }
    }//GEN-LAST:event_chkPasswordActionPerformed

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
            java.util.logging.Logger.getLogger(frPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                frPerfil dialog = new frPerfil(new Cliente(), new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btImg;
    private javax.swing.JCheckBox chkPassword;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lActual;
    private javax.swing.JLabel lCorreo;
    private javax.swing.JLabel lDNI;
    private javax.swing.JLabel lImg;
    private javax.swing.JLabel lNueva;
    private javax.swing.JLabel lRepita;
    private javax.swing.JPanel pnPass;
    private javax.swing.JPasswordField txtActual;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JPasswordField txtNueva;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JPasswordField txtRepita;
    // End of variables declaration//GEN-END:variables
}

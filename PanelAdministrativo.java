/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package prtpvtienda;

import Articulos.PanelFamilias;
import Articulos.PanelArticulos;
import Ofertas.PanelOfertas;
import Pedidos.Interfaces.PanelPedido;
import Persona.Cliente;
import Persona.PanelClientes;
import Persona.PanelUsuarios;
import Persona.Usuario;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author Familia
 */
public class PanelAdministrativo extends javax.swing.JFrame {

    private Usuario usuario;
    /**
     * Creates new form PanelAdministrativo
     */
    public PanelAdministrativo(Usuario usuario) {
        initComponents();
        this.usuario=usuario;
        cargarIMG("/Imagenes/avatar.png", this.btClientes);
        cargarIMG("/Imagenes/paquete.png", this.btArticulos);
        cargarIMG("/Imagenes/articulos.png", this.btFamilias);
        cargarIMG("/Imagenes/oferta.png", this.btOfertas);
        cargarIMG("/Imagenes/lista.png", this.btPedidos);
        cargarIMG("/Imagenes/clientes.png", this.btUsuarios);
    }

    private void cargarIMG(String url, JButton boton) {

        ImageIcon icon = new ImageIcon(getClass().getResource(url));
        ImageIcon icono = new ImageIcon(icon.getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT));
        boton.setIcon(icono);

        boton.setIconTextGap(2);
        boton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        boton.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
        boton.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        boton.setVerticalTextPosition(javax.swing.SwingConstants.CENTER);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jToolBar1 = new javax.swing.JToolBar();
        jLabel1 = new javax.swing.JLabel();
        btFamilias = new javax.swing.JButton();
        btArticulos = new javax.swing.JButton();
        btUsuarios = new javax.swing.JButton();
        btClientes = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        jLabel2 = new javax.swing.JLabel();
        btPedidos = new javax.swing.JButton();
        btOfertas = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PANEL ADMINISTRATIVO");

        jToolBar1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jToolBar1.setRollover(true);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel1.setText("ADMINISTRATIVO");
        jToolBar1.add(jLabel1);

        btFamilias.setText("FAMILIAS");
        btFamilias.setFocusable(false);
        btFamilias.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btFamilias.setMaximumSize(new java.awt.Dimension(120, 45));
        btFamilias.setMinimumSize(new java.awt.Dimension(120, 45));
        btFamilias.setPreferredSize(new java.awt.Dimension(120, 45));
        btFamilias.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btFamilias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFamiliasActionPerformed(evt);
            }
        });
        jToolBar1.add(btFamilias);

        btArticulos.setText("ARTICULOS");
        btArticulos.setFocusable(false);
        btArticulos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btArticulos.setMaximumSize(new java.awt.Dimension(120, 45));
        btArticulos.setMinimumSize(new java.awt.Dimension(120, 45));
        btArticulos.setPreferredSize(new java.awt.Dimension(120, 45));
        btArticulos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btArticulos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btArticulosActionPerformed(evt);
            }
        });
        jToolBar1.add(btArticulos);

        btUsuarios.setText("USUARIOS");
        btUsuarios.setFocusable(false);
        btUsuarios.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btUsuarios.setMaximumSize(new java.awt.Dimension(120, 45));
        btUsuarios.setMinimumSize(new java.awt.Dimension(120, 45));
        btUsuarios.setPreferredSize(new java.awt.Dimension(120, 45));
        btUsuarios.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btUsuariosActionPerformed(evt);
            }
        });
        jToolBar1.add(btUsuarios);

        btClientes.setText("CLIENTES");
        btClientes.setFocusable(false);
        btClientes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btClientes.setMaximumSize(new java.awt.Dimension(120, 45));
        btClientes.setMinimumSize(new java.awt.Dimension(120, 45));
        btClientes.setPreferredSize(new java.awt.Dimension(120, 45));
        btClientes.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btClientesActionPerformed(evt);
            }
        });
        jToolBar1.add(btClientes);
        jToolBar1.add(jSeparator1);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel2.setText("OPERACIONES");
        jLabel2.setToolTipText("OPERACIONES");
        jToolBar1.add(jLabel2);

        btPedidos.setText("PEDIDOS");
        btPedidos.setFocusable(false);
        btPedidos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btPedidos.setMaximumSize(new java.awt.Dimension(120, 45));
        btPedidos.setMinimumSize(new java.awt.Dimension(120, 45));
        btPedidos.setPreferredSize(new java.awt.Dimension(120, 45));
        btPedidos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPedidosActionPerformed(evt);
            }
        });
        jToolBar1.add(btPedidos);

        btOfertas.setText("OFERTAS");
        btOfertas.setToolTipText("");
        btOfertas.setFocusable(false);
        btOfertas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btOfertas.setMaximumSize(new java.awt.Dimension(120, 45));
        btOfertas.setMinimumSize(new java.awt.Dimension(120, 45));
        btOfertas.setPreferredSize(new java.awt.Dimension(120, 45));
        btOfertas.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btOfertas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btOfertasActionPerformed(evt);
            }
        });
        jToolBar1.add(btOfertas);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 942, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jMenu1.setText("Archivo");

        jMenuItem1.setText("Salir");
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Ayuda");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 583, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btFamiliasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFamiliasActionPerformed
        PanelFamilias dialog = new PanelFamilias(false, new javax.swing.JFrame(), true);
        dialog.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                // System.exit(0);
            }
        });
        dialog.setVisible(true);
    }//GEN-LAST:event_btFamiliasActionPerformed

    private void btArticulosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btArticulosActionPerformed
        PanelArticulos dialog = new PanelArticulos(false, new javax.swing.JFrame(), true);
        dialog.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                //System.exit(0);
            }
        });
        dialog.setVisible(true);
    }//GEN-LAST:event_btArticulosActionPerformed

    private void btOfertasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btOfertasActionPerformed
        PanelOfertas dialog = new PanelOfertas(false, new javax.swing.JFrame(), true);
        dialog.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                //  System.exit(0);
            }
        });
        dialog.setVisible(true);
    }//GEN-LAST:event_btOfertasActionPerformed

    private void btPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPedidosActionPerformed
        new PanelPedido(true, new Cliente()).setVisible(true);
    }//GEN-LAST:event_btPedidosActionPerformed

    private void btUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btUsuariosActionPerformed
        PanelUsuarios dialog = new PanelUsuarios(false, new javax.swing.JFrame(), true);
        dialog.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                //  System.exit(0);
            }
        });
        dialog.setVisible(true);
    }//GEN-LAST:event_btUsuariosActionPerformed

    private void btClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btClientesActionPerformed
        PanelClientes dialog = new PanelClientes(false, new javax.swing.JFrame(), true);
        dialog.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                //  System.exit(0);
            }
        });
        dialog.setVisible(true);
    }//GEN-LAST:event_btClientesActionPerformed

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
            java.util.logging.Logger.getLogger(PanelAdministrativo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PanelAdministrativo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PanelAdministrativo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PanelAdministrativo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                new PanelAdministrativo(new Usuario()).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btArticulos;
    private javax.swing.JButton btClientes;
    private javax.swing.JButton btFamilias;
    private javax.swing.JButton btOfertas;
    private javax.swing.JButton btPedidos;
    private javax.swing.JButton btUsuarios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}

package Pedidos.Interfaces;

import Pedidos.*;
import Persona.Cliente;
import bd.bd;
import java.awt.Image;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 * Panel Administrativo tanto de Clientes como de Usuarios
 * @author Hugo de la Torre Pizarro
 * @version 0.1
 */
public class PanelPedido extends javax.swing.JFrame {
    
    /**
     * Especifica si lo esta abriendo un Usuario o un Cliente
     */
    private final boolean admin;
    
    /**
     * Cliente en caso de ser abierto por un Cliente.
     * En caso contrario puede ser null.
     */
    private Cliente client = null;
    
    /**
     * Crea ventana Administrador de Pedidos.
     * @param admin: es usuario o cliente
     * @param client: solo si admin es false
     */
    public PanelPedido(boolean admin, Cliente client) {
        initComponents();
        this.admin = admin;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        if(admin != true){
            this.client = client;
            jBDelete.setEnabled(false);
            jBAdd.setEnabled(false);
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

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jBAdd = new javax.swing.JButton();
        jBEdit = new javax.swing.JButton();
        jBDelete = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jTSearch = new javax.swing.JTextField();
        jBExit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTResultados = new javax.swing.JTable();
        jBClean = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setMaximumSize(new java.awt.Dimension(1200, 700));
        setMinimumSize(new java.awt.Dimension(800, 500));
        setPreferredSize(new java.awt.Dimension(1299, 700));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ADMINISTRACION DE PEDIDOS");

        jBAdd.setMaximumSize(new java.awt.Dimension(40, 40));
        jBAdd.setMinimumSize(new java.awt.Dimension(40, 40));
        jBAdd.setPreferredSize(new java.awt.Dimension(40, 40));
        jBAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAddActionPerformed(evt);
            }
        });

        jBEdit.setMaximumSize(new java.awt.Dimension(40, 40));
        jBEdit.setMinimumSize(new java.awt.Dimension(40, 40));
        jBEdit.setPreferredSize(new java.awt.Dimension(40, 40));
        jBEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEditActionPerformed(evt);
            }
        });

        jBDelete.setMaximumSize(new java.awt.Dimension(40, 40));
        jBDelete.setMinimumSize(new java.awt.Dimension(40, 40));
        jBDelete.setPreferredSize(new java.awt.Dimension(40, 40));
        jBDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBDeleteActionPerformed(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel2.setText("Busquedas:");

        jTSearch.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                jTSearchInputMethodTextChanged(evt);
            }
        });
        jTSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTSearchActionPerformed(evt);
            }
        });
        jTSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTSearchKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTSearchKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jBAdd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jBEdit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jBDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addComponent(jTSearch)
        );

        jBExit.setMaximumSize(new java.awt.Dimension(40, 40));
        jBExit.setMinimumSize(new java.awt.Dimension(40, 40));
        jBExit.setPreferredSize(new java.awt.Dimension(40, 40));
        jBExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBExitActionPerformed(evt);
            }
        });

        jTResultados.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTResultados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Fecha", "Forma de pago"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTResultados.setRowHeight(40);
        jScrollPane1.setViewportView(jTResultados);

        jBClean.setMaximumSize(new java.awt.Dimension(40, 40));
        jBClean.setMinimumSize(new java.awt.Dimension(40, 40));
        jBClean.setPreferredSize(new java.awt.Dimension(40, 40));
        jBClean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCleanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 758, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBClean, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBExit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBExit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBClean, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * Borra el buscador y refresca la tabla.
     * @param evt 
     */
    private void jBCleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCleanActionPerformed
        // TODO add your handling code here:
        jTSearch.setText("");
        recuperarDatos();  
    }//GEN-LAST:event_jBCleanActionPerformed

    /**
     * Cierra la ventana
     * @param evt 
     */
    private void jBExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExitActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_jBExitActionPerformed

    /**
     * Como Usuario, borra la de la fila especificada el Pedido en la Base de Datos
     * @param evt
     * @see bd
     */
    private void jBDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBDeleteActionPerformed
        // TODO add your handling code here:
        int fila = this.jTResultados.getSelectedRow();
        System.out.println("Fila seleccionada es" + fila);
        
        if (this.jTResultados.getSelectedRow() != -1) {
            
            int id = Integer.parseInt(String.valueOf(jTResultados.getValueAt(fila, 0)));
            System.out.println("El codigo es:" + id);
            Pedido pd = new Pedido(id);
            int resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro?", "Alerta!", JOptionPane.YES_NO_OPTION);
            if (resp == JOptionPane.OK_OPTION) {
                pd.eliminar();
                recuperarDatos();
            }
        }
    }//GEN-LAST:event_jBDeleteActionPerformed

    /**
     * Muestra el contenido del Pedido
     * @param evt 
     */
    private void jBEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEditActionPerformed
        int fila = jTResultados.getSelectedRow();
        if (this.jTResultados.getSelectedRow() != -1) {            
            int id = Integer.parseInt(String.valueOf(jTResultados.getValueAt(fila, 0)));
            System.out.println("El codigo es:" + id);
            Pedido pd = new Pedido(id);
            PanelCMPedido dialog = new PanelCMPedido(pd);
            dialog.setVisible(true);          
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un registro");
        }
    }//GEN-LAST:event_jBEditActionPerformed
    
    /**
     * Como Usuario, crea un Nuevo Pedido
     * @param evt 
     */
    private void jBAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAddActionPerformed
        PanelCrearPedido dialog = new PanelCrearPedido();
        dialog.setVisible(true); 
        
    }//GEN-LAST:event_jBAddActionPerformed
    
    /**
     * Funcion que se ejecutara con el inicio del panel
     * @param evt 
     */
    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here
        _main();
    }//GEN-LAST:event_formComponentShown

    private void jTSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTSearchActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jTSearchActionPerformed
    
    /**
     * Refresca la tabla cada vez que se modifica la barra de busqueda
     * @param evt 
     */
    private void jTSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTSearchKeyPressed
        // TODO add your handling code here:
        recuperarDatos();        
    }//GEN-LAST:event_jTSearchKeyPressed

    private void jTSearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTSearchKeyTyped
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jTSearchKeyTyped

    private void jTSearchInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jTSearchInputMethodTextChanged
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jTSearchInputMethodTextChanged

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
            java.util.logging.Logger.getLogger(PanelPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PanelPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PanelPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PanelPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PanelPedido(true, new Cliente("12345678X")).setVisible(true);
            }
        });
    }
    
    /**
     * Funcion que se ejecutara con el inicio del panel
     */
    public final void _main(){
        recuperarDatos();
        cargarIMG("/Imagenes/add.png", jBAdd);
        cargarIMG("/Imagenes/edit.png", jBEdit);
        cargarIMG("/Imagenes/delete.png", jBDelete);
        cargarIMG("/Imagenes/clean.png", jBClean);
        cargarIMG("/Imagenes/exit.png", jBExit);
    }
    
    /**
     * Carga icono seleccionado en el boton especificado
     * @param url
     * @param boton 
     */
    private void cargarIMG(String url, JButton boton) {
        
        ImageIcon icon = new ImageIcon(getClass().getResource(url));
        ImageIcon icono = new ImageIcon(icon.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
        boton.setIcon(icono);
    }
    
    /**
     * Rellena la sentencia despues de
     * "select * from pedidos".
     * @return String.
     */
    private final String getFiltro(){
        if(admin == true){
            if(jTSearch.getText().isEmpty()) return " ";
            else{
                return "where id like '" + jTSearch.getText() + "%' ";
            }
        }
        else{
            if(jTSearch.getText().isEmpty()) return " where cliente = '" + client.getDni() + "' ";
            else{
                return "where id like '" + jTSearch.getText() + "%' and where cliente = '" + client.getDni() + "' ";
            }
        }
    }
    
    /**
     * Obtiene pedidos de la Base de datos y los añade fila a fila.
     * Utiliza getFiltro().
     * @see bd
     * @see getFiltro()
     */
    public final void recuperarDatos() {
        
        String filtro = getFiltro();
        DefaultTableModel tm = (DefaultTableModel) this.jTResultados.getModel();
        this.jTResultados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        tm.setRowCount(0);
        
        
        String sql = "select * from pedidos " + filtro + " order by id;";
        try {
            ResultSet rs = bd.Consulta(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                String fecha = rs.getString("fecha");
                String formaPago = rs.getString("formaPago");
                Object nuev[] = {id, fecha, formaPago};
                tm.addRow(nuev);
            }
            bd.cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAdd;
    private javax.swing.JButton jBClean;
    private javax.swing.JButton jBDelete;
    private javax.swing.JButton jBEdit;
    private javax.swing.JButton jBExit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTResultados;
    private javax.swing.JTextField jTSearch;
    // End of variables declaration//GEN-END:variables
}

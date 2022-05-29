package Pedidos.Interfaces;

import Articulos.Articulo;
import Articulos.PanelArticulos;
import Pedidos.ArticuloPedido;
import Pedidos.Pedido;
import Persona.Cliente;
import Persona.PanelClientes;
import java.awt.Image;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Vennuss
 */
public class PanelCrearPedido extends javax.swing.JFrame {
    
    private final Pedido pd = new Pedido();

    /**
     * Creates new form PanelCarrito
     */
    public PanelCrearPedido() {
        initComponents();
        _main();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pd.setFormaPago(jCBPago.getItemAt(jCBPago.getSelectedIndex()));
        jBFin.setEnabled(false);
    }
    
    private void setCliente(){
        if(pd.getCliente() != null){
            jTNA.setText(pd.getCliente().getNombres() + " " + pd.getCliente().getApellidos());
            jTDni.setText(pd.getCliente().getDni());
        }
        else{
            jTNA.setText("null");
            jTDni.setText("null");
        }
    }
    
    private void refrescar(final boolean _val){
        
        DefaultTableModel tm = (DefaultTableModel) this.jTAP.getModel();
        this.jTAP.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        if(_val) setValues(tm);
        
        tm.setRowCount(0);
        double PFinal = 0;
        
        for (ArticuloPedido a : pd.getArticulos()) {
            String articulo = a.getArticuloRef();
            int cantidad = a.getCantidad();
            double precioDelArticulo = a.getArticuloPrecio();
            double precioTotal = a.getArticuloPrecio() * a.getCantidad();
            int descuento = a.getDescuento();
            double precioFinal = a.getPrecio();
            
            Object nuev[] = {articulo, cantidad, precioDelArticulo, precioTotal, descuento, precioFinal};
            tm.addRow(nuev);
            PFinal += precioFinal;
        }
        jTPrecio.setText(Double.toString(PFinal));
        if(pd.getArticulos().size() <= 0 | pd.getCliente() == null) jBFin.setEnabled(false);
        else jBFin.setEnabled(true);
    }
    
    private void setValues(DefaultTableModel tm){
            ArrayList<ArticuloPedido> articulosNuevo = new ArrayList();
            for(int i = 0; i < tm.getRowCount(); i++){
                try {
                    Articulo r = new Articulo(String.valueOf(tm.getValueAt(i, 0)));
                    int c = Integer.parseInt(String.valueOf(tm.getValueAt(i, 1)));
                    int d = Integer.parseInt(String.valueOf(tm.getValueAt(i, 4)));
                    ArticuloPedido _artP = new ArticuloPedido(r,c,d);
                    articulosNuevo.add(_artP);
                } catch (SQLException ex) {
                    Logger.getLogger(PanelCrearPedido.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            pd.redoArticulos(articulosNuevo);
    }
    
    
    public final void _main(){
        cargarIMG("/Imagenes/add.png", jBArticulo);
        cargarIMG("/Imagenes/delete.png", jBDelete);
        cargarIMG("/Imagenes/lupa.png", jBCliente);
    }
    
    private void cargarIMG(String url, JButton boton) {
        
        ImageIcon icon = new ImageIcon(getClass().getResource(url));
        ImageIcon icono = new ImageIcon(icon.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
        boton.setIcon(icono);
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTAP = new javax.swing.JTable();
        jCBPago = new javax.swing.JComboBox<>();
        jTPrecio = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jBFin = new javax.swing.JButton();
        jBArticulo = new javax.swing.JButton();
        jBCliente = new javax.swing.JButton();
        jTDni = new javax.swing.JLabel();
        jTNA = new javax.swing.JLabel();
        jBDelete = new javax.swing.JButton();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTAP.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jTAP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Articulo", "Cantidad", "Precio del Articulo", "Precio Total", "Descuento", "Precio Final"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Double.class, java.lang.Integer.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, false, false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTAP.setMinimumSize(new java.awt.Dimension(1100, 800));
        jTAP.setName(""); // NOI18N
        jTAP.setPreferredSize(new java.awt.Dimension(1100, 800));
        jTAP.setRowHeight(40);
        jTAP.addHierarchyListener(new java.awt.event.HierarchyListener() {
            public void hierarchyChanged(java.awt.event.HierarchyEvent evt) {
                jTAPHierarchyChanged(evt);
            }
        });
        jTAP.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTAPFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTAPFocusLost(evt);
            }
        });
        jScrollPane1.setViewportView(jTAP);

        jCBPago.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jCBPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Visa", "Credito", "Efectivo" }));
        jCBPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBPagoActionPerformed(evt);
            }
        });
        jCBPago.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jCBPagoPropertyChange(evt);
            }
        });

        jTPrecio.setEditable(false);
        jTPrecio.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jTPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTPrecioActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Precio Final €");

        jBFin.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jBFin.setText("Finalizar Pedido");
        jBFin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBFinActionPerformed(evt);
            }
        });

        jBArticulo.setMaximumSize(new java.awt.Dimension(40, 40));
        jBArticulo.setMinimumSize(new java.awt.Dimension(40, 40));
        jBArticulo.setPreferredSize(new java.awt.Dimension(40, 40));
        jBArticulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBArticuloActionPerformed(evt);
            }
        });

        jBCliente.setMaximumSize(new java.awt.Dimension(40, 40));
        jBCliente.setMinimumSize(new java.awt.Dimension(40, 40));
        jBCliente.setPreferredSize(new java.awt.Dimension(40, 40));
        jBCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBClienteActionPerformed(evt);
            }
        });

        jTDni.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jTDni.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jTNA.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jTNA.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jBDelete.setMaximumSize(new java.awt.Dimension(40, 40));
        jBDelete.setMinimumSize(new java.awt.Dimension(40, 40));
        jBDelete.setPreferredSize(new java.awt.Dimension(40, 40));
        jBDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 1088, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jBFin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(jTPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jCBPago, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTDni, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jTNA, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCBPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTDni, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTNA, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTPrecio)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBFin, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCBPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBPagoActionPerformed
        pd.setFormaPago(jCBPago.getItemAt(jCBPago.getSelectedIndex()));
    }//GEN-LAST:event_jCBPagoActionPerformed

    private void jCBPagoPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jCBPagoPropertyChange
        
    }//GEN-LAST:event_jCBPagoPropertyChange

    private void jTPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTPrecioActionPerformed
        
    }//GEN-LAST:event_jTPrecioActionPerformed

    private void jBFinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBFinActionPerformed
        refrescar(true);
        pd.registrar();
        this.dispose();
    }//GEN-LAST:event_jBFinActionPerformed

    private void jBClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBClienteActionPerformed
        PanelClientes dialog = new PanelClientes(true, new javax.swing.JFrame(), true);
        dialog.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {}
            });
        dialog.setVisible(true);
        if(dialog.getResult() == JOptionPane.OK_OPTION){
            pd.setCliente(dialog.getCliente());
            setCliente();
            refrescar(true);
        }
    }//GEN-LAST:event_jBClienteActionPerformed

    private void jBArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBArticuloActionPerformed
        PanelArticulos dialog = new PanelArticulos(true, new javax.swing.JFrame(), true);
        dialog.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {}
            });
        dialog.setVisible(true);
        if(dialog.getResult() == JOptionPane.OK_OPTION){
            pd.addArticulo(dialog.getArticulo(), 1, 0);
            refrescar(false);
        }
    }//GEN-LAST:event_jBArticuloActionPerformed

    private void jTAPHierarchyChanged(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_jTAPHierarchyChanged
        
    }//GEN-LAST:event_jTAPHierarchyChanged

    private void jTAPFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTAPFocusLost

    }//GEN-LAST:event_jTAPFocusLost

    private void jTAPFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTAPFocusGained
        refrescar(true);
    }//GEN-LAST:event_jTAPFocusGained

    private void jBDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBDeleteActionPerformed
        if(jTAP.getSelectedRow() != -1) pd.delArticulo(jTAP.getSelectedRow());
        else JOptionPane.showMessageDialog(this, "Selecione un articulo que eliminar");
        refrescar(false);
    }//GEN-LAST:event_jBDeleteActionPerformed

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
            java.util.logging.Logger.getLogger(PanelCrearPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PanelCrearPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PanelCrearPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PanelCrearPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PanelCrearPedido().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBArticulo;
    private javax.swing.JButton jBCliente;
    private javax.swing.JButton jBDelete;
    private javax.swing.JButton jBFin;
    private javax.swing.JComboBox<String> jCBPago;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTAP;
    private javax.swing.JLabel jTDni;
    private javax.swing.JLabel jTNA;
    private javax.swing.JTextField jTPrecio;
    // End of variables declaration//GEN-END:variables
}

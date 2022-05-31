/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package Articulos;

import bd.bd;
import java.awt.Image;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ronal Arrayaza DAM1C
 */
public class PanelFamilias extends javax.swing.JDialog {

    /**
     * Creates new form BFamilias
     */
    DefaultTableModel modelo;
    private String filtro = "";
    private boolean busqueda = false;
    Familia fami = null;
    private int result = JOptionPane.CANCEL_OPTION;

    public Familia getFamilia() {
        return fami;
    }

    public void setFamilia(Familia familia) {
        this.fami = familia;
    }

    public PanelFamilias(boolean busqueda, java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.busqueda = busqueda;
        if (this.busqueda) {
            this.btSele.setVisible(true);
        } else {
            this.btSele.setVisible(false);
        }
        recuperarDatos();
        cargarIMG("/Imagenes/add.png", this.btAñadir);
        cargarIMG("/Imagenes/edit.png", this.btModificar);
        cargarIMG("/Imagenes/delete.png", this.btEliminar);
        cargarIMG("/Imagenes/sele.png", this.btSele);
        cargarIMG("/Imagenes/exit.png", this.btSalir);
        this.txtBusqueda.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void removeUpdate(DocumentEvent e) {
                if (txtBusqueda.getText().length() > 0) {
                    filtro = " where nombre like '%" + txtBusqueda.getText() + "%' or notas like '%" + txtBusqueda.getText() + "%' ";
                } else {
                    filtro = "";
                }
                recuperarDatos();
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                if (txtBusqueda.getText().length() > 0) {
                    filtro = " where nombre like '%" + txtBusqueda.getText() + "%' or notas like '%" + txtBusqueda.getText() + "%'";
                } else {
                    filtro = "";
                }
                recuperarDatos();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                System.out.println("Cambio dessss texto: " + txtBusqueda.getText());
            }
        });
    }

    public int getResult() {
        return result;
    }

    private void Modelo() {

        try {
            modelo = (new DefaultTableModel(
                    null, new String[]{
                        "Id", "Descripcion",
                        "Notas"}) {
                Class[] types = new Class[]{
                    java.lang.Integer.class,
                    java.lang.String.class,
                    java.lang.String.class
                };
                boolean[] canEdit = new boolean[]{
                    false, false, false
                };

                @Override
                public Class getColumnClass(int columnIndex) {
                    return types[columnIndex];
                }

                @Override
                public boolean isCellEditable(int rowIndex, int colIndex) {
                    return canEdit[colIndex];
                }
            });
            this.tFamilias.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString() + "error2");
        }
        this.tFamilias.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.tFamilias.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.tFamilias.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.tFamilias.setRowHeight(30);
    }

    private void cargarIMG(String url, JButton boton) {
        ImageIcon icon = new ImageIcon(getClass().getResource(url));
        ImageIcon icono = new ImageIcon(icon.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
        boton.setIcon(icono);
    }

    public final void recuperarDatos() {
        Modelo();
        DefaultTableModel tm = (DefaultTableModel) this.tFamilias.getModel();
        this.tFamilias.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        String sql = "select * from familias" + filtro;
        try {

            ResultSet rs = bd.Consulta(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String notas = rs.getString("notas");
                Object nuev[] = {id, nombre, notas};
                tm.addRow(nuev);
            }
            bd.cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
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

        jToolBar1 = new javax.swing.JToolBar();
        btSele = new javax.swing.JButton();
        btAñadir = new javax.swing.JButton();
        btModificar = new javax.swing.JButton();
        btEliminar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        jLabel2 = new javax.swing.JLabel();
        txtBusqueda = new javax.swing.JTextField();
        btSalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tFamilias = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("PANEL DE ADMINISTRACION DE FAMILIAS");
        setResizable(false);

        jToolBar1.setRollover(true);

        btSele.setFocusable(false);
        btSele.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btSele.setMaximumSize(new java.awt.Dimension(40, 40));
        btSele.setMinimumSize(new java.awt.Dimension(40, 40));
        btSele.setPreferredSize(new java.awt.Dimension(40, 40));
        btSele.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btSele.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSeleActionPerformed(evt);
            }
        });
        jToolBar1.add(btSele);

        btAñadir.setFocusable(false);
        btAñadir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btAñadir.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btAñadir.setMaximumSize(new java.awt.Dimension(40, 40));
        btAñadir.setMinimumSize(new java.awt.Dimension(40, 40));
        btAñadir.setPreferredSize(new java.awt.Dimension(40, 40));
        btAñadir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btAñadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAñadirActionPerformed(evt);
            }
        });
        jToolBar1.add(btAñadir);

        btModificar.setFocusable(false);
        btModificar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btModificar.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btModificar.setMaximumSize(new java.awt.Dimension(40, 40));
        btModificar.setMinimumSize(new java.awt.Dimension(40, 40));
        btModificar.setPreferredSize(new java.awt.Dimension(40, 40));
        btModificar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btModificarActionPerformed(evt);
            }
        });
        jToolBar1.add(btModificar);

        btEliminar.setFocusable(false);
        btEliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btEliminar.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btEliminar.setMaximumSize(new java.awt.Dimension(40, 40));
        btEliminar.setMinimumSize(new java.awt.Dimension(40, 40));
        btEliminar.setPreferredSize(new java.awt.Dimension(40, 40));
        btEliminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEliminarActionPerformed(evt);
            }
        });
        jToolBar1.add(btEliminar);
        jToolBar1.add(jSeparator1);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Busquedas:");
        jToolBar1.add(jLabel2);

        txtBusqueda.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtBusqueda.setToolTipText("");
        txtBusqueda.setMinimumSize(new java.awt.Dimension(150, 35));
        txtBusqueda.setPreferredSize(new java.awt.Dimension(250, 35));
        txtBusqueda.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txtBusquedaInputMethodTextChanged(evt);
            }
        });
        jToolBar1.add(txtBusqueda);

        btSalir.setFocusable(false);
        btSalir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btSalir.setMaximumSize(new java.awt.Dimension(40, 40));
        btSalir.setMinimumSize(new java.awt.Dimension(40, 40));
        btSalir.setPreferredSize(new java.awt.Dimension(40, 40));
        btSalir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalirActionPerformed(evt);
            }
        });
        jToolBar1.add(btSalir);

        tFamilias.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tFamilias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tFamilias.setRowHeight(30);
        tFamilias.setRowMargin(1);
        jScrollPane1.setViewportView(tFamilias);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("ADMINISTRACION DE FAMILIAS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 865, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btSeleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSeleActionPerformed
        int fila = this.tFamilias.getSelectedRow();
        System.out.println("Fila seleccionada es" + fila);
        if (this.tFamilias.getSelectedRow() != -1) {
            int codigo = (int) modelo.getValueAt(fila, 0);
            this.fami = new Familia(codigo);
            fami.recuperaDatos();
            this.result = JOptionPane.OK_OPTION;
            this.setVisible(false);
            this.dispose();
        }
    }//GEN-LAST:event_btSeleActionPerformed

    private void btAñadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAñadirActionPerformed
        Familia fami = new Familia();
        frFamilias dialog = new frFamilias(fami, true, new javax.swing.JFrame(), true);
        dialog.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                // System.exit(0);
            }
        });
        dialog.setVisible(true);
        if (dialog.getResult() == JOptionPane.YES_NO_OPTION) {
            this.recuperarDatos();
        } else {

        }
    }//GEN-LAST:event_btAñadirActionPerformed

    private void btModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btModificarActionPerformed
        int fila = this.tFamilias.getSelectedRow();
        System.out.println("Fila seleccionada es" + fila);
        if (this.tFamilias.getSelectedRow() != -1) {
            int codigo = (Integer) modelo.getValueAt(fila, 0);
            System.out.println("El codigo es:" + codigo);
            Familia fami = new Familia(codigo);
            fami.recuperaDatos();
            // this.setVisible(false);
            /*frFamilia fa=new frFamilia(fami, false);
            // JDialog dial=(JDialog)fa;
            fa.setVisible(true);*/
            frFamilias dialog = new frFamilias(fami, false, new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    //System.exit(0);
                }
            });
            dialog.setVisible(true);
            if (dialog.getResult() == JOptionPane.YES_NO_OPTION) {
                modelo.setValueAt(fami.getNombre(), fila, 1);
                modelo.setValueAt(fami.getNotas(), fila, 2);
            } else {
                System.out.println("Mostar ajsjdj");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un registro");
        }
    }//GEN-LAST:event_btModificarActionPerformed

    private void btEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEliminarActionPerformed
        int fila = this.tFamilias.getSelectedRow();
        System.out.println("Fila seleccionada es" + fila);
        if (this.tFamilias.getSelectedRow() != -1) {
            int codigo = (Integer) modelo.getValueAt(fila, 0);
            System.out.println("El codigo es:" + codigo);
            Familia fami = new Familia(codigo);
            int resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro?", "Alerta!", JOptionPane.YES_NO_OPTION);
            if (resp == JOptionPane.OK_OPTION) {
                if (fami.eliminar()) {
                    fami = null;
                    this.modelo.removeRow(fila);
                }
            }
        }
    }//GEN-LAST:event_btEliminarActionPerformed

    private void txtBusquedaInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtBusquedaInputMethodTextChanged
        System.out.println("El texto es:" + this.txtBusqueda.getText());
    }//GEN-LAST:event_txtBusquedaInputMethodTextChanged

    private void btSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalirActionPerformed
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_btSalirActionPerformed

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
            java.util.logging.Logger.getLogger(PanelFamilias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PanelFamilias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PanelFamilias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PanelFamilias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PanelFamilias dialog = new PanelFamilias(false, new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btAñadir;
    private javax.swing.JButton btEliminar;
    private javax.swing.JButton btModificar;
    private javax.swing.JButton btSalir;
    private javax.swing.JButton btSele;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTable tFamilias;
    private javax.swing.JTextField txtBusqueda;
    // End of variables declaration//GEN-END:variables
}

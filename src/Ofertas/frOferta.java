/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package Ofertas;

import bd.bd;
import java.awt.Image;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Familia
 */
public class frOferta extends javax.swing.JDialog {

    /**
     * Creates new form frOferta
     */
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
    private boolean operacion = false;
    private int result = JOptionPane.OK_OPTION;
    Oferta ofer;
    DefaultTableModel modelo;

    public frOferta(Oferta ofer, boolean operacion, java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        Modelo();
        this.ofer = ofer;
        this.operacion = operacion;
        if (!operacion) {
            this.lId.setText(String.valueOf(ofer.getId()));
            this.txtDescripcion.setText(ofer.getDescripcion());
            this.txtNombre.setText(ofer.getNombre());
            this.chVip.setSelected(ofer.isVip());
            this.txtFechaIni.setText(String.valueOf(ofer.getFechaIni()));
            this.txtFechaFin.setText(String.valueOf(ofer.getFechaFin()));
        }
        cargarIMG("/Imagenes/add.png", this.btAñadir);
        cargarIMG("/Imagenes/edit.png", this.btModificar);
        cargarIMG("/Imagenes/delete.png", this.btEliminar);
    }

    public final void registrarLineas() {
        int resultado = bd.Sentencia("delete from aplican where ofertasid=" + this.ofer.getId());
        for (int i = 0; i < modelo.getRowCount(); i++) {
            Aplican apli = new Aplican();
            String referencia = String.valueOf(modelo.getValueAt(i, 0));
            double cantidad = (double) modelo.getValueAt(i, 2);
            double dto = (double) modelo.getValueAt(i, 1);
            apli.setCantidad(cantidad);
            apli.setDescuento(dto);
            apli.setReferencia(referencia);
            apli.setOfertasId(ofer.getId());
            apli.registrar();
        }
    }

    public final void recuperarDatos() {

        DefaultTableModel tm = (DefaultTableModel) this.tLineas.getModel();
        this.tLineas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        String sql = "select * from ofertas ";
        try {

            ResultSet rs = bd.Consulta(sql);
            while (rs.next()) {
                ofer.setDescripcion(rs.getString("descripcion"));
                ofer.setId(rs.getInt("id"));
                ofer.setNombre(rs.getString("nombre"));
                ofer.setFechaIni(rs.getDate("fechaini"));
                ofer.setFechaFin(rs.getDate("fechafin"));
                ofer.setVip(rs.getBoolean("vip"));

                this.lId.setText(String.valueOf(ofer.getId()));
                this.txtDescripcion.setText(ofer.getDescripcion());
                this.txtNombre.setText(ofer.getNombre());
                this.txtFechaIni.setText(String.valueOf(ofer.getFechaIni()));
                this.txtFechaFin.setText(String.valueOf(ofer.getFechaFin()));

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void Modelo() {

        try {
            modelo = (new DefaultTableModel(
                    null, new String[]{
                        "Referencia",
                        "Descuento", "Cantidad"}) {
                Class[] types = new Class[]{
                    java.lang.String.class,
                    java.lang.Double.class,
                    java.lang.Double.class
                };
                boolean[] canEdit = new boolean[]{
                    false, true, true
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
            this.tLineas.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString() + "error2");
        }
        this.tLineas.setRowHeight(30);
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

        jPanel1 = new javax.swing.JPanel();
        lId = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtFechaFin = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtFechaIni = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        chVip = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tLineas = new javax.swing.JTable();
        btAceptar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        btAyuda = new javax.swing.JButton();
        jToolBar1 = new javax.swing.JToolBar();
        btAñadir = new javax.swing.JButton();
        btModificar = new javax.swing.JButton();
        btEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("ID Oferta"));

        lId.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lId.setText("ID");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lId, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lId, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
        );

        jLabel1.setText("Nombre:");

        jLabel2.setText("Descripción:");

        jLabel3.setText("Fecha Inicio:");

        txtFechaIni.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFechaIniFocusLost(evt);
            }
        });

        jLabel4.setText("Fecha Fin:");

        chVip.setText("Solo para Vip");

        tLineas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tLineas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tLineas.setRowHeight(30);
        tLineas.setRowMargin(1);
        jScrollPane1.setViewportView(tLineas);

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

        btAyuda.setText("Ayuda");
        btAyuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAyudaActionPerformed(evt);
            }
        });

        jToolBar1.setRollover(true);

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(204, 204, 204))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtFechaIni, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtDescripcion)
                            .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btAceptar)
                        .addGap(18, 18, 18)
                        .addComponent(btCancelar)
                        .addGap(18, 18, 18)
                        .addComponent(btAyuda)
                        .addGap(109, 109, 109))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(chVip)
                        .addGap(189, 189, 189))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFechaIni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chVip)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btAceptar)
                    .addComponent(btCancelar)
                    .addComponent(btAyuda))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtFechaIniFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFechaIniFocusLost
        /*double aux=0;
        try{
            aux=Double.parseDouble(this.txtFechaIni.getText());

        }
        catch(Exception ex){
            this.txtFechaIni.requestFocus();
        }*/
    }//GEN-LAST:event_txtFechaIniFocusLost

    private void btAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAceptarActionPerformed
        ofer.setNombre(this.txtNombre.getText());
        ofer.setDescripcion(this.txtDescripcion.getText());
        ofer.setVip(this.chVip.isSelected());
        try {
            ofer.setFechaIni(formato.parse(this.txtFechaIni.getText()));
            ofer.setFechaFin(formato.parse(this.txtFechaFin.getText()));
        } catch (ParseException ex) {
            Logger.getLogger(frOferta.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (operacion) {
            ofer.registrar();
            this.registrarLineas();
            this.result = JOptionPane.OK_OPTION;
            /*  this.setVisible(false);
            this.dispose();*/
        } else {
            ofer.actualizar();
            ofer.actualizarLineas();
            this.result = JOptionPane.OK_OPTION;
            /* this.setVisible(false);
            this.dispose();*/
        }
    }//GEN-LAST:event_btAceptarActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        this.result = JOptionPane.CANCEL_OPTION;
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btAyudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAyudaActionPerformed

    }//GEN-LAST:event_btAyudaActionPerformed

    private void btAñadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAñadirActionPerformed
        frLineas dialog = new frLineas(new Aplican(), true, new javax.swing.JFrame(), true);
        dialog.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                System.exit(0);
            }
        });
        dialog.setVisible(true);
        if (dialog.getResult() == JOptionPane.YES_NO_OPTION) {
            DefaultTableModel tm = (DefaultTableModel) this.tLineas.getModel();
            Object nuev[] = {dialog.getApli().getReferencia(), dialog.getApli().getDescuento(), dialog.getApli().getCantidad()};
            tm.addRow(nuev);
        } else {

        }
    }//GEN-LAST:event_btAñadirActionPerformed

    private void btModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btModificarActionPerformed
        int fila = this.tLineas.getSelectedRow();
        if (this.tLineas.getSelectedRow() != -1) {
            Aplican apli = new Aplican();
            String referencia = String.valueOf(modelo.getValueAt(fila, 0));
            double cantidad = (double) modelo.getValueAt(fila, 2);
            double dto = (double) modelo.getValueAt(fila, 1);
            apli.setCantidad(cantidad);
            apli.setDescuento(dto);
            apli.setReferencia(referencia);
            frLineas dialog = new frLineas(apli, false, new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    //System.exit(0);
                }
            });
            dialog.setVisible(true);
            if (dialog.getResult() == JOptionPane.YES_NO_OPTION) {
                modelo.setValueAt(apli.getReferencia(), fila, 0);
                modelo.setValueAt(apli.getDescuento(), fila, 1);
                modelo.setValueAt(apli.getCantidad(), fila, 2);
            } else {
                System.out.println("Mostar ajsjdj");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un registro");
        }
    }//GEN-LAST:event_btModificarActionPerformed

    private void btEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEliminarActionPerformed
        int fila = this.tLineas.getSelectedRow();
        if (this.tLineas.getSelectedRow() != -1) {
            int resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro?", "Alerta!", JOptionPane.YES_NO_OPTION);
            if (resp == JOptionPane.OK_OPTION) {
                this.modelo.removeRow(fila);
            }
        }
    }//GEN-LAST:event_btEliminarActionPerformed

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
            java.util.logging.Logger.getLogger(frOferta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frOferta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frOferta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frOferta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frOferta dialog = new frOferta(new Oferta(), true, new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btAñadir;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btEliminar;
    private javax.swing.JButton btModificar;
    private javax.swing.JCheckBox chVip;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lId;
    private javax.swing.JTable tLineas;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtFechaFin;
    private javax.swing.JTextField txtFechaIni;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}

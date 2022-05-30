/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package prtpvtienda;

import Articulos.Articulo;
import Ofertas.Cesta;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;


/**
 *
 * @author admin
 */
public final class Muestra extends javax.swing.JPanel {

    /**
     * Creates new form Muestra
     */    
    private Articulo arti;
    private double dto;
    private int cantidad;
    private String referencia="";
    String cli="";
    private String cliente="";

    public Muestra(Articulo arti, String cliente, double dto, int cantidad) {
        initComponents();        
        this.arti = arti;
        this.cliente=cliente;
        arti.recuperaDatos();
        this.dto=dto;
        this.cantidad=cantidad;
       // cantMinima = (int) apli.getCantidad();
        cargarIMG("/Imagenes/carrito2.png", this.btAñadir);
        cargarImaArticulo();
        this.lReferencia.setText("Referencia: " + arti.getReferencia());
        this.lDto.setText("Dto: " + dto);
        this.lDto.setToolTipText("OFERTA  EN XX 4 SSS");
        this.lDescrip.setText(arti.getDescripcion());
        this.lPrecio.setText("Precio: "+String.valueOf(arti.getPvp()));
        spCantidad.setModel(new javax.swing.SpinnerNumberModel(cantidad, cantidad, null, 1));
    }

    public void cargarImaArticulo() {

        ImageIcon icon = new ImageIcon(getClass().getResource("/Imagenes/" + arti.getRutaImg()));
        ImageIcon icono = new ImageIcon(icon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        this.lImagen.setIcon(icono);
    }

    private void cargarIMG(String url, JButton boton) {

        ImageIcon icon = new ImageIcon(getClass().getResource(url));
        ImageIcon icono = new ImageIcon(icon.getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT));
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

        lImagen = new javax.swing.JLabel();
        lDescrip = new javax.swing.JLabel();
        lDto = new javax.swing.JLabel();
        lPrecio = new javax.swing.JLabel();
        btAñadir = new javax.swing.JButton();
        spCantidad = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        lReferencia = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setPreferredSize(new java.awt.Dimension(200, 250));

        lImagen.setMaximumSize(new java.awt.Dimension(180, 83));
        lImagen.setMinimumSize(new java.awt.Dimension(180, 83));
        lImagen.setPreferredSize(new java.awt.Dimension(180, 83));

        lDescrip.setText("Descripcion");

        lDto.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lDto.setText("Dto: 50%");
        lDto.setToolTipText("");

        lPrecio.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lPrecio.setText("Precio: 120,00 €");
        lPrecio.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        btAñadir.setMaximumSize(new java.awt.Dimension(40, 40));
        btAñadir.setMinimumSize(new java.awt.Dimension(40, 40));
        btAñadir.setPreferredSize(new java.awt.Dimension(40, 40));
        btAñadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAñadirActionPerformed(evt);
            }
        });

        jLabel5.setText("Cantidad:");

        lReferencia.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lReferencia.setText("Referencia");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(lImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lDescrip, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spCantidad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btAñadir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(lDto, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lDescrip, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lDto)
                    .addComponent(lPrecio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btAñadir, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(spCantidad)
                        .addComponent(jLabel5)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btAñadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAñadirActionPerformed
        
        this.cantidad=(int)this.spCantidad.getValue();
        Cesta ces=new Cesta(this.arti, this.cliente, this.cantidad, this.dto);
        ces.registrar();
    }//GEN-LAST:event_btAñadirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAñadir;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lDescrip;
    private javax.swing.JLabel lDto;
    private javax.swing.JLabel lImagen;
    private javax.swing.JLabel lPrecio;
    private javax.swing.JLabel lReferencia;
    private javax.swing.JSpinner spCantidad;
    // End of variables declaration//GEN-END:variables
}

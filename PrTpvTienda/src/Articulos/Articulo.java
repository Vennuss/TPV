/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Articulos;

/**
 *
 * @author admin
 */
public class Articulo {
    private String referencia;
    private String descripcion;
    private String nomCorto;
    private double pvp;
    private int stock;
    private String qr;
    private int idFamilia;

    public Articulo(String referencia, String descripcion, String nomCorto, double pvp, String qr, int idFamilia) {
        this.referencia = referencia;
        this.descripcion = descripcion;
        this.nomCorto = nomCorto;
        this.pvp = pvp;
        this.qr = qr;
        this.idFamilia = idFamilia;
    }

    public Articulo(String referencia, String descripcion, int idFamilia) {
        this.referencia = referencia;
        this.descripcion = descripcion;
        this.idFamilia = idFamilia;
    }
    
    private void actualizaStock(int cantidad){
        
    }
    
    private void recuperaDatos(){
        
    }
    
    private void registrar(){
        
    }
    
    private void eliminar(){
        
    }
    
    private void actualizar(){
        
    }
    
    private void idNuevo(){
        
    }
    
    

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNomCorto() {
        return nomCorto;
    }

    public void setNomCorto(String nomCorto) {
        this.nomCorto = nomCorto;
    }

    public double getPvp() {
        return pvp;
    }

    public void setPvp(double pvp) {
        this.pvp = pvp;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getQr() {
        return qr;
    }

    public void setQr(String qr) {
        this.qr = qr;
    }

    public int getIdFamilia() {
        return idFamilia;
    }

    public void setIdFamilia(int idFamilia) {
        this.idFamilia = idFamilia;
    }
    
    
    
}

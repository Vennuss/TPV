/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ofertas;

import Maqueta.Maqueta;
import bd.bd;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import javax.swing.JOptionPane;

/**
 *
 * @author Familia
 */
public class Oferta implements Maqueta {

    private int id;
    private String nombre;
    private String descripcion;
    private Date fechaIni;
    private Date fechaFin;
    private boolean vip;
    private ArrayList<Aplican> lineas = new ArrayList();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public Oferta(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = "";
        this.fechaIni = new Date();
        this.fechaFin = new Date();
        this.vip = false;
    }

    public ArrayList<Aplican> getLineas() {
        return lineas;
    }

    public Oferta() {
        this.id = -1;
        this.nombre = "";
        this.descripcion = "";
        this.fechaIni = new Date();
        this.fechaFin = new Date();
        this.vip = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaIni() {
        return fechaIni;
    }

    public void setFechaIni(Date fechaIni) {
        this.fechaIni = fechaIni;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public boolean isVip() {
        return vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }
    
    public void registrarLineas(){
        Iterator itera=this.lineas.iterator();
        while(itera.hasNext()){
            Aplican li=(Aplican)itera.next();
            li.registrar();
        }
    }
    public void actualizarLineas(){
        Iterator itera=this.lineas.iterator();
        while(itera.hasNext()){
            Aplican li=(Aplican)itera.next();
            li.actualizar();
        }
    }
    
    public void recuperarLineas(){
       String sql="select * from aplican where id="+this.getId();
       try {
               
                ResultSet rs = bd.Consulta(sql);
                while (rs.next()) {
                    String referencia=rs.getString("articulosRef");
                    double dto=rs.getDouble("descuento");
                    double cantidad=rs.getDouble("cantidad");
                    Aplican lin=new Aplican(this.getId(),referencia,dto,cantidad);
                    lineas.add(lin);
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
    }

    @Override
    public void recuperaDatos() {
        String sql="select * from ofertas where id="+this.getId();
       try {
               
                ResultSet rs = bd.Consulta(sql);
                while (rs.next()) {
                    this.setId(rs.getInt("id"));
                    this.setNombre(rs.getString("nombre"));
                    this.setFechaFin(rs.getDate("fechaini"));
                    this.setFechaFin(rs.getDate("fechafin"));
                    this.setVip(rs.getBoolean("vip"));
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
    }

    @Override
    public void registrar() {        
        
        String sql="insert into ofertas(nombre, descripcion, fechaini, fechafin, vip) values('"+this.getNombre()+
                "','"+this.getDescripcion()+"','"+simpleDateFormat.format(this.getFechaIni())+"','"+simpleDateFormat.format(this.getFechaIni())+"',"+this.isVip()+")";
        int resultado=bd.Sentencia(sql);
        if(resultado>0){
            JOptionPane.showMessageDialog(null, "Registro Exitoso");
            
        }
    }

    @Override
    public void eliminar() {
        String sql="delete from ofertas where id="+this.getId();
        int resultado=bd.Sentencia(sql);
        if(resultado>0){
            JOptionPane.showMessageDialog(null, "La operacion se ha realizado con Exito");
        }
        else{
            JOptionPane.showMessageDialog(null, "No se ha podido realizar la operacion");
        }
    }

    @Override
    public void actualizar() {
       String sql="update ofertas set nombre='"+this.getNombre()+"', descripcion='"+this.getDescripcion()+"', fechaini='"+
               simpleDateFormat.format(this.getFechaIni())+"', fechafin='"+simpleDateFormat.format(this.getFechaFin())+"', vip="+this.isVip()+" where id="+this.getId();
        int resultado=bd.Sentencia(sql);
        if(resultado>0){
            JOptionPane.showMessageDialog(null, "Registro Exitoso");
            
        } 
    }

}

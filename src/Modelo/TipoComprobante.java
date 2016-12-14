/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author toshiba
 */
public class TipoComprobante {

    int idtipocomprobante;
    String descripcion;

    public TipoComprobante(int idtipocomprobante, String descripcion) {
        this.idtipocomprobante = idtipocomprobante;
        this.descripcion = descripcion;
    }
    public  TipoComprobante(){
        
    }

    public int getIdtipocomprobante() {
        return idtipocomprobante;
    }

    public void setIdtipocomprobante(int idtipocomprobante) {
        this.idtipocomprobante = idtipocomprobante;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
       
}

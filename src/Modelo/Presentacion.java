/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;

/**
 *
 * @author Adolfo
 */
public class Presentacion implements Serializable{
    private Integer idPresentacion;
    private String descripcion;
    private String codPresentacion;

    public Presentacion() {
    }

    public Presentacion(Integer idPresentacion, String descripcion, String codPresentacion) {
        this.idPresentacion = idPresentacion;
        this.descripcion = descripcion;
        this.codPresentacion = codPresentacion;
    }

    public Integer getIdPresentacion() {
        return idPresentacion;
    }

    public void setIdPresentacion(Integer idPresentacion) {
        this.idPresentacion = idPresentacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCodPresentacion() {
        return codPresentacion;
    }

    public void setCodPresentacion(String codPresentacion) {
        this.codPresentacion = codPresentacion;
    }
    
    
    
}

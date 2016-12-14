/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Modelo.Presentacion;
import java.util.List;

/**
 *
 * @author Adolfo
 */
public interface PresentacionesCRUD {
    public boolean Registrar(Presentacion p)throws Exception;
    public boolean Modificar(Presentacion p)throws Exception;
    public boolean Eliminar(Presentacion p)throws Exception;
    public List<Presentacion> Listar()throws Exception;
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Modelo.TipoComprobante;
import java.util.List;

/**
 *
 * @author toshiba
 */
public interface TipoComprobanteCRUD {
    public boolean Registrar(TipoComprobante tc)throws Exception;
    public boolean Modificar (TipoComprobante tc)throws Exception;
    public void  Eliminar(TipoComprobante tc) throws Exception;
    public List<TipoComprobante>Listar () throws Exception;
         
            
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Modelo.Categoria;
import java.util.List;

/**
 *
 * @author toshiba
 */
public interface CategoriaCRUD {
    public boolean Registrar(Categoria ca) throws Exception;

    public boolean Modificar(Categoria ca) throws Exception;

    public void Eliminar(Categoria ca) throws Exception;

    public List<Categoria> Listar() throws Exception;
}

package Interfaces;

import java.util.List;
import Modelo.UsuarioPerfil;

/**
 *
 * @author Marce
 */
public interface UsuarioPerfilCRUD {

    public boolean registrar(UsuarioPerfil up) throws Exception;
    public boolean modificar(UsuarioPerfil up) throws Exception;
    public boolean eliminar(UsuarioPerfil up) throws Exception;
    public List<UsuarioPerfil> listar() throws Exception;

}

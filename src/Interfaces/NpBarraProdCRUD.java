
package Interfaces;

import Modelo.NpBarra_Prod;
import java.util.List;

/**
 *
 * @author Marce
 */
public interface NpBarraProdCRUD<Param> {
    public boolean registrar(Param pp) throws Exception;

    public boolean modificar(Param pp) throws Exception;

    public boolean anular(Param pp) throws Exception;

    public List<Param> listar() throws Exception;
}

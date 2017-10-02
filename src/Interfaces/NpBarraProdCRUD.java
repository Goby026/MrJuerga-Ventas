
package Interfaces;

import java.util.List;

/**
 *
 * @author Marce
 */
public interface NpBarraProdCRUD<Param> {
    public boolean registrar(Param pp) throws Exception;

    public boolean modificar(Param pp) throws Exception;

    public boolean anular(int id) throws Exception;

    public List<Param> listar() throws Exception;
}


package Interfaces;

import java.util.List;

public interface NpBarraCRUD<Param> {
    public boolean registrar(Param p) throws Exception;

    public boolean modificar(Param p) throws Exception;

    public boolean anular(int id) throws Exception;

    public List<Param> listar() throws Exception;
}

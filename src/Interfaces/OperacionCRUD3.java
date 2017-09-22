
package Interfaces;

import Modelo.Operacion3;
import java.util.List;

public interface OperacionCRUD3 {
    public boolean registrar(Operacion3 op) throws Exception;

    public boolean modificar(Operacion3 op) throws Exception;

    public boolean anular(int id) throws Exception;

    public List<Operacion3> listar() throws Exception;
}


package Interfaces;

import Modelo.Operacion2;
import java.util.List;

public interface OperacionCRUD2 {
    public boolean registrar(Operacion2 op) throws Exception;

    public boolean modificar(Operacion2 op) throws Exception;

    public boolean anular(int id) throws Exception;

    public List<Operacion2> listar() throws Exception;
}

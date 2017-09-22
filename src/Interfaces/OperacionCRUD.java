
package Interfaces;

import Modelo.Operacion;
import java.util.List;

public interface OperacionCRUD {
    public boolean registrar(Operacion op) throws Exception;

    public boolean modificar(Operacion op) throws Exception;

    public boolean anular(int id) throws Exception;

    public List<Operacion> listar() throws Exception;
}

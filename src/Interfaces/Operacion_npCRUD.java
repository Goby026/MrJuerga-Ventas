
package Interfaces;

import Modelo.Operacion_np;
import java.util.List;

public interface Operacion_npCRUD {
    public boolean registrar(Operacion_np np) throws Exception;

    public boolean modificar(Operacion_np np) throws Exception;

    public boolean anular(int id) throws Exception;

    public List<Operacion_np> listar() throws Exception;
}

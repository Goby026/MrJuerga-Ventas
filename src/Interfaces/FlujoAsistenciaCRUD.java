
package Interfaces;

import Modelo.FlujoAsistencia;
import java.util.List;

public interface FlujoAsistenciaCRUD {
    public boolean registrar(FlujoAsistencia fc) throws Exception;

    public boolean modificar(FlujoAsistencia fc) throws Exception;

    public boolean eliminar(FlujoAsistencia fc) throws Exception;

    public List<FlujoAsistencia> listar() throws Exception;
}

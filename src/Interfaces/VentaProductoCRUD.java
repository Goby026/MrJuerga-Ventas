
package Interfaces;

import Modelo.VentaProducto;
import java.util.List;

public interface VentaProductoCRUD {
    public boolean registrar(VentaProducto vp) throws Exception;

    public boolean modificar(VentaProducto vp) throws Exception;

    public boolean anular(VentaProducto vp) throws Exception;

    public List<VentaProducto> listar() throws Exception;
}

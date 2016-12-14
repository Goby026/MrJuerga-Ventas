package Interfaces;

import Modelo.Producto;
import java.util.List;

public interface ProductoCRUD {

    public boolean registrar(Producto p) throws Exception;

    public boolean modificar(Producto p) throws Exception;

    public boolean eliminar(Producto p) throws Exception;

    public List<Producto> listar() throws Exception;
}

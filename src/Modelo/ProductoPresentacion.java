package Modelo;

/**
 *
 * @author Marce
 */
public class ProductoPresentacion {

    int idProductoPresentacion, idProducto, idPresentacion, idalmacen, stock,idcategoria;
    double precio;

    public ProductoPresentacion() {
    }

    public ProductoPresentacion(int idProductoPresentacion, int idProducto, int idPresentacion, int idalmacen, int stock, int idcategoria, double precio) {
        this.idProductoPresentacion = idProductoPresentacion;
        this.idProducto = idProducto;
        this.idPresentacion = idPresentacion;
        this.idalmacen = idalmacen;
        this.stock = stock;
        this.idcategoria = idcategoria;
        this.precio = precio;
    }

    public int getIdProductoPresentacion() {
        return idProductoPresentacion;
    }

    public void setIdProductoPresentacion(int idProductoPresentacion) {
        this.idProductoPresentacion = idProductoPresentacion;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdPresentacion() {
        return idPresentacion;
    }

    public void setIdPresentacion(int idPresentacion) {
        this.idPresentacion = idPresentacion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getIdalmacen() {
        return idalmacen;
    }

    public void setIdalmacen(int idalmacen) {
        this.idalmacen = idalmacen;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(int idcategoria) {
        this.idcategoria = idcategoria;
    }

    
}

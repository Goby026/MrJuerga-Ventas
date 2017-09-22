package Modelo;

/**
 *
 * @author Marce
 */
public class ProductoPresentacion {

    int idProductoPresentacion, idProducto, idPresentacion, idalmacen, stock,stock2,stock3,idcategoria;
    double precio, precio2;

    public ProductoPresentacion() {
    }

    public ProductoPresentacion(int idProductoPresentacion, int idProducto, int idPresentacion, int idalmacen, int stock, int stock2, int stock3, int idcategoria, double precio, double precio2) {
        this.idProductoPresentacion = idProductoPresentacion;
        this.idProducto = idProducto;
        this.idPresentacion = idPresentacion;
        this.idalmacen = idalmacen;
        this.stock = stock;
        this.stock2 = stock2;
        this.stock3 = stock3;
        this.idcategoria = idcategoria;
        this.precio = precio;
        this.precio2 = precio2;
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

    public int getStock2() {
        return stock2;
    }

    public void setStock2(int stock2) {
        this.stock2 = stock2;
    }

    public int getStock3() {
        return stock3;
    }

    public void setStock3(int stock3) {
        this.stock3 = stock3;
    }

    public int getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(int idcategoria) {
        this.idcategoria = idcategoria;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getPrecio2() {
        return precio2;
    }

    public void setPrecio2(double precio2) {
        this.precio2 = precio2;
    }

    @Override
    public String toString() {
        return "ProductoPresentacion{" + "idProductoPresentacion=" + idProductoPresentacion + ", idProducto=" + idProducto + ", idPresentacion=" + idPresentacion + ", idalmacen=" + idalmacen + ", stock=" + stock + ", stock2=" + stock2 + ", stock3=" + stock3 + ", idcategoria=" + idcategoria + ", precio=" + precio + ", precio2=" + precio2 + '}';
    }
    

}

package Modelo;

/**
 *
 * @author ELMER_05 Clase para manejar los campos detalle de venta del
 * formulario de anulaciones
 */
public class DatosAnulacion {

    String producto, presentacion;
    int cantidad;
    double precio, subtotal;

    public DatosAnulacion() {
    }

    public DatosAnulacion(String producto,String presentacion ,int cantidad, double precio, double subtotal) {
        this.producto = producto;
        this.presentacion = presentacion;
        this.cantidad = cantidad;
        this.precio = precio;
        this.subtotal = subtotal;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }
    
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

}

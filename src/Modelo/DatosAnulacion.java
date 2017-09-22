package Modelo;

/**
 *
 * @author ELMER_05 Clase para manejar los campos detalle de venta del
 * formulario de anulaciones
 */
public class DatosAnulacion {

    private int idProductoPresentacion;
    private String producto, presentacion;
    private int cantidad;
    private double precio, subtotal;

    public DatosAnulacion() {
    }

    public DatosAnulacion(int idProductoPresentacion, String producto,String presentacion ,int cantidad, double precio, double subtotal) {
        this.idProductoPresentacion = idProductoPresentacion;
        this.producto = producto;
        this.presentacion = presentacion;
        this.cantidad = cantidad;
        this.precio = precio;
        this.subtotal = subtotal;
    }

    public int getIdProductoPresentacion() {
        return idProductoPresentacion;
    }

    public void setIdProductoPresentacion(int idProductoPresentacion) {
        this.idProductoPresentacion = idProductoPresentacion;
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

    @Override
    public String toString() {
        return "DatosAnulacion{" + "idProductoPresentacion=" + idProductoPresentacion + ", producto=" + producto + ", presentacion=" + presentacion + ", cantidad=" + cantidad + ", precio=" + precio + ", subtotal=" + subtotal + '}';
    }

}

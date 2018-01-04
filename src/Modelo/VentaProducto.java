package Modelo;

public class VentaProducto {
    private int id;
    private int idProducto;
    private int idVenta;
    private double precio;
    private double cantidad;
    private double subtotal;
    private int complemento;

    public VentaProducto() {
    }

    public VentaProducto(int id, int idProducto, int idVenta, double precio, double cantidad, double subtotal, int complemento) {
        this.id = id;
        this.idProducto = idProducto;
        this.idVenta = idVenta;
        this.precio = precio;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
        this.complemento = complemento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public int getComplemento() {
        return complemento;
    }

    public void setComplemento(int complemento) {
        this.complemento = complemento;
    }
}

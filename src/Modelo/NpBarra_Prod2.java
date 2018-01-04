
package Modelo;

/**
 *
 * @author Grover
 */
public class NpBarra_Prod2 {
    private int idNpBarraProd2;
    private int idProductoPresentacion;
    private int idNpBarra;
    private double precioU;
    private double cantidad;
    private double subtotal;
    private int complemento;

    public NpBarra_Prod2() {
    }

    public NpBarra_Prod2(int idNpBarraProd2, int idProductoPresentacion, int idNpBarra, double precioU, double cantidad, double subtotal, int complemento) {
        this.idNpBarraProd2 = idNpBarraProd2;
        this.idProductoPresentacion = idProductoPresentacion;
        this.idNpBarra = idNpBarra;
        this.precioU = precioU;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
        this.complemento = complemento;
    }

    public int getIdNpBarraProd2() {
        return idNpBarraProd2;
    }

    public void setIdNpBarraProd2(int idNpBarraProd2) {
        this.idNpBarraProd2 = idNpBarraProd2;
    }

    public int getIdProductoPresentacion() {
        return idProductoPresentacion;
    }

    public void setIdProductoPresentacion(int idProductoPresentacion) {
        this.idProductoPresentacion = idProductoPresentacion;
    }

    public int getIdNpBarra() {
        return idNpBarra;
    }

    public void setIdNpBarra(int idNpBarra) {
        this.idNpBarra = idNpBarra;
    }

    public double getPrecioU() {
        return precioU;
    }

    public void setPrecioU(double precioU) {
        this.precioU = precioU;
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

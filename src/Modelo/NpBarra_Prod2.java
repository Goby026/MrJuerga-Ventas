
package Modelo;

/**
 *
 * @author Grover
 */
public class NpBarra_Prod2 {
    int idNpBarraProd2;
    int idProductoPresentacion;
    int idNpBarra;
    double precioU;
    int cantidad;
    double subtotal;

    public NpBarra_Prod2() {
    }

    public NpBarra_Prod2(int idNpBarraProd2, int idProductoPresentacion, int idNpBarra, double precioU, int cantidad, double subtotal) {
        this.idNpBarraProd2 = idNpBarraProd2;
        this.idProductoPresentacion = idProductoPresentacion;
        this.idNpBarra = idNpBarra;
        this.precioU = precioU;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
    }

    public int getIdNpBarraProd() {
        return idNpBarraProd2;
    }

    public void setIdNpBarraProd(int idNpBarraProd2) {
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

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    @Override
    public String toString() {
        return "NpBarra_Prod{" + "idNpBarraProd=" + idNpBarraProd2 + ", idProductoPresentacion=" + idProductoPresentacion + ", idNpBarra=" + idNpBarra + ", precioU=" + precioU + ", cantidad=" + cantidad + ", subtotal=" + subtotal + '}';
    }
    
    
}

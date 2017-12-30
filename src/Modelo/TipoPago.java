
package Modelo;

/**
 *
 * @author MARCEL
 */
public class TipoPago {
    private int tipoPago;
    private String descripcion;

    public TipoPago() {
    }

    public TipoPago(int tipoPago, String descripcion) {
        this.tipoPago = tipoPago;
        this.descripcion = descripcion;
    }

    public int getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(int tipoPago) {
        this.tipoPago = tipoPago;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }    
    
}

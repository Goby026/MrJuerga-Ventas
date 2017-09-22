
package Modelo;

/**
 *
 * @author Grover
 */
public class Operacion {
    int idoperacion;
    int idventa;
    String numref;
    String tarjeta;
    double monto;

    public Operacion() {
    }

    public Operacion(int idoperacion, int idventa, String numref, String tarjeta, double monto) {
        this.idoperacion = idoperacion;
        this.idventa = idventa;
        this.numref = numref;
        this.tarjeta = tarjeta;
        this.monto = monto;
    }

    public int getIdoperacion() {
        return idoperacion;
    }

    public void setIdoperacion(int idoperacion) {
        this.idoperacion = idoperacion;
    }

    public int getIdventa() {
        return idventa;
    }

    public void setIdventa(int idventa) {
        this.idventa = idventa;
    }

    public String getNumref() {
        return numref;
    }

    public void setNumref(String numref) {
        this.numref = numref;
    }

    public String getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(String tarjeta) {
        this.tarjeta = tarjeta;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "Operacion{" + "idoperacion=" + idoperacion + ", idventa=" + idventa + ", numref=" + numref + ", tarjeta=" + tarjeta + ", monto=" + monto + '}';
    }    

}

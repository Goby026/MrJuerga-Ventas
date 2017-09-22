
package Modelo;

/**
 *
 * @author Grover
 */
public class Operacion_np {
    int idoperacion_np;
    int idnpbarra;
    String numref;
    String tarjeta;
    double monto;

    public Operacion_np() {
    }

    public Operacion_np(int idoperacion_np, int idnpbarra, String numref, String tarjeta, double monto) {
        this.idoperacion_np = idoperacion_np;
        this.idnpbarra = idnpbarra;
        this.numref = numref;
        this.tarjeta = tarjeta;
        this.monto = monto;
    }

    public int getIdoperacion_np() {
        return idoperacion_np;
    }

    public void setIdoperacion_np(int idoperacion_np) {
        this.idoperacion_np = idoperacion_np;
    }

    public int getIdnpbarra() {
        return idnpbarra;
    }

    public void setIdnpbarra(int idnpbarra) {
        this.idnpbarra = idnpbarra;
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
        return "Operacion_np{" + "idoperacion_np=" + idoperacion_np + ", idnpbarra=" + idnpbarra + ", numref=" + numref + ", tarjeta=" + tarjeta + ", monto=" + monto + '}';
    }
    
    
}

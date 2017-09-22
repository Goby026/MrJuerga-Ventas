
package Modelo;

/**
 *
 * @author Grover
 */
public class Operacion3 {
    int idoperacion3;
    int idventa3;
    String numref;
    String tarjeta;
    double monto;

    public Operacion3() {
    }

    public Operacion3(int idoperacion3, int idventa3, String numref, String tarjeta, double monto) {
        this.idoperacion3 = idoperacion3;
        this.idventa3 = idventa3;
        this.numref = numref;
        this.tarjeta = tarjeta;
        this.monto = monto;
    }

    public int getIdoperacion3() {
        return idoperacion3;
    }

    public void setIdoperacion3(int idoperacion3) {
        this.idoperacion3 = idoperacion3;
    }

    public int getIdventa3() {
        return idventa3;
    }

    public void setIdventa3(int idventa3) {
        this.idventa3 = idventa3;
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
        return "Operacion{" + "idoperacion3=" + idoperacion3 + ", idventa3=" + idventa3 + ", numref=" + numref + ", tarjeta=" + tarjeta + ", monto=" + monto + '}';
    }    

}

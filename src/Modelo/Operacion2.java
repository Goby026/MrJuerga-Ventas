
package Modelo;

/**
 *
 * @author Grover
 */
public class Operacion2 {
    int idoperacion2;
    int idventa2;
    String numref;
    String tarjeta;
    double monto;

    public Operacion2() {
    }

    public Operacion2(int idoperacion2, int idventa2, String numref, String tarjeta, double monto) {
        this.idoperacion2 = idoperacion2;
        this.idventa2 = idventa2;
        this.numref = numref;
        this.tarjeta = tarjeta;
        this.monto = monto;
    }

    public int getIdoperacion2() {
        return idoperacion2;
    }

    public void setIdoperacion2(int idoperacion2) {
        this.idoperacion2 = idoperacion2;
    }

    public int getIdventa2() {
        return idventa2;
    }

    public void setIdventa2(int idventa2) {
        this.idventa2 = idventa2;
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
        return "Operacion{" + "idoperacion2=" + idoperacion2 + ", idventa2=" + idventa2 + ", numref=" + numref + ", tarjeta=" + tarjeta + ", monto=" + monto + '}';
    }    

}


package Modelo;

/**
 *
 * @author Marce
 */
public class UsuarioGastos {
    int idUsuarioGastos, idGastos, idUsuario;
    double monto;

    public UsuarioGastos() {
    }

    public UsuarioGastos(int idUsuarioGastos, int idGastos, int idUsuario, double monto) {
        this.idUsuarioGastos = idUsuarioGastos;
        this.idGastos = idGastos;
        this.idUsuario = idUsuario;
        this.monto = monto;
    }

    public int getIdUsuarioGastos() {
        return idUsuarioGastos;
    }

    public void setIdUsuarioGastos(int idUsuarioGastos) {
        this.idUsuarioGastos = idUsuarioGastos;
    }

    public int getIdGastos() {
        return idGastos;
    }

    public void setIdGastos(int idGastos) {
        this.idGastos = idGastos;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
}

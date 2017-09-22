
package Modelo;

/**
 *
 * @author Grover
 */
public class NpBarra {
    int idNpBarra;
    String fecha;
    String hora;
    int idUsuario;
    int idCliente;
    int idTipoComprobante;
    int estado;
    int tipoPago;
    String nOperacion;
    int idCaja;
    int idFlujoCaja;

    public NpBarra() {
    }

    public NpBarra(int idNpBarra, String fecha, String hora, int idUsuario, int idCliente, int idTipoComprobante, int estado, int tipoPago, String nOperacion, int idCaja, int idFlujoCaja) {
        this.idNpBarra = idNpBarra;
        this.fecha = fecha;
        this.hora = hora;
        this.idUsuario = idUsuario;
        this.idCliente = idCliente;
        this.idTipoComprobante = idTipoComprobante;
        this.estado = estado;
        this.tipoPago = tipoPago;
        this.nOperacion = nOperacion;
        this.idCaja = idCaja;
        this.idFlujoCaja = idFlujoCaja;
    }

    public int getIdNpBarra() {
        return idNpBarra;
    }

    public void setIdNpBarra(int idNpBarra) {
        this.idNpBarra = idNpBarra;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdTipoComprobante() {
        return idTipoComprobante;
    }

    public void setIdTipoComprobante(int idTipoComprobante) {
        this.idTipoComprobante = idTipoComprobante;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(int tipoPago) {
        this.tipoPago = tipoPago;
    }

    public String getnOperacion() {
        return nOperacion;
    }

    public void setnOperacion(String nOperacion) {
        this.nOperacion = nOperacion;
    }

    public int getIdCaja() {
        return idCaja;
    }

    public void setIdCaja(int idCaja) {
        this.idCaja = idCaja;
    }

    public int getIdFlujoCaja() {
        return idFlujoCaja;
    }

    public void setIdFlujoCaja(int idFlujoCaja) {
        this.idFlujoCaja = idFlujoCaja;
    }

    @Override
    public String toString() {
        return "NpBarra{" + "idNpBarra=" + idNpBarra + ", fecha=" + fecha + ", hora=" + hora + ", idUsuario=" + idUsuario + ", idCliente=" + idCliente + ", idTipoComprobante=" + idTipoComprobante + ", estado=" + estado + ", tipoPago=" + tipoPago + ", nOperacion=" + nOperacion + ", idCaja=" + idCaja + ", idFlujoCaja=" + idFlujoCaja + '}';
    }    
    
}

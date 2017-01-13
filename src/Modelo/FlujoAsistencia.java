/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author ELMER_05
 */
public class FlujoAsistencia {
    int idAsistencia;
    int idUsuario;
    String horaEntrada;
    String fechaEntrada;
    String fechaSalida;
    String horaSalida;
    int estadoAsistencia;
    int estadoPago;

    public FlujoAsistencia(int idAsistencia, int idUsuario, String horaEntrada, String fechaEntrada, String fechaSalida, String horaSalida, int estadoAsistencia, int estadoPago) {
        this.idAsistencia = idAsistencia;
        this.idUsuario = idUsuario;
        this.horaEntrada = horaEntrada;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.horaSalida = horaSalida;
        this.estadoAsistencia = estadoAsistencia;
        this.estadoPago = estadoPago;
    }
    
    public FlujoAsistencia() {
    }

    public int getIdAsistencia() {
        return idAsistencia;
    }

    public void setIdAsistencia(int idAsistencia) {
        this.idAsistencia = idAsistencia;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(String horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public String getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(String fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    public int getEstadoAsistencia() {
        return estadoAsistencia;
    }

    public void setEstadoAsistencia(int estadoAsistencia) {
        this.estadoAsistencia = estadoAsistencia;
    }

    public int getEstadoPago() {
        return estadoPago;
    }

    public void setEstadoPago(int estadoPago) {
        this.estadoPago = estadoPago;
    }
    
    
}

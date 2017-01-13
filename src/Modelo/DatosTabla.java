
package Modelo;


public class DatosTabla {
    int idAsistencia;
    String nombre, apellido;
    String dni;
    String fec_entrada;
    String hora_entrada;    
    String fec_salida;
    String hora_salida;

    public DatosTabla(int idAsistencia, String nombre, String apellido,String dni ,String fec_entrada, String hora_entrada, String fec_salida, String hora_salida) {
        this.idAsistencia = idAsistencia;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fec_entrada = fec_entrada;
        this.hora_entrada = hora_entrada;
        this.fec_salida = fec_salida;
        this.hora_salida = hora_salida;
    }
    
    public DatosTabla() {
    }

    public int getIdAsistencia() {
        return idAsistencia;
    }

    public void setIdAsistencia(int idAsistencia) {
        this.idAsistencia = idAsistencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getFec_entrada() {
        return fec_entrada;
    }

    public void setFec_entrada(String fec_entrada) {
        this.fec_entrada = fec_entrada;
    }

    public String getHora_entrada() {
        return hora_entrada;
    }

    public void setHora_entrada(String hora_entrada) {
        this.hora_entrada = hora_entrada;
    }

    public String getFec_salida() {
        return fec_salida;
    }

    public void setFec_salida(String fec_salida) {
        this.fec_salida = fec_salida;
    }

    public String getHora_salida() {
        return hora_salida;
    }

    public void setHora_salida(String hora_salida) {
        this.hora_salida = hora_salida;
    }
    
    
}

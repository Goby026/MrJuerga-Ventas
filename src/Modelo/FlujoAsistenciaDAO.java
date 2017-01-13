
package Modelo;

import Interfaces.FlujoAsistenciaCRUD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class FlujoAsistenciaDAO extends Conexion implements FlujoAsistenciaCRUD{

    @Override
    public boolean registrar(FlujoAsistencia fc) throws Exception {
        try {
            String sql = "INSERT INTO `mrjuerga`.`flujoasistencia` (`idusuario`, `hora_entrada`, `fecha_entrada`, `hora_salida`, `fecha_salida`, `estado_asist`, `estado_pago`) VALUES (?, ?, ?, ?, ?, ?, ?)";
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setInt(1, fc.getIdUsuario());
            pst.setString(2, fc.getHoraEntrada());
            pst.setString(3, fc.getFechaEntrada());
            pst.setString(4, fc.getHoraSalida());
            pst.setString(5, fc.getFechaSalida());
            pst.setInt(6, fc.getEstadoAsistencia());
            pst.setInt(7, fc.getEstadoPago());
            int res = pst.executeUpdate();
            if (res > 0) {
                return true;
            }
            pst.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return false;
    }

    @Override
    public boolean modificar(FlujoAsistencia fc) throws Exception {
        try {
            String sql = ("UPDATE flujoasistencia set idusuario = ?, hora_entrada= ?, fecha_entrada=?,hora_salida = ? ,fecha_salida = ?, estado_asist = ?, estado_pago= ? where idasistencia=?");
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setInt(1, fc.getIdUsuario());
            pst.setString(2, fc.getHoraEntrada());
            pst.setString(3, fc.getFechaEntrada());
            pst.setString(4, fc.getHoraSalida());
            pst.setString(5, fc.getFechaSalida());
            pst.setInt(6, fc.getEstadoAsistencia());
            pst.setInt(7, fc.getEstadoPago());
            pst.setInt(8, fc.getIdAsistencia());
            int res = pst.executeUpdate();
            if (res > 0) {
                return true;
            }
            pst.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return false;
    }

    @Override
    public boolean eliminar(FlujoAsistencia fc) throws Exception {
        try {
            String sql = ("delete from flujoasistencia where idasistencia=?");
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setInt(1, fc.getIdAsistencia());
            int res = pst.executeUpdate();
            if (res > 0) {
                return true;
            }
            pst.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return false;
    }

    @Override
    public List<FlujoAsistencia> listar() throws Exception {
        List<FlujoAsistencia> lista = null;
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("select * from flujoasistencia");
            lista = new ArrayList();
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                FlujoAsistencia fa = new FlujoAsistencia();
                fa.setIdAsistencia(rs.getInt("idasistencia"));
                fa.setIdUsuario(rs.getInt("idusuario"));
                fa.setHoraEntrada(rs.getString("hora_entrada"));
                fa.setFechaEntrada(rs.getString("fecha_entrada"));
                fa.setHoraSalida(rs.getString("hora_salida"));
                fa.setFechaSalida(rs.getString("fecha_salida"));
                fa.setEstadoAsistencia(rs.getInt("estado_asist"));
                fa.setEstadoPago(rs.getInt("estado_pago"));
                lista.add(fa);
            }
            rs.close();
            pst.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return lista;
    }
    
    /* METODO PARA OBTENER EL FLUJO DE ASISTENCIA DE UN DETERMINADO USUARIO */
    public int getIdFlujo(int idUsuario) throws Exception {
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("SELECT MAX(idasistencia) FROM flujoasistencia WHERE idusuario= " + idUsuario + " AND estado_asist=1");
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                return res.getInt("MAX(idasistencia)");
            }
            pst.close();
            res.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return -1;
    }
    
    /* METODO PARA OBTENER LOS DATOS DE ASISTENCIA */
    public List<DatosTabla> getDatosTabla() throws Exception {
        List<DatosTabla> lista = null;
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("select flujoasistencia.idasistencia, usuario.nombre, usuario.apellido,usuario.dni ,flujoasistencia.fecha_entrada, flujoasistencia.hora_entrada from usuario inner join flujoasistencia on usuario.idusuario = flujoasistencia.idusuario where estado_asist = 1");
            lista = new ArrayList();
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                DatosTabla dt = new DatosTabla();
                dt.setIdAsistencia(rs.getInt("flujoasistencia.idasistencia"));
                dt.setNombre(rs.getString("usuario.nombre"));
                dt.setApellido(rs.getString("usuario.apellido"));
                dt.setDni(rs.getString("usuario.dni"));
                dt.setFec_entrada(rs.getString("flujoasistencia.fecha_entrada"));
                dt.setHora_entrada(rs.getString("flujoasistencia.hora_entrada"));
                lista.add(dt);
            }
            rs.close();
            pst.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return lista;
    }
    
    //METODO PARA ACTUALIZAR LA ASISTENCIA
    public boolean updateFlujoAssistencia(String fecha, String hora, int idFlujoAsistencia) throws Exception {
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("UPDATE `mrjuerga`.`flujoasistencia` SET `hora_salida`='"+hora+"', `fecha_salida`='"+fecha+"', `estado_asist`='0' WHERE `idasistencia`="+idFlujoAsistencia+"");
            int res = pst.executeUpdate();
            if (res > 0) {
                return true;
            }
            pst.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return false;
    }
    
    
}

package Modelo;

import Interfaces.FlujoCajaCRUD;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marce
 */
public class FlujoCajaDAO extends Conexion implements FlujoCajaCRUD {

    @Override
    public boolean Registrar(FlujoCaja fc) throws Exception {
        try {
            String sql = "INSERT INTO flujocaja(fecha_inicio,hora_inicio,fecha_final, hora_final,ingresos,egresos,saldo,idusuario,idcaja, estado)VALUE (?,?,?,?,?,?,?,?)";
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setString(1, fc.getFechaInicio());
            pst.setString(2, fc.getHoraInicio());
            pst.setString(3, fc.getFechaFinal());
            pst.setString(4, fc.getHoraFinal());
            pst.setDouble(5, fc.getIngresos());
            pst.setDouble(6, fc.getEgresos());
            pst.setDouble(7, fc.getSaldo());
            pst.setInt(8, fc.getIdUsuario());
            pst.setInt(9, fc.getIdCaja());
            pst.setString(10, fc.getEstado());
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
    public boolean Modificar(FlujoCaja fc) throws Exception {
        try {
            String sql = ("UPDATE caja flujocaja SET fecha_inicio = ?,hora_final=?,fecha_final=? ,hora_final=? ,ingresos = ?, egresos = ?, saldo = ?, idusuario = ?, idcaja = ?, estado= ? WHERE idflujocaja = ?");
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setString(1, fc.getFechaInicio());
            pst.setString(2, fc.getHoraInicio());
            pst.setString(3, fc.getFechaFinal());
            pst.setString(4, fc.getHoraFinal());
            pst.setDouble(5, fc.getIngresos());
            pst.setDouble(6, fc.getEgresos());
            pst.setDouble(7, fc.getSaldo());
            pst.setInt(8, fc.getIdUsuario());
            pst.setInt(9, fc.getIdCaja());
            pst.setString(10, fc.getEstado());
            pst.setInt(11, fc.getIdFlujoCaja());
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
    public boolean Eliminar(FlujoCaja fc) throws Exception {
        try {
            String sql = ("delete from flujocaja where idflujocaja = ?");
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setInt(1, fc.getIdFlujoCaja());
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
    public List<FlujoCaja> Listar() throws Exception {
        List<FlujoCaja> lista = new ArrayList<>();
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("SELECT * FROM flujocaja");
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                FlujoCaja fc = new FlujoCaja();
                fc.setIdFlujoCaja(res.getInt("idflujocaja"));                
                fc.setFechaInicio(res.getString("fecha_inicio"));
                fc.setHoraInicio(res.getString("hora_inicio"));
                fc.setFechaFinal(res.getString("fecha_final"));
                fc.setHoraFinal(res.getString("hora_final"));
                fc.setIngresos(res.getDouble("ingresos"));
                fc.setEgresos(res.getDouble("egresos"));
                fc.setSaldo(res.getDouble("saldo"));
                fc.setIdUsuario(res.getInt("idusuario"));
                fc.setIdCaja(res.getInt("idcaja"));
                fc.setEstado(res.getString("estado"));
                lista.add(fc);
            }
            pst.close();
            res.close();
        } catch (Exception error) {
            throw error;
        } finally {
            this.cerrar();
        }
        return lista;
    }

}

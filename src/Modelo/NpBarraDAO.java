
package Modelo;

import Interfaces.NpBarraCRUD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Grover
 */
public class NpBarraDAO extends Conexion implements NpBarraCRUD<NpBarra>{

    @Override
    public boolean registrar(NpBarra np) throws Exception {
        try {
            String sql = "insert into npbarra (fecha, hora, idusuario, idcliente, idtipocomprobante, estado, tipopago,noperacion ,idcaja, idflujocaja) values (?,?,?,?,?,?,?,?,?,?)";
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setString(1, np.getFecha());
            pst.setString(2, np.getHora());
            pst.setInt(3, np.getIdUsuario());
            pst.setInt(4, np.getIdCliente());
            pst.setInt(5, np.getIdTipoComprobante());
            pst.setInt(6, np.getEstado());
            pst.setInt(7, np.getTipoPago());
            pst.setString(8, np.getnOperacion());
            pst.setInt(9, np.getIdCaja());
            pst.setInt(10, np.getIdFlujoCaja());
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
    public boolean modificar(NpBarra np) throws Exception {
        try {
            String sql = "UPDATE npbarra SET fecha=?, hora=?, idusuario=?, idcliente=?, idtipocomprobante=?, estado=?, tipopago = ?,noperacion = ? ,idcaja = ? ,idflujocaja = ? WHERE idnpbarra = ?";
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setString(1, np.getFecha());
            pst.setString(2, np.getHora());
            pst.setInt(3, np.getIdUsuario());
            pst.setInt(4, np.getIdCliente());
            pst.setInt(5, np.getIdTipoComprobante());
            pst.setInt(6, np.getEstado());
            pst.setInt(7, np.getTipoPago());
            pst.setString(8, np.getnOperacion());
            pst.setInt(9, np.getIdCaja());
            pst.setInt(10, np.getIdFlujoCaja());
            pst.setInt(11, np.getIdNpBarra());
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
    public boolean anular(int id) throws Exception {
        try {
            //estado 0=anulado - 1=activo
            String sql = "UPDATE npbarra SET estado = 0 WHERE idnpbarra = " + id + "";
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
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
    public List<NpBarra> listar() throws Exception {
        List<NpBarra> lista = null;
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("select * from npbarra");
            lista = new ArrayList();
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                NpBarra v = new NpBarra();
                v.setIdNpBarra(rs.getInt("idnpbarra"));
                v.setFecha(rs.getString("fecha"));
                v.setHora(rs.getString("hora"));
                v.setIdUsuario(rs.getInt("idusuario"));
                v.setIdCliente(rs.getInt("idcliente"));
                v.setIdTipoComprobante(rs.getInt("idtipocomprobante"));
                v.setEstado(rs.getInt("estado"));
                v.setTipoPago(rs.getInt("tipopago"));
                v.setnOperacion(rs.getString("noperacion"));
                v.setIdCaja(rs.getInt("idcaja"));
                v.setIdFlujoCaja(rs.getInt("idflujocaja"));
                lista.add(v);
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
    
    //ultima Nota de pedido caja 1
    public int getIdUltimaNota() throws Exception {
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("SELECT  idnpbarra FROM npbarra ORDER BY idnpbarra DESC LIMIT 1");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                return rs.getInt("idnpbarra");
            }
            rs.close();
            pst.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return -1;
    }
}

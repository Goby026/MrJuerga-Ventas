
package Modelo;

import Interfaces.DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Grover
 */
public class NpBarraDAO extends Conexion implements DAO<NpBarra>{

    @Override
    public boolean Registrar(NpBarra np) throws Exception {
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
    public boolean Modificar(NpBarra np) throws Exception {
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
    public boolean Anular(int id) throws Exception {
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
    public boolean AnularNP(int id, int idCaja) throws Exception {
        try {
            //estado 0=anulado - 1=activo
            String sql = "";
            switch(idCaja){
                case 1:
                    sql = "UPDATE npbarra SET estado = 0 WHERE idnpbarra = " + id + "";
                    break;
                case 2:
                    sql = "UPDATE npbarra2 SET estado = 0 WHERE idnpbarra2 = " + id + "";
                    break;
                case 3:
                    sql = "UPDATE npbarra3 SET estado = 0 WHERE idnpbarra3 = " + id + "";
                    break;
            }
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
    public List<NpBarra> Listar() throws Exception {
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

    @Override
    public boolean Eliminar(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //obtener una nota de pedido a partir del numero de nota de pedido
    @Override
    public NpBarra Obtener(int idNp) throws Exception {
        NpBarra v = null;
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("select * from npbarra where idnpbarra = ?");
            pst.setInt(1, idNp);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                v = new NpBarra();
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
            }
            rs.close();
            pst.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return v;
    }
    
    public NpBarra ObtenerNP(int idNp, int idCaja) throws Exception {
        NpBarra v = null;
        try {
            this.conectar();
            String sql ="";
            switch (idCaja) {
                case 1:
                    sql = "select * from npbarra where idnpbarra = ?";
                    break;
                case 2:
                    sql = "select * from npbarra2 where idnpbarra2 = ?";
                    break;
                case 3:
                    sql = "select * from npbarra3 where idnpbarra3 = ?";
                    break;
            }
            
            
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setInt(1, idNp);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                v = new NpBarra();
                v.setIdNpBarra(rs.getInt(1));
                v.setFecha(rs.getString(2));
                v.setHora(rs.getString(3));
                v.setIdUsuario(rs.getInt(4));
                v.setIdCliente(rs.getInt(5));
                v.setIdTipoComprobante(rs.getInt(6));
                v.setEstado(rs.getInt(7));
                v.setTipoPago(rs.getInt(8));
                v.setnOperacion(rs.getString(9));
                v.setIdCaja(rs.getInt(10));
                v.setIdFlujoCaja(rs.getInt(11));
            }
            rs.close();
            pst.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return v;
    }
    
}

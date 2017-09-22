package Modelo;

import Interfaces.OperacionCRUD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Grover
 */
public class OperacionDAO extends Conexion implements OperacionCRUD {

    @Override
    public boolean registrar(Operacion np) throws Exception {
        try {
            String sql = "INSERT INTO operacion(idventa,numref,tarjeta, monto) VALUES (?,?,?,?)";
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setInt(1, np.getIdventa());
            pst.setString(2, np.getNumref());
            pst.setString(3, np.getTarjeta());
            pst.setDouble(4, np.getMonto());
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
    public boolean modificar(Operacion np) throws Exception {
        try {
            String sql = ("UPDATE operacion SET idventa = ?,numref = ?,tarjeta = ?, monto=? WHERE idoperacion=?");
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setInt(1, np.getIdventa());
            pst.setString(2, np.getNumref());
            pst.setString(3, np.getTarjeta());
            pst.setDouble(4, np.getMonto());
            int res = pst.executeUpdate();
            if (res > 0) {
                return true;
            }
            pst.close();
        } catch (Exception e) {
            e.getMessage();
        } finally {
            this.cerrar();
        }
        return false;
    }

    @Override
    public boolean anular(int id) throws Exception {
        try {
            boolean b = false;
            String sql = ("UPDATE operacion SET numref = 0,tarjeta = 0, monto=0 WHERE idoperacion = ?");
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setInt(1, id);
            int res = pst.executeUpdate();
            if (res > 0) {
                return true;
            }
            pst.close();
        } catch (Exception e) {
            e.getMessage();
        } finally {
            this.cerrar();
        }
        return false;
    }

    @Override
    public List<Operacion> listar() throws Exception {
        List<Operacion> li = new ArrayList<>();
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("SELECT * FROM operacion");
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                Operacion op = new Operacion();
                op.setIdoperacion(res.getInt(1));
                op.setIdventa(res.getInt(2));
                op.setNumref(res.getString(3));
                op.setTarjeta(res.getString(4));
                op.setMonto(res.getDouble(5));
                li.add(op);
            }
            pst.close();
            res.close();
        } catch (Exception error) {
            throw error;
        } finally {
            this.cerrar();
        }
        return li;
    }
    
//    public int getUltimoPedido() throws SQLException, Exception{
//        try {
//            this.conectar();
//            PreparedStatement pst = this.conexion.prepareStatement("SELECT idoperacion FROM operacion_np ORDER BY idoperacion_np DESC LIMIT 1");
//            ResultSet res = pst.executeQuery();
//            while (res.next()) {
//                return res.getInt(1);
//            }
//            pst.close();
//            res.close();
//        } catch (Exception e) {
//            throw e;
//        }finally{
//            this.cerrar();
//        }
//        return 0;
//    }

}

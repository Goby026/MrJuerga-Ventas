package Modelo;

import Interfaces.OperacionCRUD2;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Grover
 */
public class OperacionDAO2 extends Conexion implements OperacionCRUD2 {

    @Override
    public boolean registrar(Operacion2 np) throws Exception {
        try {
            String sql = "INSERT INTO operacion2(idventa2,numref,tarjeta, monto) VALUES (?,?,?,?)";
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setInt(1, np.getIdventa2());
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
    public boolean modificar(Operacion2 np) throws Exception {
        try {
            String sql = ("UPDATE operacion2 SET idventa2 = ?,numref = ?,tarjeta = ?, monto=? WHERE idoperacion=?");
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setInt(1, np.getIdventa2());
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
            String sql = ("UPDATE operacion2 SET numref = 0,tarjeta = 0, monto=0 WHERE idoperacion2 = ?");
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
    public List<Operacion2> listar() throws Exception {
        List<Operacion2> li = new ArrayList<>();
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("SELECT * FROM operacion2");
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                Operacion2 op = new Operacion2();
                op.setIdoperacion2(res.getInt(1));
                op.setIdventa2(res.getInt(2));
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

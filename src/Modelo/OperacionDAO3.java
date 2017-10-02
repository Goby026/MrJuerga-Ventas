package Modelo;

import Interfaces.OperacionCRUD3;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Grover
 */
public class OperacionDAO3 extends Conexion implements OperacionCRUD3 {

    @Override
    public boolean registrar(Operacion3 np) throws Exception {
        try {
            String sql = "INSERT INTO operacion3(idventa3,numref,tarjeta, monto) VALUES (?,?,?,?)";
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setInt(1, np.getIdventa3());
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
    public boolean modificar(Operacion3 np) throws Exception {
        try {
            String sql = ("UPDATE operacion3 SET idventa3 = ?,numref = ?,tarjeta = ?, monto=? WHERE idoperacion3=?");
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setInt(1, np.getIdventa3());
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
            String sql = ("UPDATE operacion3 SET numref = 0,tarjeta = 0, monto=0 WHERE idoperacion3 = ?");
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
    public List<Operacion3> listar() throws Exception {
        List<Operacion3> li = new ArrayList<>();
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("SELECT * FROM operacion3");
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                Operacion3 op = new Operacion3();
                op.setIdoperacion3(res.getInt(1));
                op.setIdventa3(res.getInt(2));
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

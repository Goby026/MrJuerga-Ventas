package Modelo;

import Interfaces.Operacion_npCRUD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Grover
 */
public class Operacion_npDAO extends Conexion implements Operacion_npCRUD {

    @Override
    public boolean registrar(Operacion_np np) throws Exception {
        try {
            String sql = "INSERT INTO operacion_np(idnpbarra,numref,tarjeta, monto) VALUES (?,?,?,?)";
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setInt(1, np.getIdnpbarra());
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
    
    public boolean registrar2(Operacion_np np) throws Exception {
        try {
            String sql = "INSERT INTO operacion_np2(idnpbarra2,numref,tarjeta, monto) VALUES (?,?,?,?)";
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setInt(1, np.getIdnpbarra());
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
    
    public boolean registrar3(Operacion_np np) throws Exception {
        try {
            String sql = "INSERT INTO operacion_np3(idnpbarra3,numref,tarjeta, monto) VALUES (?,?,?,?)";
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setInt(1, np.getIdnpbarra());
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
    public boolean modificar(Operacion_np np) throws Exception {
        try {
            String sql = ("UPDATE operacion_np SET idnpbarra = ?,numref = ?,tarjeta = ?, monto=? WHERE idoperacion_np=?");
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setInt(1, np.getIdnpbarra());
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
            String sql = ("UPDATE operacion_np SET numref = 0,tarjeta = 0, monto=0 WHERE idoperacion_np=?");
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
    public List<Operacion_np> listar() throws Exception {
        List<Operacion_np> li = new ArrayList<>();
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("SELECT * FROM operacion_np");
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                Operacion_np cat = new Operacion_np();
                cat.setIdoperacion_np(res.getInt(1));
                cat.setIdnpbarra(res.getInt(2));
                cat.setNumref(res.getString(3));
                cat.setTarjeta(res.getString(4));
                cat.setMonto(res.getDouble(5));
                li.add(cat);
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
    
    public int getUltimaNotaPedido() throws SQLException, Exception{
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("SELECT idoperacion_np FROM operacion_np ORDER BY idoperacion_np DESC LIMIT 1");
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                return res.getInt(1);
            }
            pst.close();
            res.close();
        } catch (Exception e) {
            throw e;
        }finally{
            this.cerrar();
        }
        return 0;
    }

}

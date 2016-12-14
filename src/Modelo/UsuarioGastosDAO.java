
package Modelo;

import Interfaces.UsuarioGastosCRUD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marce
 */
public class UsuarioGastosDAO extends Conexion implements UsuarioGastosCRUD{

    @Override
    public boolean registrar(UsuarioGastos ug) throws Exception {
        try {
            String sql = "insert into usuariogastos (idGastos, idusuario, monto) values (?,?,?)";
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setInt(1, ug.getIdGastos());
            pst.setInt(2, ug.getIdUsuario());
            pst.setDouble(3, ug.getMonto());
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
    public boolean modificar(UsuarioGastos ug) throws Exception {
        try {
            String sql = ("UPDATE usuariogastos set idGastos = ?, idusuario= ?, monto=? where idUsuarioGastos=?");
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setInt(1, ug.getIdGastos());
            pst.setInt(2, ug.getIdUsuario());
            pst.setDouble(3, ug.getMonto());
            pst.setInt(4, ug.getIdUsuarioGastos());
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
    public boolean eliminar(UsuarioGastos ug) throws Exception {
        try {
            String sql = ("delete from usuariogastos where idUsuarioGastos=?");
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setInt(1, ug.getIdUsuarioGastos());
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
    public List<UsuarioGastos> listar() throws Exception {
        List<UsuarioGastos> lista = null;
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("select * from usuariogastos");
            lista = new ArrayList();
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                UsuarioGastos ug = new UsuarioGastos();
                ug.setIdUsuarioGastos(rs.getInt("idUsuarioGastos"));
                ug.setIdGastos(rs.getInt("idGastos"));
                ug.setIdUsuario(rs.getInt("idusuario"));
                ug.setMonto(rs.getDouble("monto"));
                lista.add(ug);
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
    
}


package Modelo;

import Interfaces.UsuarioPerfilCRUD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marce
 */
public class UsuarioPerfilDAO extends Conexion implements UsuarioPerfilCRUD{

    @Override
    public boolean registrar(UsuarioPerfil up) throws Exception {
        try {
            String sql = "insert into usuarioperfil (idusuario, idperfil) values (?,?)";
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setInt(1, up.getIdusuario());
            pst.setInt(2, up.getIdperfil());
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
    public boolean modificar(UsuarioPerfil up) throws Exception {
        try {
            String sql = "update usuarioperfil set idusuario=?, idperfil=? where idusuarioperfil=?";
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setInt(1, up.getIdusuario());
            pst.setInt(2, up.getIdperfil());
            pst.setInt(3, up.getIdusuarioperfil());
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
    public boolean eliminar(UsuarioPerfil up) throws Exception {
        try {
            String sql = ("delete from usuarioperfil where idusuarioperfil=?");
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setInt(1, up.getIdusuarioperfil());
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
    public List<UsuarioPerfil> listar() throws Exception {
        List<UsuarioPerfil> lista = null;
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("select * from usuarioperfil");
            lista = new ArrayList();
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                UsuarioPerfil up = new UsuarioPerfil();
                up.setIdusuarioperfil(rs.getInt("idusuarioperfil"));
                up.setIdusuario(rs.getInt("idusuario"));
                up.setIdperfil(rs.getInt("idperfil"));
                lista.add(up);
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
    
    public String getPerfilConIdDeUsuario(int idUsuario) throws Exception {
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("select perfil.descripcion from usuario \n"
                    + "inner join usuarioperfil on usuario.idusuario = usuarioperfil.idusuario \n"
                    + "inner join perfil on usuarioperfil.idperfil = perfil.idperfil\n"
                    + "where usuario.idusuario="+idUsuario+"");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                return rs.getString("perfil.descripcion");
            }
            rs.close();
            pst.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return null;
    }
    
}

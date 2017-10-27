package Controlador;

import Modelo.Conexion;
import Modelo.Usuario;
import Modelo.UsuarioDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginControl {

//    public boolean validar(String usuario, String pass) throws Exception{
//        try {
//            UsuarioDAO udao = new UsuarioDAO();
//            for (Usuario u : udao.listar()) {
//                if (u.getUsuario().equals(usuario)) {
//                    if (u.getPass().equals(pass)) {
//                        return true;
//                    }
//                }
//            }
//        } catch (Exception e) {
//            throw e;
//        }
//        return false;
//    }
    public boolean validar(String usuario, String pass) throws Exception {
        Conexion con = new Conexion();
        try {
            con.conectar();
            String sql = "select * from usuario where usuario = ? and pass = ?";
            PreparedStatement pst = con.getConexion().prepareStatement(sql);
            pst.setString(1, usuario);
            pst.setString(2, pass);
            ResultSet res = pst.executeQuery();

            if (res.next()) {
                return true;
            }

            pst.close();
            res.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            con.cerrar();
        }
        return false;
    }

    //metodo para obtener el id de usuario cob su nombre de usuario
    public int getIdUsuarioConNombre(String nombre) throws Exception {
        try {
            UsuarioDAO udao = new UsuarioDAO();
            for (Usuario u : udao.listar()) {
                if (u.getUsuario().equals(nombre)) {
                    return u.getId();
                }
            }
        } catch (Exception ex) {
            throw ex;
        }
        return -1;
    }

}

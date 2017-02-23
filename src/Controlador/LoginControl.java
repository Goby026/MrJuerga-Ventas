
package Controlador;

import Modelo.Usuario;
import Modelo.UsuarioDAO;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginControl {
    public boolean validar(String usuario, String pass) throws Exception{
        try {             
            UsuarioDAO udao = new UsuarioDAO();
            for (Usuario u : udao.listar()) {
                if (u.getUsuario().equals(usuario)) {
                    if (u.getPass().equals(pass)) {
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            throw e;
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


package Modelo;

/**
 *
 * @author Marce
 */
public class UsuarioPerfil {
    int idusuarioperfil, idusuario,idperfil;
    
    public UsuarioPerfil(){
    }

    public UsuarioPerfil(int idusuarioperfil, int idusuario, int idperfil) {
        this.idusuarioperfil = idusuarioperfil;
        this.idusuario = idusuario;
        this.idperfil = idperfil;
    }

    public int getIdusuarioperfil() {
        return idusuarioperfil;
    }

    public void setIdusuarioperfil(int idusuarioperfil) {
        this.idusuarioperfil = idusuarioperfil;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public int getIdperfil() {
        return idperfil;
    }

    public void setIdperfil(int idperfil) {
        this.idperfil = idperfil;
    }
    
    
}

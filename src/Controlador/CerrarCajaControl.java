
package Controlador;

import Modelo.Caja;
import Modelo.CajaDAO;
import Modelo.FlujoCaja;
import Modelo.FlujoCajaDAO;
import Modelo.Usuario;
import Modelo.UsuarioDAO;

/**
 *
 * @author Marce
 */
public class CerrarCajaControl {
    
    public double getSaldoInicial(int idFlujoCaja) throws Exception{
        try {
            FlujoCajaDAO fcdao = new FlujoCajaDAO();
            for (FlujoCaja fc : fcdao.Listar()) {
                if (fc.getIdFlujoCaja()==idFlujoCaja) {
                    return fc.getSaldo();
                }
            }
        } catch (Exception e) {
            throw e;
        }
        return 0.0;
    }
    
    /*METODO PARA OBTENER EL ID DE USUARIO CON EL NOMBRE*/
    public int getIdUsuario(String usuario) throws Exception {
        try {
            UsuarioDAO udao = new UsuarioDAO();
            for (Usuario u : udao.listar()) {
                if (u.getUsuario().equals(usuario)) {
                    return u.getId();
                }
            }
            return 0;
        } catch (Exception e) {
            throw e;
        }
    }
    
    /*METODO PARA OBTENER EL ID DE CAJA CON SU NOMBRE*/
    public int getIdCaja(String nomCaja) throws Exception {
        try {
            CajaDAO cdao = new CajaDAO();
            for (Caja c : cdao.Listar()) {
                if (c.getNomCaja().equals(nomCaja)) {
                    return c.getIdCaja();
                }
            }
            return -1;
        } catch (Exception e) {
            throw e;
        }
    }
}

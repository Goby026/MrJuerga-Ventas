
package Controlador;

import Modelo.Gasto;
import Modelo.GastoDAO;
import javax.swing.DefaultListModel;
import javax.swing.JList;

/**
 *
 * @author Marce
 */
public class GastosControl {
    DefaultListModel modeloLista = new DefaultListModel();
    public void cargarListaGastos(JList lista) throws Exception{
        try {
            GastoDAO gdao = new GastoDAO();
            for (Gasto g : gdao.Listar()) {
                modeloLista.addElement(g.getConcepto());
            }
            lista.setModel(modeloLista);
        } catch (Exception e) {
            throw e;
        }
    }
    
    //metodo para registrar gasto
    public void registrarGasto(String concepto){
        try {
            //obtener el id de gasto seleccionado
            //obtener el id de usuario
            //obtener el monto fecha hora ¿usuario pagado?
        } catch (Exception e) {
        }
    }
}

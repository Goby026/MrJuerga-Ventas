/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.UsuarioCajaDAO;
import Modelo.VentaProductoDAO;

/**
 *
 * @author Marce
 */
public class Pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
//        int opc = JOptionPane.showConfirmDialog(null, "¿Esta seguro?");
//        System.out.println(opc);        

//        for (int i = 0; i < new VentaProductoDAO().getDatosTabla(7).size(); i++) {
//            System.out.println(new VentaProductoDAO().getDatosTabla(7).get(i).getProducto());
//            System.out.println(new VentaProductoDAO().getDatosTabla(7).get(i).getPrecio());
//        }
        try {
            if (new UsuarioCajaDAO().updateUsuarioCaja(4, 2)) {
                System.out.println("se actualizo la caja del usuario " + 2);
            } else {
                System.out.println("ERROR de registro");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

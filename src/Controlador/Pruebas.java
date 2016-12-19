/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ProductoPresentacionDAO;

/**
 *
 * @author Marce
 */
public class Pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            ProductoPresentacionDAO pdao = new ProductoPresentacionDAO();
            System.out.println(new VentasControl().getStockProductoPresentacion(10, 1));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
}

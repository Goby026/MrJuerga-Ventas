/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.NpBarrasControl;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLException;

/**
 *
 * @author MARCEL
 */
public class prueba {
    public static void main(String[] args) throws SQLException
{
      NpBarrasControl np = new NpBarrasControl();
      
      int res = np.getStockProductoPresentacion(252);
      
      System.out.println(res);
}
}

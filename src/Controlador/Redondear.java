
package Controlador;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Redondear {
    public double Redondear(double numero) {
        return Math.rint(numero * 100) / 100;
    }
    
    public BigDecimal Redondear2Digitos(double numero){
      String val = numero+"";
      BigDecimal big = new BigDecimal(val);
      big = big.setScale(2, RoundingMode.HALF_UP);
      //System.out.println("Número : "+big);
      return big;
    }
}

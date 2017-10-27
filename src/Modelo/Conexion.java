package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    protected Connection conexion;
//  JDBC driver nombre y base de datos
    private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
//  Credenciales de bd

//conexion LOCAL
  private final String DB_URL = "jdbc:mysql://localhost/mrjuerga_barras";
  private final String USER ="root";
  private final String PASS ="";

//conexion SERVIDOR
//    private final String DB_URL = "jdbc:mysql://192.168.1.57:3306/mrjuerga";
//    private final String USER = "mrjuerga";
//    private final String PASS = "mrjuerga";

    public void conectar() throws Exception {
        try {
            conexion = DriverManager.getConnection(DB_URL, USER, PASS);
            Class.forName(JDBC_DRIVER);
        } catch (Exception e) {
            throw e;
        }
    }

    public Connection getConexion() {
        return conexion;
    }

    public void cerrar() throws SQLException {
        if (conexion != null) {
            if (!conexion.isClosed()) {
                conexion.close();
            }
        }
    }

}


package nutricionista.AccesoADatos;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Coneccion {

    private static final String URL = "jdbc:mariadb://localhost/";
    private static final String DB = "nutricionista";
    private static final String USUARIO = "root";
    private static final String PASSWORD = "";
    private static Connection connection;

    private Coneccion() {
    }

    public static Connection getConexion() {

        if (connection == null) {
            try {
                Class.forName("org.mariadb.jdbc.Driver");
                connection = DriverManager.getConnection(URL + DB, USUARIO, PASSWORD);
                //JOptionPane.showMessageDialog(null, "Conección exitosa");
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Error al cargar los drivers:");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error de coneccion:");
            }

        }
        return connection;
    }
}

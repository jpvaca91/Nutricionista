
package nutricionista.AccesoADatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import nutricionista.Entidades.Comida;



public class ComidaData {
    
    private Connection con = null;
    
    public ComidaData() {
        con = Coneccion.getConexion();
    
}
    
    public void guardarComida(Comida comida){
        
       
        String sql = "INSERT INTO comida (nombre, detalle, cantCalorias, idComida) VALUES (?,?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, comida.getNombre());
            ps.setString(2, comida.getDetalle());
            ps.setInt(3, comida.getCantCalorias());
            ps.setInt(4, comida.getIdComidas());

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                comida.setIdComidas(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Comida guardada");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla comida" + ex);
        }
    }
}

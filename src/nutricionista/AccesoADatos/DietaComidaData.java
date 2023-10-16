
package nutricionista.AccesoADatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import nutricionista.Entidades.DietaComida;
import org.mariadb.jdbc.Statement;


public class DietaComidaData {
    
     private Connection con = null;

    public DietaComidaData() {
        con = Coneccion.getConexion();
    
}
    public void GuardarDietaComida(DietaComida dietaComida){
        
        String sql="INSERT INTO dietacomida(comida, dieta, horario) VALUES (?, ?,?)";
        
         try {
             PreparedStatement ps= con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
             ps.setInt(1, dietaComida.getComida().getIdComidas());
             ps.setInt(2, dietaComida.getDieta().getIdDieta());
             ps.setString(3, dietaComida.getHorario().toString());
             
             ps.executeUpdate();
             ResultSet rs=ps.getGeneratedKeys();
             
             if(rs.next()){
                 
                 
                 JOptionPane.showMessageDialog(null,"Comida asignada correctamente al paciente" );
             }
             ps.close();
             
         } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null ,"Error al acceder a la bd Dietacomida" +ex);
         }
         
    }
}

package nutricionista.AccesoADatos;

import static java.lang.String.valueOf;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import nutricionista.Entidades.Historial;
import java.lang.Integer;
import nutricionista.Entidades.Paciente;


public class HistorialData {
    
     private Connection con = null;
    
    public HistorialData() {
        con = Coneccion.getConexion();
    
}
    public List<Historial> listarHorarios() {

        String sql = "SELECT idHistorial, paciente, peso, fechaRegistro FROM historial ";
        ArrayList<Historial> horarios = new ArrayList<>();
       Paciente paciente=new Paciente();
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Historial horario = new Historial();
                horario.setIdHistorial(rs.getInt("idHistorial"));
                paciente.setIdPaciente(rs.getInt("paciente"));
                horario.setPaciente(paciente);
                horario.setPeso(rs.getDouble("peso"));
                horario.setFechaRegistro(rs.getDate("fechaRegistro").toLocalDate());
             

                horarios.add(horario);

            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Historial" + ex);
        }
        return horarios;
    }
}
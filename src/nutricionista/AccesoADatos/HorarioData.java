
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
import nutricionista.Entidades.Horario;
import java.lang.Integer;
import nutricionista.Entidades.Paciente;


public class HorarioData {
    
     private Connection con = null;
    
    public HorarioData() {
        con = Coneccion.getConexion();
    
}
    public List<Horario> listarHorarios() {

        String sql = "SELECT idHistorial, paciente, peso, fechaRegistro FROM historial ";
        ArrayList<Horario> horarios = new ArrayList<>();
       Paciente paciente=new Paciente();
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Horario horario = new Horario();
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
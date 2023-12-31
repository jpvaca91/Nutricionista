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
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import nutricionista.Entidades.Paciente;

public class HistorialData {

    private Connection con = null;

    public HistorialData() {
        con = Coneccion.getConexion();

    }

    public List<Historial> listarHorarios() {

        String sql = "SELECT idHistorial, paciente, peso, fechaRegistro FROM historial ";
        ArrayList<Historial> horarios = new ArrayList<>();
        Paciente paciente = new Paciente();
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

    public void guardarHistorial(Historial historial) {

        String sql = "INSERT INTO historial (paciente, peso, fechaRegistro, estado) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, historial.getPaciente().getIdPaciente());
            ps.setDouble(2, historial.getPeso());
            ps.setDate(3, Date.valueOf(historial.getFechaRegistro()));
            ps.setBoolean(4, historial.isEstado());

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                //  JOptionPane.showMessageDialog(null, "Historial actualizado");
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Historial" + ex);
        }
    }

    public void eliminarHistorial(Historial historial) {

        String sql = "DELETE FROM historial WHERE idHistorial=?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, historial.getIdHistorial());
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "eliminado correctamente");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el Historial de la BD: " + ex);
        }
    }

    public List<Historial> buscarHistorial(Paciente paciente) {
        ArrayList<Historial> listaH = new ArrayList<>();

        String sql = "SELECT peso, fechaRegistro, idHistorial FROM historial WHERE paciente=?";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, paciente.getIdPaciente());
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Historial historial = new Historial();
                historial.setIdHistorial(rs.getInt("idHistorial"));
                historial.setFechaRegistro(rs.getDate("fechaRegistro").toLocalDate());
                historial.setPeso(rs.getDouble("peso"));

                listaH.add(historial);
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Historial " + ex);
        }

        return listaH;
    }
}

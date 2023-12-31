package nutricionista.AccesoADatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import nutricionista.Entidades.Paciente;
import org.mariadb.jdbc.Statement;

public class PacienteData {

    private Connection con = null;

    public PacienteData() {
        con = Coneccion.getConexion();

    }

    public void guardarPaciente(Paciente paciente) {
        String sql = "INSERT INTO paciente (nombre,dni,domicilio,telefono,estado)"
                + "VALUE (?,?,?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, paciente.getNombre());
            ps.setInt(2, paciente.getDni());
            ps.setString(3, paciente.getDomicilio());
            ps.setString(4, paciente.getTelefono());
            ps.setBoolean(5, paciente.isEstado());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                paciente.setIdPaciente(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Paciente guardado");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectar a la Base de Datos" + ex);
        }

    }

/*    public void guardarPacienteSinDni(Paciente paciente) {
        String sql = "INSERT INTO paciente (nombre,domicilio,telefono,estado)"
                + "VALUE (?,?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, paciente.getNombre());
            ps.setString(2, paciente.getDomicilio());
            ps.setString(3, paciente.getTelefono());
            ps.setBoolean(4, paciente.isEstado());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                paciente.setIdPaciente(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Paciente actualizado");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectar a la Base de Datos" + ex);
        }

    }*/

    public void actualizarPaciente(Paciente paciente) {
        String sql = "UPDATE paciente SET nombre=?, dni=?, domicilio=?, telefono=?, estado=?"
                + " WHERE DNI=?";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, paciente.getNombre());
            ps.setInt(2, paciente.getDni());
            ps.setString(3, paciente.getDomicilio());
            ps.setString(4, paciente.getTelefono());
            ps.setBoolean(5, paciente.isEstado());
            ps.setInt(6, paciente.getDni());

            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Paciente actualizado");
              //  guardarPacienteSinDni(paciente);

            } else {
                JOptionPane.showMessageDialog(null, "No existe el paciente");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla paciente" + ex);

        }
    }

    public void actualizarEstado(Paciente paciente) {
        String sql = "UPDATE paciente SET estado=? WHERE DNI=?";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setBoolean(1, paciente.getEstado());
            ps.setInt(2, paciente.getDni());

            int exito = ps.executeUpdate();
            if (exito == 1) {
               // JOptionPane.showMessageDialog(null, "Paciente actualizado");

            } else {
                JOptionPane.showMessageDialog(null, "No existe el paciente");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla paciente" + ex);

        }
    }

    public void eliminarPaciente(int dni) {
        String sql = "UPDATE paciente SET estado=0 WHERE dni =? AND dni not in (SELECT idDieta FROM dieta WHERE paciente=?);";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, dni);
            ps.setInt(2, dni);

            int exito = ps.executeUpdate();
            if (exito == 1) {

                JOptionPane.showMessageDialog(null, "Paciente pasó a inactivo");

            } else {
                JOptionPane.showMessageDialog(null, "Paciente no encontrado o ya tiene asignada una Dieta");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla paciente");
        }

    }

    public Paciente buscarPaciente(int dni) {

        String sql = "SELECT nombre, domicilio, telefono,estado, idPaciente FROM paciente WHERE DNI= ? ";
        Paciente paciente = null;

        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, dni);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                paciente = new Paciente();
                paciente.setDni(dni);
                paciente.setNombre(rs.getString("nombre"));
                paciente.setDomicilio(rs.getString("domicilio"));
                paciente.setTelefono(rs.getString("telefono"));
                paciente.setEstado(rs.getBoolean("estado"));
                paciente.setIdPaciente(rs.getInt("idPaciente"));

            } else {
                JOptionPane.showMessageDialog(null, "paciente no encontrado");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla paciente");
        }
        return paciente;
    }

    public List<Paciente> listarPacientes() {

        String sql = "SELECT idPaciente, nombre, dni, domicilio, telefono FROM paciente WHERE estado=1 ";
        ArrayList<Paciente> pacientes = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Paciente paciente = new Paciente();
                paciente.setIdPaciente(rs.getInt("idPaciente"));
                paciente.setNombre(rs.getString("nombre"));
                paciente.setDni(rs.getInt("dni"));
                paciente.setDomicilio(rs.getString("domicilio"));
                paciente.setTelefono(rs.getString("telefono"));

                paciente.setEstado(true);

                pacientes.add(paciente);

            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla pacientes" + ex);
        }
        return pacientes;
    }

    public Paciente buscarPacientePorId(int idPaciente) {

        String sql = "SELECT dni, nombre, domicilio, telefono,estado, idPaciente FROM paciente WHERE idPaciente= ? ";
        Paciente paciente = null;

        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, idPaciente);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                paciente = new Paciente();
                paciente.setDni(rs.getInt("dni"));
                paciente.setNombre(rs.getString("nombre"));
                paciente.setDomicilio(rs.getString("domicilio"));
                paciente.setTelefono(rs.getString("telefono"));
                paciente.setEstado(rs.getBoolean("estado"));
                paciente.setIdPaciente(rs.getInt("idPaciente"));

            } else {
                JOptionPane.showMessageDialog(null, "paciente no encontrado");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla paciente");
        }
        return paciente;
    }
}

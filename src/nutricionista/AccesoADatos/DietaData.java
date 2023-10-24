
package nutricionista.AccesoADatos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import nutricionista.Entidades.Dieta;
import nutricionista.Entidades.DietaComida;
import nutricionista.Entidades.Paciente;
import org.mariadb.jdbc.Statement;

public class DietaData {

    private Connection con = null;

    public DietaData() {
        con = Coneccion.getConexion();
    }

    public void guardarDieta(Dieta dieta) {
        String sql = "INSERT INTO dieta (paciente,fechaInicial,pesoInicial,pesoFinal,fechaFinal,fechaActual,pesoActual)"
                + "VALUE (?,?,?,?,?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, dieta.getPaciente().getIdPaciente());
            ps.setDate(2, Date.valueOf(dieta.getFechaInicial()));
            ps.setDouble(3, dieta.getPesoInicial());
            ps.setDouble(4, dieta.getPesoFinal());
            ps.setDate(5, Date.valueOf(dieta.getFechaFinal()));
            ps.setDate(6, Date.valueOf(dieta.getFechaInicial()));
            ps.setDouble(7, dieta.getPesoInicial());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                dieta.setIdDieta(rs.getInt(1));
               // JOptionPane.showMessageDialog(null, "Datos guardados");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos" + ex);
        }

    }

    public void actualizarDieta(Dieta dieta) {
        String sql = "UPDATE dieta SET fechaInicial=?,pesoInicial=?,pesoFinal=?,fechaFinal=?"
                + " WHERE paciente=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setDate(1, Date.valueOf(dieta.getFechaInicial()));
            ps.setDouble(2, dieta.getPesoInicial());
            ps.setDouble(3, dieta.getPesoFinal());
            ps.setDate(4, Date.valueOf(dieta.getFechaFinal()));
            ps.setInt(5, dieta.getPaciente().getIdPaciente());

            int exito = ps.executeUpdate();
            if (exito == 1) {
                //JOptionPane.showMessageDialog(null, "Dieta actualizada");
                ps.close();
            } else {
                guardarDieta(dieta);

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla dieta"+ex);
        }

    }

    public void actualizarHistorial(Dieta dieta) {
        String sql = "UPDATE dieta SET pesoActual=?, fechaActual=? WHERE paciente=?";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setDouble(1, dieta.getPesoActual());
            ps.setDate(2, Date.valueOf(dieta.getFechaActual()));
            ps.setInt(3, dieta.getPaciente().getIdPaciente());

            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Historial actualizado");
                ps.close();
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla dieta");
        }

    }

    public Dieta buscarDietaCompleta(Paciente paciente) {

        String sql = "Select fechaInicial, pesoInicial, pesoFinal, idDieta, pesoActual, fechaActual, fechaFinal from dieta where paciente=?";
        Dieta dieta = null;

        PreparedStatement ps;

        try {
            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, paciente.getIdPaciente());

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                dieta = new Dieta();
                dieta.setFechaInicial(rs.getDate("fechaInicial").toLocalDate());
                dieta.setPesoInicial(rs.getDouble("pesoInicial"));
                dieta.setPesoFinal(rs.getDouble("pesoFinal"));
                dieta.setIdDieta(rs.getInt("idDieta"));
                dieta.setPesoActual(rs.getDouble("pesoActual"));
                dieta.setFechaActual(rs.getDate("fechaActual").toLocalDate());
                dieta.setFechaFinal(rs.getDate("fechaFinal").toLocalDate());

            } else {
                JOptionPane.showMessageDialog(null, "Dieta no encontrada");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla paciente");
        }
        return dieta;
    }

    public Dieta buscarDieta(Paciente paciente) {

        String sql = "Select fechaInicial, pesoInicial, pesoFinal, idDieta, fechaFinal from dieta where paciente=?";
        Dieta dieta = null;

        PreparedStatement ps;

        try {
            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, paciente.getIdPaciente());

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                dieta = new Dieta();
                dieta.setFechaInicial(rs.getDate("fechaInicial").toLocalDate());
                dieta.setPesoInicial(rs.getDouble("pesoInicial"));
                dieta.setPesoFinal(rs.getDouble("pesoFinal"));
                dieta.setIdDieta(rs.getInt("idDieta"));
                dieta.setFechaFinal(rs.getDate("fechaFinal").toLocalDate());

            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla paciente");
        }
        return dieta;
    }

    public void eliminarDieta(int idPaciente) {

        String sql = "DELETE FROM dieta WHERE paciente=?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idPaciente);

            int exito = ps.executeUpdate();
            if (exito == 1) {

                JOptionPane.showMessageDialog(null, "Datos iniciales de la Dieta eliminada");

            } else {
                JOptionPane.showMessageDialog(null, "Dieta no encontrada");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla dieta." + ex);
        }

    }

    public Dieta buscarDietaPorId(int idDieta) {

        String sql = "Select paciente, fechaInicial, pesoInicial, pesoFinal, idDieta from dieta where idDieta=?";
        Dieta dieta = null;
        Paciente paciente = null;
        PreparedStatement ps;

        try {
            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, idDieta);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                dieta = new Dieta();
                paciente = new Paciente();
                int idPaciente = rs.getInt("paciente");
                PacienteData pd = new PacienteData();

                dieta.setPaciente(pd.buscarPacientePorId(idPaciente));
                dieta.setFechaInicial(rs.getDate("fechaInicial").toLocalDate());
                dieta.setPesoInicial(rs.getDouble("pesoInicial"));
                dieta.setPesoFinal(rs.getDouble("pesoFinal"));
                dieta.setIdDieta(rs.getInt("idDieta"));

            } else {
                JOptionPane.showMessageDialog(null, "Dieta no encontrada");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla paciente");
        }
        return dieta;
    }

    public List<Dieta> listarTodasLasDietas() {
        ArrayList<Dieta> dieta = new ArrayList<>();

        String sql = "SELECT idDieta, paciente, fechaActual, pesoFinal, pesoActual, fechaFinal,pesoInicial FROM dieta";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Dieta d = new Dieta();
                Paciente p = new Paciente();
                PacienteData pd = new PacienteData();
                p = pd.buscarPacientePorId((rs.getInt("paciente")));

                d.setPaciente(p);
                d.setIdDieta(rs.getInt("idDieta"));
                d.setFechaActual(rs.getDate("fechaActual").toLocalDate());
                d.setPesoFinal(rs.getDouble("pesoFinal"));
                d.setPesoActual(rs.getDouble("pesoActual"));
                d.setFechaFinal(rs.getDate("fechaFinal").toLocalDate());
                d.setPesoInicial(rs.getDouble("pesoInicial"));

                dieta.add(d);
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Dieta" + ex);
        }

        return dieta;
    }
    
     public List<Dieta> listarDietasActivas() {
        ArrayList<Dieta> dieta = new ArrayList<>();

        String sql = "SELECT idDieta, paciente, fechaActual, pesoFinal, pesoActual, fechaFinal,pesoInicial, idPaciente, estado "
                + "FROM dieta, paciente WHERE dieta.paciente= paciente.idPaciente AND estado=1";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Dieta d = new Dieta();
                Paciente p = new Paciente();
                PacienteData pd = new PacienteData();
                p = pd.buscarPacientePorId((rs.getInt("paciente")));

                d.setPaciente(p);
                d.setIdDieta(rs.getInt("idDieta"));
                d.setFechaActual(rs.getDate("fechaActual").toLocalDate());
                d.setPesoFinal(rs.getDouble("pesoFinal"));
                d.setPesoActual(rs.getDouble("pesoActual"));
                d.setFechaFinal(rs.getDate("fechaFinal").toLocalDate());
                d.setPesoInicial(rs.getDouble("pesoInicial"));

                dieta.add(d);
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Dieta" + ex);
        }

        return dieta;
    }
     
     public List<Dieta> listarDietasInactivas() {
        ArrayList<Dieta> dieta = new ArrayList<>();

        String sql = "SELECT idDieta, paciente, fechaActual, pesoFinal, pesoActual, fechaFinal,pesoInicial, idPaciente, estado "
                + "FROM dieta, paciente WHERE dieta.paciente= paciente.idPaciente AND estado=0";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Dieta d = new Dieta();
                Paciente p = new Paciente();
                PacienteData pd = new PacienteData();
                p = pd.buscarPacientePorId((rs.getInt("paciente")));

                d.setPaciente(p);
                d.setIdDieta(rs.getInt("idDieta"));
                d.setFechaActual(rs.getDate("fechaActual").toLocalDate());
                d.setPesoFinal(rs.getDouble("pesoFinal"));
                d.setPesoActual(rs.getDouble("pesoActual"));
                d.setFechaFinal(rs.getDate("fechaFinal").toLocalDate());
                d.setPesoInicial(rs.getDouble("pesoInicial"));

                dieta.add(d);
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Dieta" + ex);
        }

        return dieta;
    }
}

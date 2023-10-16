/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nutricionista.AccesoADatos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
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
        String sql = "INSERT INTO dieta (paciente,fechaInicial,pesoInicial,pesoFinal)"
                + "VALUE (?,?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, dieta.getPaciente().getIdPaciente());
            ps.setDate(2, Date.valueOf(dieta.getFechaInicial()));
            ps.setDouble(3, dieta.getPesoInicial());
            ps.setDouble(4, dieta.getPesoFinal());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                dieta.setIdDieta(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Datos guardados");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos" + ex);
        }

    }

    public void actualizarDieta(Dieta dieta) {
        String sql = "UPDATE dieta SET fechaInicial=?,pesoInicial=?,pesoFinal=?"
                + " WHERE paciente=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setDate(1, Date.valueOf(dieta.getFechaInicial()));
            ps.setDouble(2, dieta.getPesoInicial());
            ps.setDouble(3, dieta.getPesoFinal());
            ps.setInt(4, dieta.getPaciente().getIdPaciente());

            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Dieta actualizada");
                ps.close();
            } else {
                guardarDieta(dieta);

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla dieta");
        }

    }

    public Dieta buscarDieta(Paciente paciente) {

        String sql = "Select fechaInicial, pesoInicial, pesoFinal, idDieta from dieta where paciente=?";
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
            } else {
                JOptionPane.showMessageDialog(null, "Dieta no encontrada");
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
  /*  public void guardarDietaComida(DietaComida dietacomida) {
        String sql = "INSERT INTO dietacomida (horario)"
                + "VALUES (?) AND comida (nombre,detalle,cantCalorias) VALUES (?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, dietacomida.getPaciente().getIdPaciente());
            ps.setString(2, comida.getNombre());
            ps.setString(3, comida.getDetalle());
            ps.setInt(4, comida.getCantCalorias());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                dietacomida.setIdPaciente(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Datos guardados");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos" + ex);
        }

    }*/
}

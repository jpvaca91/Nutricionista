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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import nutricionista.Entidades.Dieta;
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
                JOptionPane.showMessageDialog(null, "Dieta guardada");
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
            ps.setString(5, dieta.getPaciente().getNombre());

            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Dieta actualizada");

            } else {
                JOptionPane.showMessageDialog(null, "No existe la Dieta");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumno");
        }

    }

}

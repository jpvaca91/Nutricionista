/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nutricionista.AccesoADatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
                
            } else {
                JOptionPane.showMessageDialog(null, "No existe el paciente");
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla paciente" + ex);
            
        }
    }
    
    public void eliminarPaciente(int dni) {
        String sql = "UPDATE paciente SET estado=0 WHERE dni =? AND dni not in (SELECT dni FROM dieta WHERE dni=?);";


        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, dni);
            ps.setInt(2, dni);
            
            int exito = ps.executeUpdate();
            if (exito == 1) {
                
                JOptionPane.showMessageDialog(null, "Paciente eliminado");
                
            } else {
                JOptionPane.showMessageDialog(null, "Paciente no encontrado o ya tiene asignada una Dieta");
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla paciente");
        }
        
    }
    
    public Paciente buscarPaciente(int dni) {
        
        String sql = "SELECT nombre, domicilio, telefono FROM paciente WHERE DNI= ? AND estado=1 ";
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
                paciente.setEstado(true);
                
            } else {
                JOptionPane.showMessageDialog(null, "paciente no encontrado");
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla paciente");
        }
        return paciente;
    }
}//obtenerPacientePorId-obtenerTodo

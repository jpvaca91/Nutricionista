package nutricionista.AccesoADatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import nutricionista.Entidades.Comida;

public class ComidaData {

    private Connection con = null;

    public ComidaData() {
        con = Coneccion.getConexion();

    }

    public void guardarComida(Comida comida) {

        String sql = "INSERT INTO comida (nombre, detalle, cantCalorias) VALUES (?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, comida.getNombre());
            ps.setString(2, comida.getDetalle());
            ps.setInt(3, comida.getCantCalorias());

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

    public void modificarComida(Comida comida) {

        String sql = "UPDATE comida SET detalle=?, cantCalorias=?, nombre=? WHERE idComida=?";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, comida.getDetalle());
            ps.setInt(2, comida.getCantCalorias());
            ps.setString(3, comida.getNombre());
            ps.setInt(4, comida.getIdComidas());

            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Comida actualizada");

            } else {
                JOptionPane.showMessageDialog(null, "No existe la comida");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla comida" + ex);

        }

    }

    public void eliminarComida(int idComida) {

        String sql = "DELETE FROM comida WHERE idComida=?";

        
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, idComida);

            int exito = ps.executeUpdate();
            if (exito == 1) {

                JOptionPane.showMessageDialog(null, "Comida eliminada");

            } else {
                JOptionPane.showMessageDialog(null, "Comida no encontrada");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al accedeer a la tabla comida");
        }
    }

    public List<Comida> listarComidas() {

        String sql = "SELECT nombre, cantCalorias, detalle, idComida FROM comida ";
        ArrayList<Comida> comidas = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Comida comida = new Comida();
                comida.setNombre(rs.getString("nombre"));
                comida.setCantCalorias(rs.getInt("cantCalorias"));
                comida.setDetalle(rs.getString("detalle"));
                comida.setIdComidas(rs.getInt("idComida"));
                

                comidas.add(comida);

            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla comidas" + ex);
        }
        return comidas;
    }

    public Comida buscarComida(String nombre) {
        String sql = "SELECT idComida, nombre, detalle, cantCalorias FROM comida WHERE nombre=? ";
        Comida comida = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, nombre);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                comida = new Comida();
                comida.setIdComidas(rs.getInt("idComida"));
                comida.setNombre(nombre);
                comida.setDetalle(rs.getString("detalle"));
                comida.setCantCalorias(rs.getInt("cantCalorias"));

            } else {
                JOptionPane.showMessageDialog(null, "Comida no encontrada");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla comida" + ex);
        }

        return comida;

    }
    
    public List<Comida> comidasAsignadas(int idComida) {
        ArrayList<Comida> comidas = new ArrayList<>();
       
        String sql = "SELECT  nombre, detalle, cantCalorias FROM comida"
                + " WHERE comida.idComida = dietacomida.idComida";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
           ps.setInt(1, idComida);
            ResultSet rs = ps.executeQuery();
        
            if(!rs.next())
                JOptionPane.showMessageDialog(null, "El paciente no tiene comidas asignadas");
            while (rs.next()) {
              
                Comida comida = new Comida();
                comida.setIdComidas(rs.getInt("idComida"));
                comida.setNombre(rs.getString("nombre"));
                comida.setDetalle(rs.getString("detalle"));
                comida.setCantCalorias(rs.getInt("cantCalorias"));
                comidas.add(comida);
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla comidas");
        }

        return comidas;

    }

     public Comida buscarComidaPorID(int idComida) {
        String sql = "SELECT idComida, nombre, detalle, cantCalorias FROM comida WHERE idComida=? ";
        Comida comida = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, idComida);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                comida = new Comida();
                comida.setIdComidas(rs.getInt("idComida"));
                comida.setNombre(rs.getString("nombre"));
                comida.setDetalle(rs.getString("detalle"));
                comida.setCantCalorias(rs.getInt("cantCalorias"));

            } else {
                JOptionPane.showMessageDialog(null, "Comida no encontrada");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla comida" + ex);
        }

        return comida;

    }
}

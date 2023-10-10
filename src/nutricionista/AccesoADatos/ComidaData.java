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
            ResultSet rs =ps.getGeneratedKeys();

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

        String sql = "UPDATE comida SET detalle=?, cantCalorias=? WHERE idComida=?";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, comida.getDetalle());
            ps.setInt(2, comida.getCantCalorias());
            ps.setInt(3, comida.getIdComidas());

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

    /* public void eliminarComida(String nombre) {

        String sql = "UPDATE comida SET  WHERE nombre=?";

       // PreparedStatement ps;
        try {
           PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            int dni = 0;

            ps.setInt(1, dni);
            int exito = ps.executeUpdate();
            if (exito == 1) {

                JOptionPane.showMessageDialog(null, "Comida eliminada");

            } else {
                JOptionPane.showMessageDialog(null, "Comida no encontrada");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al accedeer a la tabla comida");
        }
    }*/
    public List<Comida> listarComidas() {

        String sql = "SELECT nombre, cantCalorias, detalle FROM comida ";
        ArrayList<Comida> comidas = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Comida comida = new Comida();
                comida.setNombre(rs.getString("nombre"));
                comida.setCantCalorias(rs.getInt("cantCalorias"));
                comida.setDetalle(rs.getString("detalle"));

                comidas.add(comida);

            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla comidas" + ex);
        }
        return comidas;
    }

}

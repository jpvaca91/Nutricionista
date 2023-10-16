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
import nutricionista.Entidades.Comida;
import nutricionista.Entidades.Dieta;
import nutricionista.Entidades.DietaComida;
import nutricionista.Entidades.HorarioEspecifico;
import nutricionista.Entidades.Paciente;
import org.mariadb.jdbc.Statement;

public class DietaComidaData {

    private Connection con = null;

    public DietaComidaData() {
        con = Coneccion.getConexion();

    }

    public void GuardarDietaComida(DietaComida dietaComida) {

        String sql = "INSERT INTO dietacomida (comida, dieta, horario) VALUES (?, ?, ?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, dietaComida.getComida().getIdComidas());
            ps.setInt(2, dietaComida.getDieta().getIdDieta());
            ps.setString(3, dietaComida.getHorario().toString());

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {

                JOptionPane.showMessageDialog(null, "Comida asignada correctamente al paciente");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la bd Dietacomida" + ex);
        }

    }

    public List<Object> consultaPorPaciente(Dieta dieta) {
        List<Object> comidas = new ArrayList<>();

        String sql = "SELECT dietacomida.horario, comida.nombre, comida.detalle, comida.cantCalorias FROM "
                + " comida, dietacomida WHERE comida.idComida = dietacomida.comida AND dietacomida.dieta=? ";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, dieta.getIdDieta());
            ResultSet rs = ps.executeQuery();

            if (!rs.next()) {
                JOptionPane.showMessageDialog(null, "Error en el listado de comidas asignadas al paciente");
            }

            while (rs.next()) {

                if (rs.getString("horario") == "ALMUERZO") {
                    comidas.set(1,HorarioEspecifico.ALMUERZO);
                } else if (rs.getString("horario") == "DESAYUNO") {
                    comidas.set(1,HorarioEspecifico.DESAYUNO);

                } else if (rs.getString("horario") == "MERIENDA") {
                    comidas.set(1,HorarioEspecifico.MERIENDA);

                } else if (rs.getString("horario") == "CENA") {
                    comidas.set(1,HorarioEspecifico.CENA);
                } else {
                    comidas.set(1,HorarioEspecifico.SNACK);
                }
                comidas.set(2, rs.getString("nombre"));
                comidas.set(3,rs.getString("detalle"));
                comidas.set(4, rs.getInt("cantCaloraias"));
                
               /* DietaComida dcomida = new DietaComida();
                Comida comida = new Comida();

                comida.setCantCalorias(rs.getInt("cantCalorias"));
                comida.setDetalle(rs.getString("detalle"));
                comida.setNombre(rs.getString("nombre"));
                if (rs.getString("horario") == "ALMUERZO") {
                    dcomida.setHorario(HorarioEspecifico.ALMUERZO);
                } else if (rs.getString("horario") == "DESAYUNO") {
                    dcomida.setHorario(HorarioEspecifico.DESAYUNO);

                } else if (rs.getString("horario") == "MERIENDA") {
                    dcomida.setHorario(HorarioEspecifico.MERIENDA);

                } else if (rs.getString("horario") == "CENA") {
                    dcomida.setHorario(HorarioEspecifico.CENA);
                } else {
                    dcomida.setHorario(HorarioEspecifico.SNACK);
                }
                
                */
                
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla dietaComida");
        }

        return comidas;
    }
}

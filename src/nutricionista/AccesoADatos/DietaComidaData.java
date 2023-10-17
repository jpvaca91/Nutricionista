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

    public List<DietaComida> consultaPorPaciente(Dieta dieta) {
        List<DietaComida> dietaComidas = new ArrayList<>();
        HorarioEspecifico horario = null;
        
        String sql = "SELECT dietacomida.horario, dietacomida.comida, dietacomida.dieta  FROM "
                + " dietacomida WHERE dietacomida.dieta=? ";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, dieta.getIdDieta());
            ResultSet rs = ps.executeQuery();

            if (!rs.next()) {
                JOptionPane.showMessageDialog(null, "Error en el listado de comidas asignadas al paciente");
            }

            while (rs.next()) {
                String hora = rs.getString("horario");

                if (hora == "ALMUERZO") {
                    horario = HorarioEspecifico.ALMUERZO;

                } else if (hora == "DESAYUNO") {
                    horario = HorarioEspecifico.DESAYUNO;

                } else if (hora == "MERIENDA") {
                    horario = HorarioEspecifico.MERIENDA;

                } else if (hora == "CENA") {
                    horario = HorarioEspecifico.CENA;

                } else {
                    horario = HorarioEspecifico.SNACK;

                }

                int comida = rs.getInt("comida");
                ComidaData cd = new ComidaData();

                int diet = rs.getInt("dieta");
                DietaData dd = new DietaData();

                dietaComidas.add(new DietaComida(cd.buscarComidaPorID(comida), dd.buscarDietaPorId(diet), horario));

            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla dietaComida");
        }

        return dietaComidas;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nutricionista.AccesoADatos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import nutricionista.Entidades.Dieta;
import org.mariadb.jdbc.Statement;

public class DietaData {

    private Connection con = null;
    
    public DietaData(){
        con = Coneccion.getConexion();
    }
    
    public void guardarDieta (Dieta dieta){
        String sql = "INSERT INTO dieta (nombre,paciente,fechaInicial,pesoInicial,pesoFinal,fechaFinal,estado)"
                + "VALUE (?,?,?,?,?,?,?)";
        
         PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, dieta.getNombre());
            ps.setString(2, dieta.getPaciente().getNombre());
            ps.setDate(3,Date.valueOf(dieta.getFechaFinal()));
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos"+ex);
        }
            
        
        
    }
}

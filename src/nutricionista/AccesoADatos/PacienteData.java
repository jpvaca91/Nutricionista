/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nutricionista.AccesoADatos;

import java.sql.Connection;

public class PacienteData {

    private Connection con = null;
    
    public PacienteData(){
        con =   Coneccion.getConexion();
        
    }

    
    
}

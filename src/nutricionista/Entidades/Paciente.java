
package nutricionista.Entidades;


public class Paciente {
 
    private String nombre;
    private int dni;
    private String domicilio;
    private String telefono;
    private int idPaciente;
    private boolean estado;

    public Paciente() {
    }

    public Paciente(String nombre, int dni, String domicilio, String telefono, int idPaciente, boolean estado) {
        this.nombre = nombre;
        this.dni = dni;
        this.domicilio = domicilio;
        this.telefono = telefono;
        this.idPaciente = idPaciente;
        this.estado = estado;
    }

    public Paciente(String nombre, int dni, String domicilio, String telefono, boolean estado) {
        this.nombre = nombre;
        this.dni = dni;
        this.domicilio = domicilio;
        this.telefono = telefono;
        this.estado = estado;
    }

    public Paciente(int dni, String nombre, String domicilio, String telefono, Boolean estado) {
        this.dni = dni;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.telefono = telefono;
        this.estado = estado;
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
@Override
    public String toString() {
        return nombre+"-"+dni;
    
    
    }
    
}

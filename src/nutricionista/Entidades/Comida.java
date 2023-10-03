
package nutricionista.Entidades;


public class Comida {
    
    private String nombre;
    private String detalle;
    private int cantCalorias;
    private int idComidas;

    public Comida() {
    }

    public Comida(String nombre, String detalle, int cantCalorias, int idComida) {
        this.nombre = nombre;
        this.detalle = detalle;
        this.cantCalorias = cantCalorias;
        this.idComidas = idComida;
    }

    public Comida(String nombre, String detalle, int cantCalorias) {
        this.nombre = nombre;
        this.detalle = detalle;
        this.cantCalorias = cantCalorias;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public int getCantCalorias() {
        return cantCalorias;
    }

    public void setCantCalorias(int cantCalorias) {
        this.cantCalorias = cantCalorias;
    }

    public int getIdComidas() {
        return idComidas;
    }

    public void setIdComidas(int idComida) {
        this.idComidas = idComida;
    }
    
    
    
    
    
    
    
}

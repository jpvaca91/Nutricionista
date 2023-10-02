
package nutricionista.Entidades;


public class Comida {
    
    private String comida;
    private String detalle;
    private int cantCalorias;
    private int idComidas;

    public Comida() {
    }

    public Comida(String comida, String detalle, int cantCalorias, int idComidas) {
        this.comida = comida;
        this.detalle = detalle;
        this.cantCalorias = cantCalorias;
        this.idComidas = idComidas;
    }

    public Comida(String comida, String detalle, int cantCalorias) {
        this.comida = comida;
        this.detalle = detalle;
        this.cantCalorias = cantCalorias;
    }

    public String getComida() {
        return comida;
    }

    public void setComida(String comida) {
        this.comida = comida;
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

    public void setIdComidas(int idComidas) {
        this.idComidas = idComidas;
    }
    
    
    
    
    
    
    
}

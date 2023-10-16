
package nutricionista.Entidades;


public class DietaComida {
    
    private int id;
    private Comida comida;
    private Dieta dieta;
    private HorarioEspecifico horario;

    public DietaComida() {
    }

    public DietaComida(int id, Comida comida, Dieta dieta, HorarioEspecifico horario) {
        this.id = id;
        this.comida = comida;
        this.dieta = dieta;
        this.horario = horario;
    }

    public DietaComida(Comida comida, Dieta dieta, HorarioEspecifico horario) {
        this.comida = comida;
        this.dieta = dieta;
        this.horario = horario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Comida getComida() {
        return comida;
    }

    public void setComida(Comida comida) {
        this.comida = comida;
    }

    public Dieta getDieta() {
        return dieta;
    }

    public void setDieta(Dieta dieta) {
        this.dieta = dieta;
    }

    public HorarioEspecifico getHorario() {
        return horario;
    }

    public void setHorario(HorarioEspecifico horario) {
        this.horario = horario;
    }

    
    
}

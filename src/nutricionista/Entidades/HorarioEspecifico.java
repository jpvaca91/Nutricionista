
package nutricionista.Entidades;


public enum HorarioEspecifico {
    DESAYUNO ("Desayuno"),
    ALMUERZO ("Almuerzo"),
    MERIENDA ("Merienda"),
    CENA ("Cena"),
    SNACK ("Snack");
    
    private String horarioEspecifico;

    private HorarioEspecifico(String horarioEspecifico) {
        this.horarioEspecifico = horarioEspecifico;
    }

    public String getHorarioEspecifico() {
        return horarioEspecifico;
    }

    public void setHorarioEspecifico(String horarioEspecifico) {
        this.horarioEspecifico = horarioEspecifico;
    }
    

}

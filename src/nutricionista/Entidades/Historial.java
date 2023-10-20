package nutricionista.Entidades;

import java.time.LocalDate;

public class Historial {

    private int idHistorial;
    private Paciente paciente;
    private double peso;
    private LocalDate fechaRegistro;
    private Boolean estado;

    public Historial() {
    }

    public Historial(int idHistorial, Paciente paciente, double peso, LocalDate fechaRegistro, Boolean estado) {
        this.idHistorial = idHistorial;
        this.paciente = paciente;
        this.peso = peso;
        this.fechaRegistro = fechaRegistro;
        this.estado = estado;
    }

    public Historial(Paciente paciente, double peso, LocalDate fechaRegistro, Boolean estado) {
        this.paciente = paciente;
        this.peso = peso;
        this.fechaRegistro = fechaRegistro;
        this.estado = estado;
    }

    public int getIdHistorial() {
        return idHistorial;
    }

    public void setIdHistorial(int idHistorial) {
        this.idHistorial = idHistorial;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Boolean isEstado() {
        return estado;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}

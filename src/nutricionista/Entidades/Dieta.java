package nutricionista.Entidades;

import java.time.LocalDate;

public class Dieta {

    private int idDieta;

    private Paciente paciente;
    private LocalDate fechaInicial;
    private double pesoInicial;
    private double pesoFinal;
    private LocalDate fechaFinal;
    private double pesoActual;
    private LocalDate fechaActual;

    public Dieta() {
    }

    public Dieta(int idDieta, Paciente paciente, LocalDate fechaInicial, double pesoInicial, double pesoFinal, LocalDate fechaFinal, double pesoActual, LocalDate fechaActual) {
        this.idDieta = idDieta;
        this.paciente = paciente;
        this.fechaInicial = fechaInicial;
        this.pesoInicial = pesoInicial;
        this.pesoFinal = pesoFinal;
        this.fechaFinal = fechaFinal;
        this.pesoActual = pesoActual;
        this.fechaActual = fechaActual;
    }

    public Dieta(Paciente paciente, LocalDate fechaInicial, double pesoInicial, double pesoFinal, LocalDate fechaFinal, double pesoActual, LocalDate fechaActual) {
        this.paciente = paciente;
        this.fechaInicial = fechaInicial;
        this.pesoInicial = pesoInicial;
        this.pesoFinal = pesoFinal;
        this.fechaFinal = fechaFinal;
        this.pesoActual = pesoActual;
        this.fechaActual = fechaActual;
    }

    public int getIdDieta() {
        return idDieta;
    }

    public void setIdDieta(int idDieta) {
        this.idDieta = idDieta;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public LocalDate getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaInicial(LocalDate fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public double getPesoInicial() {
        return pesoInicial;
    }

    public void setPesoInicial(double pesoInicial) {
        this.pesoInicial = pesoInicial;
    }

    public double getPesoFinal() {
        return pesoFinal;
    }

    public void setPesoFinal(double pesoFinal) {
        this.pesoFinal = pesoFinal;
    }

    public LocalDate getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(LocalDate fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public double getPesoActual() {
        return pesoActual;
    }

    public void setPesoActual(double pesoActual) {
        this.pesoActual = pesoActual;
    }

    public LocalDate getFechaActual() {
        return fechaActual;
    }

    public void setFechaActual(LocalDate fechaActual) {
        this.fechaActual = fechaActual;
    }

   

   

}

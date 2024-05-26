package co.edu.uniquindio.proyectofinal.model.Patrones.Builder;

import java.time.LocalDateTime;

import co.edu.uniquindio.proyectofinal.model.Consultorio.EstadoCita;
import co.edu.uniquindio.proyectofinal.model.Personal.Doctor;
import co.edu.uniquindio.proyectofinal.model.Personal.Paciente;

// Clase abstracta que representa una cita médica.
abstract class Cita {

    private String tipoCita;

    private LocalDateTime fechaHoraCita;

    private String consultorio;

    private Doctor doctor;

    private Paciente paciente;

    private EstadoCita estadoCita;

    public String getTipoCita() {
        return tipoCita;
    }

    public void setTipoCita(String tipoCita) {
        this.tipoCita = tipoCita;
    }

    public LocalDateTime getFechaHoraCita() {
        return fechaHoraCita;
    }

    public void setFechaHoraCita(LocalDateTime fechaHoraCita) {
        this.fechaHoraCita = fechaHoraCita;
    }

    public String getConsultorio() {
        return consultorio;
    }

    public void setConsultorio(String consultorio) {
        this.consultorio = consultorio;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public EstadoCita getEstadoCita() {
        return estadoCita;
    }

    public void setEstadoCita(EstadoCita estadoCita) {
        this.estadoCita = estadoCita;
    }

    // Método toString para obtener una representación en cadena de la cita
    @Override
    public String toString() {
        return "Cita [tipoCita=" + tipoCita +
                ", fechaCita=" + fechaHoraCita +
                ", consultorio=" + consultorio +
                ", doctor=" + doctor +
                ", paciente=" + paciente +
                "]";
    }

}


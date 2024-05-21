package co.edu.uniquindio.proyectofinal.model.Consultorio;

import java.time.LocalDate;
import java.time.LocalDateTime;

import co.edu.uniquindio.proyectofinal.model.Personal.Doctor;
import co.edu.uniquindio.proyectofinal.model.Personal.Paciente;

public class Cita {

    private LocalDateTime fechaHoraCita;
    private Paciente paciente;
    private Doctor doctor;
    private String motivo;
    private EstadoCita estadoCita;
    private String salaCita;

    public Cita(LocalDateTime fechaHoraCita, Paciente paciente, Doctor doctor, String motivo,
            String salaCita) {
        this.fechaHoraCita = fechaHoraCita;
        this.paciente = paciente;
        this.doctor = doctor;
        this.motivo = motivo;
        this.estadoCita = EstadoCita.PROGRAMADA;
        this.salaCita = salaCita;
    }

    public LocalDateTime getFechaHoraCita() {
        return fechaHoraCita;
    }


    public void setFechaHoraCita(LocalDateTime fechaHoraCita) {
        this.fechaHoraCita = fechaHoraCita;
    }


    public void setEstadoCita(EstadoCita estadoCita) {
        this.estadoCita = estadoCita;
    }
    
    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public EstadoCita getEstadoCita() {
        return estadoCita;
    }

    public String getSalaCita() {
        return salaCita;
    }

    public void setSalaCita(String salaCita) {
        this.salaCita = salaCita;
    }

    public void definirTratamiento(LocalDate fechaInicio, String nombre, 
    String descripcion, LocalDate fechaFin, RecetaMedica recetaMedica){
    paciente.agregarTratamientoActivo(new Tratamiento(fechaInicio, nombre, descripcion, fechaFin, recetaMedica));

    }


    public void actualizarEstado() {
        LocalDateTime ahora = LocalDateTime.now();
        if (estadoCita == EstadoCita.PROGRAMADA) {
            if (ahora.isAfter(fechaHoraCita)) {
                this.estadoCita = EstadoCita.EN_CURSO;
            }
        }
    }

    public void finalizarCita(){
        this.estadoCita = EstadoCita.FINALIZADA;
        Doctor doctorAsociado = getDoctor();
        Paciente pacienteAsociado = getPaciente();
        if(doctorAsociado != null){
            doctorAsociado.eliminarCitaPendiente(this);
        }

        if(pacienteAsociado !=null ){
            pacienteAsociado.eliminarCitaProgramada(this);
            pacienteAsociado.getHistorialMedico().agregarCitaFinalizada(this);
        }
    }

    public void cancelarCita(){
        this.estadoCita = EstadoCita.CANCELADA;
        Doctor doctorAsociado = getDoctor();
        if(doctorAsociado != null){
            doctorAsociado.eliminarCitaPendiente(this);
        }
    }

    

} 
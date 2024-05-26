package co.edu.uniquindio.proyectofinal.model.Consultorio;

import java.time.LocalDate;
import java.time.LocalDateTime;

import co.edu.uniquindio.proyectofinal.model.Enum.EstadoCita;
import co.edu.uniquindio.proyectofinal.model.Patrones.FactoryMetod.RecetaMedica;
import co.edu.uniquindio.proyectofinal.model.Personal.Doctor;
import co.edu.uniquindio.proyectofinal.model.Personal.Paciente;

/**
 * La clase Cita representa una cita médica en el consultorio.
 * Cada cita tiene un paciente, un doctor, una fecha y hora, un motivo, y una
 * sala asignada.
 */
public class CitaConcreta {

    private LocalDateTime fechaHoraCita;
    private Paciente paciente;
    private Doctor doctor;
    private String motivo;
    private EstadoCita estadoCita;
    private String salaCita;

    /**
     * Constructor de la clase Cita.
     * 
     * @param fechaHoraCita La fecha y hora de la cita.
     * @param paciente      El paciente que asiste a la cita.
     * @param doctor        El doctor que atenderá la cita.
     * @param motivo        El motivo de la cita.
     * @param salaCita      La sala asignada para la cita.
     */
    public CitaConcreta(LocalDateTime fechaHoraCita, Paciente paciente, Doctor doctor, String motivo, String salaCita) {
        this.fechaHoraCita = fechaHoraCita;
        this.paciente = paciente;
        this.doctor = doctor;
        this.motivo = motivo;
        this.estadoCita = EstadoCita.PROGRAMADA;
        this.salaCita = salaCita;
    }

    // Getters y Setters

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

    /**
     * Define un tratamiento para el paciente asociado a esta cita.
     * 
     * @param fechaInicio  La fecha de inicio del tratamiento.
     * @param nombre       El nombre del tratamiento.
     * @param descripcion  La descripción del tratamiento.
     * @param fechaFin     La fecha de finalización del tratamiento.
     * @param recetaMedica La receta médica asociada al tratamiento.
     */
    public void definirTratamiento(LocalDate fechaInicio, String nombre,
            String descripcion, LocalDate fechaFin, RecetaMedica recetaMedica) {
        paciente.agregarTratamientoActivo(new Tratamiento(fechaInicio, nombre, descripcion, fechaFin, recetaMedica));
    }

    /**
     * Actualiza el estado de la cita de acuerdo a la fecha y hora actual.
     * Si la cita está programada y la fecha y hora actuales son posteriores a la
     * fecha y hora de la cita,
     * el estado se cambia a "EN_CURSO".
     */
    public void actualizarEstado() {
        LocalDateTime ahora = LocalDateTime.now();
        if (estadoCita == EstadoCita.PROGRAMADA && ahora.isAfter(fechaHoraCita)) {
            this.estadoCita = EstadoCita.EN_CURSO;
        }
    }

    /**
     * Finaliza la cita, actualizando su estado a "FINALIZADA".
     * Elimina la cita de las listas de citas pendientes del doctor y citas
     * programadas del paciente.
     * Agrega la cita al historial médico del paciente.
     */
    public void finalizarCita() {
        this.estadoCita = EstadoCita.FINALIZADA;
        Doctor doctorAsociado = getDoctor();
        Paciente pacienteAsociado = getPaciente();
        if (doctorAsociado != null) {
            doctorAsociado.eliminarCitaPendiente(this);
        }
        if (pacienteAsociado != null) {
            pacienteAsociado.eliminarCitaProgramada(this);
            pacienteAsociado.getHistorialMedico().agregarCitaFinalizada(this);
        }
    }

    /**
     * Cancela la cita, actualizando su estado a "CANCELADA".
     * Elimina la cita de las listas de citas pendientes del doctor y de las citas
     * programadas del paciente.
     */

    public void cancelarCita() {
        this.estadoCita = EstadoCita.CANCELADA;
        Doctor doctorAsociado = getDoctor();
        Paciente pacienteAsociado = getPaciente();
        if (doctorAsociado != null) {
            doctorAsociado.eliminarCitaPendiente(this);
        }
        if (pacienteAsociado != null) {
            pacienteAsociado.eliminarCitaProgramada(this);
        }
    }
}

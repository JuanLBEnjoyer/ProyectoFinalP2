package co.edu.uniquindio.proyectofinal.model.Personal;

import java.time.LocalDate;
import java.time.LocalDateTime;

import co.edu.uniquindio.proyectofinal.model.Consultorio.CitaConcreta;

/**
 * Esta clase representa a un Administrador de Citas dentro del sistema.
 * Extiende de la clase Persona.
 */
public class AdministradorCitas extends Persona {

    /**
     * Constructor de la clase AdministradorCitas.
     * @param nombre El nombre del administrador de citas.
     * @param id El identificador único del administrador de citas.
     * @param fechaNacimiento La fecha de nacimiento del administrador de citas.
     */
    public AdministradorCitas(String nombre, String id, LocalDate fechaNacimiento) {
        super(nombre, id, fechaNacimiento);
    }

    /**
     * Método para programar una nueva cita en el sistema.
     * Verifica que no haya un cruce de citas y que la diferencia de tiempo entre citas sea mayor o igual a una hora.
     * @param fechaHoraCita La fecha y hora de la cita a programar.
     * @param paciente El paciente para el que se programa la cita.
     * @param doctor El doctor que atenderá la cita.
     * @param motivo El motivo de la cita.
     * @param salaCita La sala donde se llevará a cabo la cita.
     * @throws IllegalArgumentException Si se intenta programar una cita que se cruza con otra cita o si la diferencia de tiempo es menor a una hora.
     */
    public void programarCita(LocalDateTime fechaHoraCita, Paciente paciente, Doctor doctor, String motivo, String salaCita) {
        Cita nuevaCita = new Cita(fechaHoraCita, paciente, doctor, motivo, salaCita);
        paciente.agregarCitaProgramada(nuevaCita);
        doctor.agregarCitaPendiente(nuevaCita);
    }

    public void cancelarCita(Cita cita){
        cita.cancelarCita();
    }
}


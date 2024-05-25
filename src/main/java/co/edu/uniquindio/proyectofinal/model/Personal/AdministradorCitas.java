package co.edu.uniquindio.proyectofinal.model.Personal;

import java.time.LocalDate;
import java.time.LocalDateTime;

import co.edu.uniquindio.proyectofinal.model.Consultorio.Cita;

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
        // Verificar si hay una cita previa del paciente o del doctor en el mismo horario
        if (verificarCruceCitas(fechaHoraCita, paciente, doctor)) {
            throw new IllegalArgumentException("No se puede programar la cita porque se cruza con otra cita.");
        }
    
        // Crear la nueva cita
        Cita nuevaCita = new Cita(fechaHoraCita, paciente, doctor, motivo, salaCita);
        
        // Agregar la nueva cita a las listas correspondientes
        paciente.agregarCitaProgramada(nuevaCita);
        doctor.agregarCitaPendiente(nuevaCita);
    }

    /**
     * Método privado para verificar si una cita se cruza con otras citas existentes.
     * @param fechaHoraCita La fecha y hora de la cita a verificar.
     * @param paciente El paciente para el que se verifica la cita.
     * @param doctor El doctor para el que se verifica la cita.
     * @return True si hay un cruce de citas o la diferencia de tiempo entre citas es menor a una hora, false de lo contrario.
     */
    private boolean verificarCruceCitas(LocalDateTime fechaHoraCita, Paciente paciente, Doctor doctor) {
        // Verificar si el paciente tiene una cita en el mismo horario
        boolean crucesPaciente = paciente.getCitasProgramadas().stream()
                .anyMatch(cita -> cita.getFechaHoraCita().isEqual(fechaHoraCita));
    
        // Verificar si el doctor tiene una cita en el mismo horario
        boolean crucesDoctor = doctor.getCitasPendientes().stream()
                .anyMatch(cita -> cita.getFechaHoraCita().isEqual(fechaHoraCita));
    
        // Verificar si la diferencia de tiempo entre citas es menor a una hora
        LocalDateTime horaLimite = fechaHoraCita.minusHours(1);
        boolean diferenciaHoraPaciente = paciente.getCitasProgramadas().stream()
                .anyMatch(cita -> cita.getFechaHoraCita().isAfter(horaLimite));
    
        boolean diferenciaHoraDoctor = doctor.getCitasPendientes().stream()
                .anyMatch(cita -> cita.getFechaHoraCita().isAfter(horaLimite));
    
        return crucesPaciente || crucesDoctor || diferenciaHoraPaciente || diferenciaHoraDoctor;
    }

    /**
     * Método para cancelar una cita existente.
     * @param cita La cita a cancelar.
     */
    public void cancelarCita(Cita cita){
        cita.cancelarCita();
    }
}


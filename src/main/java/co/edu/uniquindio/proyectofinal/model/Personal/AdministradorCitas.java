package co.edu.uniquindio.proyectofinal.model.Personal;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;


import co.edu.uniquindio.proyectofinal.model.Consultorio.CitaConcreta;
import co.edu.uniquindio.proyectofinal.model.Consultorio.Consultorio;
import co.edu.uniquindio.proyectofinal.model.Patrones.Iterador.IteradorAleatorio;
import co.edu.uniquindio.proyectofinal.model.Patrones.Observer.GestorCitas;

/**
 * Esta clase representa a un Administrador de Citas dentro del sistema.
 * Extiende de la clase Persona.
 */
public class AdministradorCitas extends Persona {

    private GestorCitas gestorCitas;
    private Consultorio consultorio;

    /**
     * Constructor de la clase AdministradorCitas.
     * @param nombre El nombre del administrador de citas.
     * @param id El identificador único del administrador de citas.
     * @param fechaNacimiento La fecha de nacimiento del administrador de citas.
     */
    public AdministradorCitas(Consultorio consultorio, String nombre, String id, LocalDate fechaNacimiento, GestorCitas gestorCitas) {
        super(nombre, id, fechaNacimiento);
        this.gestorCitas = gestorCitas;
        this.consultorio = consultorio;
    }


    public void programarCita(LocalDateTime fechaHoraCita, Paciente paciente, String motivo, String salaCita) {
        

    Collection<Doctor> doctoresActivos = consultorio.buscarDoctoresActivos();

    if (doctoresActivos.isEmpty()) {
        throw new IllegalStateException("No hay doctores activos disponibles para programar citas.");
    }

    IteradorAleatorio<Doctor> iterador = new IteradorAleatorio<>(doctoresActivos);

    Doctor doctor = iterador.next();

        if (verificarCruceCitas(fechaHoraCita, paciente, doctor)) {
            throw new IllegalArgumentException("No se puede programar la cita porque se cruza con otra cita.");
        }
    
        // Crear la nueva cita
        CitaConcreta nuevaCita = new CitaConcreta(fechaHoraCita, paciente, doctor, motivo, salaCita);

        paciente.agregarCitaProgramada(nuevaCita);
        doctor.agregarCitaPendiente(nuevaCita);

        if (!gestorCitas.containsObserver(paciente)) {
            gestorCitas.addObserver(paciente);
        }



    }


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
    
    public void cancelarCita(CitaConcreta cita) {
        cita.cancelarCita();
        cita.getPaciente().eliminarCitaProgramada(cita);
    }

    
}
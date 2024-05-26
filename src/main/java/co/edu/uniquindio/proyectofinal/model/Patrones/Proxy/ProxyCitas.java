package co.edu.uniquindio.proyectofinal.model.Patrones.Proxy;

import java.time.LocalDateTime;

import co.edu.uniquindio.proyectofinal.model.Personal.AdministradorCitas;
import co.edu.uniquindio.proyectofinal.model.Personal.Paciente;

/**
 * La clase ProxyCitas actúa como un intermediario para la programación de
 * citas,
 * asegurando que solo los pacientes puedan programar citas.
 */
public class ProxyCitas {
    private final AdministradorCitas administradorCitas;

    /**
     * Constructor de la clase ProxyCitas.
     *
     * @param administradorCitas El administrador de citas real.
     */
    public ProxyCitas(AdministradorCitas administradorCitas) {
        this.administradorCitas = administradorCitas;
    }

    /**
     * Programa una cita para un paciente.
     *
     * @param fechaHoraCita La fecha y hora de la cita.
     * @param persona       La persona para quien se programa la cita.
     * @param motivo        El motivo de la cita.
     * @param salaCita      La sala donde se llevará a cabo la cita.
     */
    public void programarCita(LocalDateTime fechaHoraCita, Object persona, String motivo, String salaCita) {
        if (!(persona instanceof Paciente)) {
            throw new IllegalArgumentException("Solo los pacientes pueden programar citas.");
        } else {
            Paciente paciente = (Paciente) persona;
            administradorCitas.programarCita(fechaHoraCita, paciente, motivo, salaCita);
        }
    }
}

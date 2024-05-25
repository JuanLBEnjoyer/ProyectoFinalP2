package co.edu.uniquindio.proyectofinal.model.Personal;

import java.time.LocalDate;
import java.time.LocalDateTime;

import co.edu.uniquindio.proyectofinal.model.Consultorio.Cita;

public class AdministradorCitas extends Persona {

    public AdministradorCitas(String nombre, String id, LocalDate fechaNacimiento) {
        super(nombre, id, fechaNacimiento);
    }

    public void programarCita(LocalDateTime fechaHoraCita, Paciente paciente, Doctor doctor, String motivo, String salaCita) {
        Cita nuevaCita = new Cita(fechaHoraCita, paciente, doctor, motivo, salaCita);
        paciente.agregarCitaProgramada(nuevaCita);
        doctor.agregarCitaPendiente(nuevaCita);
    }

    public void cancelarCita(Cita cita){
        cita.cancelarCita();
        cita.getPaciente().eliminarCitaProgramada(cita);
    }
    
    
}

package co.edu.uniquindio.proyectofinal.model.Patrones.Builder;

import java.time.LocalDateTime;

import co.edu.uniquindio.proyectofinal.model.Personal.Doctor;
import co.edu.uniquindio.proyectofinal.model.Personal.Paciente;

public class CreadorDeCita {
    private CitaBuilder builder;

    public CreadorDeCita(CitaBuilder builder) {
        this.builder = builder;
    }

    // Método para construir una cita utilizando los datos proporcionados
    public Cita constructor(String tipoCita, LocalDateTime fechaHoraCita, String consultorio, Doctor doctor,
            Paciente paciente) {
        // Establecer los detalles de la cita en el Builder
        builder.tipoCita(tipoCita);
        builder.fechaHoraCita(fechaHoraCita);
        builder.consultorio(consultorio);
        builder.doctor(doctor);
        builder.paciente(paciente);
        // Construir y retornar la cita
        return builder.build();
    }
}

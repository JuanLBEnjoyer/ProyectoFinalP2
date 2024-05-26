package co.edu.uniquindio.proyectofinal.model.Patrones.Builder;

import java.time.LocalDateTime;

import co.edu.uniquindio.proyectofinal.model.Personal.Paciente;
import co.edu.uniquindio.proyectofinal.model.Personal.Doctor;

public interface CitaBuilder {

    void tipoCita(String tipoCita);

    void fechaHoraCita(LocalDateTime fechaHoraCita);

    void consultorio(String consultorio);

    void doctor(Doctor doctor);

    void paciente(Paciente paciente);

    Cita build();

}

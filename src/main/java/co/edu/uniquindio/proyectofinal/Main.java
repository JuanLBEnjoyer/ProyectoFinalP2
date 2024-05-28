package co.edu.uniquindio.proyectofinal;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import co.edu.uniquindio.proyectofinal.model.Consultorio.Consultorio;
import co.edu.uniquindio.proyectofinal.model.Patrones.FactoryMethod.*;
import co.edu.uniquindio.proyectofinal.model.Patrones.Observer.GestorCitas;
import co.edu.uniquindio.proyectofinal.model.Patrones.Builder.*;
import co.edu.uniquindio.proyectofinal.model.Personal.*;

public class Main {

    public static void main(String[] args) {
        // Crear consultorio
        Consultorio consultorio = Consultorio.obtenerInstancia("Clinica XYZ", "Calle 123");

        Collection<Persona> doctores = new ArrayList<>();

        // Crear pacientes
        Paciente paciente1 = new Paciente("Juan Perez", "12345", LocalDate.of(1980, 5, 15), null);
        Paciente paciente2 = new Paciente("Maria Lopez", "67890", LocalDate.of(1990, 10, 20), null);

        // Crear doctores
        Persona doctor1 = new Doctor("Pediatría", "Dr. Martínez", "DOC123", LocalDate.of(1975, 8, 25));
        Persona doctor2 = new Doctor("Cardiología", "Dra. Gómez", "DOC456", LocalDate.of(1985, 6, 30));

        // Agregar doctores al consultorio
        consultorio.agregarPersona(doctor1, doctores);
        consultorio.agregarPersona(doctor2, doctores);

        // Crear el creador de citas con el builder adecuado
        CreadorDeCita creadorDeCita = new CreadorDeCita(new ConsultaBuilder());

        // Programar una cita de tipo Consulta para el paciente 1
        LocalDateTime fechaHoraCitaConsulta = LocalDateTime.of(2024, 6, 10, 9, 0);

        Cita citaConsulta = creadorDeCita.constructor("Consulta", fechaHoraCitaConsulta, "Sala 1", (Doctor) doctor1,
                paciente1);

        // Programar una cita de tipo Seguimiento para el paciente 2
        LocalDateTime fechaHoraCitaSeguimiento = LocalDateTime.of(2024, 6, 15, 10, 30);

        Cita citaSeguimiento = creadorDeCita.constructor("Seguimiento", fechaHoraCitaSeguimiento, "Sala 2",
                (Doctor) doctor2, paciente2);

        // Crear una instancia de GestorCitas
        GestorCitas gestorCitas = new GestorCitas();

        // Agregar pacientes como observadores
        gestorCitas.addObserver(paciente1);
        gestorCitas.addObserver(paciente2);

        // Verificar citas próximas y notificar a los observadores
        gestorCitas.verificarCitasProximas(consultorio.getPacientes().stream()
                .flatMap(p -> p.getCitasProgramadas().stream())
                .collect(Collectors.toList()));

        // Mostrar información de las citas programadas
        System.out.println("Información de citas programadas:");
        System.out.println("Cita de Consulta para " + paciente1.getNombre() + ": " + citaConsulta);
        System.out.println("Cita de Seguimiento para " + paciente2.getNombre() + ": " + citaSeguimiento);

        // Crear una receta médica
        Collection<MedicamentoFactory> medicamentos = new ArrayList<>();

        // Crear diferentes tipos de medicamentos usando el Factory Method
        medicamentos.add(new MedicamentoIntravenoso("Ibuprofeno", "400mg"));
        medicamentos.add(new MedicamentoJarabe("Bronquisol", "15ml"));
        medicamentos.add(new MedicamentoPastillas("Paracetamol", "500mg"));

        // Crear la receta médica con los medicamentos y las instrucciones
        RecetaMedica receta = new RecetaMedica(medicamentos, "Tomar con comida");

        // Mostrar los detalles de la receta médica
        System.out.println("\nReceta Médica:");
        System.out.println("Instrucciones: " + receta.getInstrucciones());
        System.out.println("Medicamentos:");
        for (MedicamentoFactory medicamento : receta.getMedicamentos()) {
            System.out.println("- Nombre: " + medicamento.getNombre() +
                    ", Dosis: " + medicamento.getDosis() +
                    ", Forma de Administración: " + medicamento.getFormaAdministracion());
        }

        // Utilizar las variables doctor1 y doctor2
        System.out.println("\nDoctores:");
        for (Doctor doctor : consultorio.getDoctores()) {
            System.out.println("Doctor: " + doctor.getNombre() + " - Especialidad: " + doctor.getEspecialidad());
        }
    }
}

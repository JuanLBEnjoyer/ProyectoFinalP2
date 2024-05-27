package co.edu.uniquindio.proyectofinal;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

import co.edu.uniquindio.proyectofinal.model.Consultorio.Consultorio;
import co.edu.uniquindio.proyectofinal.model.Patrones.FactoryMethod.MedicamentoFactory;
import co.edu.uniquindio.proyectofinal.model.Patrones.FactoryMethod.MedicamentoIntravenoso;
import co.edu.uniquindio.proyectofinal.model.Patrones.FactoryMethod.MedicamentoJarabe;
import co.edu.uniquindio.proyectofinal.model.Patrones.FactoryMethod.MedicamentoPastillas;
import co.edu.uniquindio.proyectofinal.model.Patrones.FactoryMethod.RecetaMedica;
import co.edu.uniquindio.proyectofinal.model.Personal.AdministradorCitas;
import co.edu.uniquindio.proyectofinal.model.Personal.Doctor;
import co.edu.uniquindio.proyectofinal.model.Personal.Paciente;

public class Main {

    public static void main(String[] args) {
        // Crear consultorio
        Consultorio consultorio = new Consultorio("Clinica XYZ", "Calle 123");

        // Crear pacientes
        Paciente paciente1 = new Paciente("Juan Perez", "12345", LocalDate.of(1980, 5, 15), null, "Calle 456");
        Paciente paciente2 = new Paciente("Maria Lopez", "67890", LocalDate.of(1990, 10, 20), null, "Carrera 789");

        // Crear doctores
        Doctor doctor1 = new Doctor("Pediatría", "Dr. Martínez", "DOC123", LocalDate.of(1975, 8, 25));
        Doctor doctor2 = new Doctor("Cardiología", "Dra. Gómez", "DOC456", LocalDate.of(1985, 6, 30));

        // Crear administrador de citas
        AdministradorCitas administradorCitas = new AdministradorCitas(consultorio, "Administrador", "ADM001",
                LocalDate.of(1995, 4, 10));

        // Programar citas para los pacientes
        LocalDateTime fechaHoraCitaPaciente1 = LocalDateTime.of(2024, 6, 10, 9, 0);
        administradorCitas.programarCita(fechaHoraCitaPaciente1, paciente1, "Control rutinario", "Sala 1");

        LocalDateTime fechaHoraCitaPaciente2 = LocalDateTime.of(2024, 6, 15, 10, 30);
        administradorCitas.programarCita(fechaHoraCitaPaciente2, paciente2, "Examen de rutina", "Sala 2");

        // Mostrar información de citas programadas
        System.out.println("Información de citas programadas:");
        System.out.println("Paciente 1 - Cita 1: " + paciente1.getCitasProgramadas().iterator().next());
        System.out.println("Paciente 2 - Cita 1: " + paciente2.getCitasProgramadas().iterator().next());

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
        System.out.println("Doctor 1: " + doctor1.getNombre() + " - Especialidad: " + doctor1.getEspecialidad());
        System.out.println("Doctor 2: " + doctor2.getNombre() + " - Especialidad: " + doctor2.getEspecialidad());
    }
}

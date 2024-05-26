package co.edu.uniquindio.proyectofinal.model.Patrones.Strategy;

import co.edu.uniquindio.proyectofinal.model.Almacenar.HistorialMedico;

public class InformeAvanzado implements InformeStrategy {

    @Override
    public void generarInforme(HistorialMedico historial) {
        System.out.println("Informe Avanzado del Historial Médico:");
        System.out.println("Citas:");
        historial.getCitasProgramadas().forEach(cita -> System.out.println(" - " + cita));
        System.out.println("Tratamientos:");
        historial.getTratamientos().forEach(tratamiento -> System.out.println(" - " + tratamiento));
    }

    
}

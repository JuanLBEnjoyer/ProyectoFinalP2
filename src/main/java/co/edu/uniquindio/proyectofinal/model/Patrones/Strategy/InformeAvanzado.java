package co.edu.uniquindio.proyectofinal.model.Patrones.Strategy;

import co.edu.uniquindio.proyectofinal.model.Almacenar.HistorialMedico;

/**
 * Clase InformeAvanzado que implementa la estrategia para generar un informe
 * avanzado del historial médico.
 */
public class InformeAvanzado implements InformeStrategy {

    /**
     * Genera un informe avanzado del historial médico.
     * 
     * @param historial El historial médico del cual se generará el informe.
     */
    @Override
    public void generarInforme(HistorialMedico historial) {
        System.out.println("Informe Avanzado del Historial Médico:");
        System.out.println("Citas:");
        historial.getCitasFinalizadas().forEach(cita -> System.out.println(" - " + cita));
        System.out.println("Tratamientos:");
        historial.getTratamientos().forEach(tratamiento -> System.out.println(" - " + tratamiento));
    }
}

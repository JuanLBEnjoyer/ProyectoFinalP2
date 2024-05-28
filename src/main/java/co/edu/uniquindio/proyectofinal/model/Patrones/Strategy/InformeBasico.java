package co.edu.uniquindio.proyectofinal.model.Patrones.Strategy;

import co.edu.uniquindio.proyectofinal.model.Almacenar.HistorialMedico;

/**
 * Clase InformeBasico que implementa la estrategia para generar un informe
 * básico del historial médico.
 */
public class InformeBasico implements InformeStrategy {

    /**
     * Genera un informe básico del historial médico.
     * 
     * @param historial El historial médico del cual se generará el informe.
     */
    @Override
    public void generarInforme(HistorialMedico historial) {
        // Lógica para generar el informe básico
        int citasFinalizadas = historial.getCitasFinalizadas().size();
        int tratamientosActivos = historial.getTratamientosActivos().size();
        int tratamientosProgramados = historial.getTratamientosProgramados().size();
        int tratamientosFinalizados = historial.getTratamientosFinalizados().size();

        System.out.println("Informe Básico del Historial Médico:");
        System.out.println("Citas:");
        System.out.println(" - Finalizadas: " + citasFinalizadas);
        System.out.println("Tratamientos:");
        System.out.println(" - Activos: " + tratamientosActivos);
        System.out.println(" - Programados: " + tratamientosProgramados);
        System.out.println(" - Finalizados: " + tratamientosFinalizados);
    }
}

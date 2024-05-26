package co.edu.uniquindio.proyectofinal.model.Patrones.Strategy;

import co.edu.uniquindio.proyectofinal.model.Almacenar.HistorialMedico;

/**
 * Interfaz InformeStrategy que define el contrato para las estrategias de generación de informes del historial médico.
 */
public interface InformeStrategy {

    /**
     * Genera un informe del historial médico.
     * 
     * @param historial El historial médico del cual se generará el informe.
     */
    void generarInforme(HistorialMedico historial);
}


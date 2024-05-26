package co.edu.uniquindio.proyectofinal.model.Patrones.Strategy;

import co.edu.uniquindio.proyectofinal.model.Almacenar.HistorialMedico;

/**
 * Clase ContextoInforme que maneja la estrategia para generar informes de historial médico.
 */
public class ContextoInforme {

    private InformeStrategy estrategia;

    /**
     * Establece la estrategia a utilizar para generar el informe.
     * 
     * @param estrategia La estrategia a utilizar.
     */
    public void setEstrategia(InformeStrategy estrategia) {
        this.estrategia = estrategia;
    }

    /**
     * Genera un informe del historial médico utilizando la estrategia establecida.
     * 
     * @param historial El historial médico del cual se generará el informe.
     */
    public void generarInforme(HistorialMedico historial) {
        estrategia.generarInforme(historial);
    }
    
}
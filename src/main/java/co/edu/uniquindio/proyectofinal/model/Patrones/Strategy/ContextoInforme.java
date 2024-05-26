package co.edu.uniquindio.proyectofinal.model.Patrones.Strategy;

import co.edu.uniquindio.proyectofinal.model.Almacenar.HistorialMedico;

public class ContextoInforme {

    private InformeStrategy estrategia;

    public void setEstrategia(InformeStrategy estrategia) {
        this.estrategia = estrategia;
    }

    public void generarInforme(HistorialMedico historial) {
        estrategia.generarInforme(historial);
    }
    
}

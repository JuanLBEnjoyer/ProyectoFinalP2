package co.edu.uniquindio.proyectofinal.model.Patrones.Strategy;

import co.edu.uniquindio.proyectofinal.model.Almacenar.HistorialMedico;

public class InformeBasico implements InformeStrategy {

    @Override
    public void generarInforme(HistorialMedico historial) {
        // Lógica para generar el informe básico
        int citasProgramadas = historial.getCitasProgramadas().size();
        int citasFinalizadas = historial.getCitasFinalizadas().size();
        int citasCanceladas = historial.getCitasCanceladas().size();
        int tratamientosActivos = historial.getTratamientosActivos().size();
        int tratamientosProgramados = historial.getTratamientosProgramados().size();
        int tratamientosFinalizados = historial.getTratamientosFinalizados().size();

        System.out.println("Informe Básico del Historial Médico:");
        System.out.println("Citas:");
        System.out.println(" - Programadas: " + citasProgramadas);
        System.out.println(" - Finalizadas: " + citasFinalizadas);
        System.out.println(" - Canceladas: " + citasCanceladas);
        System.out.println("Tratamientos:");
        System.out.println(" - Activos: " + tratamientosActivos);
        System.out.println(" - Programados: " + tratamientosProgramados);
        System.out.println(" - Finalizados: " + tratamientosFinalizados);
    }
    
}
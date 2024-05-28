package co.edu.uniquindio.proyectofinal.model.Almacenar;

import java.util.Collection;
import java.util.stream.Collectors;

import co.edu.uniquindio.proyectofinal.model.Consultorio.CitaConcreta;
import co.edu.uniquindio.proyectofinal.model.Consultorio.Tratamiento;
import co.edu.uniquindio.proyectofinal.model.Enum.EstadoCita;
import co.edu.uniquindio.proyectofinal.model.Enum.EstadoTratamiento;

/**
 * Clase que representa el historial médico de un paciente, incluyendo sus citas y tratamientos.
 */
public class HistorialMedico {

    private Collection<CitaConcreta> citas;
    private Collection<Tratamiento> tratamientos;

    /**
     * Constructor para crear un historial médico con citas y tratamientos.
     * @param citas Las citas del historial médico.
     * @param tratamientos Los tratamientos del historial médico.
     */
    public HistorialMedico(Collection<CitaConcreta> citas,
            Collection<Tratamiento> tratamientos) {
        this.citas = citas;
        this.tratamientos = tratamientos;
    }

    // Getters y Setters


    public Collection<CitaConcreta> getCitas() {
        return citas;
    }


    public void setCitas(Collection<CitaConcreta> citas) {
        this.citas = citas;
    }

    public Collection<Tratamiento> getTratamientos(){
        return tratamientos;
    }

    /**
     * Agrega una cita finalizada al historial médico.
     * @param cita La cita finalizada a agregar.
     */
    public void agregarCitaFinalizada(CitaConcreta cita) {
        citas.add(cita);
    }

    /**
     * Obtiene todas las citas finalizadas del historial médico.
     * @return Una colección de citas finalizadas.
     */
    public Collection<CitaConcreta> getCitasFinalizadas() {
        return citas.stream()
            .filter(cita -> cita.getEstadoCita() == EstadoCita.FINALIZADA)
            .collect(Collectors.toList());
    }

    /**
     * Obtiene todos los tratamientos activos del historial médico.
     * @return Una colección de tratamientos activos.
     */
    public Collection<Tratamiento> getTratamientosActivos() {
        return tratamientos.stream()
            .filter(tratamiento -> tratamiento.getEstadoTratamiento() == EstadoTratamiento.ACTIVO)
            .collect(Collectors.toList());
    }

    /**
     * Obtiene todos los tratamientos programados del historial médico.
     * @return Una colección de tratamientos programados.
     */
    public Collection<Tratamiento> getTratamientosProgramados() {
        return tratamientos.stream()
            .filter(tratamiento -> tratamiento.getEstadoTratamiento() == EstadoTratamiento.PROGRAMADO)
            .collect(Collectors.toList());
    }

    /**
     * Obtiene todos los tratamientos finalizados del historial médico.
     * @return Una colección de tratamientos finalizados.
     */
    public Collection<Tratamiento> getTratamientosFinalizados() {
        return tratamientos.stream()
            .filter(tratamiento -> tratamiento.getEstadoTratamiento() == EstadoTratamiento.FINALIZADO)
            .collect(Collectors.toList());
    }

}


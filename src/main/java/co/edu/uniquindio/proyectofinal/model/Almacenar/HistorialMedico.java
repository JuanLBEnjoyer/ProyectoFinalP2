package co.edu.uniquindio.proyectofinal.model.Almacenar;

import java.util.Collection;
import java.util.stream.Collectors;

import co.edu.uniquindio.proyectofinal.model.Consultorio.CitaConcreta;
import co.edu.uniquindio.proyectofinal.model.Consultorio.EstadoCita;
import co.edu.uniquindio.proyectofinal.model.Consultorio.EstadoTratamiento;
import co.edu.uniquindio.proyectofinal.model.Consultorio.Tratamiento;

public class HistorialMedico {

    private Collection<CitaConcreta> citas;
    private Collection<Tratamiento> tratamientos;

    public HistorialMedico(Collection<CitaConcreta> citas,
            Collection<Tratamiento> tratamientos) {
        this.citas = citas;
        this.tratamientos = tratamientos;
    }

    public Collection<CitaConcreta> getCitas() {
        return citas;
    }

    public void setCitas(Collection<CitaConcreta> citas) {
        this.citas = citas;
    }

    public Collection<Tratamiento> getTratamientos() {
        return tratamientos;
    }

    public void setTratamientos(Collection<Tratamiento> tratamientos) {
        this.tratamientos = tratamientos;
    }

    public void agregarCitaFinalizada(CitaConcreta cita) {
        citas.add(cita);
    }

     public Collection<CitaConcreta> getCitasProgramadas() {
        return citas.stream()
            .filter(cita -> cita.getEstadoCita() == EstadoCita.PROGRAMADA)
            .collect(Collectors.toList());
    }

    public Collection<CitaConcreta> getCitasFinalizadas() {
        return citas.stream()
            .filter(cita -> cita.getEstadoCita() == EstadoCita.FINALIZADA)
            .collect(Collectors.toList());
    }

    public Collection<CitaConcreta> getCitasCanceladas() {
        return citas.stream()
            .filter(cita -> cita.getEstadoCita() == EstadoCita.CANCELADA)
            .collect(Collectors.toList());
    }

    public Collection<Tratamiento> getTratamientosActivos() {
        return tratamientos.stream()
            .filter(tratamiento -> tratamiento.getEstadoTratamiento() == EstadoTratamiento.ACTIVO)
            .collect(Collectors.toList());
    }

    public Collection<Tratamiento> getTratamientosProgramados() {
        return tratamientos.stream()
            .filter(tratamiento -> tratamiento.getEstadoTratamiento() == EstadoTratamiento.PROGRAMADO)
            .collect(Collectors.toList());
    }

    public Collection<Tratamiento> getTratamientosFinalizados() {
        return tratamientos.stream()
            .filter(tratamiento -> tratamiento.getEstadoTratamiento() == EstadoTratamiento.FINALIZADO)
            .collect(Collectors.toList());
    }

}

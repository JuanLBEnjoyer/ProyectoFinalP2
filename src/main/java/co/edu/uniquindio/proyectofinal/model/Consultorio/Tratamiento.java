package co.edu.uniquindio.proyectofinal.model.Consultorio;

import java.time.LocalDate;

public class Tratamiento {

    private LocalDate fechaInicio;
    private String nombre;
    private String descripcion;
    private LocalDate fechaFin;
    private EstadoTratamiento estadoTratamiento;

    public Tratamiento(LocalDate fechaInicio, String nombre, String descripcion, LocalDate fechaFin, EstadoTratamiento estadoTratamiento ) {

        this.fechaInicio = fechaInicio;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaFin = fechaFin;
        this.estadoTratamiento = estadoTratamiento; 
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }
    
}

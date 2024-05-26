package co.edu.uniquindio.proyectofinal.model.Consultorio;

import java.time.LocalDate;

import co.edu.uniquindio.proyectofinal.model.Patrones.FactoryMetod.RecetaMedica;

/**
 * Representa un tratamiento médico que incluye información como fecha de inicio, nombre, descripción, fecha de fin,
 * receta médica asociada y estado del tratamiento.
 */
public class Tratamiento {

    private LocalDate fechaInicio;
    private String nombre;
    private String descripcion;
    private LocalDate fechaFin;
    private RecetaMedica recetaMedica;
    private EstadoTratamiento estadoTratamiento;

    /**
     * Crea un nuevo tratamiento con la fecha de inicio, nombre, descripción, fecha de fin y receta médica especificados.
     * Inicializa el estado del tratamiento como PROGRAMADO por defecto.
     * 
     * @param fechaInicio la fecha de inicio del tratamiento
     * @param nombre el nombre del tratamiento
     * @param descripcion la descripción del tratamiento
     * @param fechaFin la fecha de fin del tratamiento
     * @param recetaMedica la receta médica asociada al tratamiento
     */
    public Tratamiento(LocalDate fechaInicio, String nombre, String descripcion, LocalDate fechaFin, RecetaMedica recetaMedica) {
        this.fechaInicio = fechaInicio;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaFin = fechaFin;
        this.recetaMedica = recetaMedica;
        this.estadoTratamiento = EstadoTratamiento.PROGRAMADO; 
    }

    // Getters y Setters


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

    public EstadoTratamiento getEstadoTratamiento() {
        return estadoTratamiento;
    }

    public void setEstadoTratamiento(EstadoTratamiento estadoTratamiento) {
        this.estadoTratamiento = estadoTratamiento;
    }    

    public RecetaMedica getRecetaMedica(){
        return recetaMedica;
    }

    public void setRecetaMedica(RecetaMedica recetaMedica){
        this.recetaMedica = recetaMedica;
    }

    /**
     * Actualiza el estado del tratamiento basado en la fecha actual.
     * Si la fecha actual es igual a la fecha de inicio, el estado se cambia a ACTIVO.
     * Si la fecha actual es después de la fecha de fin, el estado se cambia a FINALIZADO.
     */

    public void actualizarEstado() {
        LocalDate hoy = LocalDate.now();
        if (hoy.equals(fechaInicio)) {
            this.estadoTratamiento = EstadoTratamiento.ACTIVO;
        } else if (hoy.isAfter(fechaFin)) {
            this.estadoTratamiento = EstadoTratamiento.FINALIZADO;
        }
    }
    
}
package co.edu.uniquindio.proyectofinal.model.Personal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import co.edu.uniquindio.proyectofinal.model.Consultorio.CitaConcreta;
import co.edu.uniquindio.proyectofinal.model.Enum.EstadoDoctor;


/**
 * Clase Doctor que extiende de Persona y representa a un médico con especialidad, estado y citas pendientes.
 */
public class Doctor extends Persona {

    private String especialidad;
    private EstadoDoctor estado;
    private Collection<CitaConcreta> citasPendientes;

    /**
     * Constructor de la clase Doctor.
     * 
     * @param especialidad     La especialidad del doctor.
     * @param nombre           El nombre del doctor.
     * @param id               El identificador único del doctor.
     * @param fechaNacimiento  La fecha de nacimiento del doctor.
     */
    public Doctor(String especialidad, String nombre, String id, LocalDate fechaNacimiento) {
        super(nombre, id, fechaNacimiento);
        this.especialidad = especialidad;
        this.citasPendientes = new ArrayList<>();
        this.estado = EstadoDoctor.ACTIVO;
    }

    // Getters y Setters

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public Collection<CitaConcreta> getCitasPendientes() {
        return citasPendientes;
    }

    public EstadoDoctor getEstado() {
        return estado;
    }

    /**
     * Cambia el estado del doctor entre ACTIVO e INACTIVO.
     */
    public void cambiarEstado() {
        if (estado == EstadoDoctor.ACTIVO) {
            this.estado = EstadoDoctor.INACTIVO;
        } else {
            this.estado = EstadoDoctor.ACTIVO;
        }
    }

    /**
     * Agrega una cita pendiente a la colección de citas pendientes del doctor.
     * 
     * @param cita  La cita concreta a agregar.
     */
    public void agregarCitaPendiente(CitaConcreta cita) {
        citasPendientes.add(cita);
    }

    /**
     * Elimina una cita pendiente de la colección de citas pendientes del doctor.
     * 
     * @param cita  La cita concreta a eliminar.
     */
    public void eliminarCitaPendiente(CitaConcreta cita) {
        citasPendientes.remove(cita);
    }
}



package co.edu.uniquindio.proyectofinal.model.Personal;

import java.lang.String;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import co.edu.uniquindio.proyectofinal.model.Almacenar.HistorialMedico;
import co.edu.uniquindio.proyectofinal.model.Consultorio.CitaConcreta;
import co.edu.uniquindio.proyectofinal.model.Consultorio.Tratamiento;
import co.edu.uniquindio.proyectofinal.model.Patrones.FactoryMetod.RecetaMedica;
import co.edu.uniquindio.proyectofinal.model.Patrones.Observer.Observer;

/**
 * La clase Paciente representa a un paciente en el sistema de gestión médica.
 * Extiende de la clase Persona y actúa como observador en el patrón Observer.
 */
public class Paciente extends Persona implements Observer {

    private HistorialMedico historialMedico;
    private Collection<CitaConcreta> citasProgramadas;
    private Collection<Tratamiento> tratamientosActivos;
    private Collection<RecetaMedica> medicamentos;
    private String direccion;

    /**
     * Constructor de la clase Paciente.
     * 
     * @param nombre            El nombre del paciente.
     * @param id                La identificación del paciente.
     * @param fechaDeNacimiento La fecha de nacimiento del paciente.
     * @param historialMedico   El historial médico del paciente.
     * @param direccion         La dirección del paciente.
     * @throws IllegalArgumentException si alguno de los parámetros es inválido.
     */

    public Paciente(String nombre, String id, LocalDate fechaDeNacimiento, HistorialMedico historialMedico,
            String direccion) {
        super(nombre, id, fechaDeNacimiento);

        this.historialMedico = historialMedico;
        this.citasProgramadas = new ArrayList<CitaConcreta>();
        this.tratamientosActivos = new ArrayList<Tratamiento>();
        this.medicamentos = new ArrayList<RecetaMedica>();
        this.direccion = direccion;

        assert !nombre.isBlank() && !nombre.isEmpty();
        assert !id.isBlank() && !id.isEmpty();
        assert fechaDeNacimiento != null && fechaDeNacimiento.isBefore(LocalDate.now());
        assert historialMedico != null;
        assert !direccion.isBlank() && !direccion.isEmpty();
    }

    // Getters y Setters

    public HistorialMedico getHistorialMedico() {
        return historialMedico;
    }

    public void setHistorialMedico(HistorialMedico historialMedico) {
        this.historialMedico = historialMedico;
    }

    public Collection<CitaConcreta> getCitasProgrmadas() {
        return citasProgramadas;
    }

    public void setCitasProgrmadas(Collection<CitaConcreta> citasProgrmadas) {
        this.citasProgramadas = citasProgrmadas;
    }

    public Collection<Tratamiento> getTratamientosActivos() {
        return tratamientosActivos;
    }

    public void setTratamientosActivos(Collection<Tratamiento> tratamientosActivos) {
        this.tratamientosActivos = tratamientosActivos;
    }

    public Collection<CitaConcreta> getCitasProgramadas() {
        return citasProgramadas;
    }

    public void setCitasProgramadas(Collection<CitaConcreta> citasProgramadas) {
        this.citasProgramadas = citasProgramadas;
    }

    public Collection<RecetaMedica> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(Collection<RecetaMedica> medicamentos) {
        this.medicamentos = medicamentos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

   /**
     * Agrega una cita programada al paciente.
     * 
     * @param cita La cita que se va a agregar.
     */
    public void agregarCitaProgramada(CitaConcreta cita) {
        citasProgramadas.add(cita);
    }

    /**
     * Elimina una cita programada del paciente.
     * 
     * @param cita La cita que se va a eliminar.
     */
    public void eliminarCitaProgramada(CitaConcreta cita) {
        citasProgramadas.remove(cita);
    }

    /**
     * Agrega un tratamiento activo al paciente.
     * 
     * @param tratamiento El tratamiento que se va a agregar.
     */
    public void agregarTratamientoActivo(Tratamiento tratamiento) {
        tratamientosActivos.add(tratamiento);
    }

    /**
     * Método de actualización que recibe notificaciones del sujeto.
     * 
     * @param mensaje El mensaje de notificación.
     */
    @Override
    public void update(String mensaje) {
        System.out.println("Notificación para " + getNombre() + ": " + mensaje);
    }

}


package co.edu.uniquindio.proyectofinal.model.Personal;

import java.time.LocalDate;
import java.util.Collection;

import co.edu.uniquindio.proyectofinal.model.Consultorio.CitaConcreta;
import co.edu.uniquindio.proyectofinal.model.Consultorio.Medicamento;
import co.edu.uniquindio.proyectofinal.model.Consultorio.RecetaMedica;

public class Doctor extends Persona {

    private String especialidad;
    private Collection<CitaConcreta> citasPendientes;

    public Doctor(String especialidad, Collection<CitaConcreta> citasPendientes, String nombre, String id,
            LocalDate fechaNacimiento) {
        super(nombre, id, fechaNacimiento);

        this.especialidad = especialidad;
        this.citasPendientes = citasPendientes;

    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public Collection<CitaConcreta> getCitasPendientes() {
        return citasPendientes;
    }

    public void agregarCitaPendiente(CitaConcreta cita) {
        citasPendientes.add(cita);
    }

    public void eliminarCitaPendiente(CitaConcreta cita) {
        citasPendientes.remove(cita);
    }

    public void crearRecetaMedica(Paciente paciente, Collection<Medicamento> mendicamentos, String instrucciones) {
        RecetaMedica receta = new RecetaMedica(mendicamentos, instrucciones);
        paciente.agregarRecetaMedica(receta);
    }

}


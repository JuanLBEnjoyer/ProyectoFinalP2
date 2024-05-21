package co.edu.uniquindio.proyectofinal.model.Personal;

import java.time.LocalDate;
import java.util.Collection;

import co.edu.uniquindio.proyectofinal.model.Consultorio.Cita;

public class Doctor extends Persona {

    private String especialidad;
    private Collection<Cita> citasPendientes; 

    public Doctor(String especialidad, Collection<Cita> citasPendientes, String nombre, String id, LocalDate fechaNacimiento) {
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

    public Collection<Cita> getCitasPendientes() {
        return citasPendientes;
    }

    
}

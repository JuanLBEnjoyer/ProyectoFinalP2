package co.edu.uniquindio.proyectofinal.model.Personal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import co.edu.uniquindio.proyectofinal.model.Consultorio.CitaConcreta;
import co.edu.uniquindio.proyectofinal.model.Enum.EstadoDoctor;

public class Doctor extends Persona {

    private String especialidad;
    private EstadoDoctor estado;
    private Collection<CitaConcreta> citasPendientes;

    public Doctor(String especialidad, String nombre, String id,
            LocalDate fechaNacimiento) {
        super(nombre, id, fechaNacimiento);

        this.especialidad = especialidad;
        this.citasPendientes = new ArrayList<CitaConcreta>();
        this.estado = EstadoDoctor.ACTIVO;

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

    public void cambiarEstado(){
        if(estado == EstadoDoctor.ACTIVO){
            this.estado = EstadoDoctor.INACTIVO;
        }
        else{
            this.estado = EstadoDoctor.ACTIVO;
        }
    }

    public EstadoDoctor getEstado(){
        return estado;
    }

    public void agregarCitaPendiente(CitaConcreta cita) {
        citasPendientes.add(cita);
    }

    public void eliminarCitaPendiente(CitaConcreta cita) {
        citasPendientes.remove(cita);
    }

}


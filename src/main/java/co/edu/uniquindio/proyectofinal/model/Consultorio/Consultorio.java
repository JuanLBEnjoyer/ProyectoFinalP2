package co.edu.uniquindio.proyectofinal.model.Consultorio;
import co.edu.uniquindio.proyectofinal.model.Personal.Doctor;
import co.edu.uniquindio.proyectofinal.model.Personal.Paciente;

import java.time.LocalDate;
import java.util.Collection;



public class Consultorio {
    public String nombre;
    public String direccion;
    public LocalDate fechaCreacion;
    public Collection<Paciente> pacientes;
    public Collection<Doctor> doctores;


    public Consultorio(String nombre, String direccion, LocalDate fechaCreacion, Collection<Paciente> pacientes, Collection<Doctor> doctores){
        this.nombre = nombre;
        this.direccion = direccion;
        this.fechaCreacion = LocalDate.now();
        this.pacientes = pacientes;
        this.doctores = doctores;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getDireccion() {
        return direccion;
    }


    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }


    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }


    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }


    public Collection<Paciente> getPacientes() {
        return pacientes;
    }


    public void setPacientes(Collection<Paciente> pacientes) {
        this.pacientes = pacientes;
    }


    public Collection<Doctor> getDoctores() {
        return doctores;
    }


    public void setDoctores(Collection<Doctor> doctores) {
        this.doctores = doctores;
    }


    @Override
    public String toString() {
        return "Consultorio [nombre=" + nombre + ", direccion=" + direccion + ", fechaCreacion=" + fechaCreacion
                + ", pacientes=" + pacientes + ", doctores=" + doctores + "]";
    }

    

}

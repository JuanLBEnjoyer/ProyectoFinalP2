package co.edu.uniquindio.proyectofinal.model.Consultorio;
import co.edu.uniquindio.proyectofinal.model.Exception.PersonaExistenteException;
import co.edu.uniquindio.proyectofinal.model.Personal.Doctor;
import co.edu.uniquindio.proyectofinal.model.Personal.Paciente;
import co.edu.uniquindio.proyectofinal.model.Personal.Persona;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;


public class Consultorio {
    private String nombre;
    private String direccion;
    private LocalDate fechaCreacion;
    private Collection<Paciente> pacientes;
    private Collection<Doctor> doctores;


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



    public Persona buscarPersona(String id, Collection<Persona> lista){

        Predicate<Persona> condicion = p -> p.getId().equals(id);
        Optional<Persona> persona = lista.stream().filter(condicion).findFirst();
        return persona.orElse(null);
        
    }


    public Optional<Persona> verificarPersona(Persona persona, Collection<Persona> lista){
        Predicate<Persona> condicion = p->p.getId().equals(persona.getId());
        return lista.stream().filter(condicion).findAny();
    }

    private void validarPersonaExiste(Persona persona, Collection<Persona> lista) {
        boolean existePersona = verificarPersona(persona, lista).isPresent();
        if(existePersona){
            throw new PersonaExistenteException("La persona con ID" + persona.getId()+ "ya existe");
        }
    }

    public void agregarPersona(Persona persona, Collection<Persona> lista){

        validarPersonaExiste(persona, lista);
        lista.add(persona);

    }

    public void eliminarPersona(Persona persona, Collection<Persona> lista){
        lista.removeIf(p->p.getId().equals(persona.getId()));
    }
}

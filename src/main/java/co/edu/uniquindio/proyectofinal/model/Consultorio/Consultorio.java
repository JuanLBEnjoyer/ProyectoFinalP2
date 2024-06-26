package co.edu.uniquindio.proyectofinal.model.Consultorio;
import co.edu.uniquindio.proyectofinal.model.Exception.PersonaExistenteException;
import co.edu.uniquindio.proyectofinal.model.Patrones.Iterador.Iterador;
import co.edu.uniquindio.proyectofinal.model.Patrones.Iterador.IteradorDoctoresActivos;
import co.edu.uniquindio.proyectofinal.model.Personal.AdministradorCitas;
import co.edu.uniquindio.proyectofinal.model.Personal.Doctor;
import co.edu.uniquindio.proyectofinal.model.Personal.Paciente;
import co.edu.uniquindio.proyectofinal.model.Personal.Persona;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;


public class Consultorio {
    private String nombre;
    private String direccion;
    private LocalDate fechaCreacion;
    private AdministradorCitas administradorCitas;
    private Collection<Paciente> pacientes;
    private Collection<Doctor> doctores;
    private static Consultorio instanciaUnica;

    /**
     * Constructor para crear un consultorio.
     * @param nombre El nombre del consultorio.
     * @param direccion La dirección del consultorio.
     * @param administradorCitas El administrador de citas del consultorio.
     * @param pacientes La colección de pacientes del consultorio.
     * @param doctores La colección de doctores del consultorio.
     */
    public Consultorio(String nombre, String direccion){
        this.nombre = nombre;
        this.direccion = direccion;
        this.fechaCreacion = LocalDate.now();
        this.pacientes = new ArrayList<Paciente>();
        this.doctores = new ArrayList<Doctor>();
    }

    // Getters y Setters

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

    public AdministradorCitas getAdministradorCitas(){
        return administradorCitas;
    }

    public void setAdministradorCitas(AdministradorCitas administradorCitas){
        this.administradorCitas = administradorCitas;
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

    /**
     * Representa el consultorio en forma de cadena.
     * @return Una cadena que representa el consultorio.
     */
    @Override
    public String toString() {
        return "Consultorio [nombre=" + nombre + ", direccion=" + direccion + ", fechaCreacion=" + fechaCreacion
                + ", pacientes=" + pacientes + ", doctores=" + doctores + "]";
    }

    // Método estático para obtener la instancia única del Consultorio
    public static Consultorio obtenerInstancia(String nombre, String direccion) {
        if (instanciaUnica == null) {
            instanciaUnica = new Consultorio(nombre, direccion);
        }
        return instanciaUnica;
    }

    /**
     * Busca una persona en una lista dada su identificación.
     * @param id La identificación de la persona a buscar.
     * @param lista La lista de personas donde se buscará.
     * @return La persona encontrada o null si no se encuentra.
     */
    public Persona buscarPersona(String id, Collection<Persona> lista){
        Predicate<Persona> condicion = p -> p.getId().equals(id);
        Optional<Persona> persona = lista.stream().filter(condicion).findFirst();
        return persona.orElse(null);
    }

    /**
     * Verifica si una persona existe en una lista dada.
     * @param persona La persona a verificar.
     * @param lista La lista de personas donde se verificará.
     * @return Un Optional con la persona si se encuentra, o un Optional vacío si no se encuentra.
     */
    public Optional<Persona> verificarPersona(Persona persona, Collection<Persona> lista){
        Predicate<Persona> condicion = p->p.getId().equals(persona.getId());
        return lista.stream().filter(condicion).findAny();
    }

    /**
     * Valida si una persona ya existe en una lista. Si la persona existe, lanza una excepción.
     * @param persona La persona a validar.
     * @param lista La lista de personas donde se verificará.
     * @throws PersonaExistenteException Si la persona ya existe en la lista.
     */
    private void validarPersonaExiste(Persona persona, Collection<Persona> lista) {
        boolean existePersona = verificarPersona(persona, lista).isPresent();
        if (existePersona) {
            throw new PersonaExistenteException("La persona con ID " + persona.getId() + " ya existe");
        }
    }

  
    /**
     * Agrega una persona al consultorio después de validar que no exista.
     * @param persona La persona a agregar.
     * @param lista La lista de personas donde se agregará.
     */
    public void agregarPersona(Persona persona, Collection<Persona> lista){
        validarPersonaExiste(persona, lista);
        lista.add(persona);
        if (persona instanceof Doctor) { // Verifica si la persona es un doctor
            doctores.add((Doctor) persona); // Agrega el doctor a la lista de doctores
        }
    }

        /**
    * Elimina una persona de la lista.
    * @param persona La persona a eliminar.
    * @param lista La lista de personas.
    */
    public void eliminarPersona(Persona persona, Collection<Persona> lista) {
        lista.remove(persona);
    }

    /**
 * Crea un iterador para recorrer los doctores activos en el consultorio.
 * @return Un iterador para los doctores activos.
 */
public Iterador<Doctor> crearIteradorDoctoresActivos() {
    return new IteradorDoctoresActivos(doctores);
}


    /**
 * Crea un nuevo administrador de citas para el consultorio.
 * @param nombre El nombre del administrador.
 * @param id El ID del administrador.
 * @param fechaDeNacimiento La fecha de nacimiento del administrador.
 * @return El administrador de citas creado.
 */
public AdministradorCitas crearAdministrador(String nombre, String id, LocalDate fechaDeNacimiento){
    this.administradorCitas = new AdministradorCitas(this, nombre, id, fechaDeNacimiento);
    return this.administradorCitas;
}


}

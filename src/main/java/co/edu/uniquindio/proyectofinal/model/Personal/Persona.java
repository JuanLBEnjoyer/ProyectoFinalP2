package co.edu.uniquindio.proyectofinal.model.Personal;

import java.time.LocalDate;

import java.time.Period;

/**
 * Clase abstracta Persona que representa a una persona con nombre, ID, fecha de nacimiento y edad.
 */
public abstract class Persona {

    private String nombre;
    private String id;
    private LocalDate fechaNacimiento;
    private int edad;

    /**
     * Constructor de la clase Persona.
     * 
     * @param nombre           El nombre de la persona.
     * @param id               El identificador único de la persona.
     * @param fechaNacimiento  La fecha de nacimiento de la persona.
     */

     public Persona(String nombre, String id, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.id = id;
        this.fechaNacimiento = fechaNacimiento;
        this.edad = calcularEdad(fechaNacimiento);
    }

    // Getters y Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Calcula la edad a partir de la fecha de nacimiento.
     * 
     * @param fechaNacimiento  La fecha de nacimiento de la persona.
     * @return La edad calculada.
     */
    private int calcularEdad(LocalDate fechaNacimiento) {
        return Period.between(fechaNacimiento, LocalDate.now()).getYears();
    }


    /**
     * Retorna una representación en forma de cadena de la persona.
     * 
     * @return Una cadena que representa a la persona.
     */
    @Override
    public String toString() {
        return "Persona [nombre=" + nombre + ", id=" + id + ", fechaNacimiento=" + fechaNacimiento + ", edad=" + edad + "]";
    }

    

    
}

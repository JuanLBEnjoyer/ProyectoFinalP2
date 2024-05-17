package co.edu.uniquindio.proyectofinal.model.Personal;

import java.time.LocalDate;

public abstract class Persona {

    private String nombre;
    private String id;
    private LocalDate fechaNacimiento; 
    
    public Persona(String nombre, String id, LocalDate fechaNacimiento){
        this.nombre = nombre;
        this.id = id;
        this.fechaNacimiento = fechaNacimiento;
    }

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

    
}
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
}

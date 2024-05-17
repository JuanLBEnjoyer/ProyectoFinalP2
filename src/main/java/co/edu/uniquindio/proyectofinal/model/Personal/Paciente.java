package co.edu.uniquindio.proyectofinal.model.Personal;

import java.lang.String;
import java.time.LocalDate;

public class Paciente extends Persona {

    public String nombre;
    public String id;
    ;

    public Paciente(String nombre, String id, LocalDate fechaDeNacimiento){
        super(nombre, id, fechaDeNacimiento);

        assert !nombre.isBlank() && !nombre.isEmpty();
        assert !id.isBlank() && !id.isEmpty();
        assert fechaDeNacimiento != null && fechaDeNacimiento.isBefore(LocalDate.now());
    }

    public String toStringPaciente() {
        return "Paciente [nombre=" + nombre + ", id=" + id +"]";
    }

    
    
}

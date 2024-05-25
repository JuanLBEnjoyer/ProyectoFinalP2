package co.edu.uniquindio.proyectofinal.model.Consultorio;

import java.util.Collection;

// Clase RecetaMedica que contiene una colección de medicamentos e instrucciones
public class RecetaMedica {
    private Collection<Medicamento> medicamentos;
    private String instrucciones;

    // Constructor de la clase RecetaMedica
    public RecetaMedica(Collection<Medicamento> medicamentos, String instrucciones) {
        this.medicamentos = medicamentos;
        this.instrucciones = instrucciones;
    }

    // Getter y setter para la colección de medicamentos
    public Collection<Medicamento> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(Collection<Medicamento> medicamentos) {
        this.medicamentos = medicamentos;
    }

    // Getter y setter para las instrucciones
    public String getInstrucciones() {
        return instrucciones;
    }

    public void setInstrucciones(String instrucciones) {
        this.instrucciones = instrucciones;
    }    
}

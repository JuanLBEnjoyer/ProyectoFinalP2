package co.edu.uniquindio.proyectofinal.model.Patrones.FactoryMethod;

import java.util.Collection;

/**
 * Representa una receta médica que contiene medicamentos y las instrucciones
 * para su administración.
 */
public class RecetaMedica {

    private Collection<MedicamentoFactory> medicamentos;
    private String instrucciones;

    /**
     * Crea una nueva receta médica con los medicamentos y las instrucciones
     * especificadas.
     * 
     * @param medicamentos  la colección de medicamentos recetados
     * @param instrucciones las instrucciones para la administración de los
     *                      medicamentos
     */
    public RecetaMedica(Collection<MedicamentoFactory> medicamentos, String instrucciones) {
        this.medicamentos = medicamentos;
        this.instrucciones = instrucciones;
    }

    // Getters y Setters

    public Collection<MedicamentoFactory> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(Collection<MedicamentoFactory> medicamentos) {
        this.medicamentos = medicamentos;
    }

    public String getInstrucciones() {
        return instrucciones;
    }

    public void setInstrucciones(String instrucciones) {
        this.instrucciones = instrucciones;
    }
}

package co.edu.uniquindio.proyectofinal.model.Patrones.FactoryMethod;

// Clase MedicamentoPastillas que extiende de Medicamento
public class MedicamentoPastillas extends MedicamentoFactory {
    // Constructor de la clase MedicamentoPastillas
    public MedicamentoPastillas(String nombre, String dosis) {
        super(nombre, dosis);
    }

    // Implementación del método abstracto para forma de administración
    @Override
    public String getFormaAdministracion() {
        return "Pastillas";
    }
}

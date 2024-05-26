package co.edu.uniquindio.proyectofinal.model.Patrones.FactoryMetod;

// Clase MedicamentoPastillas que extiende de Medicamento
class MedicamentoPastillas extends Medicamento {
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

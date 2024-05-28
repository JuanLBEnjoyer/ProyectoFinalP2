package co.edu.uniquindio.proyectofinal.model.Patrones.FactoryMethod;

// Clase MedicamentoJarabe que extiende de Medicamento
public class MedicamentoJarabe extends MedicamentoFactory {
    // Constructor de la clase MedicamentoJarabe
    public MedicamentoJarabe(String nombre, String dosis) {
        super(nombre, dosis);
    }

    // Implementación del método abstracto para forma de administración
    @Override
    public String getFormaAdministracion() {
        return "Jarabe";
    }
}

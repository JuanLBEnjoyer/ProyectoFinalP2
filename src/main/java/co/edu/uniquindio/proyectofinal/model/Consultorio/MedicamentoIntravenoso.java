package co.edu.uniquindio.proyectofinal.model.Consultorio;

// Clase MedicamentoIntravenoso que extiende de Medicamento
public class MedicamentoIntravenoso extends Medicamento {
    // Constructor de la clase MedicamentoIntravenoso
    public MedicamentoIntravenoso(String nombre, String dosis) {
        super(nombre, dosis);
    }

    @Override
    public String getFormaAdministracion() {
        return "Intravenoso";
    }
}
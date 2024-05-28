package co.edu.uniquindio.proyectofinal.model.Patrones.FactoryMethod;

/**
 * Clase base abstracta para representar un medicamento en el sistema.
 */
public abstract class MedicamentoFactory {
    private String nombre;
    private String dosis;

    /**
     * Crea un nuevo medicamento con el nombre y la dosis especificados.
     * 
     * @param nombre El nombre del medicamento.
     * @param dosis  La dosis del medicamento.
     */
    public MedicamentoFactory(String nombre, String dosis) {
        this.nombre = nombre;
        this.dosis = dosis;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDosis() {
        return dosis;
    }

    public void setDosis(String dosis) {
        this.dosis = dosis;
    }

    /**
     * Método abstracto para obtener la forma de administración del medicamento.
     * 
     * @return La forma de administración del medicamento.
     */
    public abstract String getFormaAdministracion();
}

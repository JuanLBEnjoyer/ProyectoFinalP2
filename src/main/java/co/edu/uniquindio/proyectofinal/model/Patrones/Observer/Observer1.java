package co.edu.uniquindio.proyectofinal.model.Patrones.Observer;

/**
 * La interfaz Observer1 define el método que los observadores deben implementar para recibir actualizaciones.
 */
public interface Observer1 {

    /**
     * Este método se llama cuando el sujeto quiere notificar a los observadores.
     * 
     * @param mensaje El mensaje que se envía a los observadores.
     */
    void update(String mensaje);
}

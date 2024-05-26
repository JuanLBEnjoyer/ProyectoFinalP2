package co.edu.uniquindio.proyectofinal.model.Exception;

/**
 * Excepción lanzada cuando se intenta agregar una persona que ya existe en el sistema.
 */
public class PersonaExistenteException extends RuntimeException {
    /**
     * Constructor de la excepción con un mensaje descriptivo.
     *
     * @param mensaje El mensaje descriptivo de la excepción.
     */
    public PersonaExistenteException(String mensaje) {
        super(mensaje);
    }
}


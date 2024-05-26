package co.edu.uniquindio.proyectofinal.model.Enum;

/**
 * Representa los posibles estados de una cita médica.
 */
public enum EstadoCita {
    /**
     * La cita ha sido programada y está pendiente de realizarse.
     */
    PROGRAMADA,

    /**
     * La cita está en curso.
     */
    EN_CURSO,

    /**
     * La cita ha sido finalizada.
     */
    FINALIZADA,

    /**
     * La cita ha sido cancelada.
     */
    CANCELADA
}

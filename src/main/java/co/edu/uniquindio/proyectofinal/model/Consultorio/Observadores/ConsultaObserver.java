package co.edu.uniquindio.proyectofinal.model.Consultorio.Observadores;

// Clase que implementa el Observer para recibir actualizaciones.
public class ConsultaObserver implements Observer {

    // Nombre del observador
    private String nombreObserver;

    // Constructor de la clase ConsultaObserver.
    public ConsultaObserver(String nombreObserver) {
        this.nombreObserver = nombreObserver;
    }

    // Método para recibir y procesar una actualización.
    @Override
    public void update(String mensaje) {
        System.out.println("El Observer " + nombreObserver + " recibió el mensaje: " + mensaje);
    }
}

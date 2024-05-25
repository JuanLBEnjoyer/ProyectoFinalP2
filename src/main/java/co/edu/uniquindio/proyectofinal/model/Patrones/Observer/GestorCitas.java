package co.edu.uniquindio.proyectofinal.model.Patrones.Observer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import co.edu.uniquindio.proyectofinal.model.Consultorio.CitaConcreta;


/**
 * La clase GestorCitas gestiona la lista de observadores y las citas próximas.
 * Implementa la interfaz Sujeto para gestionar los observadores.
 */
public class GestorCitas implements Sujeto {
    private Collection<Observer1> observers;

    /**
     * Constructor de la clase GestorCitas.
     * Inicializa la colección de observadores.
     */
    public GestorCitas() {
        this.observers = new ArrayList<>();
    }

    /**
     * Agrega un observador a la lista de observadores.
     * 
     * @param observer El observador a agregar.
     */
    @Override
    public void addObserver(Observer1 observer) {
        observers.add(observer);
    }

    /**
     * Elimina un observador de la lista de observadores.
     * 
     * @param observer El observador a eliminar.
     */
    @Override
    public void removeObserver(Observer1 observer) {
        observers.remove(observer);
    }

    /**
     * Notifica a todos los observadores con un mensaje específico.
     * 
     * @param mensaje El mensaje a enviar a los observadores.
     */
    @Override
    public void notifyObservers(String mensaje) {
        observers.forEach(observer -> observer.update(mensaje));
    }

    /**
     * Verifica si un observador ya está en la lista de observadores.
     * 
     * @param observer El observador a verificar.
     * @return true si el observador está en la lista, false en caso contrario.
     */
    public boolean containsObserver(Observer1 observer) {
        return observers.contains(observer);
    }

    /**
     * Verifica las citas próximas y notifica a los observadores si tienen una cita al día siguiente.
     * 
     * @param citas La colección de citas a verificar.
     */
    @Override
    public void verificarCitasProximas(Collection<CitaConcreta> citas) {
        LocalDate hoy = LocalDate.now();
        citas.stream()
                .filter(cita -> cita.getFechaHoraCita().toLocalDate().isEqual(hoy.plusDays(1)))
                .forEach(cita -> notifyObservers("Recordatorio: Tienes una cita mañana. Motivo: " + cita.getMotivo()));
    }
}

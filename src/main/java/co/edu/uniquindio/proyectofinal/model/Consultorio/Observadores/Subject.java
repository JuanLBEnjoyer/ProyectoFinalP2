package co.edu.uniquindio.proyectofinal.model.Consultorio.Observadores;

import java.util.List;

// Interfaz que define el comportamiento de un sujeto observable.
public interface Subject {
    // Añade un observador a la lista de observadores.
    void addObserver(Observer observer);

    // Elimina un observador de la lista de observadores.
    void removeObserver(Observer observer);

    // Notifica a todos los observadores registrados de un cambio de estado.
    void notifyObservers();

    // Método abstracto para obtener la lista de observadores.
    List<Observer> getObservers();
}

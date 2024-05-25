package co.edu.uniquindio.proyectofinal.model.Patrones.Observer;

import java.util.Collection;

import co.edu.uniquindio.proyectofinal.model.Consultorio.CitaConcreta;


/**
 * La interfaz Sujeto define los métodos que un sujeto debe implementar para gestionar sus observadores.
 */

public interface Sujeto {

    /** 
     * Metodos necesarios para manejar los observadores.
    */

    void addObserver(Observer1 observer);
    void removeObserver(Observer1 observer);
    void notifyObservers(String mensaje);
    void verificarCitasProximas(Collection<CitaConcreta> citas);
    
}

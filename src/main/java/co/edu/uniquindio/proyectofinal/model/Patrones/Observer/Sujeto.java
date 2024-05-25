package co.edu.uniquindio.proyectofinal.model.Patrones.Observer;

import java.util.Collection;

import co.edu.uniquindio.proyectofinal.model.Consultorio.CitaConcreta;

public interface Sujeto {

    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(String mensaje);
    void verificarCitasProximas(Collection<CitaConcreta> citas);
    
}

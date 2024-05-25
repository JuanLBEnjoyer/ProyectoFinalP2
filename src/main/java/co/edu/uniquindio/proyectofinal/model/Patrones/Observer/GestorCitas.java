package co.edu.uniquindio.proyectofinal.model.Patrones.Observer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import co.edu.uniquindio.proyectofinal.model.Consultorio.CitaConcreta;


public class GestorCitas implements Sujeto {
    private Collection<Observer1> observers;

    public GestorCitas() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void addObserver(Observer1 observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer1 observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String mensaje) {
        observers.forEach(observer -> observer.update(mensaje));
    }

    public boolean containsObserver(Observer1 observer) {
        return observers.contains(observer);
    }
    

    @Override
    public void verificarCitasProximas(Collection<CitaConcreta> citas) {
        LocalDate hoy = LocalDate.now();
        citas.stream()
                .filter(cita -> cita.getFechaHoraCita().toLocalDate().isEqual(hoy.plusDays(1)))
                .forEach(cita -> notifyObservers("Recordatorio: Tienes una cita mañana. Motivo: " + cita.getMotivo()));
    }
}

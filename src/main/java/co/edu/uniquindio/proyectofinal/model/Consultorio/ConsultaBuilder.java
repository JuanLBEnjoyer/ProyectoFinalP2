package co.edu.uniquindio.proyectofinal.model.Consultorio;
//import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import co.edu.uniquindio.proyectofinal.model.Consultorio.Observadores.Subject;
import co.edu.uniquindio.proyectofinal.model.Consultorio.Observadores.Observer;
import co.edu.uniquindio.proyectofinal.model.Personal.Doctor;
import co.edu.uniquindio.proyectofinal.model.Personal.Paciente;

// Clase que construye una cita médica y también actúa como sujeto observable.
public class ConsultaBuilder implements CitaBuilder, Subject {

    private String tipoCita;
    private LocalDateTime fechaHoraCita;
    private String consultorio;
    private Doctor doctor;
    private Paciente paciente;

    

    // Lista de observadores registrados
    private List<Observer> observers = new ArrayList<>();
    // Estado de la cita
    private String estado;

    // Constructor
    public ConsultaBuilder() {
        // Inicializar la lista de observadores
        observers = new ArrayList<>();
    }

    // Método para establecer el tipo de cita.
    @Override
    public void tipoCita(String tipoCita) {
        this.tipoCita = tipoCita;
    }

    // Método para establecer la fecha de la cita.
    @Override
    public void fechaHoraCita(LocalDateTime fechaHoraCita) {
        this.fechaHoraCita = fechaHoraCita;
    }

    // Método para establecer el consultorio de la cita.
    @Override
    public void consultorio(String consultorio) {
        this.consultorio = consultorio;
    }

    // Método para establecer el médico de la cita.
    @Override
    public void Doctor(Doctor doctor) {
        this.doctor = doctor;
    }

    // Método para establecer el paciente de la cita.
    @Override
    public void paciente(Paciente paciente) {
        this.paciente = paciente;
    }

    // Método para obtener el estado de la cita.
    public String getEstado() {
        return estado;
    }

    // Método para establecer el estado de la cita y notificar a los observadores.
    public void setEstado(String estado) {
        this.estado = estado;
        notifyObservers();
    }

    // Método para verificar si la cita está a un día de finalizar y actualizar el estado si es el caso.
    public void checkFechaFin() {
        if (fechaHoraCita != null && LocalDateTime.now().plusDays(1).equals(fechaHoraCita)) {
            setEstado("La cita medica comienza en un dia ");
        }
    }

    // Método para añadir un observador a la lista de observadores.
    @Override
    public void addObserver(Observer observer) {
        if (observer != null) {
            observers.add(observer);
        }
    }

    // Método para notificar a todos los observadores registrados.
    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(estado);
        }
    }

    // Método para eliminar un observador de la lista de observadores.
    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

        // Método para obtener la lista de observadores.
    @Override
    public List<Observer> getObservers() {
            return observers;
        }

    // Método para construir la cita médica.
    @Override
    public Cita build() {
        // Construir la cita con los detalles establecidos.
        Cita cita = new Cita() {};
        cita.setTipoCita(tipoCita);
        cita.setFechaHoraCita(fechaHoraCita);
        cita.setConsultorio(consultorio);
        cita.setDoctor(doctor);
        cita.setPaciente(paciente);
        // Verificar la fecha de fin de la cita.
        checkFechaFin();
        return cita;
    }
}


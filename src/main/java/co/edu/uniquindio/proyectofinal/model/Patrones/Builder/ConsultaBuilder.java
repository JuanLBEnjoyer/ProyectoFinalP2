package co.edu.uniquindio.proyectofinal.model.Patrones.Builder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import co.edu.uniquindio.proyectofinal.model.Patrones.Observer.Sujeto;
import co.edu.uniquindio.proyectofinal.model.Consultorio.CitaConcreta;
import co.edu.uniquindio.proyectofinal.model.Patrones.Observer.Observer;

import co.edu.uniquindio.proyectofinal.model.Personal.Doctor;
import co.edu.uniquindio.proyectofinal.model.Personal.Paciente;

// Clase que construye una cita médica y también actúa como sujeto observable.
class ConsultaBuilder implements CitaBuilder, Sujeto {

    private String tipoCita;
    private LocalDateTime fechaHoraCita;
    private String consultorio;
    private Doctor doctor;
    private Paciente paciente;

    // Lista de observadores registrados
    private List<Observer> observers;
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
    public void doctor(Doctor doctor) {
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
        notifyObservers(estado);
    }

    /**
     * Agrega un observador a la lista de observadores.
     * 
     * @param observer El observador a agregar.
     */
    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    /**
     * Elimina un observador de la lista de observadores.
     * 
     * @param observer El observador a eliminar.
     */
    @Override
    public void removeObserver(Observer observer) {
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
    public boolean containsObserver(Observer observer) {
        return observers.contains(observer);
    }

    /**
     * Verifica las citas próximas y notifica a los observadores si tienen una cita
     * al día siguiente.
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

    public List<Observer> getObservers() {
        return observers;
    }

    // Método para verificar si la cita está a un día de finalizar y actualizar el
    // estado si es el caso.
    public void checkFechaFin() {
        if (fechaHoraCita != null && LocalDateTime.now().plusDays(1).equals(fechaHoraCita)) {
            setEstado("La cita medica comienza en un dia ");
        }
    }

    // Método para construir la cita médica.
    @Override
    public Cita build() {
        // Construir la cita con los detalles establecidos.
        Cita cita = new Cita() {
        };
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

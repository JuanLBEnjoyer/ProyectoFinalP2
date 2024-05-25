package co.edu.uniquindio.proyectofinal.model.Personal;

import java.lang.String;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import co.edu.uniquindio.proyectofinal.model.Almacenar.HistorialMedico;
import co.edu.uniquindio.proyectofinal.model.Consultorio.CitaConcreta;
import co.edu.uniquindio.proyectofinal.model.Consultorio.RecetaMedica;
import co.edu.uniquindio.proyectofinal.model.Consultorio.Tratamiento;
import co.edu.uniquindio.proyectofinal.model.Patrones.Observer.Observer1;

public class Paciente extends Persona implements Observer1 {

    private Collection<CitaConcreta> citasProgramadas;
    private HistorialMedico historialMedico;
    private Collection<Tratamiento> tratamientosActivos;
    private Collection<RecetaMedica> medicamentos;
    private String direccion;

    public Paciente(String nombre, String id, LocalDate fechaDeNacimiento, HistorialMedico historialMedico,
            String direccion) {
        super(nombre, id, fechaDeNacimiento);

        this.historialMedico = historialMedico;
        this.citasProgramadas = new ArrayList<CitaConcreta>();
        this.tratamientosActivos = new ArrayList<Tratamiento>();
        this.medicamentos = new ArrayList<RecetaMedica>();
        this.direccion = direccion;

        assert !nombre.isBlank() && !nombre.isEmpty();
        assert !id.isBlank() && !id.isEmpty();
        assert fechaDeNacimiento != null && fechaDeNacimiento.isBefore(LocalDate.now());
        assert historialMedico != null;
        assert !direccion.isBlank() && !direccion.isEmpty();
    }

    public HistorialMedico getHistorialMedico() {
        return historialMedico;
    }

    public void setHistorialMedico(HistorialMedico historialMedico) {
        this.historialMedico = historialMedico;
    }

    public Collection<CitaConcreta> getCitasProgrmadas() {
        return citasProgramadas;
    }

    public void setCitasProgrmadas(Collection<CitaConcreta> citasProgrmadas) {
        this.citasProgramadas = citasProgrmadas;
    }

    public Collection<Tratamiento> getTratamientosActivos() {
        return tratamientosActivos;
    }

    public void setTratamientosActivos(Collection<Tratamiento> tratamientosActivos) {
        this.tratamientosActivos = tratamientosActivos;
    }

    public Collection<CitaConcreta> getCitasProgramadas() {
        return citasProgramadas;
    }

    public void setCitasProgramadas(Collection<CitaConcreta> citasProgramadas) {
        this.citasProgramadas = citasProgramadas;
    }

    public Collection<RecetaMedica> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(Collection<RecetaMedica> medicamentos) {
        this.medicamentos = medicamentos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void agregarCitaProgramada(CitaConcreta cita) {
        citasProgramadas.add(cita);
    }

    public void eliminarCitaProgramada(CitaConcreta cita) {
        citasProgramadas.remove(cita);
    }

    public void agregarTratamientoActivo(Tratamiento tratamiento) {
        tratamientosActivos.add(tratamiento);
    }

    public void agregarRecetaMedica(RecetaMedica receta) {
        this.medicamentos.add(receta);
    }

    @Override
    public void update(String mensaje) {
        System.out.println("Notificación para " + getNombre() + ": " + mensaje);
    }

}


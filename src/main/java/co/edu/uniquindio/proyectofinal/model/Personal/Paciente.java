package co.edu.uniquindio.proyectofinal.model.Personal;

import java.lang.String;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import co.edu.uniquindio.proyectofinal.model.Almacenar.HistorialMedico;
import co.edu.uniquindio.proyectofinal.model.Consultorio.Cita;
import co.edu.uniquindio.proyectofinal.model.Consultorio.RecetaMedica;
import co.edu.uniquindio.proyectofinal.model.Consultorio.Tratamiento;

public class Paciente extends Persona {


    private Collection<Cita> citasProgramadas;
    private HistorialMedico historialMedico;
    private Collection<Tratamiento> tratamientosActivos;
    private Collection<RecetaMedica> medicamentos;

    public Paciente(String nombre, String id, LocalDate fechaDeNacimiento, HistorialMedico historialMedico){
        super(nombre, id, fechaDeNacimiento);

        this.historialMedico = historialMedico;
        this.citasProgramadas = new ArrayList<Cita>();
        this.tratamientosActivos = new ArrayList<Tratamiento>();
        this.medicamentos = new ArrayList<RecetaMedica>();

        assert !nombre.isBlank() && !nombre.isEmpty();
        assert !id.isBlank() && !id.isEmpty();
        assert fechaDeNacimiento != null && fechaDeNacimiento.isBefore(LocalDate.now());
        assert historialMedico != null;
    }


    public HistorialMedico getHistorialMedico() {
        return historialMedico;
    }

    public void setHistorialMedico(HistorialMedico historialMedico) {
        this.historialMedico = historialMedico;
    }


    public Collection<Cita> getCitasProgrmadas() {
        return citasProgramadas;
    }


    public void setCitasProgrmadas(Collection<Cita> citasProgrmadas) {
        this.citasProgramadas = citasProgrmadas;
    }

    public Collection<Tratamiento> getTratamientosActivos() {
        return tratamientosActivos;
    }


    public void setTratamientosActivos(Collection<Tratamiento> tratamientosActivos) {
        this.tratamientosActivos = tratamientosActivos;
    }


    public Collection<Cita> getCitasProgramadas() {
        return citasProgramadas;
    }


    public void setCitasProgramadas(Collection<Cita> citasProgramadas) {
        this.citasProgramadas = citasProgramadas;
    }


    public Collection<RecetaMedica> getMedicamentos() {
        return medicamentos;
    }


    public void setMedicamentos(Collection<RecetaMedica> medicamentos) {
        this.medicamentos = medicamentos;
    }

    

    public void agregarCitaProgramada(Cita cita) {
        citasProgramadas.add(cita);
    }
    
    public void eliminarCitaProgramada(Cita cita) {
        citasProgramadas.remove(cita);
    }

    public void agregarTratamientoActivo(Tratamiento tratamiento) {
        tratamientosActivos.add(tratamiento);
    }

    public void agregarRecetaMedica(RecetaMedica receta) {
        this.medicamentos.add(receta);
    }


    

}

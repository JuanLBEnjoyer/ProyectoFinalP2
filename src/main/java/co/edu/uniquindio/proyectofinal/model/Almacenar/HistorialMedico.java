package co.edu.uniquindio.proyectofinal.model.Almacenar;

import java.util.Collection;

import co.edu.uniquindio.proyectofinal.model.Consultorio.CitaConcreta;
import co.edu.uniquindio.proyectofinal.model.Consultorio.Tratamiento;
import co.edu.uniquindio.proyectofinal.model.Personal.Doctor;

public class HistorialMedico {

    private Collection<CitaConcreta> citas;
    private Collection<Doctor> doctores;
    private Collection<Tratamiento> tratamientos;

    public HistorialMedico(Collection<CitaConcreta> citas, Collection<Doctor> doctores,
            Collection<Tratamiento> tratamientos) {
        this.citas = citas;
        this.doctores = doctores;
        this.tratamientos = tratamientos;
    }

    public Collection<CitaConcreta> getCitas() {
        return citas;
    }

    public void setCitas(Collection<CitaConcreta> citas) {
        this.citas = citas;
    }

    public Collection<Doctor> getDoctores() {
        return doctores;
    }

    public void setDoctores(Collection<Doctor> doctores) {
        this.doctores = doctores;
    }

    public Collection<Tratamiento> getTratamientos() {
        return tratamientos;
    }

    public void setTratamientos(Collection<Tratamiento> tratamientos) {
        this.tratamientos = tratamientos;
    }

    public void agregarCitaFinalizada(CitaConcreta cita) {
        citas.add(cita);
    }

}

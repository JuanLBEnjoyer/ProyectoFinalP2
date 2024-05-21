package co.edu.uniquindio.proyectofinal.model.Almacenar;

import java.util.Collection;

import co.edu.uniquindio.proyectofinal.model.Consultorio.Cita;
import co.edu.uniquindio.proyectofinal.model.Consultorio.Tratamiento;
import co.edu.uniquindio.proyectofinal.model.Personal.Doctor;

public class HistorialMedico {

    private Collection<Cita> citas;
    private Collection <Doctor> doctores;
    private Collection<Tratamiento> tratamientos; 


    public HistorialMedico(Collection<Cita> citas, Collection<Doctor> doctores, Collection<Tratamiento> tratamientos){
        this.citas = citas;
        this.doctores = doctores;
        this.tratamientos = tratamientos;
    }


    public Collection<Cita> getCitas() {
        return citas;
    }


    public void setCitas(Collection<Cita> citas) {
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



    
}

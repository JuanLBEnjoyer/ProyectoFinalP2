package co.edu.uniquindio.proyectofinal.model.Personal;

import java.lang.String;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import co.edu.uniquindio.proyectofinal.model.Almacenar.HistorialMedico;
import co.edu.uniquindio.proyectofinal.model.Consultorio.Cita;

public class Paciente extends Persona {


    private Collection<Cita> citasProgramadas;
    private HistorialMedico historialMedico;


    public Paciente(String nombre, String id, LocalDate fechaDeNacimiento, HistorialMedico historialMedico){
        super(nombre, id, fechaDeNacimiento);

        this.historialMedico = historialMedico;
        this.citasProgramadas = new ArrayList<Cita>();

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
    
}

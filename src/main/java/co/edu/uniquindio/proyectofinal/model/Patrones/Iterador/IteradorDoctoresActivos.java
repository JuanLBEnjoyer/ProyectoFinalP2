package co.edu.uniquindio.proyectofinal.model.Patrones.Iterador;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import co.edu.uniquindio.proyectofinal.model.Enum.EstadoDoctor;
import co.edu.uniquindio.proyectofinal.model.Personal.Doctor;

public class IteradorDoctoresActivos implements Iterador<Doctor> {

    private List<Doctor> doctoresActivos;
    private int posicion;

    public IteradorDoctoresActivos(Collection<Doctor> doctores) {
        this.doctoresActivos = doctores.stream()
            .filter(doctor -> doctor.getEstado() == EstadoDoctor.ACTIVO)
            .collect(Collectors.toList());
        this.posicion = 0;
    }

    @Override
    public boolean hasNext() {
        return posicion < doctoresActivos.size();
    }

    @Override
    public Doctor next() {
        if (hasNext()) {
            return doctoresActivos.get(posicion++);
        }
        return null;
    }
    
}

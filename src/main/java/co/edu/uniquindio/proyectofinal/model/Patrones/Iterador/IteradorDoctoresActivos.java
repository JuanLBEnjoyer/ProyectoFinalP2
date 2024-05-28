package co.edu.uniquindio.proyectofinal.model.Patrones.Iterador;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import co.edu.uniquindio.proyectofinal.model.Enum.EstadoDoctor;
import co.edu.uniquindio.proyectofinal.model.Personal.Doctor;

/**
 * Esta clase implementa un iterador para recorrer la lista de doctores activos en un consultorio.
 * Se asegura de devolver solo los doctores cuyo estado es activo.
 */
public class IteradorDoctoresActivos implements Iterador<Doctor> {

    private final List<Doctor> doctoresActivos; // Lista de doctores activos
    private int posicion; // Posición actual del iterador

    /**
     * Constructor que inicializa el iterador con la colección de doctores activos.
     * @param doctores La colección de doctores del consultorio.
     */
    public IteradorDoctoresActivos(Collection<Doctor> doctores) {
        // Filtrar la lista de doctores para obtener solo los activos
        this.doctoresActivos = doctores.stream()
            .filter(doctor -> doctor.getEstado() == EstadoDoctor.ACTIVO)
            .collect(Collectors.toList());
        this.posicion = 0; // Iniciar en la posición 0
    }

    /**
     * Comprueba si hay un siguiente elemento en la lista de doctores activos.
     * @return true si hay un siguiente doctor, false en caso contrario.
     */
    @Override
    public boolean hasNext() {
        return posicion < doctoresActivos.size();
    }

    /**
     * Devuelve el siguiente doctor activo en la lista.
     * @return El siguiente doctor activo.
     */
    @Override
    public Doctor next() {
        if (hasNext()) {
            return doctoresActivos.get(posicion++);
        }
        return null; // No hay más elementos
    }
}

package co.edu.uniquindio.proyectofinal.model.Consultorio;

// Clase base abstracta Medicamento
public abstract class Medicamento {
    private String nombre;
    private String dosis;

    // Constructor de la clase Medicamento
    public Medicamento(String nombre, String dosis) {
        this.nombre = nombre;
        this.dosis = dosis;
    }

    // Getter y setter para el nombre del medicamento
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Getter y setter para la dosis del medicamento
    public String getDosis() {
        return dosis;
    }

    public void setDosis(String dosis) {
        this.dosis = dosis;
    }

    // Método abstracto para obtener la forma de administración del medicamento
    public abstract String getFormaAdministracion();
}

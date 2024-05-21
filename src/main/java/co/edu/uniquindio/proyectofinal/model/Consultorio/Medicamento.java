package co.edu.uniquindio.proyectofinal.model.Consultorio;

public class Medicamento {

    private String nombre;
    private String dosis;
    private String formaAdministracion;


    public Medicamento(String nombre, String dosis, String formaAdministracion) {
        this.nombre = nombre;
        this.dosis = dosis;
        this.formaAdministracion = formaAdministracion;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getDosis() {
        return dosis;
    }


    public void setDosis(String dosis) {
        this.dosis = dosis;
    }


    public String getFormaAdministracion() {
        return formaAdministracion;
    }


    public void setFormaAdministracion(String formaAdministracion) {
        this.formaAdministracion = formaAdministracion;
    }

    
    
}

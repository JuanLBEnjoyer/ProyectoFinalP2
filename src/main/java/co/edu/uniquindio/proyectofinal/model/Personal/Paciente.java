package co.edu.uniquindio.proyectofinal.model.Personal;

public class Paciente {

    public String nombre;
    public String id;
    public int edad;

    public Paciente(String nombre, String id, int edad){
        this.nombre = nombre;
        this.id = id;
        this.edad = edad;

        assert !nombre.isBlank() && !nombre.isEmpty();
        assert !id.isBlank() && !id.isEmpty();
        assert edad > 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Paciente [nombre=" + nombre + ", id=" + id + ", edad=" + edad + "]";
    }

    
    
}

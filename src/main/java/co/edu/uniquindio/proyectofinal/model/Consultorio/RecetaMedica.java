package co.edu.uniquindio.proyectofinal.model.Consultorio;

import java.util.Collection;

public class RecetaMedica {

    private Collection<Medicamento> mendicamentos;
    private String instrucciones;


    public RecetaMedica(Collection<Medicamento> mendicamentos, String instrucciones) {
        this.mendicamentos = mendicamentos;
        this.instrucciones = instrucciones;
    }


    public Collection<Medicamento> getMendicamentos() {
        return mendicamentos;
    }


    public void setMendicamentos(Collection<Medicamento> mendicamentos) {
        this.mendicamentos = mendicamentos;
    }


    public String getInstrucciones() {
        return instrucciones;
    }


    public void setInstrucciones(String instrucciones) {
        this.instrucciones = instrucciones;
    }    
    
}

package co.edu.uniquindio.proyectofinal.model.Patrones.Iterador;

import java.util.Iterator;

public interface Iterador<T> extends Iterator<T> {

        boolean hasNext();
        T next();
    
}

package co.edu.uniquindio.proyectofinal.model.Patrones.Iterador;

import java.util.Iterator;

/**
 * Esta interfaz define un iterador genérico para recorrer una colección de elementos.
 * Extiende la interfaz estándar Iterator para proporcionar funcionalidad adicional.
 * @param <T> El tipo de elementos que serán iterados.
 */
public interface Iterador<T> extends Iterator<T> {

        /**
         * Comprueba si hay un siguiente elemento en la iteración.
         * @return true si hay un siguiente elemento, false en caso contrario.
         */
        boolean hasNext();
    
        /**
         * Devuelve el siguiente elemento en la iteración.
         * @return El siguiente elemento de la iteración.
         */
        T next();
    
}
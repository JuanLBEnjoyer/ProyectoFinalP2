package co.edu.uniquindio.proyectofinal.model.Patrones.Iterador;

import java.util.Collection;
import java.util.Iterator;
import java.util.Random;

/**
 * Implementación de un iterador aleatorio sobre una colección de elementos.
 *
 * @param <T> Tipo de elemento sobre el cual se itera.
 */
public class IteradorAleatorio<T> implements Iterator<T> {
    private final Collection<T> elementos;
    private final Random random;
    private int indice;

    /**
     * Constructor del iterador aleatorio.
     *
     * @param elementos La colección de elementos sobre la cual se iterará de manera aleatoria.
     */
    public IteradorAleatorio(Collection<T> elementos) {
        this.elementos = elementos;
        this.random = new Random();
        this.indice = random.nextInt(elementos.size());
    }

    /**
     * Verifica si existen más elementos por iterar en la colección.
     *
     * @return true si quedan elementos por iterar, false de lo contrario.
     */
    @Override
    public boolean hasNext() {
        return !elementos.isEmpty();
    }

    /**
     * Obtiene el siguiente elemento de manera aleatoria.
     *
     * @return El siguiente elemento de la colección de manera aleatoria.
     * @throws NoSuchElementException Si no hay más elementos por iterar.
     */
    @Override
    public T next() {
        T elemento = elementos.stream().skip(indice).findFirst().orElseThrow();
        indice = random.nextInt(elementos.size());
        return elemento;
    }

    /**
     * Método de eliminación no soportado en este iterador.
     *
     * @throws UnsupportedOperationException Si se intenta usar el método remove().
     */
    @Override
    public void remove() {
        throw new UnsupportedOperationException("Operación no soportada.");
    }
}

